// Edward Callow "is it pareseable"


//Use JOptionPane.showInputDialog to prompt the user to enter a double precision number.
//Use JOptionPane.showMessageDialog to display the string "Parseable" or the string "Not Parseable" as appropriate.
//Use the Double.parseDouble exception to verify whether the string is parseable or not.
//Use JOptionPane.showMessageDialog to display the string "AGREES" or the string "DOES NOT AGREE" as appropriate.

//use a boolean to determine if parseable



import javax.swing.JOptionPane;


public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double theNumber = 0.0;
		
		String response = JOptionPane.showInputDialog("Enter a number");
		
		try{
		theNumber = Double.parseDouble(response);
		
		System.out.println("Pareseable"); //won't print unless parsed ok. . . 
		
		}catch (Exception e) {
			System.out.println("Not Parseable \"" + response + "\"");
			System.exit(3);
		} finally{
		System.out.println("finally");//this line doesn't run b/c of the "system.exit(3)"
		}
		
		
		
		
		for (int i = 0; i<response.length(); i++){
			String[] ary = response.split("");
			
			 try {
			        if (ary[i].equalsIgnoreCase(".")){
			        	return true;
			        } else if (ary[i].equalsIgnoreCase("."))
			
		}
	}
	
	

}
