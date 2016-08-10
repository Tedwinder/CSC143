
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;




public class ReadXMLFile {
	
	
	
		    public static void main(String args[]) throws IOException {
		
		  
		  
		
		        // JSoup Example 3 - Parsing an HTML file in Java
		
		        //Document htmlFile = Jsoup.parse("login.html", "ISO-8859-1"); // wrong
		
		        Document htmlFile = null;
		
		        try {
		
		            htmlFile = Jsoup.parse(new File("/Users/tedcu76/Documents/gcide-0.51/CIDE.A"), "utf-8");//path from where you stored the downloaded GCIDE dictionary
		
		        } catch (IOException e) {
		
		            // TODO Auto-generated catch block
		
		            e.printStackTrace();
		
		        } // right
		
		       // title = htmlFile.title();
	      
		        Elements all = htmlFile.getElementsByTag("p");
		
		        //String cssClass = div.className(); // getting class form HTML element
	
		
		        System.out.println("This program uses Jsoup to parse GCIDE open source Dictionary and create SQLite Insert Statements");
		        //PrintWriter writer = new PrintWriter("/Users/tedcu76/Documents/Inserts/Inserts.txt", "UTF-8");
		        PrintWriter writer = new PrintWriter("/Users/tedcu76/Documents/Inserts.txt", "UTF-8");
		        //System.out.println("title : " + title);
		        int i=0;
		        for(org.jsoup.nodes.Element element: all){
		        	
		        	Elements definition = element.getElementsByTag("def");
		        	Elements word = element.getElementsByTag("ent");
		        	Elements pronunciation = element.getElementsByTag("pr");
		        	if (!(word.isEmpty())){
		        		String w=word.text();
		        		w=w.replace('"', '\"');
		        		w=w.replace("'", "\'");
		        		String d=definition.text();
		        		d=d.replace('"', '\"');
		        		d=d.replace("'", "\'");
		        		String p=pronunciation.text();
		        		p=p.replace('"', '\"');
		        		p=p.replace("'", "\'");
		        	writer.println("db.execSQL(\"INSERT INTO word VALUES (" + i + ", '" 
		        			+ w + "',  '" + d + 
		        			"', " + p + "')\");" + "\n");i++;}
		        	//db.execSQL("INSERT INTO word VALUES (0, 'thingy', 'some sort of thingy', 'etc.')");
		        	
		        }System.out.println("A");
		        
		        //append to existing doc
		        String docName="/Users/tedcu76/Documents/Inserts.txt";//the path to the document you want to create
		        FileWriter fileWritter = new FileWriter(docName,true);
		        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		        for(char alphabet = 'B'; alphabet <= 'Z';alphabet++) {
		        	System.out.println(alphabet);
		        	int j=0;
		        	//String docName="/Users/tedcu76/Documents/Inserts/"+alphabet +"Inserts.txt";
		        	//String docName="/Users/tedcu76/Documents/Inserts.txt";
		        	//writer = new PrintWriter(docName, "UTF-8");
		        	
		        	 try {
				    		String path = "/Users/tedcu76/Documents/gcide-0.51/CIDE."+alphabet;
				            htmlFile = Jsoup.parse(new File(path), "utf-8");
				             
					         all = htmlFile.getElementsByTag("p");
				            
				        } catch (IOException e) {
				    		
				            // TODO Auto-generated catch block
				
				            e.printStackTrace();
				
				        } 
		        	 
		        	 for(org.jsoup.nodes.Element element: all){
				        	
				        	Elements definition = element.getElementsByTag("def");
				        	Elements word = element.getElementsByTag("ent");
				        	Elements pronunciation = element.getElementsByTag("pr");
				        	if (!(word.isEmpty())){
				        		//insert escape characters into quotations if any
				        		String w=word.text();
				        		w=w.replace('"', '\"');
				        		w=w.replace("'", "\'");
				        		String d=definition.text();
				        		d=d.replace('"', '\"');
				        		d=d.replace("'", "\'");
				        		String p=pronunciation.text();
				        		p=p.replace('"', '\"');
				        		p=p.replace("'", "\'");
				        		bufferWritter.write("db.execSQL(\"INSERT INTO word VALUES (" + i + ", '" 
				        			+ w + "',  '" + d + 
				        			"', " + p + "')\");" + "\n");i++;}
		        	 
		        	 
		        }
		        
		        
		        
		        
		        //System.out.println("class of div tag : " + cssClass);
		        
		        
		        
		        
//		        Elements inputElements = formElement.getElementsByTag("input");  
//		        for (Element inputElement : inputElements) {  
//		            String key = inputElement.attr("name");  
//		            String value = inputElement.attr("value");  
//		            System.out.println("Param name: "+key+" \nParam value: "+value);  
//		        } 
		
		    }
		
		  
		        writer.close();
		        bufferWritter.close();
		        
		}

}
	
	
	
	
	


