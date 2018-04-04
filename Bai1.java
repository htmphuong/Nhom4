package tinh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bai1 {

	private JFrame frame;
	private JTextField tfSoN;
	private JTextField tfKQ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai1 window = new Bai1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bai1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 692, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNhpVoS = new JLabel("Nh\u1EADp v\u00E0o s\u1ED1 nguy\u00EAn N");
		lblNhpVoS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNhpVoS.setBounds(10, 94, 209, 30);
		frame.getContentPane().add(lblNhpVoS);
		
		tfSoN = new JTextField();
		tfSoN.setBounds(229, 98, 209, 26);
		frame.getContentPane().add(tfSoN);
		tfSoN.setColumns(10);
		
		JLabel lblKtQuc = new JLabel("K\u1EBFt qu\u1EA3 \u0111\u1ECDc s\u1ED1");
		lblKtQuc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKtQuc.setBounds(20, 162, 199, 39);
		frame.getContentPane().add(lblKtQuc);
		
		tfKQ = new JTextField();
		tfKQ.setBounds(229, 162, 209, 78);
		frame.getContentPane().add(tfKQ);
		tfKQ.setColumns(10);
		
		JButton btnKQ = new JButton("K\u1EBFt qu\u1EA3");
		btnKQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int soN= Integer.parseInt(tfSoN.getText());
				int hangdv=soN%10;
				String dv;
				int hangchuc=soN/10;
				String chuc;
				switch(hangdv){
					case 1: dv="một";
							break;
					case 2:dv="hai";
							break;
					default: dv="";
							break;
				}
				switch(hangchuc){
					case 1: chuc="mười";
					break;
					case 2:chuc="hai mươi";
							break;
					default: chuc="";
					break;
				}
				tfKQ.setText(chuc+" "+dv);
			}
		});
		btnKQ.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKQ.setBounds(229, 251, 131, 33);
		frame.getContentPane().add(btnKQ);
	}
}
