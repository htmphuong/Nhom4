package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DangKy extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;
	private Connection conn;//doi tuong ket noi den csdl
	private Statement st;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKy frame = new DangKy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//ham ket noi den csdl
	public void ConnectDB() {
		try {
			//nap driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Connected");
			conn= DriverManager.getConnection("jdbc:sqlserver://DESKTOP-1I94MIJ;databaseName=QLTV;integratedSecurity=true");
			System.out.println("Connected 1");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Loi "+e.getMessage());
		}
	}

	/**
	 * Create the frame.
	 */
	public DangKy() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(40, 53, 153, 33);
		contentPane.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setBounds(167, 53, 203, 33);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(40, 136, 128, 25);
		contentPane.add(lblNewLabel_1);
		
		txtPass = new JTextField();
		txtPass.setBounds(167, 136, 197, 33);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JButton btnThem = new JButton("Th\u00EAm m\u1EDBi");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ConnectDB();
					System.out.println("Hello");
					st = conn.createStatement();
					System.out.println("Insert into Account(UserName,Password) values('"+txtUser.getText()+"','"+txtPass.getText()+"')");
					int n = st.executeUpdate("Insert into Account(UserName,Password) values('"+txtUser.getText()+"','"+txtPass.getText()+"')");
					
					if(n>0) JOptionPane.showConfirmDialog(null, "Success");
					else JOptionPane.showConfirmDialog(null, "Fail");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println(" error"+e.getMessage());
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBounds(166, 186, 128, 33);
		contentPane.add(btnThem);
	}
}
