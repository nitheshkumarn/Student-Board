package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearDelStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable studentTable;
	private JScrollPane scrollPane;
	private JTextField sId;


	final String URL ="jdbc:mysql://localhost:3306";
	final String USER = "root";
	final String PASS = "root";
	final String Driver = "com.mysql.cj.jdbc.Driver";
	private JLabel lblNewLabel_1;
	private JTextField sID;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearDelStudent frame = new SearDelStudent();
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
	public SearDelStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSearchDelete = new JLabel("SEARCH & DELETE STUDENT");
		lblSearchDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchDelete.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSearchDelete.setBounds(285, 21, 381, 57);
		contentPane.add(lblSearchDelete);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 160, 934, 142);
		contentPane.add(scrollPane);

		studentTable = new JTable();
		studentTable.setBackground(new Color(255, 255, 128));
		studentTable.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(studentTable);
		studentTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Student ID", "Student Name", "Father's Name", "Mother's Name", "Phone Number", "Address", "Class", "Section", "Roll Number"
				}
				));

		JButton btnNewButton = new JButton("GET ALL RECORDS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName(Driver);
					Connection con = DriverManager.getConnection(URL, USER, PASS);

					String sql = "SELECT * FROM school_management_system.studentreg";

					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					DefaultTableModel dtm = (DefaultTableModel)studentTable.getModel();
					dtm.setRowCount(0);

					while(rs.next()) {
						Object[] obj = {rs.getInt("sId"),rs.getString("sName"),rs.getString("sFatherName"),rs.getString("sMotherName"),rs.getString("sPhNo"),rs.getString("sAddress"),rs.getInt("sClass"),rs.getString("sSection"),rs.getInt("sRollNo")};
						dtm.addRow(obj);
					}
					con.close();

				}catch(Exception e1) {
					JOptionPane.showInputDialog(null, e1);
				}




			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(64, 0, 128));
		btnNewButton.setBounds(354, 101, 246, 38);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("To Delete, Enter the ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(43, 324, 246, 29);
		contentPane.add(lblNewLabel);

		sId = new JTextField();
		sId.setBounds(43, 361, 74, 38);
		contentPane.add(sId);
		sId.setColumns(10);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = sId.getText();
				int sid = Integer.parseInt(id);



				try {
					Class.forName(Driver);
					Connection con = DriverManager.getConnection(URL, USER, PASS);

					String sql = "Delete from school_management_system.studentreg where sId = '"+sid+"'";

					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.executeUpdate();
					JOptionPane.showInputDialog(null, "Record removed from the Database");

					con.close();
					sId.setText("");

				}catch(Exception e1) {
					JOptionPane.showInputDialog(null, e1);
				}

			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBounds(145, 361, 144, 38);
		contentPane.add(btnDelete);

		lblNewLabel_1 = new JLabel("BACK");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentsModule obj = new StudentsModule();
				obj.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(909, 15, 112, 72);
		contentPane.add(lblNewLabel_1);

		JLabel lblToSearchEnter = new JLabel("To Search, Enter the ID:");
		lblToSearchEnter.setForeground(Color.RED);
		lblToSearchEnter.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblToSearchEnter.setBounds(668, 324, 246, 29);
		contentPane.add(lblToSearchEnter);

		sID = new JTextField();
		sID.setColumns(10);
		sID.setBounds(668, 361, 74, 38);
		contentPane.add(sID);

		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = sID.getText();
				int sid = Integer.parseInt(id);


				try {
					Class.forName(Driver);
					Connection con = DriverManager.getConnection(URL, USER, PASS);

					String sql = "SELECT * FROM school_management_system.studentreg WHERE sId ='"+sid+"'";

					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();


					DefaultTableModel dtm = (DefaultTableModel)studentTable.getModel();
					dtm.setRowCount(0);

					while(rs.next()) {
						Object[] obj = {rs.getInt("sId"),rs.getString("sName"),rs.getString("sFatherName"),rs.getString("sMotherName"),rs.getString("sPhNo"),rs.getString("sAddress"),rs.getInt("sClass"),rs.getString("sSection"),rs.getInt("sRollNo")};
						dtm.addRow(obj);
					}



					con.close();

				}catch(Exception e1) {
					JOptionPane.showInputDialog(null, e1);
				}
			}
		});
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.setBounds(770, 361, 144, 38);
		contentPane.add(btnSearch);
	}
}
