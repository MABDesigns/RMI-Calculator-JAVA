package cal_rmi_gui;

import java.rmi.Remote;

public interface calculator_interface extends Remote {
	
	public int Calculator(int num1, int num2, int optr) throws Exception;
	
}
