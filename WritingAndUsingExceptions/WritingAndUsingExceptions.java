//Writing and Using Exceptions by Ted Callow

import java.util.Scanner;

public class WritingAndUsingExceptions {

	String r="";
	
	public static void main(String[] args) throws myCheckedException {
		// TODO Auto-generated method stub

		String answer = "y";
		Scanner sc = new Scanner(System.in);
		while (answer.equalsIgnoreCase("y")){
		
		
		System.out.println("Please enter a string to test: ");
		String r = sc.next(); 
		
		WritingAndUsingExceptions w = new WritingAndUsingExceptions();
				
				
			try{
				w.callUnchecked(r);
				
				System.out.println("Doesn't throw Unchecked exception");
			}catch(myUncheckedException RunTimeException){
				
				}
			
			try{
				w.callChecked(r);
				
				System.out.println("Doesn't throw checked exception");
			}catch(myCheckedException Exception){
				
				}
			w.callUnchecked(r);
			w.callChecked(r);
			
			System.out.println("would you like to enter another string? (y/n)");
			answer= sc.next();
		}sc.close();
		System.out.println("goodbye");
			
	
	
	
	}
	private  void callUnchecked(String r) throws myUncheckedException{
		char[] x=r.toCharArray();
		for (int i=0; i<x.length; i++){
			char y=x[i];
			if (y=='x'){
				throw new myUncheckedException("myUnchecked: " + r);
			}
			
		}
	}
	
	    
	private void callChecked(String r) throws myCheckedException{
		char[] x=r.toCharArray();
		for (int i=0; i<x.length; i++){
			char y=x[i];
			if (y=='x'){
				throw new myCheckedException("Checked: " + r);
			}
		}
		
	}

	
	public class myUncheckedException extends RuntimeException{
	    public myUncheckedException(String message){
	        super(message);
	    }
	}
	
	public class myCheckedException extends Exception{
	    public myCheckedException(String message){
	        super(message);
	    }
	}
		
		
		
		
	}
	



