package readerloginview;


import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.table.JTableHeader;

public class ShowBookInformation_sys extends JInternalFrame {
	/**
	 * @wbp.nonvisual location=81,-13
	 */
	private final JEditorPane editorPane = new JEditorPane();
	private JScrollPane scpDemo;
	private JTableHeader jth;
	private JTable tabDemo;
	private String dbUrl="jdbc:oracle:thin:@47.95.194.14:1521:librarydb"; // ���ݿ����ӵ�ַ
	private String dbUserName="book_admin"; // �û���
	private String dbPassword="admin"; // ����
	private String jdbcName="oracle.jdbc.driver.OracleDriver"; // ��������
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowBookInformation_sys frame = new ShowBookInformation_sys();
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
	public ShowBookInformation_sys() {
		getContentPane().setFont(new Font("����", Font.PLAIN, 24));
		setClosable(true);
		setTitle("\u8BFB\u8005\u4FE1\u606F\u67E5\u8BE2");
		//����λ�úʹ�С
		setBounds(0, 0, 1023, 481);

		this.setLayout(null);
		this.setLocation(100,50);
		// �������
		this.scpDemo = new JScrollPane();
		this.scpDemo.setBounds(0, 0, 1023, 481);
		try{
			// �������
				
			Class.forName(jdbcName);
			Connection conn = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
			// ������ѯ����
			String sql = "select * from book order by bookid"; 
			PreparedStatement pstm = conn.prepareStatement(sql);
			// ִ�в�ѯ
			ResultSet rs = pstm.executeQuery();
			// �����ж�������¼
			int count = 0;
			while(rs.next()){
			count++;
			}
			rs = pstm.executeQuery();
			// ����ѯ��õļ�¼���ݣ�ת�����ʺ�����JTable��������ʽ
			Object[][] info = new Object[count][8];
			count = 0;
			while(rs.next()){
			info[count][0] = rs.getString("bookid");
			info[count][1] = rs.getString("bookname");
			info[count][2] = rs.getString("author");
			info[count][3] = rs.getString("publisher");
			info[count][4]=rs.getString("publishtime");
			info[count][5]=rs.getString("class");
			info[count][6]=rs.getString("colnum");
			info[count][7]=rs.getString("cbnum");
			count++;
			}
			// �����ͷ
			String[] title = {"ͼ����","����","����","������","����ʱ��","���","�ݲ�����","�ɽ�����"};
			// ����JTable
			this.tabDemo = new JTable(info,title);
			// ��ʾ��ͷ
			this.jth = this.tabDemo.getTableHeader();
			// ��JTable���뵽���������������
			this.scpDemo.getViewport().add(tabDemo); 
			}catch (Exception ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
			
		// ����ťע�����
		// ��������뵽������
		add(this.scpDemo);
		// ��ʾ����
		this.setVisible(true);

		
		JLabel label_4 = new JLabel("\u4F59\u989D");
		label_4.setFont(new Font("����", Font.PLAIN, 24));
		
		JLabel label_5 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		label_5.setFont(new Font("����", Font.PLAIN, 24));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		

}
}
