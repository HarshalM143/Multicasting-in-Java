import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class MulticastFrame extends JFrame {
    private MulticastSocket multicastSocket;
    private InetAddress group;
    private JTextField textField;

    public MulticastFrame() {
        setTitle("Multicast Sender");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textField = new JTextField();
        JButton sendButton = new JButton("Send This Text to the another Frame");

        setLayout(new BorderLayout());
        add(textField, BorderLayout.CENTER);
        add(sendButton, BorderLayout.SOUTH);

        try {
            multicastSocket = new MulticastSocket();
            group = InetAddress.getByName("230.0.0.0");
            multicastSocket.joinGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sendButton.addActionListener(e -> {
            String message = textField.getText();
            if (!message.isEmpty()) {
                try {

                    String senderInfo = InetAddress.getLocalHost().getHostAddress() + ":"
                            + multicastSocket.getLocalPort();
                    message = senderInfo + ": " + message;

                    byte[] data = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(data, data.length, group, 4446);
                    multicastSocket.send(packet);

                    showConfirmationWindow(group, 4446, message);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                textField.setText("");
            }
        });
    }

    private void showConfirmationWindow(InetAddress group, int port, String message) {
        JFrame confirmationFrame = new JFrame("Your Message Sent.....!");
        confirmationFrame.setSize(400, 150);
        confirmationFrame.setLocationRelativeTo(this);

        JLabel label = new JLabel("Message sent to " + group.getHostAddress() + ":" + port + " - " + message);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        confirmationFrame.add(label);
        confirmationFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MulticastFrame().setVisible(true));
    }
}
