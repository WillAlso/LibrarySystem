package Clients;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LibraryClient implements ActionListener {

    private JFrame loginFrame;
    private JFrame mainFrame;
    private JFrame subFrame;
    JDesktopPane desktopPane;
    JDesktopPane mainPane;
    JDesktopPane subPane;
    Dimension screenSize;
    JLabel jb_user;
    JLabel jb_passwd;
    JButton btn_login;
    JButton btn_cancel;
    JTextField tf_user;
    JPasswordField tf_passwd;
    JButton btn_modifypasswd;
    JButton btn_adduser;
    JButton btn_modifyuser;
    JButton btn_deleteuser;
    JButton btn_queryuser;
    JButton btn_messagebox;
    JButton btn_reservation;
    JButton btn_unreservation;
    JButton btn_querybook;
    JButton btn_addbook;
    JButton btn_deletebook;
    JButton btn_modifybook;
    JButton btn_borrowbook;
    JButton btn_returnbook;
    JButton btn_recommend;
    JButton btn_queryborrowstate;
    JButton btn_queryuserstate;
    JButton btn_dealbill;
    User user;

    LibraryClient() {
        signUp();
    }

    private void InitElement() {

    }

    private void InitLocation(int choice) {
        if (choice == 0) {
            loginFrame = new JFrame("Library System");
            desktopPane = new JDesktopPane();
            loginFrame.getContentPane().add(desktopPane, BorderLayout.CENTER);
            jb_user = new JLabel("用户名");
            jb_passwd = new JLabel("密   码");
            btn_login = new JButton("登录");
            btn_cancel = new JButton("取消");
            tf_user = new JTextField(15);
            tf_passwd = new JPasswordField(15);
            jb_user.setBounds(100, 70, 40, 25);
            jb_passwd.setBounds(100, 110, 40, 25);
            tf_user.setBounds(145, 70, 140, 25);
            tf_passwd.setBounds(145, 110, 140, 25);
            btn_login.setBounds(115, 155, 70, 25);
            btn_cancel.setBounds(210, 155, 70, 25);
            desktopPane.add(jb_user);
            desktopPane.add(jb_passwd);
            desktopPane.add(btn_login);
            desktopPane.add(btn_cancel);
            desktopPane.add(tf_user);
            desktopPane.add(tf_passwd);
            screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            loginFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            loginFrame.setResizable(false);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setSize(400, 300);
        } else {
            String[] t_role = {"Administrator", "Operator", "Reader"};
            mainFrame = new JFrame(t_role[choice - 1] + " Library System");
            mainPane = new JDesktopPane();
            mainFrame.getContentPane().add(mainPane, BorderLayout.CENTER);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setResizable(false);
            mainFrame.setSize(900, 600);
            mainFrame.setLocation(screenSize.width / 2 - mainFrame.getWidth() / 2,
                    screenSize.height / 2 - mainFrame.getHeight() / 2);
            btn_modifypasswd = new JButton("修改密码");
            btn_modifypasswd.setBounds(130, 0, 120, 35);
            mainPane.add(btn_modifypasswd);
            if (choice == 1) {
                btn_adduser = new JButton("增加用户");
                btn_deleteuser = new JButton("删除用户");
                btn_modifyuser = new JButton("修改用户");
                btn_queryuser = new JButton("查询用户");
                btn_adduser.setBounds(0, 0, 120, 35);
                btn_deleteuser.setBounds(0, 40, 120, 35);
                btn_modifyuser.setBounds(0, 80, 120, 35);
                btn_queryuser.setBounds(0, 120, 120, 35);
                mainPane.add(btn_adduser);
                mainPane.add(btn_deleteuser);
                mainPane.add(btn_modifyuser);
                mainPane.add(btn_queryuser);
            }else{
                if(choice == 2){
                    btn_messagebox = new JButton("消息");
                    btn_borrowbook = new JButton("借出书籍");
                    btn_returnbook = new JButton("归还书籍");
                    btn_querybook = new JButton("查询书籍");
                    btn_addbook = new JButton("增加书籍");
                    btn_deletebook = new JButton("删除书籍");
                    btn_modifybook = new JButton("修改书籍");
                    btn_unreservation = new JButton("取消预订");
                    btn_dealbill = new JButton("处理赔偿");
                    btn_queryuser = new JButton("查询账户");
                    btn_messagebox.setBounds(0, 0, 120, 35);
                    btn_borrowbook.setBounds(0, 40, 120, 35);
                    btn_returnbook.setBounds(0, 80, 120, 35);
                    btn_querybook.setBounds(0, 120, 120, 35);
                    btn_addbook.setBounds(0, 160, 120, 35);
                    btn_deletebook.setBounds(0, 200, 120, 35);
                    btn_modifybook.setBounds(0, 240, 120, 35);
                    btn_unreservation.setBounds(0, 280, 120, 35);
                    btn_dealbill.setBounds(0, 320, 120, 35);
                    btn_queryuser.setBounds(0, 360, 120, 35);
                    mainPane.add(btn_messagebox);
                    mainPane.add(btn_borrowbook);
                    mainPane.add(btn_returnbook);
                    mainPane.add(btn_querybook);
                    mainPane.add(btn_addbook);
                    mainPane.add(btn_deletebook);
                    mainPane.add(btn_modifybook);
                    mainPane.add(btn_unreservation);
                    mainPane.add(btn_dealbill);
                    mainPane.add(btn_queryuser);
                }else{
                    btn_messagebox = new JButton("消息");
                    btn_reservation = new JButton("预订");
                    btn_unreservation = new JButton("取消预订");
                    btn_querybook = new JButton("查询图书");
                    btn_recommend = new JButton("推荐图书");
                    btn_queryuserstate = new JButton("查询账户");
                    btn_queryborrowstate = new JButton("查询历史");
                    btn_messagebox.setBounds(0, 0, 120, 35);
                    btn_reservation.setBounds(0, 40, 120, 35);
                    btn_unreservation.setBounds(0, 80, 120, 35);
                    btn_querybook.setBounds(0, 120, 120, 35);
                    btn_recommend.setBounds(0, 160, 120, 35);
                    btn_queryuserstate.setBounds(0, 200, 120, 35);
                    btn_queryborrowstate.setBounds(0, 240, 120, 35);
                    mainPane.add(btn_messagebox);
                    mainPane.add(btn_reservation);
                    mainPane.add(btn_unreservation);
                    mainPane.add(btn_querybook);
                    mainPane.add(btn_recommend);
                    mainPane.add(btn_queryuserstate);
                    mainPane.add(btn_queryborrowstate);
                }
            }
        }
    }

    private void InitListener(int choice) {
        if(choice == 0){
        btn_login.addActionListener(this);
        btn_cancel.addActionListener(this);
        }else if(choice == 1){
            btn_modifypasswd.addActionListener(this);
            btn_adduser.addActionListener(this);
            btn_modifyuser.addActionListener(this);
            btn_deleteuser.addActionListener(this);
            btn_queryuser.addActionListener(this);
        }else if(choice == 2){
            btn_modifypasswd.addActionListener(this);
            btn_messagebox.addActionListener(this);
            btn_unreservation.addActionListener(this);
            btn_querybook.addActionListener(this);
            btn_addbook.addActionListener(this);
            btn_deletebook.addActionListener(this);
            btn_modifybook.addActionListener(this);
            btn_borrowbook.addActionListener(this);
            btn_returnbook.addActionListener(this);
            btn_dealbill.addActionListener(this);
        }else{
            btn_modifypasswd.addActionListener(this);
            btn_messagebox.addActionListener(this);
            btn_reservation.addActionListener(this);
            btn_unreservation.addActionListener(this);
            btn_querybook.addActionListener(this);
            btn_recommend.addActionListener(this);
            btn_queryborrowstate.addActionListener(this);
            btn_queryuserstate.addActionListener(this);
        }
    }

    private void signUp() {
        InitLocation(0);
        InitListener(0);
        loginFrame.setVisible(true);
    }

    private void AdminFrame() {
        InitLocation(1);
        InitListener(1);
        mainFrame.setVisible(true);
    }

    private void OperatorFrame() {
        InitLocation(2);
        InitListener(2);
        mainFrame.setVisible(true);
    }

    private void ReaderFrame() {
        InitLocation(3);
        InitListener(3);
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btn_login) {
            String tName = tf_user.getText();
            String tPass = String.valueOf(tf_passwd.getPassword());
            if(tName == null || tPass == null || tName.equals("") || tPass.equals("")){
                return;
            }
            User tUser = new User(tName,tPass," ",0,0);
            user = tUser.loginuser();
            if(user != null){
                System.out.println(user.getUserName() + user.getUserRole()+user.getUserPasswd()+tUser.getUserPasswd());
            }
            if(user == null){
                //return;
            }else if(tPass.equals(user.getUserPasswd())){
                System.out.println(user.getUserRole());
                if(user.getUserRole().equals("SystemAdmin")){
                    loginFrame.setVisible(false);
                    AdminFrame();
                }else if(user.getUserRole().equals("BookAdmin")){
                    loginFrame.setVisible(false);
                    OperatorFrame();
                }else{
                    loginFrame.setVisible(false);
                    ReaderFrame();
                }
            }else{
                tf_passwd.setText("");
            }
        }else if(ae.getSource() == btn_cancel){
            System.exit(0);
        }else if(ae.getSource() == btn_modifypasswd){
            System.exit(0);
        }else if(ae.getSource() == btn_adduser){
            System.exit(0);
        }else if(ae.getSource() == btn_modifyuser){
            System.exit(0);
        }else if(ae.getSource() == btn_deleteuser){
            System.exit(0);
        }else if(ae.getSource() == btn_queryuser){
            Admin admin = new Admin("Root","das","asd");
            admin.queryUser(admin);
        }else if(ae.getSource() == btn_messagebox){
            System.exit(0);
        }else if(ae.getSource() == btn_reservation){
            System.exit(0);
        }else if(ae.getSource() == btn_unreservation){
            System.exit(0);
        }else if(ae.getSource() == btn_querybook){
            System.exit(0);
        }else if(ae.getSource() == btn_addbook){
            System.exit(0);
        }else if(ae.getSource() == btn_deletebook){
            System.exit(0);
        }else if(ae.getSource() == btn_modifybook){
            System.exit(0);
        }else if(ae.getSource() == btn_borrowbook){
            System.exit(0);
        }else if(ae.getSource() == btn_returnbook){
            System.exit(0);
        }else if(ae.getSource() == btn_recommend){
            System.exit(0);
        }else if(ae.getSource() == btn_queryborrowstate){
            System.exit(0);
        }else if(ae.getSource() == btn_queryuserstate){
            System.exit(0);
        }else if(ae.getSource() == btn_dealbill){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        LibraryClient myClient = new LibraryClient();
    }
}
