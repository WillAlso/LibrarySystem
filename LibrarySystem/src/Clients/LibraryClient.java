package Clients;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EtchedBorder;


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
    JLabel t1;
    JLabel t2;
    JLabel t3;
    JLabel t4;
    JLabel tLabel;
    JLabel t5;
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
            } else {
                if (choice == 2) {
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
                } else {
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
        if (choice == 0) {
            btn_login.addActionListener(this);
            btn_cancel.addActionListener(this);
        } else if (choice == 1) {
            btn_modifypasswd.addActionListener(this);
            btn_adduser.addActionListener(this);
            btn_modifyuser.addActionListener(this);
            btn_deleteuser.addActionListener(this);
            btn_queryuser.addActionListener(this);
        } else if (choice == 2) {
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
        } else {
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
            if (tName == null || tPass == null || tName.equals("") || tPass.equals("")) {
                return;
            }
            User tUser = new User(tName, tPass, " ", 0, 0);
            user = tUser.loginuser();
            if (user != null) {
                System.out.println(user.getUserName() + user.getUserRole() + user.getUserPasswd()
                        + tUser.getUserPasswd());
            }
            if (user == null) {
                // return;
            } else if (tPass.equals(user.getUserPasswd())) {
                System.out.println(user.getUserRole());
                if (user.getUserRole().equals("SystemAdmin")) {
                    loginFrame.setVisible(false);
                    AdminFrame();
                } else if (user.getUserRole().equals("BookAdmin")) {
                    loginFrame.setVisible(false);
                    OperatorFrame();
                } else {
                    loginFrame.setVisible(false);
                    ReaderFrame();
                }
            } else {
                tf_passwd.setText("");
            }
        } else if (ae.getSource() == btn_cancel) {
            System.exit(0);
        } else if (ae.getSource() == btn_modifypasswd) {
            subFrame = new JFrame("修改密码");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel oldpass = new JLabel("旧密码");
            JLabel newpass = new JLabel("新密码");
            JTextField oldfField = new JTextField();
            JTextField newField = new JTextField();
            t5 = new JLabel();
            subPane.add(oldpass);
            subPane.add(newpass);
            subPane.add(oldfField);
            subPane.add(newField);
            subPane.add(t5);
            oldpass.setBounds(60, 30, 70, 25);
            oldfField.setBounds(120, 30, 180, 25);
            newpass.setBounds(60, 80, 70, 25);
            newField.setBounds(120, 80, 180, 25);
            t5.setBounds(150, 110, 70, 25);
            t5.setForeground(new Color(255, 0, 0));
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            subPane.add(confirm);
            subPane.add(tcancel);
            confirm.setBounds(110, 135, 65, 25);
            tcancel.setBounds(205, 135, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Admin admin = new Admin();
                    User tUser = new User();
                    tUser = admin.queryUser(user);
                    String pass = tUser.getUserPasswd();
                    String toldpass = oldfField.getText();
                    String tnewpass = newField.getText();
                    if (pass.equals(toldpass)) {
                        tUser.setUserName(user.getUserName());
                        tUser.setUserPasswd(tnewpass);
                        tUser.changePassword(tUser);
                        t5.setText("修改成功");
                    } else {
                        t5.setText("密码错误");
                    }
                    subFrame.validate();
                }
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        } else if (ae.getSource() == btn_adduser) {
            subFrame = new JFrame("增加用户");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel modifylabel = new JLabel("增加用户");
            JTextField modifyuser = new JTextField();
            JTextField modifypass = new JTextField();
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            JLabel rolelabel = new JLabel("角色选择");
            JLabel passlable = new JLabel("用户密码");
            String[] listbox = {"SystemAdmin", "BookAdmin", "Reader"};
            JComboBox<String> roleBox = new JComboBox<String>(listbox);
            subPane.add(modifylabel);
            subPane.add(modifyuser);
            subPane.add(rolelabel);
            subPane.add(confirm);
            subPane.add(roleBox);
            subPane.add(modifypass);
            subPane.add(passlable);
            subPane.add(tcancel);
            modifylabel.setBounds(60, 20, 80, 25);
            modifyuser.setBounds(130, 20, 180, 25);
            passlable.setBounds(60, 50, 80, 25);
            modifypass.setBounds(130, 50, 180, 25);
            rolelabel.setBounds(60, 80, 80, 25);
            roleBox.setBounds(130, 80, 120, 25);
            confirm.setBounds(110, 135, 65, 25);
            tcancel.setBounds(205, 135, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (modifyuser.getText() == null || modifyuser.getText().equals("")) {
                        return;
                    }
                    if (modifypass.getText() == null || modifypass.getText().equals("")) {
                        return;
                    }
                    if (roleBox.getSelectedIndex() == -1) {
                        return;
                    }
                    String name = modifyuser.getText();
                    String pass = modifypass.getText();
                    String role = (String) roleBox.getSelectedItem();
                    Admin tAdmin = new Admin(name, pass, role);
                    tAdmin.setUserborrownum(0);
                    tAdmin.setUserbalance(0);
                    JLabel tLabel;
                    if (tAdmin.addUser(tAdmin)) {
                        tLabel = new JLabel("增加成功");
                    } else {
                        tLabel = new JLabel("增加失败");
                    }
                    subPane.add(tLabel);
                    tLabel.setForeground(new Color(255, 0, 0));
                    tLabel.setBounds(150, 105, 65, 25);
                }
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        } else if (ae.getSource() == btn_modifyuser) {
            subFrame = new JFrame("修改用户");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel modifylabel = new JLabel("修改用户");
            JTextField modifyuser = new JTextField();
            JTextField modifypass = new JTextField();
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            JLabel rolelabel = new JLabel("角色选择");
            JLabel passlable = new JLabel("用户密码");
            String[] listbox = {"SystemAdmin", "BookAdmin", "Reader"};
            JComboBox<String> roleBox = new JComboBox<String>(listbox);
            subPane.add(modifylabel);
            subPane.add(modifyuser);
            subPane.add(rolelabel);
            subPane.add(confirm);
            subPane.add(roleBox);
            subPane.add(modifypass);
            subPane.add(passlable);
            subPane.add(tcancel);
            modifylabel.setBounds(60, 20, 80, 25);
            modifyuser.setBounds(130, 20, 180, 25);
            passlable.setBounds(60, 50, 80, 25);
            modifypass.setBounds(130, 50, 180, 25);
            rolelabel.setBounds(60, 80, 80, 25);
            roleBox.setBounds(130, 80, 120, 25);
            confirm.setBounds(110, 135, 65, 25);
            tcancel.setBounds(205, 135, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (modifyuser.getText() == null || modifyuser.getText().equals("")) {
                        return;
                    }
                    if (modifypass.getText() == null || modifypass.getText().equals("")) {
                        return;
                    }
                    if (roleBox.getSelectedIndex() == -1) {
                        return;
                    }
                    String name = modifyuser.getText();
                    String pass = modifypass.getText();
                    String role = (String) roleBox.getSelectedItem();
                    Admin tAdmin = new Admin(name, pass, role);
                    JLabel tLabel;
                    if (tAdmin.modifyUser(tAdmin)) {
                        tLabel = new JLabel("修改成功");
                    } else {
                        tLabel = new JLabel("修改失败");
                    }
                    subPane.add(tLabel);
                    tLabel.setForeground(new Color(255, 0, 0));
                    tLabel.setBounds(150, 105, 65, 25);
                }
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        } else if (ae.getSource() == btn_deleteuser) {
            subFrame = new JFrame("删除用户");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel querylabel = new JLabel("删除用户");
            JTextField queryuser = new JTextField();
            JButton confirm = new JButton("确定");
            subPane.add(querylabel);
            subPane.add(queryuser);
            subPane.add(confirm);
            querylabel.setBounds(60, 20, 80, 25);
            queryuser.setBounds(130, 20, 120, 25);
            confirm.setBounds(260, 20, 65, 25);
            t1 = new JLabel();
            t2 = new JLabel();
            t3 = new JLabel();
            t4 = new JLabel();
            tLabel = new JLabel();
            subPane.add(t1);
            subPane.add(t2);
            subPane.add(t3);
            subPane.add(t4);
            subPane.add(tLabel);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String n = queryuser.getText();

                    if (n != null && !n.equals("")) {
                        Admin admin = new Admin(n, "", "");
                        User u = admin.queryUser(admin);
                        if (u != null) {
                            // System.out.println(u.getUserName()+u.getUserPasswd()+u.getUserRole());
                            String m1 = "用户名: " + u.getUserName();
                            String m2 = "角   色: " + u.getUserRole();
                            String m3 = "余   额: " + u.getUserbalance() + " 元";
                            String m4 = "借书量: " + u.getUserborrownum() + " 本";
                            t1.setText(m1);
                            t2.setText(m2);
                            t3.setText(m3);
                            t4.setText(m4);
                            t1.setBounds(60, 50, m1.length() * 25, 30);
                            t2.setBounds(60, 90, m2.length() * 25, 30);
                            t3.setBounds(60, 130, m3.length() * 25, 30);
                            t4.setBounds(60, 170, m4.length() * 25, 30);
                            if (admin.deleteUser(admin)) {
                                tLabel.setText("删除成功");
                            }
                            tLabel.setBounds(120, 210, 65, 25);
                            tLabel.setForeground(new Color(255, 0, 0));
                            subFrame.validate();
                        } else {
                            String m1 = "删除用户不存在!";
                            t1.setText(m1);
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            tLabel.setText("");
                            t1.setBounds(60, 50, m1.length() * 25, 30);
                            subFrame.validate();
                        }
                    }
                }
            });
        } else if (ae.getSource() == btn_queryuser) {
            subFrame = new JFrame("查询用户");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel querylabel = new JLabel("查询用户");
            JTextField queryuser = new JTextField();
            JButton confirm = new JButton("确定");
            subPane.add(querylabel);
            subPane.add(queryuser);
            subPane.add(confirm);
            querylabel.setBounds(60, 20, 80, 25);
            queryuser.setBounds(130, 20, 120, 25);
            confirm.setBounds(260, 20, 65, 25);
            t1 = new JLabel();
            t2 = new JLabel();
            t3 = new JLabel();
            t4 = new JLabel();
            subPane.add(t1);
            subPane.add(t2);
            subPane.add(t3);
            subPane.add(t4);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String n = queryuser.getText();
                    if (n != null && !n.equals("")) {
                        Admin admin = new Admin(n, "", "");
                        User u = admin.queryUser(admin);
                        if (u != null) {
                            // System.out.println(u.getUserName()+u.getUserPasswd()+u.getUserRole());
                            String m1 = "用户名: " + u.getUserName();
                            String m2 = "角   色: " + u.getUserRole();
                            String m3 = "余   额: " + u.getUserbalance() + " 元";
                            String m4 = "借书量: " + u.getUserborrownum() + " 本";
                            t1.setText(m1);
                            t2.setText(m2);
                            t3.setText(m3);
                            t4.setText(m4);
                            t1.setBounds(60, 50, m1.length() * 25, 30);
                            t2.setBounds(60, 90, m2.length() * 25, 30);
                            t3.setBounds(60, 130, m3.length() * 25, 30);
                            t4.setBounds(60, 170, m4.length() * 25, 30);
                            subFrame.validate();
                        } else {
                            String m1 = "查询信息不存在!";
                            t1.setText(m1);
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t1.setBounds(60, 50, m1.length() * 25, 30);
                            subFrame.validate();
                        }
                    }
                }
            });
        } else if (ae.getSource() == btn_messagebox) {
            subFrame = new JFrame(user.getUserName() + "的消息");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            Reader tReader = new Reader();
            tReader.setUserName(user.getUserName());
            String[] tmeaasge = tReader.messageBox();
            int len = 0;
            if (tmeaasge != null) {
                len = tmeaasge.length;
            }
            Vector<String> v = new Vector<String>();
            if (len <= 0) {
                v.add("暂无消息");
            } else {
                for (int i = 0; i < len; i++) {
                    v.add(tmeaasge[i]);
                }
            }
            ListModel model = new DefaultComboBoxModel(v);
            JList messList = new JList(model);
            messList.setBorder(new EtchedBorder(EtchedBorder.LOWERED,null,null));
            subPane.add(messList);
            messList.setBounds(20, 20, 360, 200);
            subFrame.setVisible(true);
        } else if (ae.getSource() == btn_reservation) {
            subFrame = new JFrame("预订书籍");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel bookLabel = new JLabel("书名");
            JLabel isbnLabel = new JLabel("ISBN");
            JTextField bookField = new JTextField();
            JTextField isbnField = new JTextField();
            subPane.add(bookLabel);
            subPane.add(isbnLabel);
            subPane.add(bookField);
            subPane.add(isbnField);
            bookLabel.setBounds(60, 30, 70, 25);
            bookField.setBounds(120, 30, 180, 25);
            isbnLabel.setBounds(60, 80, 70, 25);
            isbnField.setBounds(120, 80, 180, 25);
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            subPane.add(confirm);
            subPane.add(tcancel);
            confirm.setBounds(110, 135, 65, 25);
            tcancel.setBounds(205, 135, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {}
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        } else if (ae.getSource() == btn_unreservation) {
            subFrame = new JFrame("取消预订");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel bookLabel = new JLabel("书名");
            JLabel isbnLabel = new JLabel("ISBN");
            JTextField bookField = new JTextField();
            JTextField isbnField = new JTextField();
            subPane.add(bookLabel);
            subPane.add(isbnLabel);
            subPane.add(bookField);
            subPane.add(isbnField);
            bookLabel.setBounds(60, 30, 70, 25);
            bookField.setBounds(120, 30, 180, 25);
            isbnLabel.setBounds(60, 80, 70, 25);
            isbnField.setBounds(120, 80, 180, 25);
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            subPane.add(confirm);
            subPane.add(tcancel);
            confirm.setBounds(110, 135, 65, 25);
            tcancel.setBounds(205, 135, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {}
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        } else if (ae.getSource() == btn_querybook) {
            subFrame = new JFrame("查询图书");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel bookLabel = new JLabel("书名");
            JLabel isbnLabel = new JLabel("ISBN");
            JTextField bookField = new JTextField();
            JTextField isbnField = new JTextField();
            subPane.add(bookLabel);
            subPane.add(isbnLabel);
            subPane.add(bookField);
            subPane.add(isbnField);
            bookLabel.setBounds(60, 30, 70, 25);
            bookField.setBounds(120, 30, 180, 25);
            isbnLabel.setBounds(60, 80, 70, 25);
            isbnField.setBounds(120, 80, 180, 25);
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            subPane.add(confirm);
            subPane.add(tcancel);
            confirm.setBounds(110, 135, 65, 25);
            tcancel.setBounds(205, 135, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {}
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        } else if (ae.getSource() == btn_addbook) {
            subFrame = new JFrame("修改用户");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 400);
            JLabel bookLabel = new JLabel("书名");
            JLabel isbnLabel = new JLabel("ISBN");
            JLabel codeLabel = new JLabel("索书码");
            JLabel authorLabel = new JLabel("作者");
            JLabel typeLabel = new JLabel("类型");
            JLabel descLabel = new JLabel("描述");
            JLabel dateLabel = new JLabel("出版日期");
            JLabel versionLabel = new JLabel("版本");
            JLabel priceLabel = new JLabel("价格");
            JLabel totalLabel = new JLabel("数目");
            JTextField bookField = new JTextField();
            JTextField isbnField = new JTextField();
            JTextField codeField = new JTextField();
            JTextField authorField = new JTextField();
            JTextField typeField = new JTextField();
            JTextField descField = new JTextField();
            JTextField dateField = new JTextField();
            JTextField versionField = new JTextField();
            JTextField priceField = new JTextField();
            JTextField totalField = new JTextField();
            subPane.add(bookLabel);
            subPane.add(isbnLabel);
            subPane.add(codeLabel);
            subPane.add(authorLabel);
            subPane.add(typeLabel);
            subPane.add(descLabel);
            subPane.add(dateLabel);
            subPane.add(versionLabel);
            subPane.add(priceLabel);
            subPane.add(totalLabel);
            subPane.add(bookField);
            subPane.add(isbnField);
            subPane.add(codeField);
            subPane.add(authorField);
            subPane.add(typeField);
            subPane.add(descField);
            subPane.add(dateField);
            subPane.add(versionField);
            subPane.add(priceField);
            subPane.add(totalField);
            bookLabel.setBounds(60, 20, 70, 25);
            bookField.setBounds(120, 20, 180, 25);
            isbnLabel.setBounds(60, 50, 70, 25);
            isbnField.setBounds(120, 50, 180, 25);
            codeLabel.setBounds(60, 80, 70, 25);
            codeField.setBounds(120, 80, 180, 25);
            authorLabel.setBounds(60, 110, 70, 25);
            authorField.setBounds(120, 110, 180, 25);
            typeLabel.setBounds(60, 140, 70, 25);
            typeField.setBounds(120, 140, 180, 25);
            descLabel.setBounds(60, 170, 70, 25);
            descField.setBounds(120, 170, 180, 25);
            dateLabel.setBounds(60, 200, 70, 25);
            dateField.setBounds(120, 200, 180, 25);
            versionLabel.setBounds(60, 230, 70, 25);
            versionField.setBounds(120, 230, 180, 25);
            priceLabel.setBounds(60, 260, 70, 25);
            priceField.setBounds(120, 260, 180, 25);
            totalLabel.setBounds(60, 290, 70, 25);
            totalField.setBounds(120, 290, 180, 25);
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            subPane.add(confirm);
            subPane.add(tcancel);
            confirm.setBounds(110, 330, 65, 25);
            tcancel.setBounds(205, 330, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {}
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        } else if (ae.getSource() == btn_deletebook) {
            subFrame = new JFrame("删除图书");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel bookLabel = new JLabel("书名");
            JLabel isbnLabel = new JLabel("ISBN");
            JTextField bookField = new JTextField();
            JTextField isbnField = new JTextField();
            subPane.add(bookLabel);
            subPane.add(isbnLabel);
            subPane.add(bookField);
            subPane.add(isbnField);
            bookLabel.setBounds(60, 30, 70, 25);
            bookField.setBounds(120, 30, 180, 25);
            isbnLabel.setBounds(60, 80, 70, 25);
            isbnField.setBounds(120, 80, 180, 25);
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            subPane.add(confirm);
            subPane.add(tcancel);
            confirm.setBounds(110, 135, 65, 25);
            tcancel.setBounds(205, 135, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {}
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        } else if (ae.getSource() == btn_modifybook) {
            subFrame = new JFrame("修改用户");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 400);
            JLabel bookLabel = new JLabel("书名");
            JLabel isbnLabel = new JLabel("ISBN");
            JLabel codeLabel = new JLabel("索书码");
            JLabel authorLabel = new JLabel("作者");
            JLabel typeLabel = new JLabel("类型");
            JLabel descLabel = new JLabel("描述");
            JLabel dateLabel = new JLabel("出版日期");
            JLabel versionLabel = new JLabel("版本");
            JLabel priceLabel = new JLabel("价格");
            JLabel totalLabel = new JLabel("数目");
            JTextField bookField = new JTextField();
            JTextField isbnField = new JTextField();
            JTextField codeField = new JTextField();
            JTextField authorField = new JTextField();
            JTextField typeField = new JTextField();
            JTextField descField = new JTextField();
            JTextField dateField = new JTextField();
            JTextField versionField = new JTextField();
            JTextField priceField = new JTextField();
            JTextField totalField = new JTextField();
            subPane.add(bookLabel);
            subPane.add(isbnLabel);
            subPane.add(codeLabel);
            subPane.add(authorLabel);
            subPane.add(typeLabel);
            subPane.add(descLabel);
            subPane.add(dateLabel);
            subPane.add(versionLabel);
            subPane.add(priceLabel);
            subPane.add(totalLabel);
            subPane.add(bookField);
            subPane.add(isbnField);
            subPane.add(codeField);
            subPane.add(authorField);
            subPane.add(typeField);
            subPane.add(descField);
            subPane.add(dateField);
            subPane.add(versionField);
            subPane.add(priceField);
            subPane.add(totalField);
            bookLabel.setBounds(60, 20, 70, 25);
            bookField.setBounds(120, 20, 180, 25);
            isbnLabel.setBounds(60, 50, 70, 25);
            isbnField.setBounds(120, 50, 180, 25);
            codeLabel.setBounds(60, 80, 70, 25);
            codeField.setBounds(120, 80, 180, 25);
            authorLabel.setBounds(60, 110, 70, 25);
            authorField.setBounds(120, 110, 180, 25);
            typeLabel.setBounds(60, 140, 70, 25);
            typeField.setBounds(120, 140, 180, 25);
            descLabel.setBounds(60, 170, 70, 25);
            descField.setBounds(120, 170, 180, 25);
            dateLabel.setBounds(60, 200, 70, 25);
            dateField.setBounds(120, 200, 180, 25);
            versionLabel.setBounds(60, 230, 70, 25);
            versionField.setBounds(120, 230, 180, 25);
            priceLabel.setBounds(60, 260, 70, 25);
            priceField.setBounds(120, 260, 180, 25);
            totalLabel.setBounds(60, 290, 70, 25);
            totalField.setBounds(120, 290, 180, 25);
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            subPane.add(confirm);
            subPane.add(tcancel);
            confirm.setBounds(110, 330, 65, 25);
            tcancel.setBounds(205, 330, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {}
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
            JButton search = new JButton("搜索");
            subPane.add(search);
            search.setBounds(310, 50, 65, 25);
            search.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {}
            });
        } else if (ae.getSource() == btn_borrowbook) {
            subFrame = new JFrame("借阅图书");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel bookLabel = new JLabel("书名");
            JLabel isbnLabel = new JLabel("ISBN");
            JLabel readerLabel = new JLabel("借阅者");
            JTextField bookField = new JTextField();
            JTextField isbnField = new JTextField();
            JTextField readerField = new JTextField();
            subPane.add(bookLabel);
            subPane.add(isbnLabel);
            subPane.add(bookField);
            subPane.add(isbnField);
            subPane.add(readerLabel);
            subPane.add(readerField);
            bookLabel.setBounds(60, 30, 70, 25);
            bookField.setBounds(120, 30, 180, 25);
            isbnLabel.setBounds(60, 65, 70, 25);
            isbnField.setBounds(120, 65, 180, 25);
            readerLabel.setBounds(60, 100, 70, 25);
            readerField.setBounds(120, 100, 180, 25);
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            subPane.add(confirm);
            subPane.add(tcancel);
            confirm.setBounds(110, 145, 65, 25);
            tcancel.setBounds(205, 145, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {}
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        } else if (ae.getSource() == btn_returnbook) {
            subFrame = new JFrame("归还图书");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel bookLabel = new JLabel("书名");
            JLabel isbnLabel = new JLabel("ISBN");
            JLabel readerLabel = new JLabel("归还者");
            JTextField bookField = new JTextField();
            JTextField isbnField = new JTextField();
            JTextField readerField = new JTextField();
            subPane.add(bookLabel);
            subPane.add(isbnLabel);
            subPane.add(bookField);
            subPane.add(isbnField);
            subPane.add(readerLabel);
            subPane.add(readerField);
            bookLabel.setBounds(60, 30, 70, 25);
            bookField.setBounds(120, 30, 180, 25);
            isbnLabel.setBounds(60, 65, 70, 25);
            isbnField.setBounds(120, 65, 180, 25);
            readerLabel.setBounds(60, 100, 70, 25);
            readerField.setBounds(120, 100, 180, 25);
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            subPane.add(confirm);
            subPane.add(tcancel);
            confirm.setBounds(110, 145, 65, 25);
            tcancel.setBounds(205, 145, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {}
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        } else if (ae.getSource() == btn_recommend) {
            subFrame = new JFrame("推荐图书");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel bookLabel = new JLabel("书名");
            JLabel isbnLabel = new JLabel("ISBN");
            JLabel contactLabel = new JLabel("联系方式");
            JTextField bookField = new JTextField();
            JTextField isbnField = new JTextField();
            JTextField contactField = new JTextField();
            subPane.add(bookLabel);
            subPane.add(isbnLabel);
            subPane.add(bookField);
            subPane.add(isbnField);
            subPane.add(contactLabel);
            subPane.add(contactField);
            bookLabel.setBounds(60, 30, 70, 25);
            bookField.setBounds(120, 30, 180, 25);
            isbnLabel.setBounds(60, 65, 70, 25);
            isbnField.setBounds(120, 65, 180, 25);
            contactLabel.setBounds(60, 100, 70, 25);
            contactField.setBounds(120, 100, 180, 25);
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            subPane.add(confirm);
            subPane.add(tcancel);
            confirm.setBounds(110, 145, 65, 25);
            tcancel.setBounds(205, 145, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {}
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        } else if (ae.getSource() == btn_queryborrowstate) {
            subFrame = new JFrame("修改用户");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            subFrame.setVisible(true);
        } else if (ae.getSource() == btn_queryuserstate) {
            subFrame = new JFrame("修改用户");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            subFrame.setVisible(true);
        } else if (ae.getSource() == btn_dealbill) {
            subFrame = new JFrame("处理赔偿");
            subPane = new JDesktopPane();
            subFrame.getContentPane().add(subPane, BorderLayout.CENTER);
            subFrame.setLocation(screenSize.width / 2 - 400 / 2, screenSize.height / 2 - 300 / 2);
            subFrame.setResizable(false);
            subFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            subFrame.setSize(400, 300);
            JLabel bookLabel = new JLabel("书名");
            JLabel readLabel = new JLabel("借阅者");
            JLabel billLabel = new JLabel("消费金额");
            JTextField bookField = new JTextField();
            JTextField readField = new JTextField();
            JTextField billField = new JTextField();
            subPane.add(bookLabel);
            subPane.add(readLabel);
            subPane.add(bookField);
            subPane.add(readField);
            subPane.add(billLabel);
            subPane.add(billField);
            bookLabel.setBounds(60, 30, 70, 25);
            bookField.setBounds(120, 30, 180, 25);
            readLabel.setBounds(60, 65, 70, 25);
            readField.setBounds(120, 65, 180, 25);
            billLabel.setBounds(60, 100, 70, 25);
            billField.setBounds(120, 100, 180, 25);
            JButton confirm = new JButton("确定");
            JButton tcancel = new JButton("取消");
            subPane.add(confirm);
            subPane.add(tcancel);
            confirm.setBounds(110, 145, 65, 25);
            tcancel.setBounds(205, 145, 65, 25);
            subFrame.setVisible(true);
            confirm.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {}
            });
            tcancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    subFrame.dispose();
                    subFrame.setVisible(false);
                }
            });
        }
    }

    public static void main(String[] args) {
        LibraryClient myClient = new LibraryClient();
    }
}
