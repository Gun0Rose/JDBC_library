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
import java.awt.event.ActionEvent;

public class PasswordChange extends JInternalFrame {
	
	DbUtil dbUtil=new DbUtil();
	Dao dao=new Dao();
	private JTextField oldpassword;
	private JTextField newpassword;
	private JTextField newpassword1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordChange frame = new PasswordChange();
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
	public PasswordChange() {
		setTitle("\u5BC6\u7801\u4FEE\u6539");
		//����λ�ô�С
		setBounds(0, 0, 555, 239);
		
		//���������ľ�����
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u65E7\u5BC6\u7801");
		label.setFont(new Font("����", Font.PLAIN, 16));
		
		oldpassword = new JTextField();
		oldpassword.setColumns(10);
		
		//����������������
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u7684\u65B0\u5BC6\u7801");
		label_1.setFont(new Font("����", Font.PLAIN, 16));
		
		newpassword = new JTextField();
		newpassword.setColumns(10);
		
		//��ȷ������������
		JLabel label_2 = new JLabel("\u8BF7\u786E\u8BA4\u60A8\u7684\u65B0\u5BC6\u7801");
		label_2.setFont(new Font("����", Font.PLAIN, 16));
		
		newpassword1 = new JTextField();
		newpassword1.setColumns(10);
		
		//button��ȷ��
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ȡ�ı�������
				String oldpass=oldpassword.getText();
				String newpass=newpassword.getText();
				String newpass1=newpassword1.getText();
				
				//���������������
				if(!oldpass.equals(UserName_Password .password))
				{
					//��ʾ����
					JOptionPane.showMessageDialog(null, "�����������������");
					//�����ı���Ϊ��
					oldpassword.setText("");
					newpassword.setText("");
					newpassword1.setText("");
					return;
				}
				
				//���������Ϊ��
				if(newpass.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "������������");
					newpassword1.setText("");
					return;
				}
				
				//��������������벻һ��
				if(!newpass.equals(newpass1))
				{
					JOptionPane.showMessageDialog(null, "���������벻һ�£�����������");
					newpassword.setText("");
					newpassword1.setText("");
					return;
				}
				
				Connection con=null;
				try {
					//�������ݿ�
					con=dbUtil.getCon();
					//����sql����޸�����
					dao.changePassword(con, newpass);
					JOptionPane.showMessageDialog(null, "�����޸ĳɹ���");
					UserName_Password.password=newpass;
					oldpassword.setText("");
					newpassword.setText("");
					newpassword1.setText("");
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 16));
		
		//button������
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldpassword.setText("");
				newpassword.setText("");
				newpassword1.setText("");
			}
		});
		button_1.setFont(new Font("����", Font.PLAIN, 16));
		
		//button���˳�
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null, "�Ƿ��˳������޸�ҳ��");
				if(result==0)
				{
					dispose();
				}
			}
		});
		button_2.setFont(new Font("����", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(newpassword1, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(newpassword, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(oldpassword, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(153, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(button)
					.addGap(88)
					.addComponent(button_1)
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addComponent(button_2)
					.addGap(80))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(oldpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(newpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(newpassword1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_2)
						.addComponent(button_1))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}

}
