package readerloginview;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.libmanager.util.WorkerDbUtil;

import dao.AdminsDao;

public class LeaderUserinFrame_Find extends JInternalFrame {
	WorkerDbUtil wDbUtil=new WorkerDbUtil();
	AdminsDao aDao=new AdminsDao();
	private JTable table;
	private JTextField textField;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaderUserinFrame_Find frame = new LeaderUserinFrame_Find();
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
	public LeaderUserinFrame_Find() {
		setClosable(true);
		//设置位置
		setBounds(0, 0, 1023, 481);
		
		//表格桌
		JScrollPane scrollPane = new JScrollPane();
		//表格
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u751F\u65E5", "\u5730\u5740", "\u90AE\u7BB1", "\u5165\u804C\u65F6\u95F4", "\u5DE5\u8D44", "\u5DE5\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		//请输入查询条件
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u67E5\u8BE2\u6761\u4EF6");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		
		//文本框
		textField = new JTextField();
		textField.setColumns(10);
		
		//按照姓名查询
		button = new JButton("\u6309\u7167\u59D3\u540D\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				String name=textField.getText();
				Connection con=null;
				/**
				 * 连接数据库按照姓名查询
				 */
				try {
					con=wDbUtil.getCon();
					ResultSet rs=aDao.NameFind(con, name);
					//将表格置空
					DefaultTableModel dtm=(DefaultTableModel)table.getModel();
					dtm.setRowCount(0);
					while(rs.next())
					{
						i=1;						
						Vector vector=new Vector();
						vector.add(rs.getString("workid"));
						vector.add(rs.getString("wname"));
						vector.add(rs.getString("wsex"));
						vector.add(rs.getString("wbirthday"));
						vector.add(rs.getString("adress"));
						vector.add(rs.getString("post"));
						vector.add(rs.getString("entrytime"));
						vector.add(rs.getString("salary"));
						vector.add(rs.getString("idnum"));
						vector.add(rs.getString("password"));
						dtm.addRow(vector);
					}
					if(i==0)
					{
						JOptionPane.showMessageDialog(null, "该员工不存在！");
					}
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
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		
		//按照工号查询
		button_1 = new JButton("\u6309\u7167\u5DE5\u53F7\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				String workid=textField.getText();
				Connection con=null;
				/**
				 * 连接数据库按照工号查询
				 */
				try {
					con=wDbUtil.getCon();
					ResultSet rs=aDao.IDFind(con, workid);
					//将表格置空
					DefaultTableModel dtm=(DefaultTableModel)table.getModel();
					dtm.setRowCount(0);
					while(rs.next())
					{
						i=1;
						Vector vector=new Vector();
						vector.add(rs.getString("workid"));
						vector.add(rs.getString("wname"));
						vector.add(rs.getString("wsex"));
						vector.add(rs.getString("wbirthday"));
						vector.add(rs.getString("adress"));
						vector.add(rs.getString("post"));
						vector.add(rs.getString("entrytime"));
						vector.add(rs.getString("salary"));
						vector.add(rs.getString("idnum"));
						vector.add(rs.getString("password"));
						dtm.addRow(vector);
					}
					if(i==0)
					{
						JOptionPane.showMessageDialog(null, "该员工不存在！");
					}
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
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
							.addComponent(textField)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(110, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(70)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		
		getContentPane().setLayout(groupLayout);

	}

}
