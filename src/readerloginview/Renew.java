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
		//����λ�úʹ�С
		setBounds(0, 0, 1023, 481);
		
		//�����
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
		
		//���
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
		 * Ϊ�����Ӱ�ť
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
		  
		        // ��Ӱ�ť��  
		        this.panel.add(this.button);  
		    }  
		  
		    private void initButton()  
		    {  
		    	this.button = new JButton("\u7EED\u501F");  
		        // ���ð�ť�Ĵ�С��λ�á�  
		        this.button.setBounds(0, 0, 180, 15); 
		        //��������
		        button.setFont(new Font("����", Font.PLAIN, 12));
		        button.setVisible(true);  
		  
		        // ����Ⱦ�������Ӱ�ť���¼��ǲ��ᴥ����  
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
		  
		        // panelʹ�þ��Զ�λ������button�Ͳ������������Ԫ��  
		        this.panel.setLayout(null);  
		    }  
		  
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,  
		            int column)  
		    {  
		        return this.panel;  
		    }  
		  
		}  
		
		
		
		/** 
		 * �Զ���һ�����������Ӱ�ť�ĵ�Ԫ��༭������ü̳�DefaultCellEditor����ȻҪʵ�ֵķ�����̫���ˡ� 
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
		     * ���캯��
		     */
		    public MyButtonEditor()  
		    {  
		        // DefautlCellEditor�д˹���������Ҫ����һ�������������ʹ�õ���ֱ��newһ�����ɡ�  
		        super(new JTextField());  
		  
		        // ���õ�����μ���༭��  
		        this.setClickCountToStart(1);  
		  
		        this.initButton();  
		  
		        this.initPanel();  
		  
		        // ��Ӱ�ť��  
		        this.panel.add(this.button);  
		    }  
		    
		    /**
		     * ��ť����
		     */
		    private void initButton()  
		    {  
		        this.button = new JButton("\u7EED\u501F");  
		        // ���ð�ť�Ĵ�С��λ�á�  
		        this.button.setBounds(0, 0, 180, 15); 
		        //��������
		        button.setFont(new Font("����", Font.PLAIN, 12));
		        button.setVisible(true);
		        /*// ֻΪ��ť��ֵ���ɡ�Ҳ����������������  
		        this.button.setText("����");*/  
		  
		        // Ϊ��ť����¼�������ֻ�����ActionListner�¼���Mouse�¼���Ч��  
		        this.button.addActionListener(new ActionListener() { 
		            public void actionPerformed(ActionEvent e)  
		            {  
		                /*// ����ȡ���༭���¼����������tableModel��setValue������  
		                MyButtonEditor.this.fireEditingCanceled();  
		  
		                // �������������������  
		                // ���Խ�table���룬ͨ��getSelectedRow,getSelectColumn������ȡ����ǰѡ����к��м����������ȡ�  */
	            		String cardId=null;//����
	            		String bookId=null;//���
	            		String bookName=null;//����
	            		String borrowTime=null;//��������
	            		String returnTime=null;//��������
	            		String newReturnTime=null;//�»�������
	            		String borrowMouth=null;//������
	            		String returnMouth=null;//������
	            		
	            		/**
	            		 * ��ȡ����
	            		 */
	            		int row;//�к�
	            		row=table.getSelectedRow();
	            		bookName=table.getValueAt(row, 0).toString();//����
	            		
	            		/**
	            		 * ��ȡ������
	            		 */
	            		borrowTime=table.getValueAt(row, 1).toString();
	            		borrowMouth=borrowTime.substring(5, 7);
	            		int borrowMouthInt=Integer.parseInt(borrowMouth);//������int��
	            		
	            		
	            		/**
	            		 * ��ȡ�������ڲ�����
	            		 */
	            		returnTime=table.getValueAt(row, 2).toString();//��������
	            		newReturnTime=null;
	            		String year=null;
	            		returnMouth=null;
	            		String day=null;
	            		year=returnTime.substring(0,5);
	            		returnMouth=returnTime.substring(5, 7);
	            		day=returnTime.substring(7,10);
	            		int returnMouthint=Integer.parseInt(returnMouth);//������int��
	            		returnMouthint++;
	            		returnMouth=Integer.toString(returnMouthint);
	            		newReturnTime=year+returnMouth+day;
	            		
	            		/**
	            		 * ��������һ�Σ���ʾ����������
	            		 */
	            		if(returnMouthint-borrowMouthInt>2)
	            		{
	            			JOptionPane.showMessageDialog(null, "�������һ�Σ�������ɴ˴����裡");
	            			return;
	            		}
	            		else
	            		{
		            		/**
		            		 * ����connection����
		            		 */
		            		Connection con=null;
		            		
		            		/**
		            		 * �������ݿ��ѯ���Ų����ص�cardID
		            		 */
		            		try {
								con=dbUtil.getCon();
								cardId=dao.selectCardID(con);
							} catch (Exception e1) {
								// TODO �Զ����ɵ� catch ��
								e1.printStackTrace();
							}
		            		
		            		/**
		            		 * �������ݿ��ѯ��Ų����ص�bookId
		            		 */
		            		try {
								con=dbUtil.getCon();
								bookId=dao.selectBookID(con, bookName);
								//Ϊ����л�������������������
								table.setValueAt(newReturnTime, row, 2);
								//��ʾ����ɹ�
								JOptionPane.showMessageDialog(null, "����ɹ���");
							} catch (Exception e1) {
								// TODO �Զ����ɵ� catch ��
								e1.printStackTrace();
							}
		            		
		            		/**
		            		 * �������ݿ��޸Ļ�������
		            		 */
		            		try {
								con=dbUtil.getCon();
								dao.changeReturnTime(con, newReturnTime, cardId, bookId);
							} catch (Exception e1) {
								// TODO �Զ����ɵ� catch ��
								e1.printStackTrace();
							}
	            		}            		
	            	}
		        });  
		  
		    }  
		  
		    /**
		     * jpanel����
		     */
		    private void initPanel()  
		    {  
		        this.panel = new JPanel();  
		  
		        // panelʹ�þ��Զ�λ������button�Ͳ������������Ԫ��  
		        this.panel.setLayout(null);  
		    }  
		  
		  
		    /** 
		     * ������д����ı༭����������һ��JPanel���󼴿ɣ�Ҳ����ֱ�ӷ���һ��Button���󣬵��������������������Ԫ�� 
		     */  
		    @Override  
		    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)  
		    {  
		        return this.panel;  
		    }  
		  
		    /** 
		     * ��д�༭��Ԫ��ʱ��ȡ��ֵ���������д��������ܻ�Ϊ��ť���ô����ֵ�� 
		     *//*  
		    @Override  
		    public Object getCellEditorValue()  
		    {  
		        return this.button.getText();  
		    }  */
		  
		}  

		this.table.setRowSelectionAllowed(false);// ��ֹ����ѡ���ܡ���Ȼ�ڵ����ťʱ�������ж��ᱻѡ�С�Ҳ����ͨ��������ʽ��ʵ�֡�
		//������ÿ�
		DefaultTableModel dtm=(DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		//��ӱ������
		UserName_Password.mark=0;//����Ƿ��ѯ������
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		 //�ر����ݿ�����
		 try {
			UserName_Password.con.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}
