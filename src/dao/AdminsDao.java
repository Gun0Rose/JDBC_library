package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.libmanager.util.EmptyTool;

import model.Admins;

/**
 * ���¹�������
 *
 * @author Mr.Aim
 *
 */
public class AdminsDao {
	/**
	 * �����Ϣ
	 * @param con
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public int Add(Connection con,Admins admin)throws Exception {
		String sql="INSERT INTO \"WORKER_ADMIN\".\"WORKER\" (WORKID, WNAME, WSEX, WBIRTHDAY, ADRESS, ENTRYTIME, SALARY, IDNUM, PASSWORD, POST) VALUES (NULL,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		//pstmt.setString(1, admin.getWorkerid());
		pstmt.setString(1, admin.getName());
		pstmt.setString(2, admin.getSex());
		pstmt.setString(3, admin.getBirthday());
		pstmt.setString(4, admin.getAddress());
		pstmt.setString(5, admin.getEntertime());
		pstmt.setString(6, admin.getSalary());
		pstmt.setString(7, admin.getIdnum());
		pstmt.setString(8, admin.getPassword());
		pstmt.setString(9, admin.getPost());
		return pstmt.executeUpdate();
	}
	/**
	 * ��ѯ
	 * @param con
	 * @param admins
	 * @return
	 * @throws Exception
	 */
	
	public ResultSet list(Connection con,Admins admins)throws Exception{
		StringBuffer sb=new StringBuffer("select * from WORKER");
		if (EmptyTool.isNotEmpty(admins.getName())) {
			sb.append("and WNAME like '%"+admins.getName()+"%'");
			PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));
			return pstmt.executeQuery();
		}
		return null;
	}
	
	/**
	 * ����������ѯ
	 * @param con
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public ResultSet NameFind(Connection con,String name)throws Exception {
		String sql="select workid,wname,wsex,wbirthday,adress,post,entrytime,salary,idnum,password from worker where wname=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, name);
		return pstmt.executeQuery();
	}

	/**
	 * ���չ��Ų�ѯ
	 * @param con
	 * @param IDnum
	 * @return
	 * @throws Exception
	 */
	public ResultSet IDFind(Connection con,String workid)throws Exception {
		String sql="select workid,wname,wsex,wbirthday,adress,post,entrytime,salary,idnum,password from worker where workid=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, workid);
		return pstmt.executeQuery();
	}
}
