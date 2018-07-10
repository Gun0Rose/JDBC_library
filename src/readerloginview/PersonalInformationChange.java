package readerloginview;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class PersonalInformationChange extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInformationChange frame = new PersonalInformationChange();
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
	public PersonalInformationChange() {
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539");
		//设置位置和大小
		setBounds(0, 0, 1019, 481);
		
		//小桌面
		JDesktopPane table1 = new JDesktopPane();
		table1.setBackground(SystemColor.menu);
		
		//用户名修改
		JButton button = new JButton("\u7528\u6237\u540D\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NameChange nameChange=new NameChange();
				nameChange.setVisible(true);
				table1.add(nameChange);
				nameChange.toFront();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 24));
		
		//密码修改
		JButton button_1 = new JButton("\u5BC6\u7801\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PasswordChange passwordChange=new PasswordChange();
				passwordChange.setVisible(true);
				table1.add(passwordChange);
				passwordChange.toFront();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 24));
		
		//退出
		JButton button_2 = new JButton("\u9000    \u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "是否退出信息修改页面");
				System.out.println(result);
				if(result==0)
				{
					dispose();
				}
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 24));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(107, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addComponent(table1, GroupLayout.PREFERRED_SIZE, 555, GroupLayout.PREFERRED_SIZE)
					.addGap(115))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(107)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(table1, Alignment.LEADING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(61)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(67)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
