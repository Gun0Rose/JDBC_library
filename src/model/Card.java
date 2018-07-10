package model;

/**
 * 卡实体
 * @author Administrator
 *
 */
public class Card {
	private String cardID;
	private String userName;
	private String password;
	private String balance;
	private String startDate;
	private String idNum;
	
	/**
	 * 创建构造函数
	 */
	public Card() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	
	public Card(String balance) {
		super();
		this.balance = balance;
	}


	/**
	 * get/set方法
	 * @return
	 */
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNumber) {
		this.idNum = idNumber;
	}
}
