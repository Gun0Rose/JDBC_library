package readerloginview;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import model.UserName_Password;

public class PersonalInformationInquire extends JInternalFrame {
	/**
	 * @wbp.nonvisual location=81,-13
	 */
	private final JEditorPane editorPane = new JEditorPane();
	private JTextField cardnumber;
	private JTextField cardtime;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInformationInquire frame = new PersonalInformationInquire();
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
	public PersonalInformationInquire() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 24));
		setClosable(true);
		setTitle("\u4E2A\u4EBA\u4FE1\u606F\u67E5\u8BE2");
		//设置位置和大小
		setBounds(0, 0, 1019, 481);
		
		//个人信息查询结果如下
		JLabel label = new JLabel("\u4E2A\u4EBA\u4FE1\u606F\u67E5\u8BE2\u7ED3\u679C\u5982\u4E0B\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		
		//卡号
		JLabel label_1 = new JLabel("\u5361    \u53F7");
		label_1.setFont(new Font("宋体", Font.PLAIN, 24));
		
		cardnumber = new JTextField();
		cardnumber.setFont(new Font("宋体", Font.PLAIN, 22));
		cardnumber.setColumns(10);
		cardnumber.setText(UserName_Password.cardId);
		
		//开卡时间
		JLabel label_2 = new JLabel("\u5F00\u5361\u65F6\u95F4");
		label_2.setFont(new Font("宋体", Font.PLAIN, 24));
		
		cardtime = new JTextField();
		cardtime.setFont(new Font("宋体", Font.PLAIN, 22));
		cardtime.setColumns(10);
		cardtime.setText(UserName_Password.startDate);
		
		//用户名
		JLabel label_3 = new JLabel("\u7528 \u6237 \u540D");
		label_3.setFont(new Font("宋体", Font.PLAIN, 24));
		
		username = new JTextField();
		username.setFont(new Font("宋体", Font.PLAIN, 22));
		username.setColumns(10);
		username.setText(UserName_Password.userName);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cardtime, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(username, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addGap(18)
							.addComponent(cardnumber, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE))
					.addGap(584))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cardnumber)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(username, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(cardtime, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(388))
		);
		getContentPane().setLayout(groupLayout);

	}
}
