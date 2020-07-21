import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CHECKOUT extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CHECKOUT frame = new CHECKOUT();
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
	public CHECKOUT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("Drive-Thru Application");
		label.setFont(new Font("Century Gothic", Font.BOLD, 30));
		
		JLabel lblCheckout = new JLabel("BILL");
		lblCheckout.setFont(new Font("Century Gothic", Font.BOLD, 30));
		
		JLabel lblFoodGrains = new JLabel("FOOD GRAINS");
		lblFoodGrains.setFont(new Font("Century Gothic", Font.BOLD, 30));
		
		JLabel lblBakery = new JLabel("BAKERY");
		lblBakery.setFont(new Font("Century Gothic", Font.BOLD, 30));
		
		JLabel lblFruits = new JLabel("FRUITS");
		lblFruits.setFont(new Font("Century Gothic", Font.BOLD, 30));
		
		JLabel lblBeverages = new JLabel("BEVERAGES");
		lblBeverages.setFont(new Font("Century Gothic", Font.BOLD, 30));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblTotalAmount = new JLabel("TOTAL AMOUNT");
		lblTotalAmount.setFont(new Font("Century Gothic", Font.BOLD, 25));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("PROCEED TO CHECKOUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	   				  Class.forName("com.mysql.jdbc.Driver");
	   				  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	   				  


	                      Statement sta = con.createStatement();
	                      int x = sta.executeUpdate("delete from foodgrains where F_TOTAL NOT IN ('0')");
	                      int y= sta.executeUpdate("delete from bakery where bak_total NOT IN ('0')");
	                      int z= sta.executeUpdate(" delete from fruits where fr_total NOT IN ('0')");
	                      int w= sta.executeUpdate("delete from beverages where B_TOTAL NOT IN ('0') ");

	                    
	   			 }
	   			catch(Exception e1) {
	   			System.out.print(e1);	
	   			}
				
				
				JOptionPane.showMessageDialog(null,"Please pay the cash amount\nThankyou for your visit..");
				LOGIN newframe=new LOGIN();
				newframe.setVisible(true);
				dispose();

			}
		});
		btnNewButton.setFont(new Font("Stencil", Font.BOLD, 25));
		
		JButton btnNewButton_1 = new JButton("Calculate");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				 try {
	   				  Class.forName("com.mysql.jdbc.Driver");
	   				  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	                    
                      String sql1=" select SUM(F_TOTAL) as total1 from foodgrains";
                      String sql2=" select SUM(bak_total) as total2 from bakery";
                      String sql3=" select SUM(fr_total) as total3 from fruits";
                      String sql4=" select SUM(B_TOTAL) as total4 from beverages";

	   				   Statement sta = con.createStatement();
	   				   
	   				ResultSet r1=sta.executeQuery(sql1);
	   				if(r1.next()) {
	   					textField.setText(r1.getString("total1"));

	   					}
	   				ResultSet r2=sta.executeQuery(sql2);
	   				if(r2.next()) {
	   					textField_1.setText(r2.getString("total2"));
	   				}
	   				ResultSet r3=sta.executeQuery(sql3);
	   				if(r3.next()) {
	   					textField_2.setText(r3.getString("total3"));
	   				}
	   				ResultSet r4=sta.executeQuery(sql4);
	   				if(r4.next()) {
	   					textField_3.setText(r4.getString("total4"));
	   				}
	   				String a1=textField.getText();
	   				String a2=textField_1.getText();
	   				String a3=textField_2.getText();
	   				String a4=textField_3.getText();
	   				 int b1,b2,b3,b4,total=0;
	   				 b1=Integer.parseInt(a1);
	   				 b2=Integer.parseInt(a2);
	   				 b3=Integer.parseInt(a3);
	   				 b4=Integer.parseInt(a4);
	   				 total=b1+b2+b3+b4;
	   				 textField_4.setText(Integer.toString(total));


	   				

}
	   			catch(Exception e1) {
	   			System.out.print(e1);	
	   			}
			
				
				
			}
		});
		
		JButton button = new JButton("SELECT CATEGORY");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_panel newframe=new Login_panel();
				newframe.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBakery)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFruits)
										.addComponent(lblBeverages))
									.addGap(115)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField)
												.addComponent(textField_1)
												.addComponent(textField_2)
												.addComponent(textField_3))
											.addGap(119)
											.addComponent(lblTotalAmount, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
										.addComponent(btnNewButton)))
								.addComponent(lblFoodGrains)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(412)
							.addComponent(lblCheckout)))
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(399, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(393))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(676, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCheckout, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFoodGrains, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBakery, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFruits, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBeverages, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTotalAmount, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(4)
					.addComponent(btnNewButton_1)
					.addGap(22)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	
}
