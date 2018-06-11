import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.awt.event.ActionEvent;

public class LibararyClient extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibararyClient frame = new LibararyClient();
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
	public LibararyClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(43, 26, 254, 54);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(43, 105, 254, 45);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LibraryInterface tv = (LibraryInterface)Naming.lookup("rmi://localhost/LibraryObj");
					int n = tv.ExecSql("Insert into Account values('"+txtUser.getText()+"','"+txtPass.getText()+"')");
					if(n>0) JOptionPane.showConfirmDialog(null, "Success");
					else JOptionPane.showConfirmDialog(null, "Fail");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Loi"+e.getMessage());
					e.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(43, 173, 173, 54);
		contentPane.add(btnAdd);
	}
}
