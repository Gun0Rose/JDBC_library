package readerloginview;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.libmanager.util.DbUtil;

import dao.Dao;
import model.Book;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class FindBook extends JInternalFrame {
	Dao dao=new Dao();
	DbUtil dbUtil =new DbUtil();
	private JTextField findtext;
	private JTable bookfindresult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindBook frame = new FindBook();
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
	public FindBook() {
		setClosable(true);
		setTitle("\u67E5\u627E\u56FE\u4E66");
		//����λ�úʹ�С
		setBounds(0, 0, 1023, 481);
		
		//�������ѯ����
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u67E5\u8BE2\u6761\u4EF6");
		label.setFont(new Font("����", Font.PLAIN, 24));
		
		//��ѯ�����ı���
		findtext = new JTextField();
		findtext.setColumns(10);
		
		//��������ѯ
		JRadioButton radioButton = new JRadioButton("\u6309\u4E66\u540D\u67E5\u8BE2");
		radioButton.setFont(new Font("����", Font.PLAIN, 18));
		
		//��ͼ������ѯ
		JRadioButton radioButton_1 = new JRadioButton("\u6309\u56FE\u4E66\u7C7B\u522B\u67E5\u8BE2");
		radioButton_1.setFont(new Font("����", Font.PLAIN, 18));
		
		//�����
		JScrollPane scrollPane = new JScrollPane();
        //���
		bookfindresult = new JTable();
		bookfindresult.setFont(new Font("����", Font.PLAIN, 18));
		bookfindresult.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u540D", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u9986\u85CF\u6570\u91CF", "\u53EF\u501F\u6570\u91CF"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		//��ѯ��ť
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//������ÿ�
				DefaultTableModel dtm=(DefaultTableModel)bookfindresult.getModel();
				dtm.setRowCount(0);
				//��ȡ�ı�������
				String string=findtext.getText();
				//�����ѯ����Ϊ����ʾ
				if(string.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "��ѯ���ݲ���Ϊ�գ�");
					return;
				}
				//�������
				Connection con=null;
				Book book=new Book();
				try {
					//�����������ѯ
					if(radioButton.isSelected())
					{
						//�������ݿ�
						con=dbUtil.getCon();
						Book currentBook=dao.findBook(con, book, string);
						if(!currentBook.getAuthor().isEmpty())
						{
							//�����ѯ��������
							Vector vector=new Vector();
							vector.add(string);
							vector.add(currentBook.getAuthor());
							vector.add(currentBook.getPublisher());
							vector.add(currentBook.getColNum());
							vector.add(currentBook.getcBNum());
							dtm.addRow(vector);
						}
						//�ı����ÿ�
						findtext.setText("");
						return;
					}
					//�������ͼ������ѯ
					else if(radioButton_1.isSelected())
					{
						//�������ݿ�
						con=dbUtil.getCon();
						//��ѯ
						ResultSet rs=dao.findBook1(con, string);
						//�����ѯ���
						int i=0;
						while(rs.next())
						{
							i=1;
							Vector vector=new Vector();
							vector.add(rs.getString("bookname"));
							vector.add(rs.getString("author"));
							vector.add(rs.getString("publisher"));
							vector.add(rs.getString("colnum"));
							vector.add(rs.getString("cbnum"));
							dtm.addRow(vector);
						}
						if(i==0)
						{
							JOptionPane.showMessageDialog(null, "δ��ѯ�����ݣ�");
						}
						con.close();
						//�ÿ��˳�
						findtext.setText("");
						return;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "��ѡ���ѯ��ʽ��");
						return;
					}
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 24));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(115)
							.addComponent(label)
							.addGap(10)
							.addComponent(findtext, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(293)
							.addComponent(radioButton)
							.addGap(72)
							.addComponent(radioButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(123)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 741, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(143, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(findtext, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(radioButton)
						.addComponent(radioButton_1))
					.addGap(27)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		scrollPane.setViewportView(bookfindresult);
		getContentPane().setLayout(groupLayout);

	}
}
