package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JTextField code;
	
	final String URL ="jdbc:mysql://localhost:3306";
	final String USER = "root";
	final String PASS = "root";
	final String Driver = "com.mysql.cj.jdbc.Driver";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("SCHOOL MANAGEMENT SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(128, 64, 64));
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(185, 70, 446, 51);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("LOGIN PAGE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(330, 132, 160, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(102, 196, 114, 32);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(102, 272, 114, 32);
		contentPane.add(lblNewLabel_2_1);

		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		user.setBounds(240, 197, 296, 32);
		contentPane.add(user);
		user.setColumns(10);

		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pass.setBounds(240, 273, 296, 32);
		contentPane.add(pass);

		JLabel lblNewLabel_2_1_1 = new JLabel("Forgot Password?");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(43, 385, 211, 32);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_2 = new JLabel("Enter Secret Code:");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_2.setBounds(43, 437, 181, 32);
		contentPane.add(lblNewLabel_2_1_2);

		code = new JTextField();
		code.setBounds(185, 440, 133, 32);
		contentPane.add(code);
		code.setColumns(10);

		JButton btnSub = new JButton("Submit");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String un = user.getText();
				@SuppressWarnings("deprecation")
				String p = pass.getText();

				try {
					Class.forName(Driver);
					Connection con = DriverManager.getConnection(URL, USER, PASS);
					Statement stmt = con.createStatement();
					String sql = "select * from school_management_system.login_page";

					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						String username = rs.getString("username");
						String password = rs.getString("password");

						if(un.equals(username)&& p.equals(password)) {
							new welcome().setVisible(true);
							dispose();

						}
						else
							JOptionPane.showMessageDialog(null, "invalid credentials");
					}
				}catch(Exception exp){
					JOptionPane.showMessageDialog(null, "error while establishing connection");


				}
			}
		});
		btnSub.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSub.setBounds(266, 335, 93, 32);
		contentPane.add(btnSub);

		JButton btnRes = new JButton("Reset");
		btnRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setText("");
				pass.setText("");
			}
		});
		btnRes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRes.setBounds(415, 335, 93, 32);
		contentPane.add(btnRes);

		JLabel lblNewLabel_2_1_3 = new JLabel("");
		lblNewLabel_2_1_3.setIcon(new ImageIcon("C:\\Users\\kunda\\Downloads\\NITHESH (2).png"));
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1_3.setBounds(546, 254, 337, 346);
		contentPane.add(lblNewLabel_2_1_3);

		JButton scCode = new JButton("Submit");
		scCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String secret = code.getText();

				if(secret.equals("admin@123")) {
					JOptionPane.showMessageDialog(scCode, "The username and password is 'nithesh' & 'nithesh'");
				}
				else
					JOptionPane.showMessageDialog(scCode, "Invalid secret Code");

			}
		});
		scCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scCode.setBounds(351, 437, 93, 32);
		contentPane.add(scCode);
	}
}
