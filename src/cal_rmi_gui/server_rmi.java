package cal_rmi_gui;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class server_rmi {
	public static void main(String[] args) {
		try {
			Registry reg = LocateRegistry.createRegistry(1098);
			Calc_Interface_Imp cl = new Calc_Interface_Imp();
			reg.rebind("CalService", cl);
			System.out.println("Server is now ON");
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
