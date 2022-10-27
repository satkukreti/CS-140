class garrison_makeBankAccountsAndTransactions
{
	public static void main(String[] args)
	{
		if( args.length != 1 )
		{
			System.out.println("format: makeBankAccountsAndTransactions \"input file\"");
			System.exit(0);
		}
		
		String overallResults = "kukreti";
		
		try
		{
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(args[0])));
			String inn;
			java.util.ArrayList<String> inputLines = new java.util.ArrayList<>();
			while( (inn = input.readLine()) != null )
			{
				if( (inn.trim().length() > 0) && (!inn.trim().startsWith("#")) )
				{
					inputLines.add(inn);
				}
			}
			
			for( int i = 0; i < inputLines.size(); )
			{
				inn = inputLines.get(i);
				System.out.println(inn);
				
				if( inn.startsWith("new BankAccount") )
				{
					java.util.StringTokenizer st = new java.util.StringTokenizer(inn, "\t");
					st.nextToken();
					String lastName = st.nextToken();
					String firstName = st.nextToken();
					double checkingInitialValue = Double.parseDouble(st.nextToken());
					double savingsInitialValue = Double.parseDouble(st.nextToken());
					kukreti_BankAccount ba = new kukreti_BankAccount(lastName, firstName, checkingInitialValue, savingsInitialValue);
					System.out.println(ba.toString());
					i = i+1;
					while( true )
					{
						if( i >= inputLines.size() )
						{
							System.out.println(ba.toString());
							break;
						}
						
						inn = inputLines.get(i);
						if( inn.startsWith("new") )
						{
							System.out.println(ba.toString());
							int checkingBalance = (int) ba.getCheckingBalance();
							int savingsBalance = (int) ba.getSavingsBalance();
							
							if( checkingBalance == 198 )
							{
								overallResults = overallResults+"\ta0";
							}
							else
							{
								overallResults = overallResults+"\ta1";
							}
							
							if( savingsBalance == 397 )
							{
								overallResults = overallResults+"\tb0";
							}
							else
							{
								overallResults = overallResults+"\tb1";
							}
							break;
						}
						
						st = new java.util.StringTokenizer(inn, "\t");
						String type = st.nextToken();
						double amount = Double.parseDouble(st.nextToken());
						
						if( type.equals("withdrawFromChecking") )
						{
							boolean result = ba.withdrawFromChecking(amount);
							System.out.println("withdrawFromChecking " + amount + " " + result);
						}
						
						if( type.equals("withdrawFromSavings") )
						{
							boolean result = ba.withdrawFromSavings(amount);
							System.out.println("withdrawFromSavings " + amount + " " + result);
						}
						
						if( type.equals("depositToChecking") )
						{
							ba.depositToChecking(amount);
							System.out.println("depositToChecking " + amount);
						}
						
						if( type.equals("depositToSavings") )
						{
							ba.depositToSavings(amount);
							System.out.println("depositToSavings " + amount);
						}
						
						if( type.equals("transferToChecking") )
						{
							boolean result = ba.transferFromSavingsToChecking(amount);
							System.out.println("transferToChecking " + amount + " " + result);
						}
						
						if( type.equals("transferToSavings") )
						{
							boolean result = ba.transferFromCheckingToSavings(amount);
							System.out.println("transferToSavings " + amount + " " + result);
						}
						
						i = i+1;
						
					}
				}
				
				if( inn.startsWith("new EnhancedBankAccount") )
				{
					java.util.Date[] dates = new java.util.Date[10];
					java.util.StringTokenizer st = new java.util.StringTokenizer(inn, "\t");
					st.nextToken();
					String lastName = st.nextToken();
					String firstName = st.nextToken();
					double checkingInitialValue = Double.parseDouble(st.nextToken());
					double savingsInitialValue = Double.parseDouble(st.nextToken());
					kukreti_EnhancedBankAccount eba = new kukreti_EnhancedBankAccount(lastName, firstName, checkingInitialValue, savingsInitialValue);
					System.out.println(eba.toString());
					
					i = i+1;
					while( true )
					{
						if( i >= inputLines.size() )
						{
							System.out.println(eba.toString());
							int checkingBalance = (int) eba.getCheckingBalance();
							int savingsBalance = (int) eba.getSavingsBalance();
							
							if( checkingBalance == 0 )
							{
								overallResults = overallResults+"\t0";
							}
							else
							{
								overallResults = overallResults+"\t1";
							}
							
							if( savingsBalance == 0 )
							{
								overallResults = overallResults+"\t0";
							}
							else
							{
								overallResults = overallResults+"\t1";
							}
							break;
						}
						
						try
						{
							java.lang.Thread.sleep(100);
						}
						catch(Exception e)
						{
							
						}
						
						inn = inputLines.get(i);
						if( inn.startsWith("new") )
						{
							System.out.println(eba.toString());
							break;
						}
						
						st = new java.util.StringTokenizer(inn, "\t");
						String type = st.nextToken();
						double amount = Double.parseDouble(st.nextToken());
						
						// get the date 
						if( type.equals("getDate") )
						{
							int index = (int) amount;
							dates[index] = new java.util.Date();
							System.out.println("date " + index + " " + dates[index]);
						}
						
						// add code here to get and output the successful transactions between dates[index0] and dates[index1]
						if( type.equals("getSuccessfulTransactions") )
						{
							int index0 = (int) amount;
							int index1 = Integer.parseInt(st.nextToken());
							System.out.println("getSuccessfulTransactions " + dates[index0] + " " + dates[index1]);
							java.util.ArrayList<Transaction> transactions = eba.getSuccessfulTransactions(dates[index0], dates[index1]);
							if( transactions != null )
							{
								for( Transaction e : transactions )
								{
									System.out.println("\t" + e);
								}
								
								if( transactions.size() == 10 )
								{
									overallResults = overallResults+"\t0";
								}
								else
								{
									overallResults = overallResults+"\t1";
								}
							}
							else
							{
								System.out.println("\t" + "transactions is null");
								overallResults = overallResults+"\t1";
							}							
						}
						
						if( type.equals("getFailedTransactions") )
						{
							int index0 = (int) amount;
							int index1 = Integer.parseInt(st.nextToken());
							System.out.println("getFailedTransactions " + dates[index0] + " " + dates[index1]);
							java.util.ArrayList<Transaction> transactions = eba.getFailedTransactions(dates[index0], dates[index1]);
							if( transactions != null )
							{
								for( Transaction e : transactions )
								{
									System.out.println("\t" + e);
								}
								
								if( transactions.size() == 6 )
								{
									overallResults = overallResults+"\t0";
								}
								else
								{
									overallResults = overallResults+"\t1";
								}
							}
							else
							{
								System.out.println("\t" + "transactions is null");
								overallResults = overallResults+"\t1";
							}
						}
						
						if( type.equals("getWithdrawFromChecking") )
						{
							System.out.println("getWithdrawFromChecking");
							java.util.ArrayList<Transaction> transactions = eba.getCheckingWithdrawalTransactions();
							if( transactions != null )
							{
								for( Transaction e : transactions )
								{
									System.out.println("\t" + e);
								}
								
								if( transactions.size() == 3 )
								{
									overallResults = overallResults+"\t0";
								}
								else
								{
									overallResults = overallResults+"\t1";
								}
							}
							else
							{
								System.out.println("\t" + "transactions is null");
								overallResults = overallResults+"\t1";
							}
						}
						
						if( type.equals("getWithdrawFromSavings") )
						{
							System.out.println("getWithdrawFromSavings");
							java.util.ArrayList<Transaction> transactions = eba.getSavingsWithdrawalTransactions();
							if( transactions != null )
							{
								for( Transaction e : transactions )
								{
									System.out.println("\t" + e);
								}
								
								if( transactions.size() == 3 )
								{
									overallResults = overallResults+"\t0";
								}
								else
								{
									overallResults = overallResults+"\t1";
								}
							}
							else
							{
								System.out.println("\t" + "transactions is null");
								overallResults = overallResults+"\t1";
							}
						}
						
						if( type.equals("getDepositToChecking") )
						{
							System.out.println("getDepositToChecking");
							java.util.ArrayList<Transaction> transactions = eba.getCheckingDepositTransactions();
							if( transactions != null )
							{
								for( Transaction e : transactions )
								{
									System.out.println("\t" + e);
								}
								
								if( transactions.size() == 3 )
								{
									overallResults = overallResults+"\t0";
								}
								else
								{
									overallResults = overallResults+"\t1";
								}
							}
							else
							{
								System.out.println("\t" + "transactions is null");
								overallResults = overallResults+"\t1";
							}
						}
						
						if( type.equals("getDepositToSavings") )
						{
							System.out.println("getDepositToSavings");
							java.util.ArrayList<Transaction> transactions = eba.getSavingsDepositTransactions();
							if( transactions != null )
							{
								for( Transaction e : transactions )
								{
									System.out.println("\t" + e);
								}
								
								if( transactions.size() == 3 )
								{
									overallResults = overallResults+"\t0";
								}
								else
								{
									overallResults = overallResults+"\t1";
								}
							}
							else
							{
								System.out.println("\t" + "transactions is null");
								overallResults = overallResults+"\t1";
							}
						}
						
						if( type.equals("getTransferToChecking") )
						{
							System.out.println("getTransferToChecking");
							java.util.ArrayList<Transaction> transactions = eba.getSavingsToCheckingTransferTransactions();
							if( transactions != null )
							{
								for( Transaction e : transactions )
								{
									System.out.println("\t" + e);
								}
								
								if( transactions.size() == 3 )
								{
									overallResults = overallResults+"\t0";
								}
								else
								{
									overallResults = overallResults+"\t1";
								}
							}
							else
							{
								System.out.println("\t" + "transactions is null");
								overallResults = overallResults+"\t1";
							}
						}
						
						if( type.equals("getTransferToSavings") )
						{
							System.out.println("getTransferToChecking");
							java.util.ArrayList<Transaction> transactions = eba.getCheckingToSavingsTransferTransactions();
							if( transactions != null )
							{
								for( Transaction e : transactions )
								{
									System.out.println("\t" + e);
								}
								
								if( transactions.size() == 3 )
								{
									overallResults = overallResults+"\t0";
								}
								else
								{
									overallResults = overallResults+"\t1";
								}
							}
							else
							{
								System.out.println("\t" + "transactions is null");
								overallResults = overallResults+"\t1";
							}
						}
						
						if( type.equals("withdrawFromChecking") )
						{
							boolean result = eba.withdrawFromChecking(amount);
							System.out.println("withdrawFromChecking " + amount + " " + result);
						}
						
						if( type.equals("withdrawFromSavings") )
						{
							boolean result = eba.withdrawFromSavings(amount);
							System.out.println("withdrawFromSavings " + amount + " " + result);
						}
						
						if( type.equals("depositToChecking") )
						{
							eba.depositToChecking(amount);
							System.out.println("depositToChecking " + amount);
						}
						
						if( type.equals("depositToSavings") )
						{
							eba.depositToSavings(amount);
							System.out.println("depositToSavings " + amount);
						}
						
						if( type.equals("transferToChecking") )
						{
							boolean result = eba.transferFromSavingsToChecking(amount);
							System.out.println("transferToChecking " + amount + " " + result);
						}
						
						if( type.equals("transferToSavings") )
						{
							boolean result = eba.transferFromCheckingToSavings(amount);
							System.out.println("transferToSavings " + amount + " " + result);
						}
						
						i = i+1;
					}
				}
			}
		}
		catch(java.lang.IndexOutOfBoundsException e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}
		System.err.println(overallResults);
	}
}
