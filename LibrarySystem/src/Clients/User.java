package Clients;

public class User {

    private String userName;
    private String userPasswd;
    private String userRole;
    private int userborrownum;
    private double userbalance;

    User() {
        userName = null;
        userPasswd = null;
        userRole = null;
    }

    User(String name, String passwd, String role) {
        userName = name;
        passwd = userPasswd;
        setUserRole(role);
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
