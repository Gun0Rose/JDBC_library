package readerloginview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.libmanager.util.DbUtil;

import dao.Dao;
import model.Card;
import model.UserName_Password;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class MainFrm1 extends JFrame {
	
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
					MainFrm1 frame = new MainFrm1();
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
	public MainFrm1() {
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
		label.setIcon(new ImageIcon(MainFrm1.class.getResource("/images/3.2.jpg")));
		label.setBounds(4, 5, 1348, 167);
		contentPane.add(label);

		//����
		JDesktopPane table = new JDesktopPane();
		table.setBackground(Color.PINK);
		table.setBounds(283, 195, 1019, 481);
		contentPane.add(table);
		
		//����ͼƬ
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainFrm1.class.getResource("/images/4.jpg")));
		label_1.setBounds(0, 0, 1023, 481);
		table.add(label_1);
		
		//������Ϣ����ť
		JButton button = new JButton("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PersonalIMFrm personalIMFrm=new PersonalIMFrm();
				personalIMFrm.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon(MainFrm1.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406.png")));
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("����", Font.PLAIN, 22));
		button.setBounds(21, 195, 200, 74);
		contentPane.add(button);
		
		//ͼ�����ť
		JButton button_2 = new JButton("\u56FE\u4E66\u7BA1\u7406");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LibraryMFrm libraryMFrm=new LibraryMFrm();
				libraryMFrm.setVisible(true);
			}
		});
		button_2.setIcon(new ImageIcon(MainFrm1.class.getResource("/images/\u56FE\u4E66\u7BA1\u7406.png")));
		button_2.setFont(new Font("����", Font.PLAIN, 22));
		button_2.setBounds(21, 279, 200, 74);
		contentPane.add(button_2);
		
		//����ѯ��ť
		JButton button_1 = new JButton("\u4F59\u989D\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(UserName_Password.userName+" "+UserName_Password.password);
				//�����ѯ���ض���
				String balance=null;
				Card cardBalance=new Card(balance);
				//�������ݿ�
				Connection con=null;
				try {
					con=dbUtil.getCon();
					//��ѯ�����ؽ��
					Card currentCard=dao.selectCard(con, cardBalance);
					UserName_Password.balancein=currentCard.getBalance();
					UserName_Password.balancein+="Ԫ";
					//JOptionPane.showMessageDialog(null, currentCard.getBalance());
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
				//��ʾ�ڲ�����
				BalanceQuery balanceQuery=new BalanceQuery();
				balanceQuery.setVisible(true);
				//label_1.setVisible(false);
				table.add(balanceQuery);
				balanceQuery.toFront();
				
			}
		});
		button_1.setIcon(new ImageIcon(MainFrm1.class.getResource("/images/\u4F59\u989D\u5145\u503C.png")));
		button_1.setFont(new Font("����", Font.PLAIN, 22));
		button_1.setBounds(21, 363, 199, 74);
		contentPane.add(button_1);
		
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
		button_3.setIcon(new ImageIcon(MainFrm1.class.getResource("/images/\u5B89\u5168\u9000\u51FA.png")));
		button_3.setFont(new Font("����", Font.PLAIN, 22));
		button_3.setBounds(21, 447, 200, 74);
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
		
		//����Jframe��СΪ720p
		this.setSize(1366, 768);
		//����Jframe���
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
