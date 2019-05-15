import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TinhImpl extends UnicastRemoteObject implements ITinh
{
	public TinhImpl() throws RemoteException{
		
	}
	public int add(int a,int b) throws RemoteException{
		return a+b;
	}
	public int sub(int a,int b) throws RemoteException{
		return a-b;
	}
}
