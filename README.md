*********************************************************************************************************************************************************************************************

Multicast Sender Application:
Description:
The Multicast Sender application is a Java program that enables users to multicast messages over a network. It features a Swing-based graphical user interface (GUI) for user interaction.

Key Features:
1.GUI interface for user input and interaction.
2.Utilizes MulticastSocket and DatagramPacket for efficient data transmission.
3.Supports sending messages to a specified multicast group and port.
4.Displays confirmation window upon successful message transmission.

Dependencies:
1.Java Swing
2.java.net.MulticastSocket
3.java.net.DatagramPacket
4.java.net.InetAddress

Usage:
1.Compile the Java file: javac MulticastSender.java
2.Run the program: java MulticastSender

***************************************************************************************************************************************************************************************************
***************************************************************************************************************************************************************************************************
Multicast Receiver Application:
Description:
The Multicast Receiver application is a Java program designed to receive multicast messages over a network. It features a Swing-based GUI for displaying received messages.

Key Features:
1.GUI interface for displaying received multicast messages.
2.Uses MulticastSocket to listen for messages on a specified port.
3.Displays sender information along with received messages.
4.Handles exceptions gracefully for robust functionality.

Dependencies:
1.Java Swing
2.java.net.MulticastSocket
3.java.net.DatagramPacket
4.java.net.InetAddress

Usage:
1.Compile the Java file: javac MulticastReceiver.java
2.Run the program: java MulticastReceiver
*********************************************************************************************************************************************************************************************************
