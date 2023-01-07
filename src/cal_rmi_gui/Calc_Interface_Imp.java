package cal_rmi_gui;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
@SuppressWarnings("serial")
public class Calc_Interface_Imp extends UnicastRemoteObject implements calculator_interface{
	
	public Calc_Interface_Imp() throws RemoteException {
		super();
	}
	public int Calculator(int a, int b, int choice) throws Exception{
		int result = 0;
		switch(choice) {
		case 0:
			result = a+b;
			break;
		case 1:
			result = a*b;
			break;
		case 2:
			result = a/b;
			break;
		case 3:
			result = a-b;
			break;
		default:
			System.out.println("Please Select a valid number 1-4");
		}
		return result;
	}
	
}
