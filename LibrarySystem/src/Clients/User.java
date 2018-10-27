package Clients;

public class User {

    private String userName;
    private String userPasswd;
    private String userRole;

    User() {
        userName = null;
        userPasswd = null;
        setUserRole(null);
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

}
