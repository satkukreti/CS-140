//Satvik Kukreti

class kukreti_p1
{
	// constructor for the class
	public kukreti_p1()
	{	
	}
	
	// method to sort an array of String values using selection sort
	// sorting the array element starting at lowerBound and ending at upperBound
	public String[] selectionSort(String[] values, int lowerBound, int upperBound)
	{
		for (int i = lowerBound; i < upperBound; i++)
		{
			int min = i;
			for (int j = i+1; j <= upperBound; j++)
			{
				if (values[j].compareTo(values[min]) < 0)
				{
					min = j;
				}
			}
			if (min != i)
			{
				String temp = values[i];
				values[i] = values[min];
				values[min] = temp;
			}
		}
		return values;
	}
	
	// method to return the number of array elements <= testValue with indices in [lowerBound, upperBound]
	// using a for loop to examine the array elements
	public int forLoopTest(int lowerBound, int upperBound, int testValue, int[] values)
	{
		int counter = 0;
		for (int i = lowerBound; i <= upperBound; i++)
		{
			if (values[i] <= testValue)
			{
				counter++;
			}
		}
		return counter;
	}
	
	// method to return the number of array elements >= testValue with indices in [lowerBound, upperBound]
	// using a while loop to examine the array elements
	public int whileLoopTest(int lowerBound, int upperBound, int testValue, int[] values)
	{
		int counter = 0;
		int i = lowerBound;
		while(i <= upperBound)
		{
			if (values[i] >= testValue)
			{
				counter++;			
			}
			i++;
		}
		return counter;
	}
	
	// method to return the number of array elements in [testValue1, testValue2] or [testValue2, testValue1] with 
	// indices in [lowerBound, upperBound] using a do-while loop to examine the array elements
	public int doWhileLoopTest(int lowerBound, int upperBound, int testValue1, int testValue2, int[] values)
	{
		int counter = 0;
		int lower, upper;
		if (testValue1 < testValue2)
		{
			lower = testValue1;
			upper = testValue2;
		}
		else
		{
			lower = testValue2;
			upper = testValue1;
		}
		int i = lowerBound;
		do
		{
			if (values[i] >= lower && values[i] <= upper)
			{
				counter++;		
			}
			i++;
		} while(i <= upperBound);
		return counter;
	}
	
	// method to return the number of array elements that match the switch cases [0, 2, 4, 6, 8, 10, 12, 14, 16, 18] and the default case with 
	// indices in [lowerBound, upperBound]
	public int[] switchTest(int lowerBound, int upperBound, int[] values)
	{
		int[] counter = new int[11];
		for (int i = lowerBound; i <= upperBound; i++)
		{
			int temp = values[i];
			switch (temp)
			{
			case 0: counter[0]++;
				break;
			case 2: counter[1]++;
				break;
			case 4: counter[2]++;
				break;
			case 6: counter[3]++;
				break;
			case 8: counter[4]++;
				break;
			case 10: counter[5]++;
				break;
			case 12: counter[6]++;
				break;
			case 14: counter[7]++;
				break;
			case 16: counter[8]++;
				break;
			case 18: counter[9]++;
				break;
			default: counter[10]++;
				break;
			}
		}
		return counter;
	}	
}
