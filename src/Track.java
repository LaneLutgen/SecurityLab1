import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Track {

	public static void main(String[] args) {
		
	String cname = null;
        String cnum = null;
        String month = null;
        String year = null;
        String cvv = null;
        String pin = null;
	String s = null;
	BufferedReader buffer = null;
        Matcher matchOne = null;
        Matcher matchTwo = null;

        String patternOne = "%B\\d{0,19}\\^[\\w\\s\\/]{2,26}\\^\\d{7}?";
        String patternTwo = ";\\d{0,19}=\\d{14}?";
        
        Pattern trackOnePattern = Pattern.compile(patternOne);
        Pattern trackTwoPattern = Pattern.compile(patternTwo);
        
        int i = 0;
        
        try {
        	
        	String filePath = null;
        	
        	if(args.length > 0)
        	{
        		filePath = args[0];
        	}
        	else
        	{
        		filePath = "memorydump.dmp";
        	}
        	
        	buffer = new BufferedReader(new FileReader(filePath));
        	while ((s = buffer.readLine()) != null) {
        		matchOne = trackOnePattern.matcher(s);
        		matchTwo = trackTwoPattern.matcher(s);
	     		if (matchOne.find( )) {
				i++;
						
		     		String str = matchOne.group(0);
				str = str.replace('/','\0');
	     			str = str.replace('^','\0');
		   		str = str.replace('=','\0');

				cnum = str.substring(2,19);
		     		cname = str.substring(19,str.length()-8);
				year = str.substring(str.length()-7,str.length()-5);
	     			month = str.substring(str.length()-5,str.length()-3);
					
				System.out.println("<Information of the "+ i +" credit card>");
				System.out.println("Cardholder's Name: " +cname);
				System.out.println("Card Number: " +cnum);
	  	       		System.out.println("Expiration Date: " +month+ "/20" +year);
	     		}
	     		if(matchTwo.find()){	
	     			String str = matchTwo.group(0);
	     			pin = str.substring(str.length()-7,str.length()-3);
	     			cvv = str.substring(str.length()-3,str.length());
	     			
	     			System.out.println("Encrypted PIN: " +pin);
  	         		System.out.println("CVV Number: " +cvv);
	     		}
		}   
	}
		
	catch (IOException e) {
		e.printStackTrace();
	} 
		System.out.println("There is "+ i +" piece of credit card information in the memory data!");
	}

}
