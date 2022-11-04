import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class adminlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField txtpwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin frame = new adminlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement pst;
	public void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
con =DriverManager.getConnection("jdbc:mysql://localhost:3306/localschool", "root","");

		}
		catch(ClassNotFoundException ea){
			Logger.getLogger(adminlogin.class.getName()).log(Level.SEVERE,null,ea);
		}
		catch(SQLException ex)
		{
			Logger.getLogger(adminlogin.class.getName()).log(Level.SEVERE,null,ex);	
		}
	}
	/**
	 * Create the frame.
	 */
	public adminlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(138, 0, 227, 78);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(44, 88, 127, 25);
		contentPane.add(lblNewLabel_1);
		
		textUser = new JTextField();
		textUser.setBounds(236, 88, 96, 19);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblNewLabel_1_1.setBounds(44, 148, 127, 25);
		contentPane.add(lblNewLabel_1_1);
		
		txtpwd = new JPasswordField();
		txtpwd.setBounds(236, 148, 96, 19);
		contentPane.add(txtpwd);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
				String username=textUser.getText();
				String password=txtpwd.getText();
				
				try {
					pst =con.prepareStatement("insert into adminlogin(Username,Password)values(?,?)");
					pst.setString(1,username);
					pst.setString(2,password);
					
					pst.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Record added");
				textUser.setText("");
				txtpwd.setText("");
				textUser.requestFocus();
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(148, 203, 108, 25);
		contentPane.add(btnNewButton);
	}
}
