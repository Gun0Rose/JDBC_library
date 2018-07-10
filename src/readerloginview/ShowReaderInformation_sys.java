package readerloginview;


import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

public class ShowReaderInformation_sys extends JInternalFrame {
	/**
	 * @wbp.nonvisual location=81,-13
	 */
	private final JEditorPane editorPane = new JEditorPane();
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private String dbUrl="jdbc:oracle:thin:@47.95.194.14:1521:librarydb"; // 数据库连接地址
	private String dbUserName="book_admin"; // 用户名
	private String dbPassword="admin"; // 密码
	private String jdbcName="oracle.jdbc.driver.OracleDriver"; // 驱动名称
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowReaderInformation_sys frame = new ShowReaderInformation_sys();
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
	public ShowReaderInformation_sys() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 24));
		setClosable(true);
		setTitle("\u8BFB\u8005\u4FE1\u606F\u67E5\u8BE2");
		//设置位置和大小
		setBounds(0, 0, 1023, 481);

		this.setLayout(null);
		this.setLocation(100,50);
		// 创建组件
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(0, 0, 1023, 481);
		try{
			// 获得连接
				
			Class.forName(jdbcName);
			Connection conn = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			// 建立查询条件
			String sql = "select * from card order by cardid"; 
			PreparedStatement pstm = conn.prepareStatement(sql);
			// 执行查询
			ResultSet rs = pstm.executeQuery();
			// 计算有多少条记录
			int count = 0;
			while(rs.next()){
			count++;
			}
			rs = pstm.executeQuery();
			// 将查询获得的记录数据，转换成适合生成JTable的数据形式
			Object[][] info = new Object[count][6];
			count = 0;
			while(rs.next()){
			info[count][0] = rs.getString("cardid");
			info[count][1] = rs.getString("username");
			info[count][2] = rs.getString("password");
			info[count][3] = rs.getFloat("balance");
			info[count][4]=rs.getString("startdate");
			info[count][5]=Integer.valueOf(rs.getString("idnum"));
			count++;
			}
			// 定义表头
			String[] title = {"卡号","用户名","密码","余额","开卡时间","身份证号"};
			// 创建JTable
			this.tabDemo = new JTable(info,title);
			// 显示表头
			this.jth = this.tabDemo.getTableHeader();
			// 将JTable加入到带滚动条的面板中
			this.scpDemo.getViewport().add(tabDemo); 
			}catch(ClassNotFoundException cnfe){
			JOptionPane.showMessageDialog(null,"数据源错误","错误",JOptionPane.ERROR_MESSAGE);
			}catch(SQLException sqle){
			JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
			}
			
		// 给按钮注册监听
		// 将组件加入到窗体中
		add(this.scpDemo);
		// 显示窗体
		this.setVisible(true);

		
		JLabel label_4 = new JLabel("\u4F59\u989D");
		label_4.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JLabel label_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_5.setFont(new Font("宋体", Font.PLAIN, 24));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		

}
}
