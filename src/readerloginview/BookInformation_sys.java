package readerloginview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BookInformation_sys extends JFrame {

	private JPanel contentPane;
	public String name=null,password=null;//读者登陆的用户名密码
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
					BookInformation_sys frame = new BookInformation_sys();
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
	public BookInformation_sys() {
		setFont(new Font("宋体", Font.PLAIN, 12));
		setTitle("\u56FE\u4E66\u7BA1\u7406\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//横标图片
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainFrm1.class.getResource("/images/3.2.jpg")));
		label.setBounds(4, 5, 1348, 167);
		contentPane.add(label);
        
		//桌面
		JDesktopPane table = new JDesktopPane();
		table.setBackground(Color.PINK);
		table.setBounds(283, 195, 1019, 481);
		contentPane.add(table);
		
		//桌面图片
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainFrm1.class.getResource("/images/4.jpg")));
		label_1.setBounds(0, 0, 1023, 481);
		table.add(label_1);
		
		//查询馆藏信息按钮
		JButton BN_SearchBook = new JButton("\u67E5\u8BE2\u9986\u85CF\u4FE1\u606F");
		BN_SearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowBookInformation_sys sbi_sys=new ShowBookInformation_sys();
				sbi_sys.setVisible(true);
				sbi_sys.setBounds(0, 0, 1023, 481);
				table.removeAll();
				table.add(label_1);
				table.add(sbi_sys);
				sbi_sys.toFront();
			}
		});
		BN_SearchBook.setIcon(new ImageIcon(BookInformation_sys.class.getResource("/images/\u67E5\u627E\u56FE\u4E66.png")));
		BN_SearchBook.setForeground(new Color(0, 0, 0));
		BN_SearchBook.setFont(new Font("宋体", Font.PLAIN, 22));
		BN_SearchBook.setBounds(21, 195, 200, 74);
		contentPane.add(BN_SearchBook);
		
		//增加图书按钮
		JButton BN_AddBook = new JButton("\u6DFB\u52A0\u56FE\u4E66");
		BN_AddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewBook_sys nb_sys=new NewBook_sys();
				nb_sys.setVisible(true);
				nb_sys.setBounds(0, 0, 1023, 481);
				table.removeAll();
				table.add(label_1);
				table.add(nb_sys);
				nb_sys.toFront();
			}
		});
		BN_AddBook.setIcon(new ImageIcon(BookInformation_sys.class.getResource("/images/\u7EED\u501F.png")));
		BN_AddBook.setFont(new Font("宋体", Font.PLAIN, 22));
		BN_AddBook.setBounds(22, 282, 199, 74);
		contentPane.add(BN_AddBook);
		
		//返回上一层按钮
		JButton button_3 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrm_sys mf_sys=new MainFrm_sys();
				mf_sys.setVisible(true);
			}
		});
		button_3.setIcon(new ImageIcon(MainFrm1.class.getResource("/images/\u5B89\u5168\u9000\u51FA.png")));
		button_3.setFont(new Font("宋体", Font.PLAIN, 22));
		button_3.setBounds(21, 456, 200, 74);
		contentPane.add(button_3);
		
		//Jlable：欢迎来到
		JLabel label_2 = new JLabel("\u6B22\u8FCE\u6765\u5230");
		label_2.setForeground(new Color(0, 0, 255));
		label_2.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		label_2.setBounds(21, 640, 190, 53);
		contentPane.add(label_2);
		
		//Jlable：R市图书馆管理系统
		JLabel lblR = new JLabel("R\u5E02\u56FE\u4E66\u9986\u7BA1\u7406\u7CFB\u7EDF");
		lblR.setForeground(Color.BLUE);
		lblR.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 20));
		lblR.setBounds(21, 685, 190, 53);
		contentPane.add(lblR);
		
		//删除图书按钮
		JButton BN_DeleteBook = new JButton("\u5220\u9664\u56FE\u4E66");
		BN_DeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deletebookid =JOptionPane.showInputDialog(null,"请输入需要删除的图书书号：\n");
				Connection conn = null;//表示数据库连接的对象   
				String sql0 = " update book set colnum='0',cbnum='0' where bookid=?"; 
				PreparedStatement pstmt0=null;
				try {
					Class.forName(jdbcName);//使用class类加载驱动程序  
				    conn=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//连接数据库  
					pstmt0 = conn.prepareStatement(sql0);
					pstmt0.setString(1,deletebookid);
					int result=pstmt0.executeUpdate();
					if(result>0){
						JOptionPane.showMessageDialog(null, "删除图书成功","删除图书成功", JOptionPane.INFORMATION_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "不存在的书号","删除失败", JOptionPane.INFORMATION_MESSAGE);
					conn.close();
					pstmt0.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		BN_DeleteBook.setIcon(new ImageIcon(BookInformation_sys.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539.png")));
		BN_DeleteBook.setFont(new Font("宋体", Font.PLAIN, 22));
		BN_DeleteBook.setBounds(21, 369, 200, 74);
		contentPane.add(BN_DeleteBook);
		
		//设置Jframe大小为720p
		this.setSize(1366, 768);
		//设置Jframe最大化
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}

