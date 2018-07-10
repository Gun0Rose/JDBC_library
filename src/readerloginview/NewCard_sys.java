package readerloginview;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class NewCard_sys extends JInternalFrame {
	/**
	 * @wbp.nonvisual location=81,-13
	 */
	private final JEditorPane editorPane = new JEditorPane();
	private String dbUrl="jdbc:oracle:thin:@47.95.194.14:1521:librarydb"; // 数据库连接地址
	private String dbUserName="book_admin"; // 用户名
	private String dbPassword="admin"; // 密码
	private String jdbcName="oracle.jdbc.driver.OracleDriver"; // 驱动名称
	public JTextField cardid;
	public JTextField password;
	public JTextField username;
	public JTextField balance;
	public JTextField startdate;
	private JTextField idnum;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	private String Newcardid=null;//新开卡卡号
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewCard_sys frame = new NewCard_sys();
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
	public NewCard_sys() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 24));
		setClosable(true);
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u67E5\u8BE2");
		//设置位置和大小
		setBounds(0, 0, 1019, 481);
		
		//卡号
		JLabel label_1 = new JLabel("\u5361    \u53F7");
		label_1.setFont(new Font("宋体", Font.PLAIN, 24));
		
		cardid = new JTextField();
		cardid.setColumns(10);
		
		//开卡时间
		JLabel label_2 = new JLabel("\u5F00\u5361\u65F6\u95F4");
		label_2.setFont(new Font("宋体", Font.PLAIN, 24));
		
		password = new JTextField();
		password.setColumns(10);
		
		//用户名
		JLabel label_3 = new JLabel("\u7528 \u6237 \u540D");
		label_3.setFont(new Font("宋体", Font.PLAIN, 24));
		
		username = new JTextField();
		username.setColumns(10);
		
		balance = new JTextField();
		balance.setColumns(10);
		
		startdate = new JTextField();
		startdate.setColumns(10);
		startdate.setText(df.format(new Date()));
		
		JLabel label_4 = new JLabel("\u4F59\u989D");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JLabel label_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_5.setFont(new Font("宋体", Font.PLAIN, 24));
		
		idnum = new JTextField();
		idnum.setColumns(10);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		
		//得到新开卡卡号
		Connection conn = null;//表示数据库连接的对象   
		String sql0 = "select * from card order by cardid"; 
		PreparedStatement pstmt0=null;
		try {
			Class.forName(jdbcName);//使用class类加载驱动程序  
		    conn=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//连接数据库  
			pstmt0 = conn.prepareStatement(sql0);
			ResultSet rs0 = pstmt0.executeQuery();
			String ncardid=null;
			rs0 = pstmt0.executeQuery();
			while(rs0.next()){
				ncardid=rs0.getString("cardid");
			}
			Newcardid=String.format("%03d",Integer.valueOf(ncardid.substring(1,ncardid.length()))+1);
			Newcardid="C"+Newcardid;
			cardid.setText(Newcardid);
			//System.out.println(Newcardid);
			rs0.close();
			conn.close();
			pstmt0.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton execute = new JButton("\u63D0\u4EA4");
		execute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;//表示数据库连接的对象   
		          
		        PreparedStatement pstmt = null;//表示数据库更新操作  
		          
		        try{  
		        Class.forName(jdbcName);//使用class类加载驱动程序  
		          
		        con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//连接数据库  
		        String sql="insert into card values(?,?,?,?,?,?)";
		        pstmt = con.prepareStatement(sql);//tatement接口需要通过connection接口进行实例化操作  
		       // pstmt.setString(1,cardid.getText());
		        pstmt.setString(1,cardid.getText());
		        pstmt.setString(2,username.getText());
		        pstmt.setString(3,password.getText());
		        pstmt.setFloat(4,Float.parseFloat(balance.getText()));
		        pstmt.setString(5,startdate.getText());
		        pstmt.setString(6,idnum.getText());
		        int result=pstmt.executeUpdate();
		        if(result>0)
		        	JOptionPane.showMessageDialog(null, "开卡成功","开卡成功", JOptionPane.INFORMATION_MESSAGE); 
		        con.close(); 
		        pstmt.close();
		       }catch(Exception ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				}
		        
		        
			}
		});
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardid.setText(Newcardid);
				username.setText("");
				password.setText("");
				balance.setText("");
				startdate.setText(df.format(new Date()));
				idnum.setText("");
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(password, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(username, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(18)
									.addComponent(cardid, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(startdate, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
										.addComponent(balance, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
										.addComponent(idnum, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(70)
							.addComponent(execute)
							.addGap(162)
							.addComponent(reset)))
					.addContainerGap(626, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cardid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(balance, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(startdate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(idnum, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(execute)
						.addComponent(reset))
					.addGap(29))
		);
		getContentPane().setLayout(groupLayout);

	}
}
