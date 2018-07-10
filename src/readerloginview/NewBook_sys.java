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

public class NewBook_sys extends JInternalFrame {
	/**
	 * @wbp.nonvisual location=81,-13
	 */
	private final JEditorPane editorPane = new JEditorPane();
	private String dbUrl="jdbc:oracle:thin:@47.95.194.14:1521:librarydb"; // 数据库连接地址
	private String dbUserName="book_admin"; // 用户名
	private String dbPassword="admin"; // 密码
	private String jdbcName="oracle.jdbc.driver.OracleDriver"; // 驱动名称
	public JTextField bookid;
	public JTextField author;
	public JTextField bookname;
	public JTextField publisher;
	public JTextField publishtime;
	private JTextField bookclass;
	private String Newbookid=null;//新开卡卡号
	private JTextField colnum;
	private JTextField cbnum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBook_sys frame = new NewBook_sys();
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
	public NewBook_sys() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 24));
		setClosable(true);
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u67E5\u8BE2");
		//设置位置和大小
		setBounds(0, 0, 1019, 481);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7F16\u53F7");
		label_1.setFont(new Font("宋体", Font.PLAIN, 24));
		
		bookid = new JTextField();
		bookid.setColumns(10);
		
		JLabel label_2 = new JLabel("\u51FA\u7248\u65F6\u95F4");
		label_2.setFont(new Font("宋体", Font.PLAIN, 24));
		
		author = new JTextField();
		author.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4E66\u540D");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("宋体", Font.PLAIN, 24));
		
		bookname = new JTextField();
		bookname.setColumns(10);
		
		publisher = new JTextField();
		publisher.setColumns(10);
		
		publishtime = new JTextField();
		publishtime.setColumns(10);
		
		JLabel label_4 = new JLabel("\u51FA\u7248\u793E");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JLabel label_5 = new JLabel("\u7C7B\u522B");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("宋体", Font.PLAIN, 24));
		
		bookclass = new JTextField();
		bookclass.setColumns(10);
		
		JLabel label = new JLabel("\u4F5C\u8005");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		
		//得到新书书号
		Connection conn = null;//表示数据库连接的对象   
		String sql0 = "select * from book order by bookid"; 
		PreparedStatement pstmt0=null;
		try {
			Class.forName(jdbcName);//使用class类加载驱动程序  
		    conn=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//连接数据库  
			pstmt0 = conn.prepareStatement(sql0);
			ResultSet rs0 = pstmt0.executeQuery();
			String nbookid=null;
			rs0 = pstmt0.executeQuery();
			while(rs0.next()){
				nbookid=rs0.getString("bookid");
			}
			Newbookid=String.format("%03d",Integer.valueOf(nbookid)+1);
			bookid.setText(Newbookid);
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
		        if(bookid.getText().equals(Newbookid)) {
			        try{  
			        Class.forName(jdbcName);//使用class类加载驱动程序  
			          
			        con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//连接数据库  
			        String sql="insert into book values(?,?,?,?,?,?,?,?)";
			        pstmt = con.prepareStatement(sql);//tatement接口需要通过connection接口进行实例化操作  
			        pstmt.setString(1,bookid.getText());
			        pstmt.setString(2,bookname.getText());
			        pstmt.setString(3,author.getText());
			        pstmt.setString(4,publisher.getText());
			        pstmt.setString(5,publishtime.getText());
			        pstmt.setString(6,bookclass.getText());
			        pstmt.setString(7,colnum.getText());
			        pstmt.setString(8,cbnum.getText());
			        int result=pstmt.executeUpdate();
			        if(result>0)
			        	JOptionPane.showMessageDialog(null, "添加图书成功","添加图书成功", JOptionPane.INFORMATION_MESSAGE); 
			        con.close(); 
			        pstmt.close();
			       }catch(Exception ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
			       }
		       }
		       else{
		    	   int res=JOptionPane.showConfirmDialog(null, "是否增加该图书数量", "该编号图书已存在", JOptionPane.YES_NO_OPTION);
		    	   if(res==JOptionPane.YES_OPTION){ 
		    		  String booknum =JOptionPane.showInputDialog(null,"请输入需要增加的图书数量：\n"); 
		    		  String ocolnum=null,ocbnum=null,ncolnum=null,ncbnum=null;
		    		  try {
						Class.forName(jdbcName);
						con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//连接数据库  
					    String sql="select * from book where bookid=?";
					    pstmt = con.prepareStatement(sql);//tatement接口需要通过connection接口进行实例化操作 
					    pstmt.setString(1,bookid.getText());
					    ResultSet rs = pstmt.executeQuery();
					    while(rs.next()){
					    	ocolnum=rs.getString("colnum");
					    	ocbnum=rs.getString("cbnum");
					    }
					    ncolnum=Integer.valueOf(ocolnum)+Integer.valueOf(booknum)+"";
					    ncbnum=Integer.valueOf(ocbnum)+Integer.valueOf(booknum)+"";
					    sql="update book set colnum=?,cbnum=? where bookid=?";
					    pstmt = con.prepareStatement(sql);//tatement接口需要通过connection接口进行实例化操作 
					    pstmt.setString(1,ncolnum);
					    pstmt.setString(2,ncbnum);
					    pstmt.setString(3,bookid.getText());
					    int result=pstmt.executeUpdate();
					    if(result>0){
					    	JOptionPane.showMessageDialog(null, "添加图书成功","添加图书成功", JOptionPane.INFORMATION_MESSAGE); 
					    }
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//使用class类加载驱动程序  
		    		 
		    	   }	  
		    	   else{
		    	   } 
		       }
		        	
		        
		        
			}
		});
		
		JButton reset = new JButton("\u91CD\u7F6E");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookid.setText(Newbookid);
				bookname.setText("");
				author.setText("");
				publisher.setText("");
				publishtime.setText("");
				bookclass.setText("");
				colnum.setText("");
				cbnum.setText("");
			}
		});
		
		colnum = new JTextField();
		colnum.setColumns(10);
		
		cbnum = new JTextField();
		cbnum.setColumns(10);
		
		JLabel label_6 = new JLabel("\u9986\u85CF\u6570\u91CF");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JLabel label_7 = new JLabel("\u53EF\u501F\u6570\u91CF");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("宋体", Font.PLAIN, 24));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(author, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bookname, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bookid, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
											.addGap(14))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(bookclass, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
										.addComponent(publishtime, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
										.addComponent(publisher, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
										.addComponent(colnum, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
										.addComponent(cbnum, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(execute)
							.addGap(143)
							.addComponent(reset)))
					.addContainerGap(630, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(bookid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookname, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(author, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(publisher, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(publishtime, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookclass, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(colnum, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbnum, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(execute)
						.addComponent(reset))
					.addGap(21))
		);
		getContentPane().setLayout(groupLayout);

	}
}
