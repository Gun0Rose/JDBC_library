package model;
/**
 * 图书管理员实体
 * @author Mr.Aim
 *
 */

public class Admins {
	
	public Admins() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public Admins(String name, String sex, String birthday, String address, String post, String entertime,
			String salary, String idnum, String password) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.post = post;
		this.entertime = entertime;
		this.salary = salary;
		this.idnum = idnum;
		this.password = password;
	}

	private int workerid;
	private String name;
	private String sex;
	private String birthday;
	private String address;
	private String post;
	private String entertime;
	private String salary;
	private String idnum;
	private String password;
	public int getWorkerid() {
		return workerid;
	}
	public void setWorkerid(int workerid) {
		this.workerid = workerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getEntertime() {
		return entertime;
	}
	public void setEntertime(String entertime) {
		this.entertime = entertime;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
