package Clients;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{
    private String book_author;
    private String book_name;
    private String book_code;
    private String book_isbn;
    private String book_press;
    private Date book_publishdate;
    private int book_version;
    private double book_price;
    private String book_type;
    private int book_borrowednum;
    private int book_totalnum;
    private String book_describe;
    private String tempdate;
    

    public Book() {
        book_author = null;
        book_name = null;
        book_code = null;
        book_isbn = null;
        book_press = null;
        book_publishdate = null;
        book_version = 0;
        book_price = 0.0;
        book_type = null;
        book_borrowednum = 0;
        book_totalnum = 0;
        
    }

    public Book(String author, String name, String code, String isbn,String desc, String press, Date publishdate, int version,
            double price, String type, int borrowednum, int totalnum) {
        setBookauthor(author);
        setBookname(name);
        setBookcode(code);
        setBookisbn(isbn);
        setBookdescribe(desc);
        setBookpress(press);
        setBookpublishdate(publishdate);
        setBookversion(version);
        setBookprice(price);
        setBooktype(type);
        setBookborrowednum(borrowednum);
        setBooktotalnum(totalnum);
    }
    
    public Book(String name,String isbn){
        setBookname(name);
        setBookisbn(isbn);
    }

    public String getBookauthor() {
        return book_author;
    }

    public void setBookauthor(String book_author) {
        this.book_author = book_author;
    }

    public String getBookname() {
        return book_name;
    }

    public void setBookname(String book_name) {
        this.book_name = book_name;
    }

    public String getBookisbn() {
        return book_isbn;
    }

    public void setBookisbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getBookpress() {
        return book_press;
    }

    public void setBookpress(String book_press) {
        this.book_press = book_press;
    }

    public Date getBookpublishdate() {
        return book_publishdate;
    }

    public void setBookpublishdate(Date book_publishdate) {
        this.book_publishdate = book_publishdate;
    }

    public int getBookversion() {
        return book_version;
    }

    public void setBookversion(int version) {
        this.book_version = version;
    }

    public double getBookprice() {
        return book_price;
    }

    public void setBookprice(double book_price) {
        this.book_price = book_price;
    }

    public String getBooktype() {
        return book_type;
    }

    public void setBooktype(String book_type) {
        this.book_type = book_type;
    }

    public int getBookborrowednum() {
        return book_borrowednum;
    }

    public void setBookborrowednum(int book_borrowednum) {
        this.book_borrowednum = book_borrowednum;
    }

    public int getBooktotalnum() {
        return book_totalnum;
    }

    public void setBooktotalnum(int book_totalnum) {
        this.book_totalnum = book_totalnum;
    }

    public String getBookcode() {
        return book_code;
    }

    public void setBookcode(String book_code) {
        this.book_code = book_code;
    }

    public String getBookdescribe() {
        return book_describe;
    }

    public void setBookdescribe(String book_describe) {
        this.book_describe = book_describe;
    }

    public String getTempdate() {
        return tempdate;
    }

    public void setTempdate(String tempdate) {
        this.tempdate = tempdate;
    }
}
