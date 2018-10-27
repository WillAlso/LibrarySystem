package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GetMessage {

    private static final int PORT = 2017;
    private ServerSocket server;
    private Socket client;
    static DataOutputStream dos;
    static DataInputStream dis;
    
    public GetMessage() {
        try {
            server = new ServerSocket(PORT);
            while(true){
                client = server.accept();
                dis = new DataInputStream(client.getInputStream());
                int m = dis.readInt();
                System.out.print(m);
                dis.close();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        GetMessage message = new GetMessage();
    }

}
