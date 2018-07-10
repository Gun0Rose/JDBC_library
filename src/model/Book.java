package model;

/**
 * 图书实体
 * @author Administrator
 *
 */
public class Book {
	private String bookId;
	private String bookName;
	private String author;
	private String publisher;
	private String publishTime;
	private String colNum;
	private String cBNum;
	private String class1;
	
	public Book() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	/**
	 * get/set方法
	 * @return
	 */
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getColNum() {
		return colNum;
	}
	public void setColNum(String colNum) {
		this.colNum = colNum;
	}
	public String getcBNum() {
		return cBNum;
	}
	public void setcBNum(String cBNum) {
		this.cBNum = cBNum;
	}
	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

}
