package Clients;

public class Admin extends User {
    
    Sendmessage sendmessage;
    
    Admin(){
        setUserName(null);
        setUserPasswd(null);
        setUserRole(null);
        sendmessage = null;
    }
    
    Admin(String name, String passwd, String role) {
        setUserName(name);
        setUserPasswd(passwd);
        setUserRole(role);
        sendmessage = new Sendmessage();
    }
    
    public boolean addUser(User user){
        return false;
    }
    
    public boolean deleteUser(User user){
        return false;
    }
    
    public boolean modifyUser(User user){
        return false;
    }
    
    public boolean queryUser(User user){
        String sql = "SELECT * FORM USER WHERE name='" + user.getUserName() + "';";
        sendmessage.SendInfo(0, sql);
        return false;
    }
}
