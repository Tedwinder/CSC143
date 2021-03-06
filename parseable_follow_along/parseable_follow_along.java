//Ted Callow "parseable_follow_along"

package parseable_follow_along;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class parseable_follow_along {

	private JFrame pane_in;
	private JTextField txtIn;
	private JTextField txtMyParseable;
	private JTextField txtAgreement;

	
	//parseable follow along by Ted Callow
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					parseable_follow_along window = new parseable_follow_along();
					window.pane_in.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public parseable_follow_along() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pane_in = new JFrame();
		pane_in.setTitle("parseable_follow_along");
		pane_in.setBounds(100, 100, 450, 300);
		pane_in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane_in.getContentPane().setLayout(null);
		
		txtIn = new JTextField();
		txtIn.setBounds(10, 11, 86, 20);
		pane_in.getContentPane().add(txtIn);
		txtIn.setColumns(10);
		
		JButton btnNewButton = new JButton("Test");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String r = txtIn.getText();
				char[] a = r.toCharArray();
				boolean myOpinion = getMyOpinion(r);
				boolean itsOpinion = getItsOpinion(r);
				
				if (myOpinion) {txtMyParseable.setText("It's Parseable");
			
				
			}else {txtMyParseable.setText("It's NOT Parseable");}
			
				if (myOpinion == itsOpinion) {txtAgreement.setText("Agrees");
				
				
				}else {txtAgreement.setText("DOES NOT AGREE");}
					
			}
			
			
			
			
			private boolean getItsOpinion(String r) {
				try{
				double d = Double.parseDouble(r);
				return true;
				}catch (Exception e){
					return false;
				}
			}
			
			
			
			private boolean getMyOpinion(String r){
				
				char[] a = r.toCharArray();
				boolean eOk= true;
				boolean dotOk = true;
				boolean minusOk = true;
				int eCounter = 0;
				int periodCounter=0;
				int minusCounter=0;
				
				for (int i=0; i<a.length; i++){
					char c = a[i];
					if(c=='e' || c=='E'){
						eCounter ++;
						if(i==0||i==(a.length-1) || eCounter>1){eOk=false;}
						
						if(!eOk) return false; 
							minusOk = true;
							
					
					}else if (c=='.'){
						periodCounter++;
						if(periodCounter>1 || eCounter>=1){dotOk=false;}
						if(!dotOk){return false;}
						
					}else if(c=='-'){
						minusCounter++;
						if(minusCounter>2 || !Character.isDigit(a[i+1])){minusOk=false;}
						if(!minusOk){return false;}
						
					}else if (Character.isDigit(c)){
						minusOk= false;
				
					}else{return false;}
				
				}return true;
				
			}
			
			
		});
		
				
			
			
			
		
		
		
		btnNewButton.setBounds(117, 10, 89, 23);
		pane_in.getContentPane().add(btnNewButton);
		
		txtMyParseable = new JTextField();
		txtMyParseable.setEditable(false);
		txtMyParseable.setBounds(10, 62, 287, 20);
		pane_in.getContentPane().add(txtMyParseable);
		txtMyParseable.setColumns(10);
		
		txtAgreement = new JTextField();
		txtAgreement.setBounds(10, 145, 287, 20);
		pane_in.getContentPane().add(txtAgreement);
		txtAgreement.setColumns(10);
	}
}
