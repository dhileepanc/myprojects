import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class studentdetails extends JFrame {

	private JPanel contentPane;
	private JTextField textid;
	private JTextField textSname;
	private JTextField textAge;
	private JTextField textAddress;
	private JTextField textmobnum;
	private String gender;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentdetails frame = new studentdetails();
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
			Logger.getLogger(studentdetails.class.getName()).log(Level.SEVERE,null,ea);
		}
		catch(SQLException ex)
		{
			Logger.getLogger(studentdetails.class.getName()).log(Level.SEVERE,null,ex);	
		}
	}

	/**
	 * Create the frame.
	 */
	public studentdetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(170, 42, 109, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentName = new JLabel("Student name");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStudentName.setBounds(170, 88, 128, 23);
		contentPane.add(lblStudentName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAge.setBounds(170, 135, 128, 23);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(170, 262, 128, 23);
		contentPane.add(lblGender);
		
		JLabel lblMobNum = new JLabel("Mob num");
		lblMobNum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobNum.setBounds(170, 297, 128, 23);
		contentPane.add(lblMobNum);
		
		textid = new JTextField();
		textid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textid.setColumns(10);
		textid.setBounds(440, 47, 109, 19);
		contentPane.add(textid);
		
		textSname = new JTextField();
		textSname.setColumns(10);
		textSname.setBounds(440, 93, 109, 19);
		contentPane.add(textSname);
		
		textAge = new JTextField();
		textAge.setColumns(10);
		textAge.setBounds(440, 140, 109, 19);
		contentPane.add(textAge);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(440, 233, 109, 19);
		contentPane.add(textAddress);
		
		textmobnum = new JTextField();
		textmobnum.setColumns(10);
		textmobnum.setBounds(440, 302, 109, 19);
		contentPane.add(textmobnum);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(170, 228, 128, 23);
		contentPane.add(lblAddress);
		
		JRadioButton rdbtnmale = new JRadioButton("Male");
		rdbtnmale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="male";
			}
		});
		buttonGroup.add(rdbtnmale);
		rdbtnmale.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnmale.setBounds(440, 266, 65, 21);
		contentPane.add(rdbtnmale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="female";
			}
		});
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnFemale.setBounds(507, 265, 91, 21);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender="others";
			}
		});
		buttonGroup.add(rdbtnOthers);
		rdbtnOthers.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rdbtnOthers.setBounds(601, 266, 103, 21);
		contentPane.add(rdbtnOthers);
		
		JDateChooser dates = new JDateChooser();
		dates.setBounds(440, 186, 109, 19);
		contentPane.add(dates);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateOfBirth.setBounds(170, 186, 128, 23);
		contentPane.add(lblDateOfBirth);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();
				String id,name,age,address,Mob,Dob;
				id=textid.getText();
				name=textSname.getText();
				age=textAge.getText();
				address=textAddress.getText();
				Mob=textmobnum.getText();
				try {
					pst =con.prepareStatement("insert into studentdetails(id,name,age,dob,address,gender,Mob)values(?,?,?,?,?,?,?)");
					pst.setString(1,id);
					pst.setString(2,name);
					pst.setString(3,age);
			
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
						String date = sdf.format(dates.getDate());
						pst.setString(4,date);
					pst.setString(5,address);
					if (rdbtnmale.isSelected())
					{
						gender="Male";
					}
					else if(rdbtnFemale.isSelected())
					{
						gender="female";
					}
					else {
						gender="others";
					}
					pst.setString(6,gender);
					pst.setString(7,Mob);
					pst.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Record added");
				textid.setText("");
				textAddress.setText("");
				textAge.setText("");
				
				textmobnum.setText("");
				textSname.setText("");
				textid.requestFocus();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton.setBounds(321, 337, 85, 21);
		contentPane.add(btnNewButton);
		
		
	}
}
