import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class ClientUI extends JFrame {

    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    private String userName;

    public ClientUI() {

        // Ask Username
        userName = JOptionPane.showInputDialog(this, "Enter Your Name");

        if (userName == null || userName.trim().isEmpty()) {
            userName = "Anonymous";
        }

        // Window
        setTitle("Java Chat Application - " + userName);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header
        JLabel title = new JLabel("Java Chat Application", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setOpaque(true);
        title.setBackground(new Color(30, 144, 255));
        title.setForeground(Color.WHITE);
        title.setPreferredSize(new Dimension(600, 50));

        add(title, BorderLayout.NORTH);

        // Chat Area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        chatArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        messageField = new JTextField();
        messageField.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 15));
        sendButton.setBackground(new Color(30, 144, 255));
        sendButton.setForeground(Color.WHITE);

        bottomPanel.add(messageField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        // Button Events
        sendButton.addActionListener(e -> sendMessage());

        messageField.addActionListener(e -> sendMessage());

        // Connect Server
        connectToServer();

        setVisible(true);
    }

    private void connectToServer() {

        try {

            socket = new Socket("localhost", 5000);

            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            writer = new PrintWriter(
                    socket.getOutputStream(), true);

            chatArea.append("Connected to Server...\n\n");

            // Receive Messages
            Thread receiveThread = new Thread(() -> {

                try {

                    String message;

                    while ((message = reader.readLine()) != null) {

                        String received = message;

                        SwingUtilities.invokeLater(() -> {

                            chatArea.append(received + "\n");

                        });

                    }

                } catch (Exception e) {

                    SwingUtilities.invokeLater(() -> {

                        chatArea.append("Disconnected from Server.\n");

                    });

                }

            });

            receiveThread.start();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Unable to connect to the server.");

        }

    }

    private void sendMessage() {

    String message = messageField.getText().trim();

    if (!message.isEmpty()) {

        String time = LocalTime.now()
                .format(DateTimeFormatter.ofPattern("hh:mm a"));

        writer.println("[" + time + "] " + userName + " : " + message);

        chatArea.append("[" + time + "] You : " + message + "\n");

        messageField.setText("");
    }
}

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new ClientUI());

    }

}