package sec07;

import java.util.Date;
// DB : servletdb - book
public class BookVO {
	private String book_no;
	private String book_name;
	private int book_price;
	private String book_author;
	private Date book_date;
	private String book_pubNo;

	public BookVO() {
		
	}
	
	public BookVO(String bookNo, String bookName, int bookPrice, String bookAuthor, Date bookDate, String pubNo) {
		super();
		this.book_no = bookNo;
		this.book_name = bookName;
		this.book_price = bookPrice;
		this.book_author = bookAuthor;
		this.book_date = bookDate;
		this.book_pubNo = pubNo;
	}
	
	public String getBookNo() {
		return book_no;
	}

	public void setBookNo(String bookNo) {
		this.book_no = bookNo;
	}

	public String getBookName() {
		return book_name;
	}

	public void setBookName(String bookName) {
		this.book_name = bookName;
	}

	public int getBookPrice() {
		return book_price;
	}

	public void setBookPrice(int bookPrice) {
		this.book_price = bookPrice;
	}

	public String getBookAuthor() {
		return book_author;
	}

	public void setBookAuthor(String bookAuthor) {
		this.book_author = bookAuthor;
	}

	public Date getBookDate() {
		return book_date;
	}

	public void setBookDate(Date bookDate) {
		this.book_date = bookDate;
	}

	public String getPubNo() {
		return book_pubNo;
	}

	public void setPubNo(String pubNo) {
		this.book_pubNo = pubNo;
	}

	
}