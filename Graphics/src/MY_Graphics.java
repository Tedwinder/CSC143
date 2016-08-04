
//Graphics by Ted Callow
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
//import javax.Graphics;

public class MY_Graphics {

	private JFrame frame;
	GPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MY_Graphics window = new MY_Graphics();
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
	public MY_Graphics() {
		
		
		
		initialize();
	}
		
		
		
		
		
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
			
				int wwidth, wheight;
				wwidth = frame.getWidth();
				wheight=frame.getHeight();
				int width, height;
				width=wwidth - (450-309);
				height = wheight - (300-262); 
				System.out.println("width,height= " + width + " , " + height);
				panel.setBounds(60, 20, width, height-40);
				frame.getContentPane().add(panel);
			}
		});
		frame.setBounds(100, 100, 450, 346);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new GPanel();
		int wwidth, wheight;
		wwidth = 450;
		wheight=300;
		System.out.println("width,height: " + wheight);
		int width, height;
		width=wwidth - (450-309);
		System.out.println("width= " + width);
		height = wheight - (300-262); 
		panel.setBounds(93, 26, width, height);
		frame.getContentPane().add(panel);
		
		
	}
	
	private class GPanel extends JPanel {
		public void paint(Graphics g){
			//here is my display list
			//(0,0) will be the upper left
			//(xmax,ymax) will be the lower right
			int xmax,ymax;
			
			
					xmax=panel.getWidth()-1;
					ymax=panel.getHeight()-1;
			g.drawLine(0,0,xmax,ymax);
			g.drawLine(0,ymax , xmax, 0);
			g.drawRect(0, 0, xmax, ymax);
					Color c;
					//c = new Color(0xff8080);
//					c = new Color(255,200,200);
//					g.setColor(c);
//					g.fillOval(60, 20, 50, 50);
//					g.setColor(Color.BLACK);
//					g.drawLine(85,70,85,170);
		}
	
			
		

	
	}

}