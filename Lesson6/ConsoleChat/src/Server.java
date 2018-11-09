import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        ConnectionSettings connectionSettings = new ConnectionSettings();
        try {
            server = new ServerSocket(connectionSettings.getPORT());
            System.out.println("Server started!");
            socket = server.accept();
            System.out.println("Client connected!");
            DataInputStream serverIn = new DataInputStream(socket.getInputStream());
            DataOutputStream serverOut = new DataOutputStream(socket.getOutputStream());
            Scanner scnServer = new Scanner(System.in);

                Thread serverOutThread = new Thread(() -> {
                    while (true) {
                        try {
                            String serverMsg2Client = scnServer.nextLine();
                            serverOut.writeUTF(serverMsg2Client);
                            System.out.println("Server: " + serverMsg2Client);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                serverOutThread.start();

                Thread serverInThread = new Thread(() -> {
                    while (true) {
                        try {
                            String clientMsg = serverIn.readUTF();
                            System.out.println("Client: " + clientMsg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                serverInThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}