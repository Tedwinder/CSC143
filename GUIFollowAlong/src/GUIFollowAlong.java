import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIFollowAlong {

	private JFrame frmGuifollowalongByDave;
	JLabel lblQuadraticsOfThe;
	int n = 3;
	JLabel[] lblA = new JLabel[n];
	JTextField[] txtA = new JTextField[n];
	JLabel lblX;
	JTextField textX;
	JButton btnEvalFofX;
	JTextField txtFofX;
	JLabel lblFx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIFollowAlong window = new GUIFollowAlong();
					window.frmGuifollowalongByDave.setVisible(true);
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
		frmGuifollowalongByDave = new JFrame();
		frmGuifollowalongByDave.setTitle("GUIFollowAlong by Dave");
		frmGuifollowalongByDave.setBounds(100, 100, 650, 450);
		frmGuifollowalongByDave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuifollowalongByDave.getContentPane().setLayout(null);

		lblQuadraticsOfThe = new JLabel("Quadratics of the form f(x) = Ax^2 +Bx + C ");
		lblQuadraticsOfThe.setBounds(10, 11, 603, 38);
		frmGuifollowalongByDave.getContentPane().add(lblQuadraticsOfThe);
		
		lblX = new JLabel("X:");
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX.setBounds(298, 84, 46, 14);
		frmGuifollowalongByDave.getContentPane().add(lblX);
		
		textX = new JTextField();
		textX.setBounds(362, 81, 86, 20);
		frmGuifollowalongByDave.getContentPane().add(textX);
		textX.setColumns(10);
		
		btnEvalFofX = new JButton("Evaluate f(x)");
		btnEvalFofX.addActionListener(new BtnEvalFofXActionListener());
		btnEvalFofX.setBounds(326, 109, 122, 23);
		frmGuifollowalongByDave.getContentPane().add(btnEvalFofX);
		
		txtFofX = new JTextField();
		txtFofX.setEditable(false);
		txtFofX.setBounds(362, 143, 86, 20);
		frmGuifollowalongByDave.getContentPane().add(txtFofX);
		txtFofX.setColumns(10);
		
		lblFx = new JLabel("f(x) =");
		lblFx.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFx.setBounds(306, 146, 46, 14);
		frmGuifollowalongByDave.getContentPane().add(lblFx);
		int ydelta = 30;

		for (int i=0; i<lblA.length; i++ ) {
			char letter = (char)(65+i);
			String label = letter + ":";
			lblA[i] = new JLabel(label);
			lblA[i].setHorizontalAlignment(SwingConstants.RIGHT);
			lblA[i].setBounds(10, 59+i*ydelta, 40, 14);
			frmGuifollowalongByDave.getContentPane().add(lblA[i]);

			txtA[i] = new JTextField();
			txtA[i].setBounds(60, 56+i*ydelta, 86, 20);
			frmGuifollowalongByDave.getContentPane().add(txtA[i]);
			txtA[i].setColumns(10);
		}

	}
	private double[] getCoefs() {
		double[] ret = new double[3];
		for (int i=0; i<txtA.length; i++) {
			ret[i] = getNumber(txtA[i]);
		}
		return ret;
	}
	private double getNumber(JTextField jtf) {
		String s = jtf.getText();
		double r = 0.0;
		try {
			r = Double.parseDouble(s);
		} catch (Exception e) {
			jtf.setText(s + " 0.0 by default.");
		}
		return r;
	}
	private class BtnEvalFofXActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double [] coefs =getCoefs();
			double x = getNumber(textX);
			double fOfX = coefs[0]*x*x + coefs[1]*x+ coefs[2];
			txtFofX.setText(""+fOfX);
		}
	}
}
