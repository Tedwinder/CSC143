// Edward Callow "is it pareseable?"


//Use JOptionPane.showInputDialog to prompt the user to enter a double precision number.
//Use JOptionPane.showMessageDialog to display the string "Parseable" or the string "Not Parseable" as appropriate.
//Use the Double.parseDouble exception to verify whether the string is parseable or not.
//Use JOptionPane.showMessageDialog to display the string "AGREES" or the string "DOES NOT AGREE" as appropriate.

//use a boolean to determine if parseable



import javax.swing.JOptionPane;


public class Main {
	
	
	public static double theNumber = 0.0;
	
	public static String response = "";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean parseable = true;
		
		
		String answer = "y";
		
		
		while (answer.equalsIgnoreCase("y")){
		
		response = JOptionPane.showInputDialog("Enter a number");
			
		try{
		theNumber = Double.parseDouble(response);
		
		if (parseable(response, parseable)){ //compares my parseable method against parseDouble where parseDouble does not throw an exception
			System.out.println("Parseable"); 
			System.out.println("AGREES");
		}else {
			System.out.println("Not Parseable"); 
			System.out.println("DOES NOT AGREE");
		}
		
		}catch (Exception e) {//compares my parseable method against parseDouble where parseDouble DOES throw an exception
			
			
			if (parseable(response, parseable)){
				System.out.println("Parseable"); 
				System.out.println("DOES NOT AGREE");
			}else {
				System.out.println("Not Parseable");
				System.out.println("AGREES");
			}
		} answer = JOptionPane.showInputDialog("would you like to enter another number y/n? ");
		if (answer.equalsIgnoreCase("n")){
			System.exit(3);}else answer = "y";
		}
			
	}
		
	
	
	public static boolean parseable(String response, boolean parseable){
		
		String[] ary = response.split("");
		char[]array = response.toCharArray(); //note - used this only so I could employ the isDigit method, which requires a char
		int i=0;
		parseable=true;
		int counterE=0;
		int counterPeriod=0;
		
		
		 
		for (i = 0; i<response.length(); i++){
			
			
			        //if (response.contains("e") && ary[i].equals("e") && !(i==(response.length()-1))){
			        	//parseable = false;} // "e" should only be allowed at the end, as far as I understand traditional mathematical notation, 
			        //unless the number following is an exponent.  
			        //Not sure why, e.g. "22e22" is parseable in the parseDouble method, but I believe this is wrong. If I am wrong about this,
			        // and the user wants, e.g. "22e22" to be a valid parseable number, this if block can be deleted.
			        //for some reason, java thinks "e" must be embedded between 2 numbers - almost the opposite of what I 
			        //understand as traditional mathematical notation, and it does not allow only "e" by itself.
			        //the 2 if blocks below are required to mimic java syntax. . . . 
			        if (response.contains("e") && ary[i].equals("e") && ( (i==(response.length()-1)) || (i==(0)))){
			        	parseable = false;}
			       
			        if (response.contains("-") && response.contains("e")&& ary[i].equals("e") && !(i>(1))){
			        	parseable = false;} //because java doesn't allow double to be -e2, for example. . . 
			        
			        if (response.contains("-") && ary[i].equals("-") && !(i==(0))){
			        	parseable = false;}
			        if (!Character.isDigit((array[i])) && !(ary[i].equals("e")) && !(ary[i].equals(".")) && !(ary[i].equals("-"))){
			        	parseable = false;}
			        	
			        if (ary[i].equals("e")){counterE ++;} 
			        if (ary[i].equals(".")){counterPeriod ++;}
			        
			        if (counterE > 1 || counterPeriod > 1)
			        	{parseable= false;
			        }
			        
			        	
			 } 
		
		return parseable;  
			
			 
			 
	}  
		
		
		

	
}
