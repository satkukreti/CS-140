import java.io.*;
import java.util.*;
import java.nio.*;
//number of lines
//arraylist and count the number of lines


class kukreti_p2
{
    public static void main(String [] args)
	{
		if (args.length != 3)
		{
			System.out.println("Wrong argument");
			System.exit(0);		
		}
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
		try
		{
			System.out.println("convertBinaryToText");
			
			//input and output
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(inputFilename));
			PrintWriter output = new PrintWriter(new BufferedWriter((new FileWriter(outputFilename))));

			//gets the length of the file in bytes			
			byte[] temp = new byte[4];		
			ByteBuffer bTemp = ByteBuffer.wrap(temp);
			input.read(temp);
			int length = bTemp.getInt(0);
			
			for (int i = 0; i < length; i++)
			{
				byte[] b = new byte[2];
				ByteBuffer bBuffer = ByteBuffer.wrap(b);
				input.read(b);
				char type = bBuffer.getChar(0);
				
				switch(type)
				{
					case 'i':
						output.write("int\t");
						byte[] bInt = new byte[4];
						ByteBuffer bbInt = ByteBuffer.wrap(bInt);
						input.read(bInt);
						String iValue = String.valueOf(bbInt.getInt(0));
						output.write(iValue);
						output.write("\n");
						break;
						
					case 'd':
						output.write("double\t");
						byte[] bDouble = new byte[8];
						ByteBuffer bbDouble = ByteBuffer.wrap(bDouble);
						input.read(bDouble);
						String dValue = String.valueOf(bbDouble.getDouble(0));
						output.write(dValue);
						output.write("\n");
						break;

					case 'l':
						output.write("long\t");
						byte[] bLong = new byte[8];
						ByteBuffer bbLong = ByteBuffer.wrap(bLong);
						input.read(bLong);
						String lValue = String.valueOf(bbLong.getLong(0));
						output.write(lValue);
						output.write("\n");
						break;
						
					case 'h':
						output.write("short\t");
						byte[] bShort = new byte[2];
						ByteBuffer bbShort = ByteBuffer.wrap(bShort);
						input.read(bShort);
						String hValue = String.valueOf(bbShort.getShort(0));
						output.write(hValue);
						output.write("\n");
						break;
						
					case 'f':
						output.write("float\t");
						byte[] bFloat = new byte[4];
						ByteBuffer bbFloat = ByteBuffer.wrap(bFloat);
						input.read(bFloat);
						String fValue = String.valueOf(bbFloat.getFloat(0));
						output.write(fValue);
						output.write("\n");
						break;
						
					case 'a':
						output.write("int array\t");
						byte[] bIntarr = new byte[4];
						ByteBuffer bbIntarr = ByteBuffer.wrap(bIntarr);
						input.read(bIntarr);
						
						int intarrLength = bbIntarr.getInt(0);
						
						for (int j = 0; j < intarrLength; j++)
						{
							byte[] ii = new byte[4];
							ByteBuffer bii = ByteBuffer.wrap(ii);
							input.read(ii);
							String sii = String.valueOf(bii.getInt(0));
							output.write(sii);
							
							if (j < intarrLength - 1)
							{
								output.write(",");							
							}
							else
							{
								output.write("\n");							
							}
						}
						break;
						
					case 'e':
						output.write("double array\t");
						byte[] bDarr = new byte[4];
						ByteBuffer bbDarr = ByteBuffer.wrap(bDarr);
						input.read(bDarr);
						
						int darrLength = bbDarr.getInt(0);
						
						for (int k = 0; k < darrLength; k++)
						{
							byte[] dd = new byte[8];
							ByteBuffer bdd = ByteBuffer.wrap(dd);
							input.read(dd);
							String sdd = String.valueOf(bdd.getDouble(0));
							output.write(sdd);
							
							if (k < darrLength - 1)
							{
								output.write(",");							
							}
							else
							{
								output.write("\n");							
							}
						}
						break;					
					
					case 's':
						output.write("string\t");
						byte[] bSarr = new byte[4];
						ByteBuffer bbSarr = ByteBuffer.wrap(bSarr);
						input.read(bSarr);
						
						int sarrLength = bbSarr.getInt(0);
						
						for (int m = 0; m < sarrLength; m++)
						{
							byte[] ss = new byte[2];
							ByteBuffer bss = ByteBuffer.wrap(ss);
							input.read(ss);
							String sss = String.valueOf(bss.getChar(0));
							output.write(sss);
							
							if (m < sarrLength - 1)
							{

							}
							else
							{
								output.write("\n");							
							}
						}	
						break;
				}
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
		try
		{
			System.out.println("convertTextToBinary");
			
			//initializing input and output
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilename)));
			DataOutputStream output = new DataOutputStream(new FileOutputStream(outputFilename));
			
			//size of the file
			String inn;
			ArrayList<String> inputLines = new ArrayList<>(0);
			while ((inn = input.readLine()) != null)
			{
				inputLines.add(inn); //gets lines in text file
			}
			
			int size = inputLines.size(); //num lines of file
			output.writeInt(size); //allocates the blocks in binary file

			for (int i = 0; i < inputLines.size(); i++)
			{
				String[] strArray = inputLines.get(i).split("\t");
				
				String first = strArray[0];
				String rest = strArray[1];

				switch(first)
				{
					case "string":
						output.writeChar('s');
						output.writeInt(rest.length());
						output.writeChars(rest);
						break;
						
					case "double":
						output.writeChar('d');
						output.writeDouble(Double.parseDouble(rest));
						break;
						
					case "int":
						output.writeChar('i');
						output.writeInt(Integer.parseInt(rest));
						break;
						
					case "float":
						output.writeChar('f');
						output.writeFloat(Float.parseFloat(rest));
						break;
						
					case "long":
						output.writeChar('l');
						output.writeLong(Long.parseLong(rest));
						break;
						
					case "short":
						output.writeChar('h');
						output.writeShort(Short.parseShort(rest));
						break;
						
					case "int array":
						output.writeChar('a');
						String[] intTemp = rest.split(",");
						output.writeInt(intTemp.length);
						for(int k = 0; k < intTemp.length; k++)
						{
							output.writeInt(Integer.parseInt(intTemp[k]));
						}
						break;
						
					case "double array":
						output.writeChar('e');
						String[] doubleTemp = rest.split(",");
						output.writeInt(doubleTemp.length);
						for(int j = 0; j < doubleTemp.length; j++)
						{
							output.writeDouble(Double.parseDouble(doubleTemp[j]));
						}
						break;
				}

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