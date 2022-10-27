class kukreti_BankAccount
{
	private final String ownerLastName;
	private final String ownerFirstName;
	private final String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	private static int bankAccountCount = 0;
	
	kukreti_BankAccount(String ownerLastName, String ownerFirstName, double checkingBalance, double savingsBalance)
	{
		this.ownerLastName = ownerLastName;
		this.ownerFirstName = ownerFirstName;
		this.accountNumber = makeAccountNumber();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		
		bankAccountCount = bankAccountCount+1;
	}
	
	kukreti_BankAccount(String ownerLastName, String ownerFirstName)
	{
		this(ownerLastName, ownerFirstName, 0.0, 0.0);
	}
	
	public boolean withdrawFromChecking(double amount)
	{
		if (amount > checkingBalance)
		{
			return false;
		}
		else
		{
			checkingBalance -= amount;
			return true;		
		}
	}
	
	public boolean withdrawFromSavings(double amount)
	{
		if (amount > savingsBalance)
		{
			return false;
		}
		else
		{
			savingsBalance -= amount;
			return true;		
		}
	}
	
	public boolean transferFromSavingsToChecking(double amount)
	{
		if (amount > savingsBalance)
		{
			return false;		
		}
		else
		{
			checkingBalance += amount;
			savingsBalance -= amount;
			return true;		
		}
	}
	
	public boolean transferFromCheckingToSavings(double amount)
	{
		if (amount > checkingBalance)
		{
			return false;		
		}
		else
		{
			savingsBalance += amount;
			checkingBalance -= amount;
			return true;		
		}
	}
	
	public void depositToSavings(double amount)
	{
		savingsBalance += amount;
	}
	
	public void depositToChecking(double amount)
	{
		checkingBalance += amount;
	}
	
	public String toString()
	{
		String firstLine = ownerLastName + ", " + ownerFirstName + ", " + accountNumber; 
		String secondLine = "" + checkingBalance;
		String thirdLine = "" + savingsBalance;
		return firstLine + "\n" + secondLine + "\n" + thirdLine;
	}
	
	public String getOwnerLastName()
	{
		return ownerLastName;
	}
	
	public String getOwnerFirstName()
	{
		return ownerFirstName;
	}
	
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
	public double getCheckingBalance()
	{
		return checkingBalance;
	}
	
	public double getSavingsBalance()
	{
		return savingsBalance;
	}
	
	private String makeAccountNumber()
	{
		String aNumber = "" + bankAccountCount;
		
		while( aNumber.length() < 6 )
		{
			aNumber = "0" + aNumber;
		}
		return aNumber;
	}
	
	public static int getBankAccountCount()
	{
		return bankAccountCount;
	}
}
