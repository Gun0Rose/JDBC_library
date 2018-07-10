package readerloginview;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.libmanager.util.EmptyTool;
import com.libmanager.util.WorkerDbUtil;

import dao.AdminsDao;
import model.Admins;

public class LeaderUserinFrame extends JInternalFrame {
	private JTextField UsernameTxt;
	private JTextField UsersexTxt;
	private JTextField UserbirthTxt;
	private JTextField UseraddrTxt;
	private JTextField UserpostTxt;
	private JTextField UserintimeTxt;
	private JTextField UsersalaryTxt;
	private JTextField UseridTxt;
	private JTextField UserpasswTxt;
	private WorkerDbUtil workerDbUtil=new WorkerDbUtil();
	private AdminsDao adminsDao=new AdminsDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaderUserinFrame frame = new LeaderUserinFrame();
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
	public LeaderUserinFrame() {
		setClosable(true);
		setTitle("\u4EBA\u5458\u4FE1\u606F\u6DFB\u52A0");
		setBounds(100, 100, 1023, 481);
		
		JLabel label = new JLabel("\u59D3   \u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel label_1 = new JLabel("\u6027   \u522B");
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel label_2 = new JLabel("\u751F   \u65E5\r\n");
		label_2.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel label_3 = new JLabel("\u5730   \u5740");
		label_3.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel label_4 = new JLabel("\u90AE   \u7BB1");
		label_4.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel label_5 = new JLabel("\u5165\u804C\u65F6\u95F4");
		label_5.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel label_6 = new JLabel("\u5DE5   \u8D44");
		label_6.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel label_7 = new JLabel("\u5DE5   \u53F7");
		label_7.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JLabel label_8 = new JLabel("\u5BC6   \u7801");
		label_8.setFont(new Font("宋体", Font.PLAIN, 17));
		
		UsernameTxt = new JTextField();
		UsernameTxt.setColumns(10);
		
		UsersexTxt = new JTextField();
		UsersexTxt.setColumns(10);
		
		UserbirthTxt = new JTextField();
		UserbirthTxt.setColumns(10);
		
		UseraddrTxt = new JTextField();
		UseraddrTxt.setColumns(10);
		
		UserpostTxt = new JTextField();
		UserpostTxt.setColumns(10);
		
		UserintimeTxt = new JTextField();
		UserintimeTxt.setColumns(10);
		
		UsersalaryTxt = new JTextField();
		UsersalaryTxt.setColumns(10);
		
		UseridTxt = new JTextField();
		UseridTxt.setColumns(10);
		
		UserpasswTxt = new JTextField();
		UserpasswTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LeaderUserinFrame.class.getResource("/images/resizeApi.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LeaderUserinFrame.class.getResource("/images/\u7EED\u501F.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(128)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(UsernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(UsersexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(UserbirthTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(UseraddrTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(UserpostTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(218)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(UserpasswTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(UseridTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(UsersalaryTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(UserintimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(235)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(268, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(UsernameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(UsersexTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(UserbirthTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(UseraddrTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(UserpostTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(UserintimeTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(UsersalaryTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(UseridTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(UserpasswTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addGap(98))
		);
		getContentPane().setLayout(groupLayout);
	}

	private void AddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String username= UsernameTxt.getText();
		String useradd= UseraddrTxt.getText();
		String userbirth= UserbirthTxt.getText();
		String userid= UseridTxt.getText();
		String userintime= UserintimeTxt.getText();
		String userpassw= UserpasswTxt.getText();
		String userpost= UserpostTxt.getText();
		String usersalary= UsersalaryTxt.getText();
		String usersex= UsersexTxt.getText();
		if (EmptyTool.isEmpty(username)||EmptyTool.isEmpty(useradd)||EmptyTool.isEmpty(userbirth)||EmptyTool.isEmpty(userid)||EmptyTool.isEmpty(userintime)||EmptyTool.isEmpty(userpassw)||EmptyTool.isEmpty(userpost)||EmptyTool.isEmpty(usersalary)||EmptyTool.isEmpty(usersex)) {
			JOptionPane.showMessageDialog(null, "有未填写项目！");
			return;
		}
		Admins admins=new Admins(username,usersex,userbirth,useradd,userpost,userintime,usersalary,userid,userpassw);
		Connection con=null;
		try {
			con=workerDbUtil.getCon();
			int n=adminsDao.Add(con, admins);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "添加成功");
				ResetValue();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败1");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	/**
	 *重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.ResetValue();
	}

	/**
	 * 重置表单
	 * 
	 */
	private void ResetValue() {
		this.UsernameTxt.setText("");
		this.UseraddrTxt.setText("");
		this.UserbirthTxt.setText("");
		this.UseridTxt.setText("");
		this.UserintimeTxt.setText("");
		this.UserpasswTxt.setText("");
		this.UserpostTxt.setText("");
		this.UsersalaryTxt.setText("");
		this.UsersexTxt.setText("");
		
	}
}
