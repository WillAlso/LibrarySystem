package Clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Operator extends User {
    Operator() {
        setUserName(null);
        setUserPasswd(null);
        setUserRole(null);
    }

    Operator(String name, String passwd, String role) {
        setUserName(name);
        setUserPasswd(passwd);
        setUserRole(role);
    }

    public boolean dealBill(String user, Double bill) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql1 = "INSERT INTO librarybilled VALUES(0,'" + user + "'," + bill + ",NOW())";
            dos.writeInt(13);
            dos.flush();
            dos.writeUTF(sql1);
            dos.flush();
            String sql2 =
                    "UPDATE libraryuser SET Blance=Blance-" + bill + " WHERE Name='" + user + "' ";
            dos.writeUTF(sql2);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            dos.close();
            dis.close();
            client.close();
            return flag;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean borrowBook(String user, String book, String isbn) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql1 =
                    "INSERT INTO libraryborrow VALUES(0,'" + user + "','" + book + "',NOW(),'"
                            + isbn + "');";
            dos.writeInt(14);
            dos.flush();
            dos.writeUTF(sql1);
            dos.flush();
            String sql2 = "UPDATE libraryuser SET BorrowNum=BorrowNum+1 WHERE Name='" + user + "';";
            dos.writeUTF(sql2);
            dos.flush();
            String sql3 =
                    "UPDATE librarybook SET Totalnum=Totalnum-1,Borrowednum=Borrowednum+1 WHERE Name='"
                            + book + "';";
            dos.writeUTF(sql3);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            dos.close();
            dis.close();
            client.close();
            return flag;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean returnBook(String user, String book, String isbn) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            String sql1 =
                    "SELECT * FROM libraryborrow WHERE User='" + user + "' and Name='" + book
                            + "';";
            dos.writeInt(15);
            dos.flush();
            dos.writeUTF(sql1);
            dos.flush();
            String sql2 = "UPDATE libraryuser SET BorrowNum=BorrowNum-1 WHERE Name='" + user + "';";
            dos.writeUTF(sql2);
            dos.flush();
            String sql3 =
                    "UPDATE librarybook SET Totalnum=Totalnum+1,Borrowednum=Borrowednum-1 WHERE Name='"
                            + book + "';";
            dos.writeUTF(sql3);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            dos.close();
            dis.close();
            client.close();
            return flag;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addBook(Book book) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            dos.writeInt(16);
            String sql =
                    "INSERT INTO librarybook VALUES(0,'" + book.getBookname() + "','"
                            + book.getBookisbn() + "','" + book.getBookcode() + "','"
                            + book.getBookauthor() + "','" + book.getBooktype() + "','"
                            + book.getBookdescribe() + "','" + book.getTempdate() + "',"
                            + book.getBookversion() + "," + book.getBookprice() + ","
                            + book.getBookborrowednum() + "," + book.getBooktotalnum() + ")";
            dos.writeUTF(sql);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            dis.close();
            dos.close();
            client.close();
            return flag;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(String book, String isbn) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            dos.writeInt(17);
            String sql =
                    "DELETE FROM librarybook WHERE Name='" + book + "' and ISBN='" + isbn + "';";
            dos.writeUTF(sql);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            dis.close();
            dos.close();
            client.close();
            return flag;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyBook(Book old, Book book) {
        try {
            client = new Socket("127.0.0.1", 2018);
            dos = new DataOutputStream(client.getOutputStream());
            dos.writeInt(17);
            String sql = "UPDATE librarybook SET Name='" + book.getBookname() + "',ISBN='"
                    + book.getBookisbn() + "',Bookcode='" + book.getBookauthor() + "',Booktype='"
                    +book.getBooktype() + "',Bookdescribe='" + book.getBookdescribe() + "',Publishdate='"
                    +book.getTempdate() + "',Version=" + book.getBookversion() + ",Price=" + book.getBookprice() +",Borrowednum=" 
                    +book.getBookborrowednum() + ",Totalnum=" + book.getBooktotalnum() + " WHERE Name='" + old.getBookname()+"' and ISBN='" +
                    old.getBookisbn() + "';";
            dos.writeUTF(sql);
            dos.flush();
            dis = new DataInputStream(client.getInputStream());
            boolean flag = dis.readBoolean();
            dis.close();
            dos.close();
            client.close();
            return flag;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
