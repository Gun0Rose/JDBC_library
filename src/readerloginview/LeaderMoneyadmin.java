package readerloginview;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.libmanager.util.DbUtil;
import com.libmanager.util.FinDbUtil;

import dao.Dao;
import dao.FinAdminDao;

public class LeaderMoneyadmin extends JFrame {
	FinAdminDao finAdminDao=new FinAdminDao();
	FinDbUtil finDbUtil=new FinDbUtil();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaderMoneyadmin frame = new LeaderMoneyadmin();
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
	public LeaderMoneyadmin() {
		setFont(new Font("宋体", Font.PLAIN, 12));
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406\u754C\u9762");
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
		
		JButton button = new JButton("\u6536\u652F\u60C5\u51B5\u7EDF\u8BA1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeaderIOSummation leaderIOSummation=new LeaderIOSummation();
				leaderIOSummation.setVisible(true);
				table.add(leaderIOSummation);
				leaderIOSummation.toFront();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 24));
		button.setIcon(new ImageIcon(LeaderMoneyadmin.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539.png")));
		button.setBounds(10, 331, 252, 64);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LeaderMFrm leaderMFrm=new LeaderMFrm();
				leaderMFrm .setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.setIcon(new ImageIcon(LeaderMoneyadmin.class.getResource("/images/\u5B89\u5168\u9000\u51FA.png")));
		btnNewButton.setBounds(10, 468, 252, 64);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4E00\u952E\u53D1\u653E\u5DE5\u8D44");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				try {
					//连接数据库
					con=finDbUtil.getCon();
					//发工资
					finAdminDao.salary(con);
					JOptionPane.showMessageDialog(null, "发工资成功！");
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				/**
				 * 关闭数据库连接
				 */
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton_1.setIcon(new ImageIcon(LeaderMoneyadmin.class.getResource("/images/nomey2.png")));
		btnNewButton_1.setBounds(10, 195, 252, 64);
		contentPane.add(btnNewButton_1);
		//设置Jframe大小为720p
		this.setSize(1366, 768);
		//设置Jframe最大化
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
