package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import model.Book;
import model.Card;
import model.UserName_Password;

/**
 * 查询卡信息
 * @author Administrator
 *
 */
public class Dao {
	/**
	 * 查询卡信息
	 * @param con
	 * @param card
	 * @return
	 * @throws Exception
	 */
	public Card selectCard(Connection con,Card card)throws Exception{
		Card resultCard=null;
		//设置sql语句
		String sql="select * from card where username=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, UserName_Password.userName);
		pstmt.setString(2, UserName_Password.password);
		//执行sql语句
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			//System.out.println("查到了");
			resultCard=new Card();
			resultCard.setUserName(UserName_Password.userName);
			resultCard.setPassword(UserName_Password.password);
			resultCard.setCardID(rs.getString("cardid"));
			resultCard.setBalance(rs.getString("balance"));
			resultCard.setStartDate(rs.getString("startdate"));
			resultCard.setIdNum(rs.getString("idnum"));
		}
		//关闭
		rs.close();
		pstmt.close();
		con.close();
		return resultCard;
	}
	
	/**
	 * 修改用户名
	 * @param con
	 * @param str
	 * @throws Exception
	 */
	public void changeName(Connection con,String str)throws Exception{
		//设置sql语句
		String sql="update card set username=? where username=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, str);
		pstmt.setString(2, UserName_Password.userName);
		pstmt.setString(3, UserName_Password.password);
		//执行sql语句
		ResultSet rs=pstmt.executeQuery();
		//关闭
		rs.close();
		pstmt.close();
		con.close();
	}
	
	/**
	 * 修改密码
	 * @param con
	 * @param password
	 * @throws Exception
	 */
	public void changePassword(Connection con,String password)throws Exception{
		//设置sql语句
		String sql="update card set password=? where username=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setString(2, UserName_Password.userName);
		pstmt.setString(3, UserName_Password.password);
		//执行sql语句
		ResultSet rs=pstmt.executeQuery();
		//关闭
		rs.close();
		pstmt.close();
		con.close();
	}
	
	/**
	 * 通过书名查找图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public Book findBook(Connection con,Book book,String bookName)throws Exception{
		Book bookFindRs=null;
		//设置sql语句
		String sql="select * from book where bookname=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookName);
		//执行sql语句
		ResultSet rs=pstmt.executeQuery();
		//保存查询信息到bookFindResult
		if(rs.next())
		{
			bookFindRs=new Book();
			bookFindRs.setAuthor(rs.getString("author"));
			bookFindRs.setBookId(rs.getString("bookid"));
			bookFindRs.setBookName(bookName);
			bookFindRs.setcBNum(rs.getString("cbnum"));
			bookFindRs.setColNum(rs.getString("colnum"));
			bookFindRs.setPublisher(rs.getString("publisher"));
			bookFindRs.setPublishTime(rs.getString("publishtime"));
			bookFindRs.setClass1(rs.getString("class"));
		}
		//如果没有查到
		else
		{
			JOptionPane.showMessageDialog(null, "未查询到数据！");
		}
		//关闭链接
		rs.close();
		pstmt.close();
		con.close();
		return bookFindRs;
	}
	
	/**
	 * 通过图书类别查找图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet findBook1(Connection con,String bookType)throws Exception{
		//设置sql语句
		String sql="select * from book where class=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookType);
		//执行sql语句
		ResultSet rs= pstmt.executeQuery();
		return rs;
	}
	
	/**
	 * 在借图书查询
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public ResultSet findBorrowedBook(Connection con,String cardID)throws Exception{
		//设置sql语句
		String sql="select bookname, author, publisher, borrowtime, returntime from borrowrecord natural join book where borrowrecord.cardid=? and status=0";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, cardID);
		//执行sql语句
		return pstmt.executeQuery();
	}
	
	/**
	 * 查询卡号
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public String selectCardID(Connection con)throws Exception{
		//设置sql语句
		String cardID=null;
		String sql="select * from card where username=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, UserName_Password.userName);
		pstmt.setString(2, UserName_Password.password);
		//执行sql语句
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			cardID=rs.getString("cardid");
		}
		//关闭数据库连接
		rs.close();
		pstmt.close();
		con.close();
		return cardID;
	}
	
	/**
	 * 查询书号
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public String selectBookID(Connection con,String bookName)throws Exception{
		//设置sql语句
		String bookID=null;
		String sql="select * from book where bookname=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookName);
		//执行sql语句
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			bookID=rs.getString("bookid");
		}
		//关闭数据库连接
		rs.close();
		pstmt.close();
		con.close();
		return bookID;
	}
	
	
	/**
	 * 续借
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public ResultSet renew(Connection con,String cardID)throws Exception{
		//设置sql语句
		String sql="select bookname, borrowtime, returntime from borrowrecord natural join book where borrowrecord.cardid=? and status=0";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, cardID);
		//执行sql语句
		return pstmt.executeQuery();
	}
	
	/**
	 * 修改还书日期
	 * @param con
	 * @param cardID
	 * @param bookID
	 */
	public void changeReturnTime(Connection con,String newReturnTime,String cardID,String bookID)throws Exception{
		//设置sql语句
		String sql="update borrowrecord set returntime=? where cardid=? and bookid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, newReturnTime);
		pstmt.setString(2, cardID);
		pstmt.setString(3, bookID);
		//执行sql语句
		pstmt.executeQuery();
		//关闭连接
		pstmt.close();
		con.close();
		return;
	}
}
