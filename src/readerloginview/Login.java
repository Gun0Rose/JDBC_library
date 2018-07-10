
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
	private String dbUrl="jdbc:oracle:thin:@47.95.194.14:1521:librarydb"; // ���ݿ����ӵ�ַ
	private String dbUserName="book_admin"; // �û���
	private String dbPassword="admin"; // ����
	private String jdbcName="oracle.jdbc.driver.OracleDriver"; // ��������
	private boolean canlog=false;
	public String name=null,password=null;//��½���û�������
	public String post=null;//ְλ
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
		setFont(new Font("����", Font.PLAIN, 12));
		setTitle("\u7528\u6237\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//���ͼƬ
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/images/3.2.jpg")));
		label.setBounds(4, 5, 1348, 167);
		contentPane.add(label);

		//����
		JDesktopPane table = new JDesktopPane();
		table.setBackground(Color.PINK);
		table.setBounds(283, 195, 1019, 481);
		contentPane.add(table);
		
		//����ͼƬ
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/images/4.jpg")));
		label_1.setBounds(0, 0, 1023, 481);
		table.add(label_1);
		
		
		//��ȫ�˳���ť
		JButton button_3 = new JButton("\u5B89\u5168\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "�Ƿ��˳�ϵͳ");
				System.out.println(result);
				if(result==0)
				{
					dispose();
				}
			}
		});
		button_3.setIcon(new ImageIcon(Login.class.getResource("/images/\u5B89\u5168\u9000\u51FA.png")));
		button_3.setFont(new Font("����", Font.PLAIN, 22));
		button_3.setBounds(27, 519, 198, 65);
		contentPane.add(button_3);
		
		//Jlable����ӭ����
		JLabel label_2 = new JLabel("\u6B22\u8FCE\u6765\u5230");
		label_2.setForeground(new Color(0, 0, 255));
		label_2.setFont(new Font("����", Font.BOLD | Font.ITALIC, 20));
		label_2.setBounds(25, 575, 190, 53);
		contentPane.add(label_2);
		
		//Jlable��R��ͼ��ݹ���ϵͳ
		JLabel lblR = new JLabel("R\u5E02\u56FE\u4E66\u9986\u7BA1\u7406\u7CFB\u7EDF");
		lblR.setForeground(Color.BLUE);
		lblR.setFont(new Font("����", Font.BOLD | Font.ITALIC, 20));
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
					Connection con = null;//��ʾ���ݿ����ӵĶ���   
			          
			        Statement stmt = null;//��ʾ���ݿ���²���  
			          
			        ResultSet result = null;//��ʾ�������ݿ��ѯ���Ľ��  
			        try{  
			        Class.forName(jdbcName);//ʹ��class�������������  
			          
			        con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//�������ݿ�  
			          
			        stmt = con.createStatement();//tatement�ӿ���Ҫͨ��connection�ӿڽ���ʵ��������  
			          
			        result = stmt.executeQuery("select * from card");//ִ��sql��䣬���������result��  
			          
			        while(result.next()){//�ж��Ƿ�����һ��  
			            String name = result.getString("username");//��ȡ���ݿ�person����name�ֶε�ֵ  
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
						JOptionPane.showMessageDialog(null,  "�����ڵĶ��߻��������","��½ʧ��", JOptionPane.ERROR_MESSAGE);
					}
				}
				if(rb_sys.isSelected()){
					Connection con = null;//��ʾ���ݿ����ӵĶ���   
			          
			        Statement stmt = null;//��ʾ���ݿ���²���  
			          
			        ResultSet result = null;//��ʾ�������ݿ��ѯ���Ľ��  
			        dbUserName="worker_admin";
			        try{  
			        Class.forName(jdbcName);//ʹ��class�������������  
			          
			        con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//�������ݿ�  
			          
			        stmt = con.createStatement();//tatement�ӿ���Ҫͨ��connection�ӿڽ���ʵ��������  
			          
			        result = stmt.executeQuery("select * from worker");//ִ��sql��䣬���������result��  
			          
			        while(result.next()){//�ж��Ƿ�����һ��  
			            name = result.getString("wname");//��ȡ���ݿ�person����name�ֶε�ֵ  
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
			        		System.out.println("���");
			        	}
			        	if(post.equals("hr manager")){
			        		System.out.println("����");
			        	}
			        	if(post.equals("curator")){
			        		System.out.println("�ݳ�");
			        	}
			        }
			        else{
			        	JOptionPane.showMessageDialog(null,  "�����ڵĹ���Ա���������","��½ʧ��", JOptionPane.ERROR_MESSAGE);
			        }
				}
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 22));
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
		
		

		//����Jframe��СΪ720p
		this.setSize(1366, 768);
		//����Jframe���
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}