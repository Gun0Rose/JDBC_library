package readerloginview;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrm_sys extends JFrame {

	private JPanel contentPane;
	public String name=null,password=null;//管理员登陆的用户名密码
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm_sys frame = new MainFrm_sys();
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
	public MainFrm_sys() {
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
		label.setIcon(new ImageIcon(MainFrm_sys.class.getResource("/images/3.2.jpg")));
		label.setBounds(4, 5, 1348, 167);
		contentPane.add(label);

		//桌面
		JDesktopPane table = new JDesktopPane();
		table.setBackground(Color.PINK);
		table.setBounds(283, 195, 1019, 481);
		contentPane.add(table);
		
		//桌面图片
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainFrm_sys.class.getResource("/images/4.jpg")));
		label_1.setBounds(0, 0, 1023, 481);
		table.add(label_1);
		
		//读者信息管理按钮
		JButton button = new JButton("\u8BFB\u8005\u4FE1\u606F\u7BA1\u7406");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ReaderInformation_sys rm_sys=new ReaderInformation_sys();
				rm_sys.name=name;
				rm_sys.password=password;
				rm_sys.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(MainFrm_sys.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406.png")));
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("宋体", Font.PLAIN, 22));
		button.setBounds(21, 195, 200, 74);
		contentPane.add(button);
		
		//图书管理按钮
		JButton button_2 = new JButton("\u56FE\u4E66\u7BA1\u7406");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BookInformation_sys BI_sys=new BookInformation_sys();
				BI_sys.setVisible(true);
			}
		});
		button_2.setIcon(new ImageIcon(MainFrm_sys.class.getResource("/images/\u56FE\u4E66\u7BA1\u7406.png")));
		button_2.setFont(new Font("宋体", Font.PLAIN, 22));
		button_2.setBounds(21, 279, 200, 74);
		contentPane.add(button_2);
		
		//安全退出按钮
		JButton button_3 = new JButton("\u6CE8\u9500");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否注销");
				System.out.println(result);
				if(result==0)
				{
					dispose();
					Login log=new Login();
					log.setVisible(true);
				}
			}
		});
		button_3.setIcon(new ImageIcon(MainFrm_sys.class.getResource("/images/\u5B89\u5168\u9000\u51FA.png")));
		button_3.setFont(new Font("宋体", Font.PLAIN, 22));
		button_3.setBounds(21, 366, 200, 74);
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
		
		//设置Jframe大小为720p
		this.setSize(1366, 768);
		//设置Jframe最大化
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
