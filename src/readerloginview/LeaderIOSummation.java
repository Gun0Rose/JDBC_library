package readerloginview;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.libmanager.util.FinDbUtil;
import com.libmanager.util.Time;

import dao.FinAdminDao;
import model.UserName_Password;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class LeaderIOSummation extends JInternalFrame {
	FinAdminDao fDao=new FinAdminDao();
	FinDbUtil fDbUtil=new FinDbUtil();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaderIOSummation frame = new LeaderIOSummation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LeaderIOSummation() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 20));
		setTitle("\u6536\u652F\u60C5\u51B5\u7EDF\u8BA1");
		setBounds(0, 0, 1023, 481);
		
		//表格桌
		JScrollPane scrollPane = new JScrollPane();
		
		//近一个月内收支统计
		JButton button = new JButton("\u8FD1\u4E00\u4E2A\u6708\u5185\u6536\u652F\u7EDF\u8BA1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 查询当前月
				 */
				Time time=new Time();
				time.getDate();
				/**
				 * 连接数据库查询读者表
				 */
				Connection con=null;
				try {
					con=fDbUtil.getCon();
					ResultSet rs=fDao.IOReader(con);
					//将表格置空
					DefaultTableModel dtm=(DefaultTableModel)table.getModel();
					dtm.setRowCount(0);
					while(rs.next())
					{
						String dealdate=rs.getString("dealdate");
						String cmonth=dealdate.substring(5,7);
						if(cmonth.equals(time.month))
						{
							Vector vector=new Vector();
							vector.add(rs.getString("money"));
							vector.add(rs.getString("dealdate"));
							vector.add("收");
							vector.addElement("用户充值");
							dtm.addRow(vector);
						}
					}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				/**
				 * 关闭
				 */
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				/**
				 * 连接数据库查询工资表
				 */
				try {
					con=fDbUtil.getCon();
					ResultSet rs=fDao.IOWorker(con);
					//将表格置空
					DefaultTableModel dtm=(DefaultTableModel)table.getModel();
					dtm.setRowCount(0);
					while(rs.next())
					{
						String saltime=rs.getString("saltime");
						String cmonth=saltime.substring(5,7);
						if(cmonth.equals(time.month))
						{
							Vector vector=new Vector();
							vector.add(rs.getString("salmount"));
							vector.add(rs.getString("saltime"));
							vector.add("支");
							vector.addElement("发放工资");
							dtm.addRow(vector);
						}
					}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				/**
				 * 关闭
				 */
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		
		//本年内收支统计
		JButton button_1 = new JButton("\u672C\u5E74\u5185\u6536\u652F\u7EDF\u8BA1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 查询当前月
				 */
				Time time=new Time();
				time.getDate();
				/**
				 * 连接数据库查询读者表
				 */
				Connection con=null;
				try {
					con=fDbUtil.getCon();
					ResultSet rs=fDao.IOReader(con);
					//将表格置空
					DefaultTableModel dtm=(DefaultTableModel)table.getModel();
					dtm.setRowCount(0);
					while(rs.next())
					{
						String dealdate=rs.getString("dealdate");
						String cyear=dealdate.substring(0,4);
						if(cyear.equals(time.year))
						{
							Vector vector=new Vector();
							vector.add(rs.getString("money"));
							vector.add(rs.getString("dealdate"));
							vector.add("收");
							vector.addElement("用户充值");
							dtm.addRow(vector);
						}
					}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				/**
				 * 关闭
				 */
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				/**
				 * 连接数据库查询工资表
				 */
				try {
					con=fDbUtil.getCon();
					ResultSet rs=fDao.IOWorker(con);
					//将表格置空
					DefaultTableModel dtm=(DefaultTableModel)table.getModel();
					dtm.setRowCount(0);
					while(rs.next())
					{
						String saltime=rs.getString("saltime");
						String cyear=saltime.substring(0,4);
						if(cyear.equals(time.year))
						{
							Vector vector=new Vector();
							vector.add(rs.getString("salmount"));
							vector.add(rs.getString("saltime"));
							vector.add("支");
							vector.addElement("发放工资");
							dtm.addRow(vector);
						}
					}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				/**
				 * 关闭
				 */
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		//退出
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出");
				System.out.println(result);
				if(result==0)
				{
					dispose();
				}
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(29, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(82)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(65))))
		);
		
		//表格
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u91D1\u989D", "\u65F6\u95F4", "\u6536/\u652F", "\u5907\u6CE8"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		getContentPane().setLayout(groupLayout);

	}
}
