package Clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Reader extends User {
    
    Reader(){
        setUserName(null);
        setUserPasswd(null);
        setUserRole(null);
    }
    
    Reader(String name, String passwd, String role) {
        setUserName(name);
        setUserPasswd(passwd);
        setUserRole(role);
    }
    
    public String[] messageBox(){
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql1 = "SELECT * FROM librarymessage WHERE user='" + getUserName() + "';";
            String sql2 = "Select count(*) FROM librarymessage WHERE user='" + getUserName() + "';";
            dos.writeInt(6);
            dos.flush();
            dos.writeUTF(sql2);
            dos.flush();
            dos.writeUTF(sql1);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            int len = dis.readInt();
            if(len <= 0){
                dos.close();
                dis.close();
                ois.close();
                client.close();
                return null;
            }
            String[] message = new String[len];
            for(int i = 0;i < len;i++){
                message[i] = dis.readUTF();
            }
            dos.close();
            dis.close();
            ois.close();
            client.close();
            return message;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public void reserveBook(){
        
    }
    
    public void unreserveBook() {
        
    }
    
    public void queryBook(){
        
    }
    
    public void recommendBook(){
        
    }
    
    public void queryUserState(){
        
    }
    
    public void queryBorrowState(){
        
    }
}
