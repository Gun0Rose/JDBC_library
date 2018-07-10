package readerloginview;

import java.awt.Button;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.libmanager.util.DbUtil;

import dao.Dao;
import model.UserName_Password;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Renew extends JInternalFrame {
	private JTable table;
	DbUtil dbUtil=new DbUtil();
	Dao dao=new Dao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Renew frame = new Renew();
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
	public Renew() {
		setClosable(true);
		setTitle("\u7EED\u501F");
		//设置位置和大小
		setBounds(0, 0, 1023, 481);
		
		//表格桌
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 679, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(172, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		
		//表格
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u4E66\u540D", "\u501F\u4E66\u65E5\u671F", "\u8FD8\u4E66\u65E5\u671F", "\u662F\u5426\u7EED\u501F"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		
		/**
		 * 为表格添加按钮
		 * @author Administrator
		 *
		 */
		class MyButtonRender implements TableCellRenderer  
		{  
		    private JPanel panel;  
		  
		    private JButton button;  
		  
		    public MyButtonRender()  
		    {  
		        this.initButton();  
		  
		        this.initPanel();  
		  
		        // 添加按钮。  
		        this.panel.add(this.button);  
		    }  
		  
		    private void initButton()  
		    {  
		    	this.button = new JButton("\u7EED\u501F");  
		        // 设置按钮的大小及位置。  
		        this.button.setBounds(0, 0, 180, 15); 
		        //设置字体
		        button.setFont(new Font("宋体", Font.PLAIN, 12));
		        button.setVisible(true);  
		  
		        // 在渲染器里边添加按钮的事件是不会触发的  
		        // this.button.addActionListener(new ActionListener()  
		        // {  
		        //  
		        // public void actionPerformed(ActionEvent e)  
		        // {  
		        // // TODO Auto-generated method stub  
		        // }  
		        // });  
		  
		    }  
		  
		    private void initPanel()  
		    {  
		        this.panel = new JPanel();  
		  
		        // panel使用绝对定位，这样button就不会充满整个单元格。  
		        this.panel.setLayout(null);  
		    }  
		  
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,  
		            int column)  
		    {  
		        return this.panel;  
		    }  
		  
		}  
		
		
		
		/** 
		 * 自定义一个往列里边添加按钮的单元格编辑器。最好继承DefaultCellEditor，不然要实现的方法就太多了。 
		 *  
		 */  
		class MyButtonEditor extends DefaultCellEditor  
		{  
		  
		    /** 
		     * serialVersionUID 
		     */  
		    private static final long serialVersionUID = -6546334664166791132L;  
		  
		    private JPanel panel;  
		  
		    private JButton button;  
		    
		    /**
		     * 构造函数
		     */
		    public MyButtonEditor()  
		    {  
		        // DefautlCellEditor有此构造器，需要传入一个，但这个不会使用到，直接new一个即可。  
		        super(new JTextField());  
		  
		        // 设置点击几次激活编辑。  
		        this.setClickCountToStart(1);  
		  
		        this.initButton();  
		  
		        this.initPanel();  
		  
		        // 添加按钮。  
		        this.panel.add(this.button);  
		    }  
		    
		    /**
		     * 按钮函数
		     */
		    private void initButton()  
		    {  
		        this.button = new JButton("\u7EED\u501F");  
		        // 设置按钮的大小及位置。  
		        this.button.setBounds(0, 0, 180, 15); 
		        //设置字体
		        button.setFont(new Font("宋体", Font.PLAIN, 12));
		        button.setVisible(true);
		        /*// 只为按钮赋值即可。也可以作其它操作。  
		        this.button.setText("续借");*/  
		  
		        // 为按钮添加事件。这里只能添加ActionListner事件，Mouse事件无效。  
		        this.button.addActionListener(new ActionListener() { 
		            public void actionPerformed(ActionEvent e)  
		            {  
		                /*// 触发取消编辑的事件，不会调用tableModel的setValue方法。  
		                MyButtonEditor.this.fireEditingCanceled();  
		  
		                // 这里可以做其它操作。  
		                // 可以将table传入，通过getSelectedRow,getSelectColumn方法获取到当前选择的行和列及其它操作等。  */
	            		String cardId=null;//卡号
	            		String bookId=null;//书号
	            		String bookName=null;//书名
	            		String borrowTime=null;//借书日期
	            		String returnTime=null;//还书日期
	            		String newReturnTime=null;//新还书日期
	            		String borrowMouth=null;//借书月
	            		String returnMouth=null;//还书月
	            		
	            		/**
	            		 * 获取书名
	            		 */
	            		int row;//行号
	            		row=table.getSelectedRow();
	            		bookName=table.getValueAt(row, 0).toString();//书名
	            		
	            		/**
	            		 * 获取借书月
	            		 */
	            		borrowTime=table.getValueAt(row, 1).toString();
	            		borrowMouth=borrowTime.substring(5, 7);
	            		int borrowMouthInt=Integer.parseInt(borrowMouth);//借书月int型
	            		
	            		
	            		/**
	            		 * 获取还书日期并处理
	            		 */
	            		returnTime=table.getValueAt(row, 2).toString();//还书日期
	            		newReturnTime=null;
	            		String year=null;
	            		returnMouth=null;
	            		String day=null;
	            		year=returnTime.substring(0,5);
	            		returnMouth=returnTime.substring(5, 7);
	            		day=returnTime.substring(7,10);
	            		int returnMouthint=Integer.parseInt(returnMouth);//还书月int型
	            		returnMouthint++;
	            		returnMouth=Integer.toString(returnMouthint);
	            		newReturnTime=year+returnMouth+day;
	            		
	            		/**
	            		 * 如果续借过一次，提示不能再续接
	            		 */
	            		if(returnMouthint-borrowMouthInt>2)
	            		{
	            			JOptionPane.showMessageDialog(null, "已续借过一次，不能完成此次续借！");
	            			return;
	            		}
	            		else
	            		{
		            		/**
		            		 * 定义connection对象
		            		 */
		            		Connection con=null;
		            		
		            		/**
		            		 * 连接数据库查询卡号并返回到cardID
		            		 */
		            		try {
								con=dbUtil.getCon();
								cardId=dao.selectCardID(con);
							} catch (Exception e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
							}
		            		
		            		/**
		            		 * 连接数据库查询书号并返回到bookId
		            		 */
		            		try {
								con=dbUtil.getCon();
								bookId=dao.selectBookID(con, bookName);
								//为表格中还书日期列设置新内容
								table.setValueAt(newReturnTime, row, 2);
								//提示续借成功
								JOptionPane.showMessageDialog(null, "续借成功！");
							} catch (Exception e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
							}
		            		
		            		/**
		            		 * 连接数据库修改还书日期
		            		 */
		            		try {
								con=dbUtil.getCon();
								dao.changeReturnTime(con, newReturnTime, cardId, bookId);
							} catch (Exception e1) {
								// TODO 自动生成的 catch 块
								e1.printStackTrace();
							}
	            		}            		
	            	}
		        });  
		  
		    }  
		  
		    /**
		     * jpanel函数
		     */
		    private void initPanel()  
		    {  
		        this.panel = new JPanel();  
		  
		        // panel使用绝对定位，这样button就不会充满整个单元格。  
		        this.panel.setLayout(null);  
		    }  
		  
		  
		    /** 
		     * 这里重写父类的编辑方法，返回一个JPanel对象即可（也可以直接返回一个Button对象，但是那样会填充满整个单元格） 
		     */  
		    @Override  
		    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)  
		    {  
		        return this.panel;  
		    }  
		  
		    /** 
		     * 重写编辑单元格时获取的值。如果不重写，这里可能会为按钮设置错误的值。 
		     *//*  
		    @Override  
		    public Object getCellEditorValue()  
		    {  
		        return this.button.getText();  
		    }  */
		  
		}  

		this.table.setRowSelectionAllowed(false);// 禁止表格的选择功能。不然在点击按钮时表格的整行都会被选中。也可以通过其它方式来实现。
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
				 vector.add(UserName_Password.resultSet.getString("borrowtime"));
				 vector.add(UserName_Password.resultSet.getString("returntime")); 
				 this.table.getColumnModel().getColumn(3).setCellRenderer(new MyButtonRender());  
				 this.table.getColumnModel().getColumn(3).setCellEditor(new MyButtonEditor());   
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
