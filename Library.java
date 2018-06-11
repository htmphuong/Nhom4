import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Library extends UnicastRemoteObject 
implements LibraryInterface {
	private Connection conn;
	private Statement st;
	public Library() throws RemoteException{
		super();
	}
	//ham connect DB
	public void ConnectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-1I94MIJ;databaseName=QLTV;integratedSecurity=true");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public int ExecSql(String sql) throws RemoteException{
		int n=0;
		try {
			ConnectDB();
			System.out.println("SqlServer started");
			st=conn.createStatement();
			n = st.executeUpdate(sql);
			if(n>0) JOptionPane.showConfirmDialog(null, "OK");
			else JOptionPane.showConfirmDialog(null, "Fail");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return n;
	}
}
