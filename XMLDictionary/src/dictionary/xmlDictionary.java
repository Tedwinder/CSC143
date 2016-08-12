package dictionary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class xmlDictionary {

	private JFrame frmThePortableOpen;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel;
	private JLabel lbltoAddA ;
	private JButton btnNewEntry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					xmlDictionary window = new xmlDictionary();
					window.frmThePortableOpen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public xmlDictionary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThePortableOpen = new JFrame();
		frmThePortableOpen.setTitle("The Portable Open Source Dictionary by Ted Callow");
		frmThePortableOpen.setBounds(100, 100, 537, 324);
		frmThePortableOpen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmThePortableOpen.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(95, 38, 130, 26);
		frmThePortableOpen.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		
		textArea.setBounds(99, 98, 302, 84);
		frmThePortableOpen.getContentPane().add(textArea);
		
		textArea.setWrapStyleWord(true);
		
		JButton btnLookUp = new JButton("Look Up");
		btnLookUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
    			lbltoAddA.setVisible(false);
    			//btnNewEntry.setVisible(false);
				 Document htmlFile = null;
					
		        try {
			
			        	//URL url = getClass().getResource("XMLDict.xml");
						//File file = new File(url.getPath());
		        	//String docName= "/Users/tedcu76/Documents/gcide-0.51/CIDE.A";
		        	String docName= "XML/XMLDict.html";
						htmlFile = Jsoup.parse(new File(docName), "utf-8");
			           // htmlFile = Jsoup.parse(new File("/Users/tedcu76/Documents/gcide-0.51/CIDE.A"), "utf-8");//path from where you stored the downloaded GCIDE dictionary
			
			        } catch (IOException o) {
			
			            // TODO Auto-generated catch block
			
			            o.printStackTrace();
			
			        }
				
			        Elements all = htmlFile.getElementsByTag("p");
			        boolean there=false;
				
			        for(org.jsoup.nodes.Element element: all){
			        	Elements word = element.getElementsByTag("ent");
			        	if (word!=null){
			        		String ent=word.text();
			        		String r= textField.getText();
			        		if (ent.equalsIgnoreCase(r)){
			        			//System.out.println("record found!");
			        			Elements definition= element.getElementsByTag("def");
			        			String def= definition.text();
			        			textArea.setText(def);
			        			Elements partOfSpeech=element.getElementsByTag("pos");
			        			String pos=partOfSpeech.text();
			        			textField_1.setText(pos);
			        			Elements source=element.getElementsByTag("contributor");
			        			String s=source.text();
			        			textField_2.setText(s);
			        			there=true;
			        			break;
			        		}
			        	}
			        	
			        	
			        	/*System.out.println(r);
			        	if(word.contains(r)){
			        		//textArea.setText(element.getElementsByTag("def").toString());
			        		//textField_1.setText(element.getElementsByTag("pos").toString());
			        		//System.out.println("i");
			        		
			        	}else System.out.println("not found");*/
			        	
			        }
			        if(!there){
	        			
			        	lblNewLabel.setVisible(true);
	        			lbltoAddA.setVisible(true);
	        			btnNewEntry.setVisible(true);
	        			}
				
				
				
				
				
			}
		});
		btnLookUp.setBounds(241, 37, 117, 29);
		frmThePortableOpen.getContentPane().add(btnLookUp);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Document htmlFile = null;
				 boolean there=false;
			        try {
				
				        	//URL url = getClass().getResource("XMLDict.xml");
							//File file = new File(url.getPath());
			        	//String docName= "/Users/tedcu76/Documents/gcide-0.51/CIDE.A";
			        	//InputStream input = getClass().getResourceAsStream("/XMLDict.xml");
			        	String docName= "XML/XMLDict.html";
							htmlFile = Jsoup.parse(new File(docName), "utf-8");
				           // htmlFile = Jsoup.parse(new File("/Users/tedcu76/Documents/gcide-0.51/CIDE.A"), "utf-8");//path from where you stored the downloaded GCIDE dictionary
				
				        } catch (IOException o) {
				
				            // TODO Auto-generated catch block
				
				            o.printStackTrace();
				
				        }
					
				        Elements all = htmlFile.getElementsByTag("p");
				        int goner=0;
				        
				        for(org.jsoup.nodes.Element element: all){
				        	Elements word = element.getElementsByTag("ent");
				        	
				        	if (word!=null){
				        		String ent=word.text();
				        		String r= textField.getText();
				        		if (ent.equalsIgnoreCase(r)){
				        			
				        			//goner=getElementsByIndexEquals(int index)
				        			there=true;
				        			Elements definition= element.getElementsByTag("def");
				        			String def= definition.text();
				        			textArea.setText(def);
				        			Elements partOfSpeech=element.getElementsByTag("pos");
				        			String pos=partOfSpeech.text();
				        			textField_1.setText(pos);
				        			Elements source=element.getElementsByTag("contributor");
				        			String s=source.text();
				        			textField_2.setText(s);
				        			break;
				        			
				        		}
				        		
				        		
				        		}goner++;
				        	
				        	}
				        
				        if(!there){
				        	lblNewLabel.setVisible(true);
		        			lbltoAddA.setVisible(true);
		        			textArea.setText("");
				        	
				        }else if(textField_2.getText().length()==0 ){
				        	JOptionPane.showMessageDialog(null,
				        			"You may not delete records belonging to the original collection" + "\n" +
				        	"You may, however, delete records contributed by other users");
				        }else{
				        	
				        	
				        	int value = JOptionPane.showConfirmDialog(null, 
				        			   "Are you sure you wish to delete?",null, JOptionPane.YES_NO_OPTION);
				        	if (value == JOptionPane.YES_OPTION) {
				        		//System.out.println(goner);
				        		 
				        		String docName= "XML/XMLDict.html";
								
				        		 for(org.jsoup.nodes.Element element: all){
							        	Elements word = element.getElementsByTag("ent");
							        	
							        	if (word!=null){
							        		String ent=word.text();
							        		String r= textField.getText();
							        		if (ent.equalsIgnoreCase(r)){
							        			break;											
							        		} 	
							        	}
				        		 }all.remove(goner);
				        		 try {
										PrintWriter writer = new PrintWriter(docName, "UTF-8");
										for(org.jsoup.nodes.Element element: all){
						        			 writer.println(element);
						        		 }writer.close();
									} catch (FileNotFoundException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									} catch (UnsupportedEncodingException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}
				        		 textField.setText("");
				        		 textArea.setText("");
				        		 textField_1.setText("");
				        		 textField_2.setText("");
				        		 
				        		 		 
				        		 
				        		 
				        	} else if (value == JOptionPane.NO_OPTION) {
				        	   // JOptionPane.setVisible(false);
				        	}
				        }
					
			}
		});
		btnDelete.setBounds(414, 50, 117, 29);
		frmThePortableOpen.getContentPane().add(btnDelete);
		
		btnNewEntry = new JButton("New  Entry");
		btnNewEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Document htmlFile = null;
				 lblNewLabel.setVisible(false);
	    			lbltoAddA.setVisible(false);
	    			//btnNewEntry.setVisible(false);	
			        try {
				
				        	//URL url = getClass().getResource("XMLDict.xml");
							//File file = new File(url.getPath());
			        	//String docName= "/Users/tedcu76/Documents/gcide-0.51/CIDE.A";
			        	String docName= "XML/XMLDict.html";
							htmlFile = Jsoup.parse(new File(docName), "utf-8");
				           // htmlFile = Jsoup.parse(new File("/Users/tedcu76/Documents/gcide-0.51/CIDE.A"), "utf-8");//path from where you stored the downloaded GCIDE dictionary
				
				        } catch (IOException o) {
				
				            // TODO Auto-generated catch block
				
				            o.printStackTrace();
				
				        }
					
				        Elements all = htmlFile.getElementsByTag("p");
				        Boolean there=false;
				        for(org.jsoup.nodes.Element element: all){
				        	Elements word = element.getElementsByTag("ent");
				        	
				        	if (word!=null){
				        		String ent=word.text();
				        		String r= textField.getText();
				        		if (ent.equalsIgnoreCase(r)){
				        			JOptionPane.showMessageDialog(null,
				        			"A matching record already exists." + "\n" +
				        			"You may only add entries for words not already in the primary collection" +"\n"
				        				+"you may also modify an existing definition by clicking \"modify\"");
				        			//lbltoAddA.setText("An entry for this word already exists! You may delete if the word is not part of the core);
				        			
				        		/*	Elements definition= element.getElementsByTag("def");
				        			String def= definition.text();
				        			textArea.setText(def);
				        			Elements partOfSpeech=element.getElementsByTag("pos");
				        			String pos=partOfSpeech.text();
				        			textField_1.setText(pos);
				        			Elements source=element.getElementsByTag("source");
				        			String s=source.text();
				        			textField_2.setText(s);*/
				        		}
				        	}
				        	
				        	
				        	/*System.out.println(r);
				        	if(word.contains(r)){
				        		//textArea.setText(element.getElementsByTag("def").toString());
				        		//textField_1.setText(element.getElementsByTag("pos").toString());
				        		//System.out.println("i");
				        		
				        	}else System.out.println("not found");*/
				        	
				        }
				        if (!there){
				        	
				        	String word= textField.getText();
				        	String def=textArea.getText();
				        	String pos=textField_1.getText();
				        	String source=textField_2.getText();
				        	
				        	
				        	
				        	String XMLString = 
				        			
				        			                 "<p>" + "<ent>" + word + "</ent>" + 
				        			                "<def>" + def + "</def>" +
				        			                	"<pos>" + pos + "</pos>" +
				        			                "<contributor>" + source + "</contributor>" +"</p>";
				        		
				        			
				        			        //Document html = Jsoup.parse(XMLString);
				        			
				        			        //String title = html.title();
				        			
				        			        //String h1 = html.body().getElementsByTag("h1").text();
				        			        if (word.length()==0 || source.length()==0 || def.length()==0){
				        			        	JOptionPane.showMessageDialog(null,
				    				        			"To add to the collection you must fill out "+"\n"
				    				        			+ "both \"Word\", \"Definition\" and \"Contributor\" fields.");
				        			        	
				        			        	
				        			        }else{
				        			        	
				        			        	//String docName="/Users/tedcu76/Documents/gcide-0.51/CIDE.A";//the path to the document you want to create
				        			        	String docName= "XML/XMLDict.html";
				        			      
				        			        	 FileWriter fileWritter;
													try {
														fileWritter = new FileWriter(docName,true);
														BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
														bufferWritter.write(XMLString);
														//FileOutputStream fos = new FileOutputStream(docName);
														//XMLEncoder encoder = new XMLEncoder(fos);
														//encoder.writeObject(html);
														//encoder.close();
														bufferWritter.close();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}
				        			        }
				        			
				        			       // System.out.println("Input HTML String to JSoup :" + html);
				        			
				        			       
				        	
				        }
					
				
			}
		});
		btnNewEntry.setBounds(414, 20, 117, 29);
		frmThePortableOpen.getContentPane().add(btnNewEntry);
		btnNewEntry.setVisible(true);
		
		textField_1 = new JTextField();
		textField_1.setBounds(99, 188, 130, 26);
		frmThePortableOpen.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(99, 215, 130, 26);
		frmThePortableOpen.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblWord = new JLabel("Word:");
		lblWord.setBounds(6, 40, 61, 16);
	frmThePortableOpen.getContentPane().add(lblWord);
		
		JLabel lblDefinition = new JLabel("Definition:");
		lblDefinition.setBounds(5, 96, 70, 16);
		frmThePortableOpen.getContentPane().add(lblDefinition);
		
		JLabel lblPartOfSpeech = new JLabel("Part of Speech:");
		lblPartOfSpeech.setBounds(6, 194, 94, 16);
		frmThePortableOpen.getContentPane().add(lblPartOfSpeech);
		
		JLabel lblContributor = new JLabel("Contributor:");
		lblContributor.setBounds(6, 220, 90, 16);
		frmThePortableOpen.getContentPane().add(lblContributor);
		
		lblNewLabel = new JLabel("No Entry Exists for this Word!" + "\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(93, 69, 306, 26);
		frmThePortableOpen.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		lbltoAddA = new JLabel("To add a new entry fill out the fields and click \"New Entry\".");
		lbltoAddA.setForeground(Color.RED);
		lbltoAddA.setBounds(93, 258, 418, 16);
		frmThePortableOpen.getContentPane().add(lbltoAddA);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//getting the values to add
				String word= textField.getText();
	        	String def=textArea.getText();
	        	String pos=textField_1.getText();
	        	String source=textField_2.getText();
	        	String XMLString = 
	        			
		                 "<p>" + "<ent>" + word + "</ent>" + 
		                "<def>" + def + "</def>" +
		                	"<pos>" + pos + "</pos>" +
		                "<contributor>" + source + "</contributor>" +"</p>";
	        	
	        	 if (word.length()==0 || source.length()==0 || def.length()==0){
			        	JOptionPane.showMessageDialog(null,
			        			"To modify the collection you must fill out "+"\n"
			        			+ "both \"Word\", \"Definition\" and \"Contributor\" fields.");}
	        	
	        	int value = JOptionPane.showConfirmDialog(null, 
	        			   "Are you sure you wish to replace the original entry with the current" + "\n" 
	        	+"contents of the text fields?",null, JOptionPane.YES_NO_OPTION);
	        	if (value == JOptionPane.YES_OPTION) {
	        		//System.out.println(goner);
	        	
	        	
	        	
	        	//deleting the old values
	        	Document htmlFile = null;
				 boolean there=false;
	        	 try {
	 				
			        	//URL url = getClass().getResource("XMLDict.xml");
						//File file = new File(url.getPath());
		        	String docName= "XML/XMLDict.html";
		        	//Strings docName="/Users/tedcu76/Documents/Inserts/experiment";
						htmlFile = Jsoup.parse(new File(docName), "utf-8");
			           // htmlFile = Jsoup.parse(new File("/Users/tedcu76/Documents/gcide-0.51/CIDE.A"), "utf-8");//path from where you stored the downloaded GCIDE dictionary
			
			        } catch (IOException o) {
			
			            // TODO Auto-generated catch block
			
			            o.printStackTrace();
			
			        }
	        	
	        	
	        	Elements all = htmlFile.getElementsByTag("p");
		        int goner=0;
	        	 for(org.jsoup.nodes.Element element: all){
			        	Elements words = element.getElementsByTag("ent");
			        	
			        	if (words!=null){
			        		String ent=words.text();
			        		String r= textField.getText();
			        		if (ent.equalsIgnoreCase(r)){
			        			break;											
			        		}
			        	}goner++; 	
     		 }all.remove(goner);
     		
     		 try {
     			 		String docName= "XML/XMLDict.html";
     			 		PrintWriter writer = new PrintWriter(docName, "UTF-8");
						for(org.jsoup.nodes.Element element: all){
		        			 writer.println(element);
		        		 }writer.close();
		        		 	
		        		 
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (UnsupportedEncodingException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
     		FileWriter fileWritter;
			try {
				String docName= "XML/XMLDict.html";
				fileWritter = new FileWriter(docName,true);
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
				bufferWritter.write(XMLString);
				//FileOutputStream fos = new FileOutputStream(docName);
				//XMLEncoder encoder = new XMLEncoder(fos);
				//encoder.writeObject(html);
				//encoder.close();
				bufferWritter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			}
			}
		});
		btnModify.setBounds(413, 78, 117, 29);
		frmThePortableOpen.getContentPane().add(btnModify);
		lbltoAddA .setVisible(false);
	}
}
