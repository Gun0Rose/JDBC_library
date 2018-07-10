package readerloginview;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.UserName_Password;

public class FindBorrowedBook extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindBorrowedBook frame = new FindBorrowedBook();
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
	public FindBorrowedBook() {
		setClosable(true);
		setTitle("\u5728\u501F\u56FE\u4E66\u67E5\u8BE2");
		//设置位置和大小
		setBounds(0, 0, 1023, 481);
		
		//您的在借图书如下：
		JLabel label = new JLabel("\u60A8\u7684\u5728\u501F\u56FE\u4E66\u5982\u4E0B\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		
		//表格桌
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(136)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		//表格
		table = new JTable();
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u540D", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u501F\u4E66\u65E5\u671F", "\u8FD8\u4E66\u65E5\u671F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		//将表格置空
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		//添加表格内容
		 UserName_Password.mark=0;//标记是否查询到数据
		 try {
			while(UserName_Password.resultSet.next())
			 {
				 UserName_Password.mark=1;
				 Vector vector=new Vector();
				 vector.add(UserName_Password.resultSet.getString("bookname"));
				 vector.add(UserName_Password.resultSet.getString("author"));
				 vector.add(UserName_Password.resultSet.getString("publisher"));
				 vector.add(UserName_Password.resultSet.getString("borrowtime"));
				 vector.add(UserName_Password.resultSet.getString("returntime"));
				 dtm.addRow(vector);
			 }
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		 //关闭数据库连接
		 try {
			UserName_Password.con.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
	}
}
