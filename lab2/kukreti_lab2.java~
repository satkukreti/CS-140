//Satvik Kukreti

import java.io.*;
import java.util.*;

class kukreti_lab2
{
	public static void main(String[] args)
	{
		// put some code here to check for three commandline arguments
		if (args.length != 3)
		{
			System.out.println("Wrong argument");
			System.exit(0);		
		}
		// puts some code here to check that the first commandline argument starts with "b" or "t"
		if (args[0].startsWith("b"))
		{
			convertBinaryToText(args[1], args[2]);
		}
		else if (args[0].startsWith("t"))
		{
			convertTextToBinary(args[1], args[2]);
		}
		else
		{
			System.out.println("Wrong argument");
			System.exit(0);		
		}
	}
	
	private static void convertBinaryToText(String inputFilename, String outputFilename)
	{
		System.out.println("convertBinaryToText");
		try
		{
			// put your code to read a binary file and output it as a text file
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputFilename)); //reads the bytes in inputFile
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename)));
			byte[] reader = new byte[1024];
			while ((input.read(reader)) != -1) //reading as many bytes as it can while putting bytes into byte array
			{
				//conversion step
				String newString = new String(reader); //converts all elements in reader to String
				//output it as a text
				output.write(newString); //writes string into file
			}
			input.close();
			output.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	private static void convertTextToBinary(String inputFilename, String outputFilename)
	{
		System.out.println("convertTextToBinary");
		try
		{
			// put your code to read a text file and output it as a binary file
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename))); //saves each line as a String
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outputFilename));
			String inn;
			ArrayList <String> inputLines = new ArrayList<>(0);
			while ((inn = input.readLine()) != null)
			{
				inputLines.add(inn); //adds lines, not needed for this lab
				byte[]  byteConvert = inn.getBytes(); //read as a bytes
				output.write(byteConvert);
				output.write(System.lineSeparator().getBytes());
				
			}
			input.close();
			output.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}

