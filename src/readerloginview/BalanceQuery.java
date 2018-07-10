package readerloginview;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import model.UserName_Password;
import oracle.jdbc.replay.ReplayableConnection.StatisticsReportType;

import java.awt.Color;
import javax.swing.SwingConstants;

public class BalanceQuery extends JInternalFrame {
	JTextField balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceQuery frame = new BalanceQuery();
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
	public BalanceQuery() {
		setClosable(true);
		setTitle("\u4F59\u989D\u67E5\u8BE2");
		//设置位置和大小
		setBounds(0, 0, 1019, 481);
		
		//您当前的余额为
		JLabel label = new JLabel("\u60A8\u5F53\u524D\u7684\u4F59\u989D\u4E3A");
		label.setFont(new Font("宋体", Font.PLAIN, 24));
		
		//文本框余额
		balance = new JTextField();
		balance.setHorizontalAlignment(SwingConstants.CENTER);
		balance.setFont(new Font("宋体", Font.PLAIN, 22));
		balance.setToolTipText("");
		balance.setBackground(new Color(255, 255, 255));
		balance.setColumns(10);
		balance.setText(UserName_Password.balancein);
		getContentPane().add(balance);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(315)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(balance, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(321, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(179)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(balance, Alignment.LEADING)
						.addComponent(label, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(241, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
