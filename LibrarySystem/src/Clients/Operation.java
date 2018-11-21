package Clients;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable {
    
    private String username;
    private String bookname;
    private String isbn;
    private Date breakdate;
    private String back;
    private int state;
    
    public Operation(){
        username = null;
        bookname = null;
        isbn = null;
        breakdate = null;
        back = null;
        state = 0;
    }
    
    public Operation(String user,String book,String is,Date borrow,String due,int s){
        username = user;
        bookname = book;
        isbn = is;
        breakdate = borrow;
        back = due;
        state = s;
    }
    
    
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Date getBorrowdate() {
        return breakdate;
    }
    public void setBorrowdate(Date borrowdate) {
        this.breakdate = borrowdate;
    }
    public String getDuedate() {
        return back;
    }
    public void setDuedate(String duedate) {
        this.back = duedate;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
