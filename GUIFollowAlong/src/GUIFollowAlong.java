// GUIFollowAlong by TedCallow
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIFollowAlong {
	int n;
	 JFrame frame;
	 JFrame frame_1;
	 JFrame frame_1_1;
	 JLabel[] lblA = new JLabel[3];
	 JTextField[] txtA = new JTextField[n];
	 JTextField textField;
	 JTextField txtFofx;
	private JTextField textX;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIFollowAlong window = new GUIFollowAlong();
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
	public GUIFollowAlong() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame frame;
		frame_1_1 = new JFrame();
		frame_1_1.setTitle("GUIFollowAlong by Morgan Hepfer");
		frame_1_1 = frame_1_1;
		frame_1_1.setBounds(100, 100, 650, 450);
		frame_1_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1_1.getContentPane().setLayout(null);
		int ydelta = 25;
		
		for (int i = 0; i<3; i++){
			char letter = (char) (65+i);
			String label = letter + ":";
			lblA[i] = new JLabel(label);
			lblA[i].setHorizontalAlignment(SwingConstants.RIGHT);
			lblA[i].setBounds(10, 60+i *ydelta, 46, 14);
			frame_1.getContentPane().add(lblA[i]);
			
			JLabel lblA = new JLabel(label);

			txtA[i] = new JTextField();
			txtA[i].setBounds(66, 57, 86, 20);
			frame_1_1.getContentPane().add(txtA[i]);
			txtA[i].setColumns(10);

		
		JLabel lblQuadraticAxbxc = new JLabel("Quadratic: f(x) = Ax^2+Bx+C");
		lblQuadraticAxbxc.setBounds(10, 11, 594, 49);
		frame_1_1.getContentPane().add(lblQuadraticAxbxc);
		

		JLabel lblX = new JLabel("X:");
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX.setBounds(280, 60, 46, 14);
		frame_1_1.getContentPane().add(lblX);
		
		textField = new JTextField();
		textField.setBounds(336, 57, 86, 20);
		frame_1_1.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEvaluateFx = new JButton("Evaluate f(x)");
		btnEvaluateFx.addActionListener(new BtnEvaluateFxActionListener());
		btnEvaluateFx.setBounds(311, 88, 111, 23);
		frame_1_1.getContentPane().add(btnEvaluateFx);
		
		txtFofx = new JTextField();
		txtFofx.setBounds(336, 149, 86, 20);
		frame_1_1.getContentPane().add(txtFofx);
		txtFofx.setColumns(10);
		
		JLabel lblFx = new JLabel("F(x)=");
		lblFx.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFx.setBounds(246, 152, 46, 14);
		frame_1_1.getContentPane().add(lblFx);
		txtA[i].setColumns(10);
	}
	}
	
	private double getNumber(JTextField jtf){
		String s= jtf.getText();
		double r=0;
		try{
			 r = Double.parseDouble(s);
		}catch (Exception e){
			System.out.println("by default 0.0");
		}
				return r;
	}
	private double[] getCoefs(){
		double[] ret = new double[3];
		for(int i=0; i<txtA.length;i++){
			ret[i] = getNumber(txtA[i]);
		}
		return ret;
		
	}
	
	private class BtnEvaluateFxActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			txtFofx.setText("hello world");
			
			double[] coefs = getCoefs();
			double x = getNumber(textX);
			double fOfx = coefs[0] *x*x + coefs[1]*x+ coefs[0];
			
			txtFofx.setText(""+fOfx);
		}
	}
}
