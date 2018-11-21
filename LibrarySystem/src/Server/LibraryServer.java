package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.text.SimpleDateFormat;
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
            "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    final int LOGINUSER = 0;
    final int QUERRYUSER = 1;
    final int ADDUSER = 2;
    final int MODIFYUSER = 3;
    final int DELETEUSER = 4;
    final int MODIFYPASS = 5;
    final int MESSAGEBOX = 6;
    final int RESERVEBOOK = 7;
    final int UNRESERVEBOOK = 8;
    final int QUERYBOOK = 9;
    final int RECOMMONDBOOK = 10;
    final int QUERYUSERSTATE = 11;
    final int QUERYBORROWSTATE = 12;
    final int DEALBILL = 13;
    final int BORROWBOOK = 14;
    final int RETURNBOOK = 15;
    final int ADDBOOK = 16;
    final int DELETEBOOK = 17;
    final int MODIFYBOOK = 18;

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
                Thread t = new Thread() {
                    public void run() {
                        try {
                            dis = new DataInputStream(client.getInputStream());
                            int m = dis.readInt();
                            String sqlst = dis.readUTF();
                            if (m == QUERRYUSER) {
                                ResultSet result = st.executeQuery(sqlst);
                                if (result.next()) {
                                    String tName = result.getString("Name");
                                    String tRole = result.getString("Role");
                                    String tPass = result.getString("Password");
                                    int tNum = result.getInt("BorrowNum");
                                    double tBlan = result.getDouble("Blance");
                                    User user = new User(tName, tPass, tRole, tNum, tBlan);
                                    dos = new DataOutputStream(client.getOutputStream());
                                    dos.writeBoolean(true);
                                    dos.flush();
                                    oos = new ObjectOutputStream(client.getOutputStream());
                                    oos.writeObject(user);
                                    oos.flush();
                                    dos.close();
                                    oos.close();
                                } else {
                                    dos = new DataOutputStream(client.getOutputStream());
                                    dos.writeBoolean(false);
                                    dos.flush();
                                }
                            } else if (m == LOGINUSER) {
                                ResultSet result = st.executeQuery(sqlst);
                                if (result.next()) {
                                    String tName = result.getString("Name");
                                    String tRole = result.getString("Role");
                                    String tPass = result.getString("Password");
                                    int tNum = result.getInt("BorrowNum");
                                    double tBlan = result.getDouble("Blance");
                                    User user = new User(tName, tPass, tRole, tNum, tBlan);
                                    dos = new DataOutputStream(client.getOutputStream());
                                    dos.writeBoolean(true);
                                    dos.flush();
                                    oos = new ObjectOutputStream(client.getOutputStream());
                                    oos.writeObject(user);
                                    oos.flush();
                                } else {
                                    dos = new DataOutputStream(client.getOutputStream());
                                    dos.writeBoolean(false);
                                    dos.flush();
                                }
                            } else if (m == ADDUSER) {
                                boolean result = st.execute(sqlst);
                                dos = new DataOutputStream(client.getOutputStream());
                                if (result) {
                                    dos.writeBoolean(true);
                                    dos.flush();
                                } else {
                                    dos.writeBoolean(true);
                                    dos.flush();
                                }
                                dos.close();
                            } else if (m == MODIFYUSER) {
                                boolean result = st.execute(sqlst);
                                dos = new DataOutputStream(client.getOutputStream());
                                if (result) {
                                    dos.writeBoolean(true);
                                    dos.flush();
                                } else {
                                    dos.writeBoolean(true);
                                    dos.flush();
                                }
                                dos.close();
                            } else if (m == DELETEUSER) {
                                boolean result = st.execute(sqlst);
                                dos = new DataOutputStream(client.getOutputStream());
                                if (result) {
                                    dos.writeBoolean(true);
                                    dos.flush();
                                } else {
                                    dos.writeBoolean(true);
                                    dos.flush();
                                }
                                dos.close();
                            } else if (m == MODIFYPASS) {
                                boolean result = st.execute(sqlst);
                                dos = new DataOutputStream(client.getOutputStream());
                                if (result) {
                                    dos.writeBoolean(true);
                                    dos.flush();
                                } else {
                                    dos.writeBoolean(true);
                                    dos.flush();
                                }
                                dos.close();
                            } else if (m == MESSAGEBOX) {
                                ResultSet result = st.executeQuery(sqlst);
                                String sql2 = dis.readUTF();
                                int len = 0;
                                if (result.next()) {
                                    len = result.getInt("count(*)");
                                }
                                dos = new DataOutputStream(client.getOutputStream());
                                if (len <= 0) {
                                    dos.writeInt(len);
                                    dos.flush();
                                    result.close();
                                } else {
                                    dos.writeInt(len);
                                    dos.flush();
                                    result.close();
                                    ResultSet result1 = st.executeQuery(sql2);
                                    while (result1.next()) {
                                        dos.writeUTF(result1.getString("Message"));
                                        dos.flush();
                                    }
                                }
                                dos.close();
                            } else if (m == RESERVEBOOK) {
                                ResultSet result = st.executeQuery(sqlst);
                                String sql2 = dis.readUTF();
                                int len = 0;
                                if (result.next()) {
                                    len = result.getInt("count(*)");
                                }
                                dos = new DataOutputStream(client.getOutputStream());
                                if (len <= 0) {
                                    dos.writeInt(len);
                                    dos.flush();
                                    result.close();
                                } else {
                                    dos.writeInt(len);
                                    dos.flush();
                                    result.close();
                                    boolean result1 = st.execute(sql2);
                                    dos.writeBoolean(true);
                                }
                                dis.close();
                                dos.close();
                            } else if (m == UNRESERVEBOOK) {
                                ResultSet result = st.executeQuery(sqlst);
                                String sql2 = dis.readUTF();
                                int len = 0;
                                if (result.next()) {
                                    len = result.getInt("count(*)");
                                }
                                dos = new DataOutputStream(client.getOutputStream());
                                if (len <= 0) {
                                    dos.writeInt(len);
                                    dos.flush();
                                    result.close();
                                } else {
                                    dos.writeInt(len);
                                    dos.flush();
                                    result.close();
                                    boolean result1 = st.execute(sql2);
                                    dos.writeBoolean(true);
                                }
                                dis.close();
                                dos.close();
                            } else if (m == QUERYBOOK) {
                                ResultSet result = st.executeQuery(sqlst);
                                oos = new ObjectOutputStream(client.getOutputStream());
                                Book book = new Book();
                                if (!result.next()) {
                                    oos.writeObject(null);
                                    oos.close();
                                    dis.close();
                                } else {
                                    book.setBookname(result.getString("Name"));
                                    book.setBookisbn(result.getString("ISBN"));
                                    book.setBookcode(result.getString("Bookcode"));
                                    book.setBookauthor(result.getString("Author"));
                                    book.setBookdescribe(result.getString("Bookdescribe"));
                                    book.setBookpublishdate(result.getDate("Publishdate"));
                                    book.setBookversion(result.getInt("Version"));
                                    book.setBookprice(result.getDouble("Price"));
                                    book.setBooktotalnum(result.getInt("Totalnum"));
                                    book.setBooktype(result.getString("Booktype"));
                                    oos.writeObject(book);
                                    oos.flush();
                                    dis.close();
                                    oos.close();
                                }
                            } else if (m == RECOMMONDBOOK) {
                                boolean result = st.execute(sqlst);
                                dos = new DataOutputStream(client.getOutputStream());
                                dos.writeBoolean(true);
                                dos.flush();
                                dis.close();
                                dos.close();
                            } else if (m == QUERYUSERSTATE) {
                                ResultSet result = st.executeQuery(sqlst);
                                dos = new DataOutputStream(client.getOutputStream());
                                if (result.next()) {
                                    dos.writeBoolean(true);
                                    dos.flush();
                                    User user = new User();
                                    user.setUserRole(result.getString("Role"));
                                    user.setUserName(result.getString("Name"));
                                    user.setUserborrownum(result.getInt("BorrowNum"));
                                    user.setUserbalance(result.getDouble("Blance"));
                                    oos = new ObjectOutputStream(client.getOutputStream());
                                    oos.writeObject(user);
                                    oos.flush();
                                    oos.close();
                                } else {
                                    dos.writeBoolean(false);
                                    dos.flush();
                                    dis.close();
                                    dos.close();
                                }
                            } else if (m == QUERYBORROWSTATE) {
                                ResultSet result1 = st.executeQuery(sqlst);
                                String sql2 = dis.readUTF();
                                String sql3 = dis.readUTF();
                                String sql4 = dis.readUTF();
                                int cnt = 0;
                                if (result1.next()) {
                                    cnt = result1.getInt("count(*)");
                                }
                                result1.close();
                                dos = new DataOutputStream(client.getOutputStream());
                                dos.writeInt(cnt);
                                dos.flush();
                                int cnt2 = 0;
                                ResultSet result2 = st.executeQuery(sql2);
                                if (result2.next()) {
                                    cnt2 = result2.getInt("count(*)");
                                }
                                result2.close();
                                dos.writeInt(cnt2);
                                dos.flush();
                                oos = new ObjectOutputStream(client.getOutputStream());
                                if (cnt > 0) {
                                    ResultSet result3 = st.executeQuery(sql3);
                                    result3.next();
                                    for (int i = 0; i < cnt; i++) {
                                        String user = result3.getString("User");
                                        String book = result3.getString("Name");
                                        String isbn = result3.getString("Isbn");
                                        Date date = result3.getDate("Borrowdate");
                                        Operation op =
                                                new Operation(user, book, isbn, date, "未归还", 0);
                                        oos.writeObject(op);
                                        oos.flush();
                                    }
                                    result3.close();
                                }
                                if (cnt2 > 0) {
                                    ResultSet result4 = st.executeQuery(sql4);
                                    result4.next();
                                    for (int i = 0; i < cnt2; i++) {
                                        String user = result4.getString("User");
                                        String book = result4.getString("Name");
                                        String isbn = result4.getString("Isbn");
                                        Date date = result4.getDate("Borrowdate");
                                        SimpleDateFormat formatter =
                                                new SimpleDateFormat("yyyy-MM-dd");
                                        String back = formatter.format(result4.getDate("Duetime"));
                                        Operation op =
                                                new Operation(user, book, isbn, date, back, 0);
                                        oos.writeObject(op);
                                        oos.flush();
                                    }
                                    result4.close();
                                }
                                oos.close();
                                dis.close();
                                dos.close();
                            } else if (m == DEALBILL) {
                                boolean result = st.execute(sqlst);
                                String sql2 = dis.readUTF();
                                boolean result2 = st.execute(sql2);
                                dos = new DataOutputStream(client.getOutputStream());
                                dos.writeBoolean(true);
                                dos.flush();
                                dis.close();
                                dos.close();
                                client.close();
                            } else if (m == BORROWBOOK) {
                                boolean result = st.execute(sqlst);
                                String sql2 = dis.readUTF();
                                boolean result2 = st.execute(sql2);
                                String sql3 = dis.readUTF();
                                boolean result3 = st.execute(sql3);
                                dos = new DataOutputStream(client.getOutputStream());
                                dos.writeBoolean(true);
                                dos.flush();
                                dis.close();
                                dos.close();
                                client.close();
                            } else if (m == RETURNBOOK) {
                                ResultSet result = st.executeQuery(sqlst);
                                if (result.next()) {
                                    String user = result.getString("User");
                                    String book = result.getString("Name");
                                    String isbn = result.getString("Isbn");
                                    Date date = result.getDate("Borrowdate");
                                    result.close();
                                    String tsql =
                                            "DELETE FROM libraryborrow WHERE User='" + user
                                                    + "' and Name='" + book + "';";
                                    String tsql2 =
                                            "INSERT FROM libraryborrowed VALUES(0,'" + user + "','"
                                                    + book + "','" + isbn + "','" + date
                                                    + "',NOW())";
                                    boolean result1 = st.execute(tsql);
                                    boolean tresult1 = st.execute(tsql2);
                                }
                                String sql2 = dis.readUTF();
                                boolean result2 = st.execute(sql2);
                                String sql3 = dis.readUTF();
                                boolean result3 = st.execute(sql3);
                                dos = new DataOutputStream(client.getOutputStream());
                                dos.writeBoolean(true);
                                dos.flush();
                                dis.close();
                                dos.close();
                                client.close();
                            } else if (m == ADDBOOK) {
                                boolean result = st.execute(sqlst);
                                dos = new DataOutputStream(client.getOutputStream());
                                dos.writeBoolean(true);
                                dos.flush();
                                dis.close();
                                dos.close();
                                client.close();
                            } else if (m == DELETEBOOK) {
                                boolean result = st.execute(sqlst);
                                dos = new DataOutputStream(client.getOutputStream());
                                dos.writeBoolean(true);
                                dos.flush();
                                dis.close();
                                dos.close();
                                client.close();
                            } else if (m == MODIFYBOOK) {
                                boolean result = st.execute(sqlst);
                                dos = new DataOutputStream(client.getOutputStream());
                                dos.writeBoolean(true);
                                dos.flush();
                                dis.close();
                                dos.close();
                                client.close();
                            }
                        } catch (Exception e) {
                        }
                    }
                };
                t.start();
            }
        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        LibraryServer library = new LibraryServer();
    }
}
