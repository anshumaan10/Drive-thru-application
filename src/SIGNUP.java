import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SIGNUP extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass;
	private JTextField user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SIGNUP frame = new SIGNUP();
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
	public SIGNUP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.PINK);
		
		JButton btnSignup = new JButton("SIGNUP");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  try {
					  Class.forName("com.mysql.jdbc.Driver");
					  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					  

	                    String query = "INSERT INTO login_details values('" + user.getText() + "','"+pass.getText()+"')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);

                        if(x!=0) {
                        	int i;
                        	
                        	if(user.getText().equals("") || pass.getText().equals("")) {
                        	JOptionPane.showMessageDialog(null,"Input fields cant be empty");
                        	}
                        	else{
                        		JOptionPane.showMessageDialog(null,"You have been registered successfully");
                        	}
                        

	                                 }
else
{
JOptionPane.showMessageDialog(null,"Something went wrong.Try again");
}
				  }
				catch(Exception e1) {
				System.out.print(e1);	
				}
			}
		});
		btnSignup.setForeground(Color.DARK_GRAY);
		btnSignup.setFont(new Font("Century Gothic", Font.BOLD, 25));
		
		JLabel label = new JLabel("USERNAME");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Century Gothic", Font.BOLD, 30));
		
		JLabel label_1 = new JLabel("PASSWORD");
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setFont(new Font("Century Gothic", Font.BOLD, 30));
		
		pass = new JPasswordField();
		
		user = new JTextField();
		user.setForeground(Color.DARK_GRAY);
		user.setFont(new Font("Century Gothic", Font.BOLD, 30));
		user.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 463, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSignup, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(29)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(user, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
								.addComponent(pass, Alignment.LEADING))
							.addGap(23)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 285, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(53)
							.addComponent(label))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(66)
							.addComponent(user, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(49)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pass)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addComponent(btnSignup)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel = new JLabel("Drive-Thru Application");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Desktop\\IMAGES\\image-4.png"));
		
		JLabel lblRegisterYourself = new JLabel("Register yourself");
		lblRegisterYourself.setFont(new Font("Century Gothic", Font.BOLD, 30));
		
		JButton btnNewButton = new JButton("Buy Now");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LOGIN newframe=new LOGIN();
			newframe.setVisible(true);
			dispose();
			
			
			}
		});
		btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(23, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
							.addGap(146)
							.addComponent(btnNewButton)
							.addGap(43))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
							.addGap(25))))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(268)
					.addComponent(lblRegisterYourself, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(336, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRegisterYourself, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
							.addGap(40))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
