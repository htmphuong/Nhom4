package FileDemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class ReadSwing {

	private JFrame frame;
	private FileWriter fw=null;
	private JFileChooser fc=null;
	private FileReader fr=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadSwing window = new ReadSwing();
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
	public ReadSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea taSave = new JTextArea();
		taSave.setBounds(62, 11, 325, 176);
		frame.getContentPane().add(taSave);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String s= taSave.getText();
					fw = new FileWriter("D:\\java\\test.txt");
					fw.write(s);
					fw.flush();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				finally {
					try {
						fw.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btnSave.setBounds(112, 198, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JButton btnSaveAs = new JButton("Save as");
		btnSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					fc = new JFileChooser();
					fc.setCurrentDirectory(new File("D:\\java"));
					//int showSaveDialog(Component parent) Hiển thị một hộp thoại "Save File"
					int retrival = fc.showOpenDialog(null);
					if(retrival==JFileChooser.APPROVE_OPTION) {
						fw= new FileWriter(fc.getSelectedFile()+".txt");
						fw.write(taSave.getText());
						fw.flush();
						System.out.println("Save as file: " + fc.getSelectedFile().getAbsolutePath());
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				finally {
					try {
						fw.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btnSaveAs.setBounds(213, 198, 106, 23);
		frame.getContentPane().add(btnSaveAs);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					fc = new JFileChooser();
					fc.setCurrentDirectory(new File("D:\\java"));
					int re =fc.showOpenDialog(null);
					if(re==JFileChooser.APPROVE_OPTION) {
						fr= new FileReader(fc.getSelectedFile());
						BufferedReader br = new BufferedReader(fr);
						String s;
						while((s=br.readLine())!=null) {
							taSave.append(s);
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}finally {
					try {
						fw.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btnOpen.setBounds(112, 227, 89, 23);
		frame.getContentPane().add(btnOpen);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNew.setBounds(213, 232, 106, 18);
		frame.getContentPane().add(btnNew);
	}
}
