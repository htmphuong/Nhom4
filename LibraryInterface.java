import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LibraryInterface extends Remote {
	public int ExecSql(String sql) throws RemoteException;
}
