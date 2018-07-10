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
		//设置位置和大小
		setBounds(0, 0, 1023, 481);
		
		//请输入查询条件
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u67E5\u8BE2\u6761\u4EF6");
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		
		//查询条件文本框
		findtext = new JTextField();
		findtext.setColumns(10);
		
		//按书名查询
		JRadioButton radioButton = new JRadioButton("\u6309\u4E66\u540D\u67E5\u8BE2");
		radioButton.setFont(new Font("宋体", Font.PLAIN, 18));
		
		//按图书类别查询
		JRadioButton radioButton_1 = new JRadioButton("\u6309\u56FE\u4E66\u7C7B\u522B\u67E5\u8BE2");
		radioButton_1.setFont(new Font("宋体", Font.PLAIN, 18));
		
		//表格桌
		JScrollPane scrollPane = new JScrollPane();
        //表格
		bookfindresult = new JTable();
		bookfindresult.setFont(new Font("宋体", Font.PLAIN, 18));
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
		//查询按钮
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//将表格置空
				DefaultTableModel dtm=(DefaultTableModel)bookfindresult.getModel();
				dtm.setRowCount(0);
				//获取文本框内容
				String string=findtext.getText();
				//如果查询内容为空提示
				if(string.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "查询内容不能为空！");
					return;
				}
				//定义变量
				Connection con=null;
				Book book=new Book();
				try {
					//如果按书名查询
					if(radioButton.isSelected())
					{
						//连接数据库
						con=dbUtil.getCon();
						Book currentBook=dao.findBook(con, book, string);
						if(!currentBook.getAuthor().isEmpty())
						{
							//输出查询结果到表格
							Vector vector=new Vector();
							vector.add(string);
							vector.add(currentBook.getAuthor());
							vector.add(currentBook.getPublisher());
							vector.add(currentBook.getColNum());
							vector.add(currentBook.getcBNum());
							dtm.addRow(vector);
						}
						//文本框置空
						findtext.setText("");
						return;
					}
					//如果按照图书类别查询
					else if(radioButton_1.isSelected())
					{
						//连接数据库
						con=dbUtil.getCon();
						//查询
						ResultSet rs=dao.findBook1(con, string);
						//输出查询结果
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
							JOptionPane.showMessageDialog(null, "未查询到数据！");
						}
						con.close();
						//置空退出
						findtext.setText("");
						return;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "请选择查询方式！");
						return;
					}
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 24));
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
