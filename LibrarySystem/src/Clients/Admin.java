package Clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import com.sun.javafx.iio.ios.IosDescriptor;

public class Admin extends User {
    Admin(){
        setUserName(null);
        setUserPasswd(null);
        setUserRole(null);
    }
    
    Admin(String name, String passwd, String role) {
        setUserName(name);
        setUserPasswd(passwd);
        setUserRole(role);
    }
    
    public boolean addUser(User user){
        return false;
    }
    
    public boolean deleteUser(User user){
        return false;
    }
    
    public boolean modifyUser(User user){
        return false;
    }
    
    public User queryUser(User user){
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql = "SELECT * FROM libraryuser WHERE name='" + user.getUserName() + "';";
            dos.writeInt(1);
            dos.flush();
            dos.writeUTF(sql);
            dos.flush();
            dos.close();
            dis = new DataInputStream(client.getInputStream());
            dis.readBoolean();
            dis.close();
            User user1 = new User();
            ois = new ObjectInputStream(client.getInputStream());
            user1 = (User) ois.readObject();
            ois.close();
            client.close();
            return user1;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
