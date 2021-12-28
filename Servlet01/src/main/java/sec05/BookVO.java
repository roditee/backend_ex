package sec05;

import java.util.Date;

public class BookVO {
	private String no;
	private String name;
	private String author;
	private int price;
	private Date date;
	private String pubNo;
	
	// ����Ʈ ������
		public BookVO() { }
		
	// ����� �Ű����� �ִ� ������ �ʿ� ����
		
	public BookVO(String no, String name, String author, int price, Date date, String pubNo) {
		this.no = no;
		this.name = name;
		this.author = author;
		this.price = price;
		this.date = date;
		this.pubNo = pubNo;
	}

	// Getters / Setters
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPubNo() {
		return pubNo;
	}

	public void setPubNo(String pubNo) {
		this.pubNo = pubNo;
	}
}
