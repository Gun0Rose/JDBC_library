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
 * ��ѯ����Ϣ
 * @author Administrator
 *
 */
public class Dao {
	/**
	 * ��ѯ����Ϣ
	 * @param con
	 * @param card
	 * @return
	 * @throws Exception
	 */
	public Card selectCard(Connection con,Card card)throws Exception{
		Card resultCard=null;
		//����sql���
		String sql="select * from card where username=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, UserName_Password.userName);
		pstmt.setString(2, UserName_Password.password);
		//ִ��sql���
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			//System.out.println("�鵽��");
			resultCard=new Card();
			resultCard.setUserName(UserName_Password.userName);
			resultCard.setPassword(UserName_Password.password);
			resultCard.setCardID(rs.getString("cardid"));
			resultCard.setBalance(rs.getString("balance"));
			resultCard.setStartDate(rs.getString("startdate"));
			resultCard.setIdNum(rs.getString("idnum"));
		}
		//�ر�
		rs.close();
		pstmt.close();
		con.close();
		return resultCard;
	}
	
	/**
	 * �޸��û���
	 * @param con
	 * @param str
	 * @throws Exception
	 */
	public void changeName(Connection con,String str)throws Exception{
		//����sql���
		String sql="update card set username=? where username=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, str);
		pstmt.setString(2, UserName_Password.userName);
		pstmt.setString(3, UserName_Password.password);
		//ִ��sql���
		ResultSet rs=pstmt.executeQuery();
		//�ر�
		rs.close();
		pstmt.close();
		con.close();
	}
	
	/**
	 * �޸�����
	 * @param con
	 * @param password
	 * @throws Exception
	 */
	public void changePassword(Connection con,String password)throws Exception{
		//����sql���
		String sql="update card set password=? where username=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setString(2, UserName_Password.userName);
		pstmt.setString(3, UserName_Password.password);
		//ִ��sql���
		ResultSet rs=pstmt.executeQuery();
		//�ر�
		rs.close();
		pstmt.close();
		con.close();
	}
	
	/**
	 * ͨ����������ͼ��
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public Book findBook(Connection con,Book book,String bookName)throws Exception{
		Book bookFindRs=null;
		//����sql���
		String sql="select * from book where bookname=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookName);
		//ִ��sql���
		ResultSet rs=pstmt.executeQuery();
		//�����ѯ��Ϣ��bookFindResult
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
		//���û�в鵽
		else
		{
			JOptionPane.showMessageDialog(null, "δ��ѯ�����ݣ�");
		}
		//�ر�����
		rs.close();
		pstmt.close();
		con.close();
		return bookFindRs;
	}
	
	/**
	 * ͨ��ͼ��������ͼ��
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet findBook1(Connection con,String bookType)throws Exception{
		//����sql���
		String sql="select * from book where class=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookType);
		//ִ��sql���
		ResultSet rs= pstmt.executeQuery();
		return rs;
	}
	
	/**
	 * �ڽ�ͼ���ѯ
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public ResultSet findBorrowedBook(Connection con,String cardID)throws Exception{
		//����sql���
		String sql="select bookname, author, publisher, borrowtime, returntime from borrowrecord natural join book where borrowrecord.cardid=? and status=0";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, cardID);
		//ִ��sql���
		return pstmt.executeQuery();
	}
	
	/**
	 * ��ѯ����
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public String selectCardID(Connection con)throws Exception{
		//����sql���
		String cardID=null;
		String sql="select * from card where username=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, UserName_Password.userName);
		pstmt.setString(2, UserName_Password.password);
		//ִ��sql���
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			cardID=rs.getString("cardid");
		}
		//�ر����ݿ�����
		rs.close();
		pstmt.close();
		con.close();
		return cardID;
	}
	
	/**
	 * ��ѯ���
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public String selectBookID(Connection con,String bookName)throws Exception{
		//����sql���
		String bookID=null;
		String sql="select * from book where bookname=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookName);
		//ִ��sql���
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
		{
			bookID=rs.getString("bookid");
		}
		//�ر����ݿ�����
		rs.close();
		pstmt.close();
		con.close();
		return bookID;
	}
	
	
	/**
	 * ����
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public ResultSet renew(Connection con,String cardID)throws Exception{
		//����sql���
		String sql="select bookname, borrowtime, returntime from borrowrecord natural join book where borrowrecord.cardid=? and status=0";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, cardID);
		//ִ��sql���
		return pstmt.executeQuery();
	}
	
	/**
	 * �޸Ļ�������
	 * @param con
	 * @param cardID
	 * @param bookID
	 */
	public void changeReturnTime(Connection con,String newReturnTime,String cardID,String bookID)throws Exception{
		//����sql���
		String sql="update borrowrecord set returntime=? where cardid=? and bookid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, newReturnTime);
		pstmt.setString(2, cardID);
		pstmt.setString(3, bookID);
		//ִ��sql���
		pstmt.executeQuery();
		//�ر�����
		pstmt.close();
		con.close();
		return;
	}
}
