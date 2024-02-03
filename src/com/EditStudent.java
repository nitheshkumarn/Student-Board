package com;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class EditStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField father;
	private JTextField mother;
	private JTextField phone;
	private JTextField add;
	private JTextField cl;
	private JTextField textField_7;
	private JTextField sec;
	private JTextField roll;

	final String URL ="jdbc:mysql://localhost:3306";
	final String USER = "root";
	final String PASS = "root";
	final String Driver = "com.mysql.cj.jdbc.Driver";
	private JTable studentTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudent frame = new EditStudent();
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
	public EditStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 764);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("UPDATION OF RECORD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(263, 10, 381, 57);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(39, 64, 133, 35);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(39, 120, 133, 35);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Father's Name:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(39, 178, 157, 35);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mother's Name:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(39, 234, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Phone No:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_2.setBounds(39, 296, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_2);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("Class:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_3.setBounds(39, 419, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_3);

		JLabel lblNewLabel_1_1_1_4 = new JLabel("Section:");
		lblNewLabel_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_4.setBounds(39, 481, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_4);

		JLabel lblNewLabel_1_1_1_5 = new JLabel("Roll No:");
		lblNewLabel_1_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_5.setBounds(39, 546, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_5);

		JLabel lblNewLabel_1_1_1_6 = new JLabel("Address:");
		lblNewLabel_1_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_6.setBounds(39, 354, 157, 35);
		contentPane.add(lblNewLabel_1_1_1_6);

		id = new JTextField();
		id.setBounds(230, 67, 265, 35);
		contentPane.add(id);
		id.setColumns(10);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(230, 120, 265, 35);
		contentPane.add(name);

		father = new JTextField();
		father.setColumns(10);
		father.setBounds(230, 178, 265, 35);
		contentPane.add(father);

		mother = new JTextField();
		mother.setColumns(10);
		mother.setBounds(230, 234, 265, 35);
		contentPane.add(mother);

		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(230, 296, 265, 35);
		contentPane.add(phone);

		add = new JTextField();
		add.setColumns(10);
		add.setBounds(230, 354, 265, 35);
		contentPane.add(add);

		cl = new JTextField();
		cl.setColumns(10);
		cl.setBounds(230, 419, 265, 35);
		contentPane.add(cl);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(230, 419, 176, 35);
		contentPane.add(textField_7);

		sec = new JTextField();
		sec.setColumns(10);
		sec.setBounds(230, 481, 265, 35);
		contentPane.add(sec);

		roll = new JTextField();
		roll.setColumns(10);
		roll.setBounds(230, 546, 265, 35);
		contentPane.add(roll);

		JButton submit = new JButton("Update");
		submit.setBackground(new Color(0, 255, 0));
		submit.setForeground(new Color(0, 0, 0));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ID = id.getText();
				int sId = Integer.parseInt(ID);
				String sName = name.getText();
				String sFather = father.getText();
				String sMother = mother.getText();
				String sPhone = phone.getText();
				String sAdd = add.getText();
				String Cl = cl.getText();
				int sClass = Integer.parseInt(Cl);
				String sSec = sec.getText();
				String Roll = roll.getText();
				int sRoll = Integer.parseInt(Roll);

				try {
					Class.forName(Driver);
					Connection con = DriverManager.getConnection(URL, USER, PASS);

					String sql = "UPDATE school_management_system.studentreg SET sName = '"+sName+"',sFatherName = '"+sFather+"', sMotherName = '"+sMother+"', sPhNo = '"+sPhone+"', sAddress = '"+sAdd+"', sClass = '"+sClass+"',sSection = '"+sSec+"', sRollNo = '"+sRoll+"'"+" WHERE sId = '"+sId+"'";  
					

					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.executeUpdate();
					JOptionPane.showConfirmDialog(null, "Student Record Updated");
					con.close();

				}catch(Exception e1) {
					JOptionPane.showInputDialog(null, e1);
				}
			}
		});
		submit.setFont(new Font("Tahoma", Font.BOLD, 19));
		submit.setBounds(168, 622, 157, 47);
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
		lblNewLabel_2.setBounds(843, 10, 112, 72);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("STUDENTS RECORDS");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(617, 121, 210, 35);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(570, 166, 323, 429);
		contentPane.add(scrollPane);
		
		studentTable = new JTable();
		studentTable.setForeground(new Color(255, 0, 0));
		studentTable.setBackground(new Color(255, 255, 128));
		studentTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Student Id", "Student Name"
			}
		));
		scrollPane.setViewportView(studentTable);
		
		JButton btnNewButton = new JButton("Get Records");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName(Driver);
					Connection con = DriverManager.getConnection(URL, USER, PASS);

					String sql = "SELECT sId,sName FROM school_management_system.studentreg";

					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					DefaultTableModel dtm = (DefaultTableModel)studentTable.getModel();
					dtm.setRowCount(0);

					while(rs.next()) {
						Object[] obj = {rs.getInt("sId"),rs.getString("sName")};
						dtm.addRow(obj);
					}
					con.close();

				}catch(Exception e1) {
					JOptionPane.showInputDialog(null, e1);
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(651, 614, 157, 35);
		contentPane.add(btnNewButton);

	}
}
