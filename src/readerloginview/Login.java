
package readerloginview;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.UserName_Password;  

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_uesrname;
	private JPasswordField passwordField;
	private String dbUrl="jdbc:oracle:thin:@47.95.194.14:1521:librarydb"; // 数据库连接地址
	private String dbUserName="book_admin"; // 用户名
	private String dbPassword="admin"; // 密码
	private String jdbcName="oracle.jdbc.driver.OracleDriver"; // 驱动名称
	private boolean canlog=false;
	public String name=null,password=null;//登陆的用户名密码
	public String post=null;//职位
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setFont(new Font("宋体", Font.PLAIN, 12));
		setTitle("\u7528\u6237\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//横标图片
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/images/3.2.jpg")));
		label.setBounds(4, 5, 1348, 167);
		contentPane.add(label);

		//桌面
		JDesktopPane table = new JDesktopPane();
		table.setBackground(Color.PINK);
		table.setBounds(283, 195, 1019, 481);
		contentPane.add(table);
		
		//桌面图片
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/images/4.jpg")));
		label_1.setBounds(0, 0, 1023, 481);
		table.add(label_1);
		
		
		//安全退出按钮
		JButton button_3 = new JButton("\u5B89\u5168\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
				System.out.println(result);
				if(result==0)
				{
					dispose();
				}
			}
		});
		button_3.setIcon(new ImageIcon(Login.class.getResource("/images/\u5B89\u5168\u9000\u51FA.png")));
		button_3.setFont(new Font("宋体", Font.PLAIN, 22));
		button_3.setBounds(27, 519, 198, 65);
		contentPane.add(button_3);
		
		//Jlable：欢迎来到
		JLabel label_2 = new JLabel("\u6B22\u8FCE\u6765\u5230");
		label_2.setForeground(new Color(0, 0, 255));
		label_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		label_2.setBounds(25, 575, 190, 53);
		contentPane.add(label_2);
		
		//Jlable：R市图书馆管理系统
		JLabel lblR = new JLabel("R\u5E02\u56FE\u4E66\u9986\u7BA1\u7406\u7CFB\u7EDF");
		lblR.setForeground(Color.BLUE);
		lblR.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		lblR.setBounds(27, 623, 190, 53);
		contentPane.add(lblR);
		
		ButtonGroup chooselog=new ButtonGroup(); 
		
		JRadioButton rb_sys = new JRadioButton("\u56FE\u4E66\u7BA1\u7406\u5458",true);
		rb_sys.setBounds(27, 334, 157, 27);
		contentPane.add(rb_sys);
		chooselog.add(rb_sys);
	
		JRadioButton rb_reader = new JRadioButton("\u7528\u6237");
		rb_reader.setBounds(28, 369, 157, 27);
		contentPane.add(rb_reader);
		chooselog.add(rb_reader);
		
		JButton button = new JButton("\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rb_reader.isSelected()){
					Connection con = null;//表示数据库连接的对象   
			          
			        Statement stmt = null;//表示数据库更新操作  
			          
			        ResultSet result = null;//表示接受数据库查询到的结果  
			        try{  
			        Class.forName(jdbcName);//使用class类加载驱动程序  
			          
			        con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//连接数据库  
			          
			        stmt = con.createStatement();//tatement接口需要通过connection接口进行实例化操作  
			          
			        result = stmt.executeQuery("select * from card");//执行sql语句，结果集放在result中  
			          
			        while(result.next()){//判断是否还有下一行  
			            String name = result.getString("username");//获取数据库person表中name字段的值  
			            String password=result.getString("password");
			            if(name.equals(textField_uesrname.getText())&&password.equals(passwordField.getText())){
			            	canlog=true;
			            	UserName_Password.userName=name;
			            	UserName_Password.password=password;
			            }
			        }  
			        result.close();  
			        stmt.close();  
			        con.close();  
			        }catch (Exception ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}
					if(canlog){
						dispose();
						MainFrm1 reader=new MainFrm1();
						reader.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null,  "不存在的读者或密码错误","登陆失败", JOptionPane.ERROR_MESSAGE);
					}
				}
				if(rb_sys.isSelected()){
					Connection con = null;//表示数据库连接的对象   
			          
			        Statement stmt = null;//表示数据库更新操作  
			          
			        ResultSet result = null;//表示接受数据库查询到的结果  
			        dbUserName="worker_admin";
			        try{  
			        Class.forName(jdbcName);//使用class类加载驱动程序  
			          
			        con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//连接数据库  
			          
			        stmt = con.createStatement();//tatement接口需要通过connection接口进行实例化操作  
			          
			        result = stmt.executeQuery("select * from worker");//执行sql语句，结果集放在result中  
			          
			        while(result.next()){//判断是否还有下一行  
			            name = result.getString("wname");//获取数据库person表中name字段的值  
			            password=result.getString("password");
			            post=result.getString("post");
			            if(name.equals(textField_uesrname.getText())&&password.equals(passwordField.getText())){
			            	canlog=true;
			            	break;
			            }
			        }  
			        result.close();  
			        stmt.close();  
			        con.close();  
			        }catch (Exception ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}
			        if(canlog){
			        	if(post.equals("librarian")){
			        		dispose();
							MainFrm_sys sys=new MainFrm_sys();
							sys.name=name;
							sys.password=password;
							sys.setVisible(true);
			        	}
			        	if(post.equals("accountant")){
			        		System.out.println("会计");
			        	}
			        	if(post.equals("hr manager")){
			        		System.out.println("人事");
			        	}
			        	if(post.equals("curator")){
			        		System.out.println("馆长");
			        	}
			        }
			        else{
			        	JOptionPane.showMessageDialog(null,  "不存在的管理员或密码错误","登陆失败", JOptionPane.ERROR_MESSAGE);
			        }
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 22));
		button.setBounds(27, 440, 198, 65);
		contentPane.add(button);
		
		JLabel label_3 = new JLabel("\u7528\u6237\u540D");
		label_3.setBounds(27, 235, 72, 18);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u5BC6\u7801");
		label_4.setBounds(27, 280, 72, 18);
		contentPane.add(label_4);
		
		textField_uesrname = new JTextField();
		textField_uesrname.setBounds(98, 232, 86, 24);
		contentPane.add(textField_uesrname);
		textField_uesrname.setColumns(10);
        
		passwordField = new JPasswordField();
		passwordField.setBounds(98, 277, 86, 24);
		contentPane.add(passwordField);
		
		JLabel label_5 = new JLabel("\u672C\u9879\u76EE\u6240\u91C7\u7528\u4E91\u670D\u52A1\u5668\u7531\u963F\u91CC\u4E91\u63D0\u4F9B\u6280\u672F\u652F\u6301");
		label_5.setBounds(1060, 714, 272, 15);
		contentPane.add(label_5);
		
		

		//设置Jframe大小为720p
		this.setSize(1366, 768);
		//设置Jframe最大化
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}