package cal_rmi_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


@SuppressWarnings("serial")
public class client_rmi extends JFrame {
    static calculator_interface calculator;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	JComboBox<String> choose;
	
	
	
	
	 public client_rmi() {
	    	initComponents();
	    }

	private void initComponents() {
  	  String[] jcomp4Items = {"Add", "Mult", "Sub", "Div"};
  	  
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 367, 520);
	contentPane = new JPanel();
	contentPane.setBackground(Color.DARK_GRAY);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.DARK_GRAY);
	panel.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Client Side", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Client Side", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
	panel.setBounds(29, 11, 289, 207);
	contentPane.add(panel);
	panel.setLayout(null);
	
	textField = new JTextField();
	textField.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
	textField.setBackground(new Color(255, 255, 255));
	textField.setBounds(10, 50, 269, 51);
	panel.add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
	textField_1.setBounds(10, 130, 269, 51);
	panel.add(textField_1);
	textField_1.setColumns(10);
	
	JLabel lblNewLabel = new JLabel("First Value : ");
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
	lblNewLabel.setBounds(10, 20, 113, 26);
	panel.add(lblNewLabel);
	
	JLabel lblSecondValue = new JLabel("Second  Value : ");
	lblSecondValue.setForeground(Color.WHITE);
	lblSecondValue.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
	lblSecondValue.setBounds(10, 105, 150, 26);
	panel.add(lblSecondValue);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBackground(Color.DARK_GRAY);
	panel_1.setBorder(new TitledBorder(null, "Server Result", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
	panel_1.setBounds(29, 256, 289, 164);
	contentPane.add(panel_1);
	panel_1.setLayout(null);
	
	JTextPane textPane = new JTextPane();
	textPane.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
	textPane.setBounds(10, 22, 269, 131);
	panel_1.add(textPane);
	
	JButton resulta = new JButton("Calculate !");
	resulta.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
	resulta.setForeground(new Color(0, 0, 0));
	resulta.setBackground(new Color(0, 255, 128));
	resulta.setBounds(173, 225, 145, 29);
	contentPane.add(resulta);
	
	JButton clear = new JButton("X");
	clear.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
	clear.setForeground(new Color(255, 255, 255));
	clear.setBackground(new Color(255, 0, 0));
	clear.setBounds(110, 225, 50, 29);
	contentPane.add(clear);
	clear.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	    	
	    	try {
	    		textPane.setText("");
	    		
	    	} catch(Exception e1) {
	    		System.out.println(e1);
	    	}
		}
	});	
	
	
	
	choose = new JComboBox<>(jcomp4Items);
	choose.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 18));
	choose.setBounds(35, 225, 60, 29);
	contentPane.add(choose);
	resulta.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int num1, num2, optr, result;
	    	
	    	try {
	    		Registry regs = LocateRegistry.getRegistry("127.0.0.1", 1098);
	    		calculator = (calculator_interface) regs.lookup("CalService");
	    		
	    		num1 = Integer.parseInt(textField.getText());
	    		num2 = Integer.parseInt(textField_1.getText());
	    		optr = choose.getSelectedIndex();
	    		
	    		
	    		result = calculator.Calculator(num1, num2, optr);
	    		textPane.setText(textPane.getText()+"\nResult is : "+ result);
	    		
	    	} catch(Exception e1) {
	    		System.out.println(e1);
	    	}
		}
	});	
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client_rmi frame = new client_rmi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
