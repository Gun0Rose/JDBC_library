package readerloginview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
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

import dao.Dao;
import model.UserName_Password;

public class LibraryMFrm extends JFrame {
	
	DbUtil dbUtil=new DbUtil();
	Dao dao=new Dao();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryMFrm frame = new LibraryMFrm();
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
	public LibraryMFrm() {
		setFont(new Font("����", Font.PLAIN, 12));
		setTitle("\u56FE\u4E66\u7BA1\u7406\u754C\u9762");
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
		
		//����ͼ�鰴ť
		JButton button = new JButton("\u67E5\u627E\u56FE\u4E66");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindBook findBook=new FindBook();
				findBook .setVisible(true);
				table.add(findBook);
				findBook.toFront();
			}
		});
		button.setIcon(new ImageIcon(LibraryMFrm.class.getResource("/images/\u67E5\u627E\u56FE\u4E66.png")));
		button.setForeground(new Color(0, 0, 0));
		button.setFont(new Font("����", Font.PLAIN, 22));
		button.setBounds(21, 195, 200, 74);
		contentPane.add(button);
		
		//�ڽ�ͼ���ѯ��ť
		JButton button_2 = new JButton("\u5728\u501F\u56FE\u4E66\u67E5\u8BE2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * ��ѯ���Ų����ص�cardID
				 */
				String cardID=null;
				try {
					//�������ݿ�
					UserName_Password .con=dbUtil.getCon();
					//��ѯ���Ų�����
					cardID=dao.selectCardID(UserName_Password .con);
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				//System.out.println(cardID);
				/**
				 * ��ѯ�ڽ�ͼ����Ϣ
				 */
				try {
					UserName_Password .con=dbUtil.getCon();
					UserName_Password.resultSet=null;
					UserName_Password.resultSet=dao.findBorrowedBook(UserName_Password .con, cardID);
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
				/**
				 * �����ڲ�����
				 */
				FindBorrowedBook findBorrowedBook=new FindBorrowedBook();
				findBorrowedBook.setVisible(true);
				table.add(findBorrowedBook);
				findBorrowedBook.toFront();
				
                //���δ��ѯ���ڽ�ͼ����Ϣ
				if(UserName_Password.mark==0)
				{
					JOptionPane.showMessageDialog(null, "δ��ѯ���ڽ�ͼ�飡");
				}
			}
		});
		button_2.setIcon(new ImageIcon(LibraryMFrm.class.getResource("/images/\u5728\u501F\u56FE\u4E66.png")));
		button_2.setFont(new Font("����", Font.PLAIN, 22));
		button_2.setBounds(21, 279, 200, 74);
		contentPane.add(button_2);
		
		//���谴ť
		JButton button_1 = new JButton("\u7EED\u501F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * ��ѯ���Ų����ص�cardID
				 */
				String cardID=null;
				try {
					//�������ݿ�
					UserName_Password .con=dbUtil.getCon();
					//��ѯ���Ų�����
					cardID=dao.selectCardID(UserName_Password .con);
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
				/**
				 * ����
				 */
				try {
					//�������ݿ�
					UserName_Password.con=dbUtil.getCon();
					//��ѯ�����ز�ѯ���
					UserName_Password.resultSet=null;
					UserName_Password.resultSet=dao.renew(UserName_Password.con, cardID);
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				
				/**
				 * �����ڲ�����
				 */
				Renew renew=new Renew();
				renew .setVisible(true);
				table.add(renew);
				renew.toFront();
				
				//���δ��ѯ���ڽ�ͼ����Ϣ
				if(UserName_Password.mark==0)
				{
					JOptionPane.showMessageDialog(null, "����ǰδ����ͼ�飡");
				}
			}
		});
		button_1.setIcon(new ImageIcon(LibraryMFrm.class.getResource("/images/\u7EED\u501F.png")));
		button_1.setFont(new Font("����", Font.PLAIN, 22));
		button_1.setBounds(21, 363, 199, 74);
		contentPane.add(button_1);
		
		//������һ�㰴ť
		JButton button_3 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrm1 mainFrm1=new MainFrm1();
				mainFrm1.setVisible(true);
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

