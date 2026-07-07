import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        int port = 5000;

        try {

            Socket socket = new Socket("localhost", port);

            System.out.println("Connected to Server");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter writer = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            // Ask username only once
            System.out.print("Enter Your Name: ");
            String name = sc.nextLine();

            // Thread to receive messages
            Thread receiveThread = new Thread(() -> {
                try {

                    String message;

                    while ((message = reader.readLine()) != null) {

                        System.out.println(message);

                    }

                } catch (Exception e) {

                    System.out.println("Disconnected from Server");

                }
            });

            receiveThread.start();

            // Send messages
            while (true) {

                String message = sc.nextLine();

                writer.println(name + " : " + message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            socket.close();
            sc.close();

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }

    }
}