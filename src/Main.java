
import java.io.*;
import java.util.ArrayList;

public class Main 
{
	/*
	 * Determine if track one of a credit card is found
	 */
	private static void IsTrackOne()
	{
		
	}
	
	/*
	 * Determine if track two of a credit card is found
	 */
	private static void IsTrackTwo()
	{
		
	}
	
	/*
	 * Main method
	 */
	public static void main(String[] args) 
	{
		try{
			//Read the memory dump file
			System.out.println("Reading file...");
			File file = new File("input/memorydump.dmp");
			FileInputStream fileIn = new FileInputStream(file);
			BufferedInputStream bufferedIn = new BufferedInputStream(fileIn);
			DataInputStream dataIn = new DataInputStream(bufferedIn);
			
			byte[] fileContents = new byte[(int)file.length()];
			
			//Copy file contents to byte array
			dataIn.readFully(fileContents);
			
			dataIn.close();
			System.out.println("File read successfully");
			
			//Parse file for credit card information
		}
		catch(IOException ex)
		{
			System.out.println("File not found");
		}
	}
	
	

}
