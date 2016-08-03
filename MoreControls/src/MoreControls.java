import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;

public class MoreControls {

	private JFrame frame;
	private JRadioButton rdbtnWhite;
	private JRadioButton rdbtnBrown;
	private JRadioButton rdbtnFried;
	private final ButtonGroup riceGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoreControls window = new MoreControls();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MoreControls() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rdbtnWhite = new JRadioButton("White");
		riceGroup.add(rdbtnWhite);
		rdbtnWhite.setBounds(6, 57, 109, 23);
		frame.getContentPane().add(rdbtnWhite);
		
		rdbtnBrown = new JRadioButton("Brown");
		riceGroup.add(rdbtnBrown);
		rdbtnBrown.setBounds(6, 83, 109, 23);
		frame.getContentPane().add(rdbtnBrown);
		
		rdbtnFried = new JRadioButton("Fried");
		riceGroup.add(rdbtnFried);
		rdbtnFried.setBounds(6, 109, 109, 23);
		frame.getContentPane().add(rdbtnFried);
		
//need to copy his code on Panopto		
//		textArea  = new JTextArea();
//		scrollPane.setViewPortView(textArea);
//		String s = "";
//		scrollPane.setBounds(192,24,206,203);
		
	}
	
	
	
			
}


