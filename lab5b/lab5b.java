
public class lab5b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("yo, i am here, and below are the command line arguments you gave me");
		for(int i = 0; i < args.length; i++)
		{
			System.out.println("\t args[" + i + "] = " + args[i]);
		}
		for(int i = 0; i < args.length; i++)
		{
			int intValue = Integer.parseInt(args[i]);
			System.out.println("\t args[" + i + "] as an int = " + intValue);
		}
	}

}
