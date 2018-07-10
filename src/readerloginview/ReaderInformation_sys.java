package readerloginview;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class ReaderInformation_sys extends JFrame {

	private JPanel contentPane;
	private String dbUrl="jdbc:oracle:thin:@47.95.194.14:1521:librarydb"; // ���ݿ����ӵ�ַ
	private String dbUserName="book_admin"; // �û���
	private String dbPassword="admin"; // ����
	private String jdbcName="oracle.jdbc.driver.OracleDriver"; // ��������
	public String name=null;//���ߵ�½���û�������
	public String password=null;
	public String cardid=null,startdate=null,idnum=null;//���ţ�����ʱ�䣬���֤��
	public float balance=0;//���
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderInformation_sys frame = new ReaderInformation_sys();
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
	public ReaderInformation_sys() {
		setFont(new Font("����", Font.PLAIN, 12));
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406\u754C\u9762");
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
		
		//������Ϣ��ѯ��ť
		JButton Bn_ReaderInformation = new JButton("\u8BFB\u8005\u4FE1\u606F\u67E5\u8BE2");
		Bn_ReaderInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowReaderInformation_sys sri_sys=new ShowReaderInformation_sys();
				sri_sys.setVisible(true);
				sri_sys.setBounds(0, 0, 1023, 481);
				table.removeAll();
				table.add(label_1);
				table.add(sri_sys);
				sri_sys.toFront();
			}
		});
		Bn_ReaderInformation.setIcon(new ImageIcon(ReaderInformation_sys.class.getResource("/images/\u4E2A\u4EBA\u4FE1\u606F\u67E5\u8BE2.png")));
		Bn_ReaderInformation.setForeground(new Color(0, 0, 0));
		Bn_ReaderInformation.setFont(new Font("����", Font.PLAIN, 22));
		Bn_ReaderInformation.setBounds(21, 195, 200, 74);
		contentPane.add(Bn_ReaderInformation);
		
		//������һ�㰴ť
		JButton button_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrm_sys mainFrm_sys=new MainFrm_sys();
				mainFrm_sys.name=name;
				mainFrm_sys.password=password;
				mainFrm_sys.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon(ReaderInformation_sys.class.getResource("/images/\u5B89\u5168\u9000\u51FA.png")));
		button_1.setFont(new Font("����", Font.PLAIN, 22));
		button_1.setBounds(22, 543, 199, 74);
		contentPane.add(button_1);
		
		//Jlable����ӭ����
		JLabel label_2 = new JLabel("\u6B22\u8FCE\u6765\u5230");
		label_2.setForeground(new Color(0, 0, 255));
		label_2.setFont(new Font("����", Font.BOLD | Font.ITALIC, 20));
		label_2.setBounds(21, 641, 190, 53);
		contentPane.add(label_2);
		
		//Jlable��R��ͼ��ݹ���ϵͳ
		JLabel lblR = new JLabel("R\u5E02\u56FE\u4E66\u9986\u7BA1\u7406\u7CFB\u7EDF");
		lblR.setForeground(Color.BLUE);
		lblR.setFont(new Font("����", Font.BOLD | Font.ITALIC, 20));
		lblR.setBounds(21, 688, 190, 53);
		contentPane.add(lblR);
		
		//������ť
		JButton Bn_NewCard = new JButton("\u5F00\u5361");
		Bn_NewCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCard_sys nc_sys=new NewCard_sys();
				nc_sys.setVisible(true);
				nc_sys.setBounds(0, 0, 1023, 481);
				table.removeAll();
				table.add(label_1);
				table.add(nc_sys);
				nc_sys.toFront();
			}
		});
		Bn_NewCard.setFont(new Font("����", Font.PLAIN, 22));
		Bn_NewCard.setBounds(21, 369, 200, 74);
		contentPane.add(Bn_NewCard);
		
		//ע������ť
		JButton Bn_DeleteCard = new JButton("\u6CE8\u9500\u501F\u4E66\u5361");
		Bn_DeleteCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deletecardid =JOptionPane.showInputDialog(null,"��������Ҫע���Ľ��鿨���ţ�\n");
				Connection conn = null;//��ʾ���ݿ����ӵĶ���   
				String sql0 = " update card set username='��ע��',password='��ע��' where cardid=?"; 
				PreparedStatement pstmt0=null;
				try {
					Class.forName(jdbcName);//ʹ��class�������������  
				    conn=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//�������ݿ�  
					pstmt0 = conn.prepareStatement(sql0);
					pstmt0.setString(1,deletecardid);
					int result=pstmt0.executeUpdate();
					if(result>0){
						JOptionPane.showMessageDialog(null, "ע���ɹ�","ע���ɹ�", JOptionPane.INFORMATION_MESSAGE);
						/*ShowReaderInformation_sys sri_sys=new ShowReaderInformation_sys();
						sri_sys.setVisible(true);
						sri_sys.setBounds(0, 0, 1023, 481);
						table.removeAll();
						table.add(label_1);
						table.add(sri_sys);
						sri_sys.toFront();*/
					}
					else
						JOptionPane.showMessageDialog(null, "�����ڵĿ���","ע��ʧ��", JOptionPane.INFORMATION_MESSAGE);
					conn.close();
					pstmt0.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Bn_DeleteCard.setFont(new Font("����", Font.PLAIN, 22));
		Bn_DeleteCard.setBounds(21, 456, 200, 74);
		contentPane.add(Bn_DeleteCard);
		
		//����ֵ��ť
		JButton Bn_Money = new JButton("\u4F59\u989D\u5145\u503C");
		Bn_Money.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String moneycardid =JOptionPane.showInputDialog(null,"��������Ҫ��ֵ�Ľ��鿨���ţ�\n");
				String money=JOptionPane.showInputDialog(null,"�������ֵ��\n");
				float balance=Float.valueOf(money);
				Connection conn = null;//��ʾ���ݿ����ӵĶ���   
				String sql0 = "UPDATE card SET balance=balance+? where cardid=?"; 
				PreparedStatement pstmt0=null;
				try {
					Class.forName(jdbcName);//ʹ��class�������������  
				    conn=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);//�������ݿ�  
					pstmt0 = conn.prepareStatement(sql0);
					pstmt0.setFloat(1,balance);
					pstmt0.setString(2, moneycardid);
					int result=pstmt0.executeUpdate();
					if(result>0){
						JOptionPane.showMessageDialog(null, "��ֵ�ɹ�","��ֵ�ɹ�", JOptionPane.INFORMATION_MESSAGE);
						/*ShowReaderInformation_sys sri_sys=new ShowReaderInformation_sys();
						sri_sys.setVisible(true);
						sri_sys.setBounds(0, 0, 1023, 481);
						table.removeAll();
						table.add(label_1);
						table.add(sri_sys);
						sri_sys.toFront();*/
					}
					else
						JOptionPane.showMessageDialog(null, "�����ڵĿ���","��ֵʧ��", JOptionPane.INFORMATION_MESSAGE);
					conn.close();
					pstmt0.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Bn_Money.setFont(new Font("����", Font.PLAIN, 22));
		Bn_Money.setBounds(21, 282, 200, 74);
		contentPane.add(Bn_Money);
		
		//����Jframe��СΪ720p
		this.setSize(1366, 768);
		//����Jframe���
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
