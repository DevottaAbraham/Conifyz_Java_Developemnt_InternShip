import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    // Stores all connected clients
    public static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {

        int port = 5000;

        try {

            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server Started on Port " + port);

            while (true) {

                System.out.println("Waiting for Client...");

                Socket socket = serverSocket.accept();

                System.out.println("New Client Connected : "
                        + socket.getInetAddress());

                ClientHandler handler = new ClientHandler(socket);

                clients.add(handler);

                handler.start();
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}