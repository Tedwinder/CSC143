import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GUIFollowAlong {

	private JFrame frmGuifollowalongByTed;
	JLabel lblQuadraticsOfThe;
	int n = 3;
	JLabel[] lblA = new JLabel[n];
	JTextField[] txtA = new JTextField[n];
	JLabel lblX;
	JTextField textX;
	JButton btnEvalFofX;
	JTextField txtFofX;
	JLabel lblFx;
	JComboBox comboBox;
	private JTextField txtComboRead;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIFollowAlong window = new GUIFollowAlong();
					window.frmGuifollowalongByTed.setVisible(true);
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
		frmGuifollowalongByTed = new JFrame();
		frmGuifollowalongByTed.setTitle("GUIFollowAlong by Ted");
		frmGuifollowalongByTed.setBounds(100, 100, 650, 450);
		frmGuifollowalongByTed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuifollowalongByTed.getContentPane().setLayout(null);

		lblQuadraticsOfThe = new JLabel("Quadratics of the form f(x) = Ax^2 +Bx + C ");
		lblQuadraticsOfThe.setBounds(10, 11, 603, 38);
		frmGuifollowalongByTed.getContentPane().add(lblQuadraticsOfThe);
		
		lblX = new JLabel("X:");
		lblX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblX.setBounds(298, 84, 46, 14);
		frmGuifollowalongByTed.getContentPane().add(lblX);
		
		textX = new JTextField();
		textX.setBounds(362, 81, 86, 20);
		frmGuifollowalongByTed.getContentPane().add(textX);
		textX.setColumns(10);
		
		btnEvalFofX = new JButton("Evaluate f(x)");
		btnEvalFofX.addActionListener(new BtnEvalFofXActionListener());
		btnEvalFofX.setBounds(326, 109, 122, 23);
		frmGuifollowalongByTed.getContentPane().add(btnEvalFofX);
		
		txtFofX = new JTextField();
		txtFofX.setFont(new Font("Tahoma", Font.PLAIN,18));
		txtFofX.setEditable(false);
		txtFofX.setBounds(362, 143, 86, 20);
		txtFofX.setBounds(362,143,86,32);
		Rectangle bb= txtFofX.getBounds();
		//bb. //can set or get. . . 
		
		frmGuifollowalongByTed.getContentPane().add(txtFofX);
		txtFofX.setColumns(10);
		
		lblFx = new JLabel("f(x) =");
		lblFx.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFx.setBounds(306, 146, 46, 14);
		frmGuifollowalongByTed.getContentPane().add(lblFx);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {//will act without button - i.e. if the choice is changed. . . 
				String s=(String) comboBox.getSelectedItem();
				txtComboRead.setText("It was" + s);
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"dog", "cat", "mouse", "koala", "wombat"}));//can enter another choice if editable is set to "True"
		comboBox.setBounds(165, 249, 143, 54);
		frmGuifollowalongByTed.getContentPane().add(comboBox);
		
		
		JButton btnNewButton = new JButton("pet chooser");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=(String) comboBox.getSelectedItem();
				txtComboRead.setText("It was" + s);
				
				
			}
		});
		btnNewButton.setBounds(359, 265, 89, 23);
		frmGuifollowalongByTed.getContentPane().add(btnNewButton);
		
		txtComboRead = new JTextField();
		txtComboRead.setText("pet display");
		txtComboRead.setBounds(222, 355, 86, 20);
		frmGuifollowalongByTed.getContentPane().add(txtComboRead);
		txtComboRead.setColumns(10);
		
		JCheckBox checkbxIsItChecked = new JCheckBox("New check box");
		checkbxIsItChecked.setBounds(23, 276, 122, 23);
		frmGuifollowalongByTed.getContentPane().add(checkbxIsItChecked);
		
		JButton txtButtonStatus = new JButton("checked?");
		txtButtonStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String s = checkbxIsItChecked.isSelected() ? "was checked": "was not checked";
			txtButtonStatus.setText(s);
			}
		});
		txtButtonStatus.setBounds(33, 306, 89, 23);
		frmGuifollowalongByTed.getContentPane().add(txtButtonStatus);
		int ydelta = 30;

		for (int i=0; i<lblA.length; i++ ) {
			char letter = (char)(65+i);
			String label = letter + ":";
			lblA[i] = new JLabel(label);
			lblA[i].setHorizontalAlignment(SwingConstants.RIGHT);
			lblA[i].setBounds(10, 59+i*ydelta, 40, 14);
			frmGuifollowalongByTed.getContentPane().add(lblA[i]);

			txtA[i] = new JTextField();
			txtA[i].setBounds(60, 56+i*ydelta, 86, 20);
			frmGuifollowalongByTed.getContentPane().add(txtA[i]);
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
			double a, b, c, x;
			a = getVal(txtA[0]);
			b = getVal(txtA[1]);
			c = getVal(txtA[2]);
			x = getVal(textX);
			double y = a*x*x + b*x + c;
			txtFofX.setText(""+y);
			
			
//			double [] coefs =getCoefs();
//			double x = getNumber(textX);
//			double fOfX = coefs[0]*x*x + coefs[1]*x+ coefs[2];
//			txtFofX.setText(""+fOfX);
		}
		
		private double getVal(JTextField j){
			double r=0;
			try{
				r=Double.parseDouble(j.getText());
				
			}catch(Exception e){
				j.setText("0.0");
			}return r;
		}
	}
}
