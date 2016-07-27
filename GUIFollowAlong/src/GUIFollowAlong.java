import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class GUIFollowAlong {

	private JFrame frmGuifollowalong;
	JTextField txtB;
	JTextField txtA;
	JTextField txtC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIFollowAlong window = new GUIFollowAlong();
					window.frmGuifollowalong.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIFollowAlong() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuifollowalong = new JFrame();
		frmGuifollowalong.getContentPane().setBackground(new Color(127, 255, 212));
		frmGuifollowalong.setTitle("GUIFollowAlong");
		frmGuifollowalong.setBounds(100, 100, 650, 450);//1st 2 is x,y coordinates of location of upper left hand corner
		frmGuifollowalong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuifollowalong.getContentPane().setLayout(null);
		
		JLabel lblQuadraticFormulaIn = new JLabel("Quadratic formula in the form f(x) = ax^2 + bx + c ");
		lblQuadraticFormulaIn.setBounds(129, 86, 290, 14);
		frmGuifollowalong.getContentPane().add(lblQuadraticFormulaIn);
		
		JLabel lblA = new JLabel("a:");
		lblA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblA.setBackground(new Color(176, 224, 230));
		lblA.setBounds(155, 166, 46, 14);
		frmGuifollowalong.getContentPane().add(lblA);
		
		txtA = new JTextField();
		txtA.setBounds(211, 163, 86, 20);
		frmGuifollowalong.getContentPane().add(txtA);
		txtA.setColumns(10);
		
		
		JLabel lblB = new JLabel("b:");
		lblB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblB.setBackground(new Color(176, 224, 230));
		lblB.setBounds(205, 186, 46, 14);
		frmGuifollowalong.getContentPane().add(lblB);
		
		txtB = new JTextField();
		txtB.setBounds(261, 183, 86, 20);
		frmGuifollowalong.getContentPane().add(txtB);
		txtB.setColumns(10);
		
		
		JLabel lblC = new JLabel("c:");
		lblC.setHorizontalAlignment(SwingConstants.RIGHT);
		lblC.setBackground(new Color(176, 224, 230));
		lblC.setBounds(255, 206, 46, 14);
		frmGuifollowalong.getContentPane().add(lblC);
		
		txtC = new JTextField();
		txtC.setBounds(311, 203, 86, 20);
		frmGuifollowalong.getContentPane().add(txtC);
		txtC.setColumns(10);
	}
}
