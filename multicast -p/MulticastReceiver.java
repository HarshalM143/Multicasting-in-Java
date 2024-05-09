import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.*;

public class MulticastReceiver {
    private JTextArea messageArea;

    public MulticastReceiver() {
        JFrame frame = new JFrame("Multicast Receiver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void startReceiver() {
        try {
            MulticastSocket multicastSocket = new MulticastSocket(4446);
            InetAddress group = InetAddress.getByName("230.0.0.0");
            multicastSocket.joinGroup(group);

            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                multicastSocket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                String senderInfo = packet.getAddress().getHostAddress() + ":" + packet.getPort();
                showMessage("From " + received + "\n");
            }
        } catch (IOException e) {
            showMessage("Error: " + e.getMessage() + "\n");
        }
    }

    private void showMessage(String message) {
        SwingUtilities.invokeLater(() -> {
            messageArea.append(message);
        });
    }

    public static void main(String[] args) {
        MulticastReceiver receiver = new MulticastReceiver();
        receiver.startReceiver();
    }
}
