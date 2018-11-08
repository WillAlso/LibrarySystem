package Clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class User implements Serializable{
    
    static String SERVER_IP = "127.0.0.1";
    static int SERVER_PORT = 2017;
    static Socket client;
    static DataOutputStream dos;    //send data to server
    static DataInputStream dis;     //accept data
    private String userName;
    private String userPasswd;
    private String userRole;
    private int userborrownum;
    private double userbalance;

    static ObjectInputStream ois;
    static ObjectOutputStream oos;
    User() {
        userName = null;
        userPasswd = null;
        userRole = null;
        userborrownum = 0;
        userbalance = 0;
    }

    public User(String name, String passwd, String role,int num,double bala) {
        userName = name;
        userPasswd = passwd;
        userRole = role;
        userborrownum = num;
        userbalance = bala;
    }
    
    public User loginuser(){
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql = "SELECT * FROM libraryuser WHERE name='" + getUserName() + "' and password='"+ getUserPasswd() + "';";
            dos.writeInt(0);
            dos.flush();
            dos.writeUTF(sql);
            dos.flush();
            //dos.close();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            //dis.close();
            if(flag == false){
                return null;
            }
            User user1 = new User();
            ois = new ObjectInputStream(client.getInputStream());
            user1 = (User) ois.readObject();
            System.out.println(user1.getUserPasswd());
            ois.close();
            client.close();
            return user1;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void modifyPasswd(){
        
    }

    public int getUserborrownum() {
        return userborrownum;
    }

    public void setUserborrownum(int userborrownum) {
        this.userborrownum = userborrownum;
    }

    public double getUserbalance() {
        return userbalance;
    }

    public void setUserbalance(double userbalance) {
        this.userbalance = userbalance;
    }
}
