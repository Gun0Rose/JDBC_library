package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.libmanager.util.Time;
import com.libmanager.util.WorkerDbUtil;

import oracle.jdbc.proxy.annotation.Pre;

public class FinAdminDao {
	WorkerDbUtil workerDbUtil=new WorkerDbUtil();
	/**
	 * һ��������
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public void salary(Connection con)throws Exception{
		/**
		 * ��ѯԱ���ź�нˮ���ص������
		 */
		Connection conw=workerDbUtil.getCon();
		String sql="select workid,salary from worker";
		PreparedStatement pstmt=conw.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		/**
		 * ����id,saltime
		 */
		Time time=new Time();
		String sid=null;//��н���
		String salTime=null;//��нʱ��
		int i=1000;
		time.getDate();
		salTime=time.year+"-"+time.month+"-"+time .day;
		sid=time.year+time.month+time .day;
		
		/**
		 * ��salary���в�������
		 */
		while(rs.next())
		{
			i=i+1;
			String ssid=sid+i;
			String workId=rs.getString("workid");
			String salmount=rs.getString("salary");
			//System.out.println(ssid+" "+workId+" "+salTime+" "+salmount);
			String sql1="insert into salary values (?,?,?,?)";
			PreparedStatement pstmt1=con.prepareStatement(sql1);
			pstmt1.setString(1, ssid);
			pstmt1.setString(2, workId);
			pstmt1.setString(3, salTime);
			pstmt1.setString(4, salmount);
			pstmt1.executeQuery();
		}
		conw.close();
	}
	
	/**
	 * ��ѯһ���ڶ��߳�ֵ��¼
	 * @return
	 * @throws Exception
	 */
	public ResultSet IOReader(Connection con)throws Exception{
		/**
		 * ��ѯ
		 */
		String sql="select mouney,dealdate from fund_ref";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	
	/**
	 *��ѯ���ʷ��ż�¼
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public ResultSet IOWorker(Connection con)throws Exception{
		String sql="select salmount,saltime from salary";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	/*public static void main(String[] args) {
		try {
			IOReader();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}*/
}
