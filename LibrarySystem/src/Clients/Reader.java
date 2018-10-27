package Clients;

public class Reader extends User {
    
    Reader(){
        setUserName(null);
        setUserPasswd(null);
        setUserRole(null);
    }
    
    Reader(String name, String passwd, String role) {
        setUserName(name);
        setUserPasswd(passwd);
        setUserRole(role);
    }
    
    public void messageBox(){
        
    }
    
    public void reserveBook(){
        
    }
    
    public void unreserveBook() {
        
    }
    
    public void queryBook(){
        
    }
    
    public void recommendBook(){
        
    }
    
    public void queryUserState(){
        
    }
    
    public void queryBorrowState(){
        
    }
}
