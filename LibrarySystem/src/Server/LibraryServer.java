package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import com.sun.security.auth.UserPrincipal;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import Clients.*;

public class LibraryServer {

    String mysqlUser = "root";
    String mysqlPasswd = "123456";
    private static final int PORT = 2018;
    private ServerSocket server;
    private Socket client;
    static DataOutputStream dos;
    static DataInputStream dis;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    static protected String sqlst;
    String mysqlUrl =
            "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    
    final int LOGINUSER = 0;
    final int QUERRYUSER = 1;
    final int ADDUSER = 2;
    final int MODIFYUSER = 3;
    final int DELETEUSER = 4;

    public LibraryServer() {

        Connection con;
        Statement st;
        try {
            server = new ServerSocket(PORT);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(mysqlUrl, mysqlUser, mysqlPasswd);
            st = con.createStatement();
            while (true) {
                client = server.accept();
                dis = new DataInputStream(client.getInputStream());
                int m = dis.readInt();
                String sqlst = dis.readUTF();
                System.out.println(sqlst);
                //dis.close();
                if (m == QUERRYUSER) {
                    ResultSet result = st.executeQuery(sqlst);
                    if (result.next()) {
                        String tName = result.getString("Name");
                        String tRole = result.getString("Role");
                        String tPass = result.getString("Password");
                        int tNum = result.getInt("BorrowNum");
                        double tBlan = result.getDouble("Blance");
                        User user = new User(tName,tPass,tRole,tNum,tBlan);
                        
                        dos = new DataOutputStream(client.getOutputStream());
                        dos.writeBoolean(true);
                        dos.flush();
                        dos.close();
                        oos = new ObjectOutputStream(client.getOutputStream());
                        oos.writeObject(user);
                        oos.flush();
                        oos.close();
                    } else {
                        dos = new DataOutputStream(client.getOutputStream());
                        dos.writeBoolean(false);
                        dos.flush();
                        dos.close();
                    }
                }else if(m == LOGINUSER){
                    ResultSet result = st.executeQuery(sqlst);
                    if (result.next()) {
                        String tName = result.getString("Name");
                        String tRole = result.getString("Role");
                        String tPass = result.getString("Password");
                        int tNum = result.getInt("BorrowNum");
                        double tBlan = result.getDouble("Blance");
                        User user = new User(tName,tPass,tRole,tNum,tBlan);
                        dos = new DataOutputStream(client.getOutputStream());
                        dos.writeBoolean(true);
                        dos.flush();
                        System.out.println(user.getUserName()+user.getUserRole()+tPass+tNum+tBlan);
                        //dos.close();
                        oos = new ObjectOutputStream(client.getOutputStream());
                        oos.writeObject(user);
                        oos.flush();
                        //oos.close();
                    } else {
                        dos = new DataOutputStream(client.getOutputStream());
                        dos.writeBoolean(false);
                        dos.flush();
                        //dos.close();
                    }
                } else if (m == ADDUSER) {

                } else if (m == MODIFYUSER) {

                } else if (m == DELETEUSER) {

                }

                //System.out.print(sqlst);
               // dis.close();
                //client.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LibraryServer lib = new LibraryServer();
    }
}
