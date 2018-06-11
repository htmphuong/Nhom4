import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class LibraryServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			LocateRegistry.createRegistry(1094);
			Library obj = new  Library();
			Naming.rebind("LibraryObj", obj);
			System.out.println("Library registered");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
