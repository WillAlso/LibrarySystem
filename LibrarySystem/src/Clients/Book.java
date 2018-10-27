package Clients;

import java.util.Date;

public class Book {
    private String book_author;
    private String book_name;
    private String book_code;
    private String book_isbn;
    private String book_press;
    private Date book_publishdate;
    private String book_version;
    private double book_price;
    private String book_type;
    private int book_borrowednum;
    private int book_totalnum;

    Book() {
        book_author = null;
        book_name = null;
        book_code = null;
        book_isbn = null;
        book_press = null;
        book_publishdate = null;
        book_version = null;
        book_price = 0.0;
        book_type = null;
        book_borrowednum = 0;
        book_totalnum = 0;
    }

    Book(String author, String name, String code, String isbn, String press, Date publishdate, String version,
            double price, String type, int borrowednum, int totalnum) {
        setBookauthor(author);
        setBookname(name);
        setBookcode(code);
        setBookisbn(isbn);
        setBookpress(press);
        setBookpublishdate(publishdate);
        setBookversion(version);
        setBookprice(price);
        setBooktype(type);
        setBookborrowednum(borrowednum);
        setBooktotalnum(totalnum);
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

    public String getBookversion() {
        return book_version;
    }

    public void setBookversion(String book_version) {
        this.book_version = book_version;
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
}
