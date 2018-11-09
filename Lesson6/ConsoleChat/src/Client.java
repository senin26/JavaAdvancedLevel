import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket;
        ConnectionSettings connectionSettings = new ConnectionSettings();
        try {
            socket = new Socket(connectionSettings.getIP_ADDRESS(), connectionSettings.getPORT());
            DataOutputStream clientOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream clientIn = new DataInputStream(socket.getInputStream());
            Scanner scnClient = new Scanner(System.in);

                Thread clientInThread = new Thread(() -> {
                    while (true) {
                        try {
                            String serverMsg = clientIn.readUTF();
                            System.out.println("Server: " + serverMsg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                clientInThread.start();

                Thread clientOutThread = new Thread(() -> {
                    while (true) {
                        try {
                            String clientMsg2Server = scnClient.nextLine();
                            clientOut.writeUTF(clientMsg2Server);
                            System.out.println("Client: " + clientMsg2Server);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                clientOutThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
