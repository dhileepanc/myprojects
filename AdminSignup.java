import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;



public class AdminSignup extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFname;
	private JTextField textFatherName;
	private JTextField textAge;
	private JTextField textEmail;
	
	private JTextField textMob;
	private JPasswordField crpwd;
	private JPasswordField repwd;
	private JFrame frame;
	private String gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSignup frame = new AdminSignup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con;
	PreparedStatement pst;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
con =DriverManager.getConnection("jdbc:mysql://localhost:3306/localschool", "root","");

		}
		catch(ClassNotFoundException ea){
			Logger.getLogger(AdminSignup.class.getName()).log(Level.SEVERE,null,ea);
		}
		catch(SQLException ex)
		{
			Logger.getLogger(AdminSignup.class.getName()).log(Level.SEVERE,null,ex);	
		}
	}

	/**
	 * Create the frame.
	 */
	public AdminSignup() {
		
		setTitle("AdminSignup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lblNewLabel = new JLabel("SIGNUP");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setFont(new Font("Adobe Myungjo Std M", Font.BOLD, 26));
		lblNewLabel.setBounds(251, 10, 178, 75);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FULL NAME");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(63, 78, 130, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("FATHER'S NAME");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(63, 117, 166, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("AGE");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(63, 156, 130, 29);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("GENDER");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(63, 195, 130, 29);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("DOB");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_3.setBounds(63, 232, 130, 29);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("EMAIL");
		lblNewLabel_1_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_4.setBounds(63, 271, 130, 29);
		contentPane.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_4_1 = new JLabel("MOBILE NUMBER");
		lblNewLabel_1_1_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_4_1.setBounds(63, 315, 166, 29);
		contentPane.add(lblNewLabel_1_1_4_1);
		
		JLabel lblNewLabel_1_1_4_2 = new JLabel("CREATE PASSWORD");
		lblNewLabel_1_1_4_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_4_2.setBounds(63, 354, 203, 29);
		contentPane.add(lblNewLabel_1_1_4_2);
		
		JLabel lblNewLabel_1_1_4_2_1 = new JLabel("RE-ENTER PASSWORD");
		lblNewLabel_1_1_4_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_4_2_1.setBounds(63, 392, 217, 29);
		contentPane.add(lblNewLabel_1_1_4_2_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="male";
			}
		});
		rdbtnNewRadioButton.setBounds(417, 201, 70, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="female";
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(489, 201, 88, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		textFname = new JTextField();
		textFname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFname.setBounds(417, 85, 203, 22);
		contentPane.add(textFname);
		textFname.setColumns(10);
		
		textFatherName = new JTextField();
		textFatherName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textFatherName.setColumns(10);
		textFatherName.setBounds(417, 124, 203, 22);
		contentPane.add(textFatherName);
		
		textAge = new JTextField();
		textAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textAge.setColumns(10);
		textAge.setBounds(417, 163, 203, 22);
		contentPane.add(textAge);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textEmail.setColumns(10);
		textEmail.setBounds(417, 278, 203, 22);
		contentPane.add(textEmail);
		
		textMob = new JTextField();
		textMob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textMob.setColumns(10);
		textMob.setBounds(417, 322, 203, 22);
		contentPane.add(textMob);
		
		JDateChooser dob = new JDateChooser();
		dob.setBounds(417, 232, 203, 19);
		contentPane.add(dob);
		
		crpwd = new JPasswordField();
		crpwd.setBounds(417, 361, 203, 19);
		contentPane.add(crpwd);
		
		repwd = new JPasswordField();
		repwd.setBounds(417, 399, 203, 19);
		contentPane.add(repwd);
		
	
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				connect();
				String fullname,fathername,age,Dob,email,Mob,Crpwd,Repwd;
			
				fathername=textFatherName.getText();
				fullname=textFname.getText();
				age=textAge.getText();
				Mob=textMob.getText();
				gender=rdbtnNewRadioButton.getText();
				gender=rdbtnNewRadioButton_1.getText();
				email=textEmail.getText();
				Crpwd=crpwd.getText();
				Repwd=repwd.getText();
				try {
					pst =con.prepareStatement("insert into adminsignup(Fullname,Fathername,age,gender,date,Email,mob,Crpwd,Repwd)values(?,?,?,?,?,?,?,?,?)");
					pst.setString(1,fullname);
					pst.setString(2,fathername);
					pst.setString(3,age);
				   pst.setString(4,gender);
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(dob.getDate());
					pst.setString(5,date);
					pst.setString(6,email);
					pst.setString(7,Mob);
					pst.setString(8,Crpwd);
					pst.setString(9,Repwd);
					pst.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Record added");
				textFatherName.setText("");
				textFname.setText("");
				textAge.setText("");
				
				textMob.setText("");
				
				textFatherName.requestFocus();
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		btnNewButton.setBounds(251, 438, 166, 29);
		contentPane.add(btnNewButton);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
	}
}
