import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TinhServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TinhImpl objTinh= new TinhImpl();
			//dang ky
			LocateRegistry.createRegistry(1099);
			Naming.rebind("RMITinh", objTinh);
			System.out.println("Binding success");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
