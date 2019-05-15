import java.rmi.Naming;

public class TinhClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ITinh obj = (ITinh)Naming.lookup("rmi://localhost/RMITinh");
			int tong = obj.add(5, 6);
			int hieu =obj.sub(10, 5);
			System.out.println("Tong la "+tong+" hieu la "+hieu);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
