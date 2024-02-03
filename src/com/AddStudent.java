package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField father;
	private JTextField mother;
	private JTextField phone;
	private JTextField add;
	private JTextField cl;
	private JTextField sec;
	private JTextField roll;

	final String URL ="jdbc:mysql://localhost:3306";
	final String USER = "root";
	final String PASS = "root";
	final String Driver = "com.mysql.cj.jdbc.Driver";
	private JTextField addId;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("STUDENT'S REGISTRATION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(41, 0, 381, 57);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(26, 65, 133, 35);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Father's Name:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(26, 123, 157, 35);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mother's Name:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(26, 179, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Phone No:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_2.setBounds(26, 241, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_2);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("Class:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_3.setBounds(26, 364, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_3);

		JLabel lblNewLabel_1_1_1_4 = new JLabel("Section:");
		lblNewLabel_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_4.setBounds(26, 426, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_4);

		JLabel lblNewLabel_1_1_1_5 = new JLabel("Roll No:");
		lblNewLabel_1_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_5.setBounds(26, 491, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_5);

		JLabel lblNewLabel_1_1_1_6 = new JLabel("Address:");
		lblNewLabel_1_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_6.setBounds(26, 299, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_6);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(217, 65, 265, 35);
		contentPane.add(name);

		father = new JTextField();
		father.setColumns(10);
		father.setBounds(217, 123, 265, 35);
		contentPane.add(father);

		mother = new JTextField();
		mother.setColumns(10);
		mother.setBounds(217, 179, 265, 35);
		contentPane.add(mother);

		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(217, 241, 265, 35);
		contentPane.add(phone);

		add = new JTextField();
		add.setColumns(10);
		add.setBounds(217, 299, 265, 35);
		contentPane.add(add);

		cl = new JTextField();
		cl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cl.setColumns(10);
		cl.setBounds(217, 364, 265, 35);
		contentPane.add(cl);

		sec = new JTextField();
		sec.setColumns(10);
		sec.setBounds(217, 426, 265, 35);
		contentPane.add(sec);

		roll = new JTextField();
		roll.setToolTipText("");
		roll.setColumns(10);
		roll.setBounds(217, 491, 265, 35);
		contentPane.add(roll);

		JButton submit = new JButton("Submit");
		submit.setBackground(new Color(0, 255, 0));
		submit.setForeground(new Color(0, 0, 0));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long generatedId;
				try {
					Class.forName(Driver);
					Connection con = DriverManager.getConnection(URL, USER, PASS);

					String sql = "INSERT INTO school_management_system.studentreg (sName, sFatherName, sMotherName, sPhNo, sAddress, sClass, sSection, sRollNo) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

					try (PreparedStatement pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

						pstmt.setString(1, name.getText());
						pstmt.setString(2, father.getText());
						pstmt.setString(3, mother.getText());
						pstmt.setString(4, phone.getText());
						pstmt.setString(5, add.getText());
						pstmt.setInt(6, Integer.parseInt(cl.getText()));
						pstmt.setInt(8, Integer.parseInt(roll.getText()));
						pstmt.setString(7, sec.getText());

						int affectedRows = pstmt.executeUpdate();

						if (affectedRows > 0) {
							// Retrieve the auto-generated ID
							try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
								if (generatedKeys.next()) {
									generatedId = generatedKeys.getLong(1);
									addId.setText(String.valueOf(generatedId));
								}
							}
						}


					}catch(Exception e2) {
						JOptionPane.showInputDialog(null, e2);
					}

					con.close();

				}catch(Exception e1) {
					JOptionPane.showInputDialog(null, e1);
				}
			}
		});
		submit.setFont(new Font("Tahoma", Font.BOLD, 19));
		submit.setBounds(280, 548, 157, 47);
		contentPane.add(submit);

		JLabel lblNewLabel_2 = new JLabel("BACK");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentsModule obj = new StudentsModule();
				obj.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(745, 10, 112, 72);
		contentPane.add(lblNewLabel_2);

		addId = new JTextField();
		addId.setFont(new Font("Tahoma", Font.BOLD, 20));
		addId.setHorizontalAlignment(SwingConstants.CENTER);
		addId.setBounds(583, 136, 157, 78);
		contentPane.add(addId);
		addId.setColumns(10);

		lblNewLabel_1 = new JLabel("Addmission ID Generated");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(542, 96, 226, 35);
		contentPane.add(lblNewLabel_1);
	}
}
