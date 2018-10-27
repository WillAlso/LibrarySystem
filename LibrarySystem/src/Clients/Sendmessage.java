package Clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sendmessage {
    
    static String SERVER_IP = "127.0.0.1";
    static int SERVER_PORT = 2017;
    static Socket client;
    static DataOutputStream dos;    //send data to server
    static DataInputStream dis;     //accept data
    
    public Sendmessage(){
        try {
            client = new Socket("127.0.0.1", 2017);
            dos = new DataOutputStream(client.getOutputStream());
            dos.writeInt(6);
            dos.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        }
    }
    
    public boolean SendInfo(int status,String sql) {
        return false;
        
    }

    public static void main(String[] args) {
        new Sendmessage();
    }

}
