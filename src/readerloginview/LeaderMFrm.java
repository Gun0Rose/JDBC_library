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

import com.libmanager.util.DbUtil;

import dao.Dao;

public class LeaderMFrm extends JFrame {
	Dao dao=new Dao();
	DbUtil dbUtil=new DbUtil();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaderMFrm frame = new LeaderMFrm();
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
	public LeaderMFrm() {
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
		
		JButton btnRenYuanguanli = new JButton("\u4EBA\u5458\u7BA1\u7406");
		btnRenYuanguanli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LeaderUseradmin user =new LeaderUseradmin();
				user.setVisible(true);
			}
		});
		btnRenYuanguanli.setFont(new Font("宋体", Font.PLAIN, 24));
		btnRenYuanguanli.setIcon(new ImageIcon(LeaderMFrm.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406.png")));
	/*	btnRenYuanguanli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LeaderUseradmin leaderUseradmin= new LeaderUseradmin();
				LeaderUseradmin.
			}
		});*/
		btnRenYuanguanli.setBounds(25, 210, 210, 81);
		contentPane.add(btnRenYuanguanli);
		
		JButton btnCaiWuguanli = new JButton("\u8D22\u52A1\u7BA1\u7406");
		btnCaiWuguanli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LeaderMoneyadmin money= new LeaderMoneyadmin();
				money.setVisible(true);
			}
		});
		btnCaiWuguanli.setFont(new Font("宋体", Font.PLAIN, 24));
		btnCaiWuguanli.setIcon(new ImageIcon(LeaderMFrm.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539.png")));
		btnCaiWuguanli.setBounds(25, 322, 210, 81);
		contentPane.add(btnCaiWuguanli);
		
		JButton btnNewButton = new JButton(" \u5B89\u5168\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
				System.out.println(result);
				if(result==0)
				{
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		btnNewButton.setIcon(new ImageIcon(LeaderMFrm.class.getResource("/images/\u5B89\u5168\u9000\u51FA.png")));
		btnNewButton.setBounds(25, 443, 210, 81);
		contentPane.add(btnNewButton);
		
		//设置Jframe大小为720p
		this.setSize(1366, 768);
		//设置Jframe最大化
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
