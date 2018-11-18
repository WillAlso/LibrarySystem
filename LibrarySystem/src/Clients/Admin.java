package Clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import jdk.nashorn.internal.ir.Flags;
import com.sun.javafx.iio.ios.IosDescriptor;

public class Admin extends User {
    /**
     * 
     */
    // private static final long serialVersionUID = 1L;

    Admin() {
        setUserName(null);
        setUserPasswd(null);
        setUserRole(null);
    }

    Admin(String name, String passwd, String role) {
        setUserName(name);
        setUserPasswd(passwd);
        setUserRole(role);
    }

    public boolean addUser(User user) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql =
                    "INSERT INTO libraryuser (Name,Role,Password,BorrowNum,Blance) VALUES('"
                            + user.getUserName() + "','" + user.getUserRole() + "','"
                            + user.getUserPasswd() + "','" + user.getUserborrownum() + "','"
                            + user.getUserbalance() + "')";
            dos.writeInt(2);
            dos.flush();
            dos.writeUTF(sql);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            if (flag == false) {
                dos.close();
                dis.close();
                client.close();
                return false;
            }
            dos.close();
            dis.close();
            ois.close();
            client.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(User user) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql = "DELETE FROM libraryuser WHERE name='" + user.getUserName() + "';";
            dos.writeInt(4);
            dos.flush();
            dos.writeUTF(sql);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            if (flag == false) {
                dos.close();
                dis.close();
                client.close();
                return false;
            }
            dos.close();
            dis.close();
            ois.close();
            client.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyUser(User user) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql =
                    "UPDATE libraryuser set Password = '" + user.getUserPasswd() + "',Role = '"
                            + user.getUserRole() + "' WHERE name='" + user.getUserName() + "';";
            dos.writeInt(3);
            dos.flush();
            dos.writeUTF(sql);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            if (flag == false) {
                dos.close();
                dis.close();
                client.close();
                return false;
            }
            dos.close();
            dis.close();
            ois.close();
            client.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User queryUser(User user) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql = "SELECT * FROM libraryuser WHERE name='" + user.getUserName() + "';";
            dos.writeInt(1);
            dos.flush();
            dos.writeUTF(sql);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            if (flag == false) {
                dos.close();
                dis.close();
                client.close();
                return null;
            }
            User user1 = new User();
            ois = new ObjectInputStream(client.getInputStream());
            user1 = (User) ois.readObject();
            dos.close();
            dis.close();
            ois.close();
            client.close();
            return user1;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
