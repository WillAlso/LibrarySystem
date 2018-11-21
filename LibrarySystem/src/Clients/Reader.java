package Clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import org.ietf.jgss.Oid;
import com.sun.org.apache.xpath.internal.operations.And;

public class Reader extends User {

    Reader() {
        setUserName(null);
        setUserPasswd(null);
        setUserRole(null);
    }

    Reader(String name, String passwd, String role) {
        setUserName(name);
        setUserPasswd(passwd);
        setUserRole(role);
    }

    public String[] messageBox() {
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
            if (len <= 0) {
                dos.close();
                dis.close();
                ois.close();
                client.close();
                return null;
            }
            String[] message = new String[len];
            for (int i = 0; i < len; i++) {
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

    public boolean reserveBook(Book book) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql1 =
                    "SELECT count(*) FROM librarybook WHERE Name='" + book.getBookname()
                            + "' and ISBN='" + book.getBookisbn() + "';";
            String sql2 =
                    "INSERT INTO libraryreserve VALUES(0,'" + getUserName() + "','"
                            + book.getBookname() + "','" + book.getBookisbn() + "',NOW())";
            dos.writeInt(7);
            dos.flush();
            dos.writeUTF(sql1);
            dos.flush();
            dos.writeUTF(sql2);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            int len = dis.readInt();
            if (len <= 0) {
                dos.close();
                dis.close();
                ois.close();
                client.close();
                return false;
            }
            boolean flag = dis.readBoolean();
            dos.close();
            dis.close();
            ois.close();
            client.close();
            return flag;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean unreserveBook(Book book) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql1 =
                    "SELECT count(*) FROM libraryreserve WHERE Name='" + book.getBookname()
                            + "' and Isbn='" + book.getBookisbn() + "';";
            String sql2 =
                    "DELETE FROM libraryreserve WHERE Name='" + book.getBookname() + "' and Isbn='"
                            + book.getBookisbn() + "' and User='" + getUserName() + "';";
            dos.writeInt(8);
            dos.flush();
            dos.writeUTF(sql1);
            dos.flush();
            dos.writeUTF(sql2);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            int len = dis.readInt();
            if (len <= 0) {
                dos.close();
                dis.close();
                ois.close();
                client.close();
                return false;
            }
            boolean flag = dis.readBoolean();
            dos.close();
            dis.close();
            ois.close();
            client.close();
            return flag;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Book queryBook(Book book) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql = "SELECT * FROM librarybook WHERE Name='" + book.getBookname() + "';";
            dos.writeInt(9);
            dos.flush();
            dos.writeUTF(sql);
            dos.flush();
            ois = new ObjectInputStream(client.getInputStream());
            Book t = (Book) ois.readObject();
            dos.close();
            ois.close();
            client.close();
            return t;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean recommendBook(String name, String ISBN, String mail) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql =
                    "INSERT INTO libraryrecommend VALUES(0,'" + getUserName() + "','" + name
                            + "','" + ISBN + "','" + mail+"')";
            dos.writeInt(10);
            dos.flush();
            dos.writeUTF(sql);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            dis.close();
            dos.close();
            client.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User queryUserState(User user) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql = "SELECT * FROM libraryuser WHERE Name='" + user.getUserName()+"';";
            dos.writeInt(11);
            dos.flush();
            dos.writeUTF(sql);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            if(flag){
                ois = new ObjectInputStream(client.getInputStream());
                user = (User)ois.readObject();
                ois.close();
            }
            dis.close();
            dos.close();
            client.close();
            return user;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Operation[] queryBorrowState(User user) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql1 = "SELECT COUNT(*) FROM libraryborrow WHERE User='" + user.getUserName() +"';";
            String sql2 = "SELECT COUNT(*) FROM libraryborrowed WHERE User='" + user.getUserName() +"';";
            String sql3 = "SELECT * FROM libraryborrow WHERE User='" + user.getUserName() +"';";
            String sql4 = "SELECT * FROM libraryborrowed WHERE User='" + user.getUserName() +"';";
            dos.writeInt(12);
            dos.flush();
            dos.writeUTF(sql1);
            dos.flush();
            dos.writeUTF(sql2);
            dos.flush();
            dos.writeUTF(sql3);
            dos.flush();
            dos.writeUTF(sql4);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            int cnt1 = dis.readInt();
            int cnt2 = dis.readInt();
            Operation[] op = new Operation[cnt1 + cnt2];
            ois = new ObjectInputStream(client.getInputStream());
            for(int i = 0;i < cnt1;i++){
                op[i] = (Operation) ois.readObject();
            }
            for(int i = cnt1;i < cnt1 + cnt2;i++){
                op[i] = (Operation) ois.readObject();
            }
            dis.close();
            dos.close();
            ois.close();
            client.close();
            return op;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
