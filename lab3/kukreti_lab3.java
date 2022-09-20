//Satvik Kukreti

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class kukreti_lab3
{
	public static void main(String[] args)
	{
		// check the number of commandline arguments
		if( args.length < 2 )
		{
			System.out.println("format: lab3 \"input filename\" \"output filename\" \"<output unique sorted words>\"");
			System.exit(0);
		}
		
		// allocate the DecimalFormat 
		DecimalFormat df = new DecimalFormat("###, ###, ###, ###, ###");
		
		// define a boolean variable that specifies if the list of unique words needs to be printed to the screen
		boolean outputWords = false;
		if( args.length > 2 )
		{
			if( args[2].toLowerCase().startsWith("y") || args[2].toLowerCase().startsWith("t") )
			{
				outputWords = true;
			}
		}
		
		// declare and initialize int to keep track of the number of lines
		int numLines = 0;
		// declare and initialize int to keep track of the number of words
		int numWords = 0;
		// declare and initialize int to keep track of the number of characters
		int numChars = 0;
		// try block for all of the work
		try
		{
			// instantiate the BufferedReader for the input file (args[0] is the input filename)
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
			// instantiate the PrintWriter for the output file (args[1] is the output filename)
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));
			// instantiate the TreeSet of type String for the list of unique words
			TreeSet<String> uniqueStrings = new TreeSet<>();
			// instantiate the ArrayDeque of type String to use to reverse the words of a line of input
			ArrayDeque<String> stackOfCurrentStrings = new ArrayDeque<>();
			// declare a String for the current line from the input file
			String inn;
			// while loop to read the input file a line at a time using BufferedReader.readLine()
			while((inn = input.readLine()) != null)
			{
				// increment the line count
				numLines++;
				// create a StringTokenizer for the current line using a blank space delimitter
				StringTokenizer st = new StringTokenizer(inn);
				// while loop over the tokens of the StringTokenizer
				while(st.hasMoreTokens())
				{
					// get the current token (or word)
					String token = st.nextToken();
					// increment the word count
					numWords++;
					// increment the character count based on the length of the current token (String.length())
					numChars += token.length();
					// add the current token to the ArrayDeque using ArrayDeque.addLast() (adds to top of stack)
					stackOfCurrentStrings.addLast(token);
					// add the current token to the TreeSet
					if(uniqueStrings.contains(token) == false)
						uniqueStrings.add(token);
				}
				
				// while loop over the elements of the ArrayDeque, containing the words of the current line of input
				while(stackOfCurrentStrings.size() != 0)
				{
					// use ArrayDeque.removeLast() to get the element from the top of the stack
					String temp = stackOfCurrentStrings.removeLast();
					// get a char[] of the characters of the current word using String.toCharArray()
					char[] c = temp.toCharArray();
					// use a for loop, to output the elements of the char[] in reverse order
					for(int i = c.length - 1; i >= 0; i--)
					{
						// output the current symbol using PrintWriter.print(char)
						output.print(c[i]);
					}
					
					// if the ArrayDeque is not empty, print a blank space after the current word to the output file
					if(stackOfCurrentStrings.size() > 0)
					{
						output.print(" ");
					}
				}
				// output an end of line character to the end of the current line of output to the output file
				output.println();
			}
			
			// close the BufferedReader and PrintWriter
			input.close();
			output.close();
			// output the number of lines using the DecimalFormat
			System.out.println("Lines: " + df.format(numLines));
			// output the number of words using the DecimalFormat
			System.out.println("Words: " + df.format(numWords));
			// output the number of characters using the DecimalFormat
			System.out.println("Characters: " + df.format(numChars));
			// output the number of unique words, size of the TreeSet, using the DecimalFormat
			System.out.println("Unique Words: " + df.format(uniqueStrings.size()));
			// output the unique list of words to the screen, if requested, using an 
			// enhanced for loop over the elements of the TreeSet
			if( outputWords )
			{
				for (String word:uniqueStrings)
				{
					System.out.println(word);
				}
			}
		}
		// catch any exceptions
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
	}
}
