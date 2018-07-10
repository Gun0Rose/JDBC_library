package readerloginview;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.libmanager.util.DbUtil;

import dao.Dao;
import model.UserName_Password;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NameChange extends JInternalFrame {
	DbUtil dbUtil=new DbUtil();
	Dao dao=new Dao();
	
	private JTextField newname;
	private JTextField newname1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NameChange frame = new NameChange();
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
	public NameChange() {
		setTitle("\u7528\u6237\u540D\u4FEE\u6539");
		//设置位置大小
		setBounds(0, 0, 555, 239);
		
		//新的用户名
		JLabel lable = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7684\u7528\u6237\u540D");
		lable.setFont(new Font("宋体", Font.PLAIN, 16));
		//新用户名文本输入框
		newname = new JTextField();
		newname.setColumns(10);
		
		//确认用户名
		JLabel lable1 = new JLabel("\u8BF7\u786E\u8BA4\u60A8\u7684\u7528\u6237\u540D");
		lable1.setFont(new Font("宋体", Font.PLAIN, 16));
		//确认用户名文本输入框
		newname1 = new JTextField();
		newname1.setColumns(10);
		
		//button：确认
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//获取文本框内容
				String name=newname.getText();
				String name1=newname1.getText();
				
				//如果用户名为空提示
				if(name.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "请输入用户名");
					newname1.setText("");
					return;
				}
				
				//如果两次用户名输入不一致，提示
				if(!name.equals(name1))
				{
					JOptionPane.showMessageDialog(null, "用户名输入不一致！");
					newname.setText("");
					newname1.setText("");
					return;
				}
				
				Connection con=null;
				try {
					//连接数据库
					con=dbUtil.getCon();
					//发送sql语句修改用户名
					dao.changeName(con, name);
					//提示修改成功
					JOptionPane.showMessageDialog(null, "用户名修改成功！");
					UserName_Password.userName=name;
					newname.setText("");
					newname1.setText("");
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		
		//button：重置
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newname.setText("");
				newname1.setText("");
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		//button：退出
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出用户名修改页面");
				System.out.println(result);
				if(result==0)
				{
					dispose();
				}
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lable)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(newname, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lable1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(newname1, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(99)
							.addComponent(button)
							.addGap(68)
							.addComponent(button_1)
							.addGap(67)
							.addComponent(button_2)))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(newname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lable))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lable1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(newname1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(27))
		);
		getContentPane().setLayout(groupLayout);

	}
}
