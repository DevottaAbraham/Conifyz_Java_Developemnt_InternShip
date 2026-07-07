import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;

public class ClientHandler extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ClientHandler(Socket socket) {

        this.socket = socket;

        try {

            reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            writer = new PrintWriter(
                    socket.getOutputStream(), true);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        try {

            while (true) {

                String message = reader.readLine();

                if (message == null || message.equalsIgnoreCase("exit")) {

                    System.out.println("Client Disconnected");

                    Server.clients.remove(this);

                    socket.close();

                    break;
                }

                System.out.println("Client : " + message);

                broadcastMessage(message);

            }

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    private void broadcastMessage(String message) {

        for (ClientHandler client : Server.clients) {

           if (client != this) {

            client.writer.println(message);

}

        }

    }

}