import java.util.Scanner;

public class Factory
{
	protected Scanner input = new Scanner(System.in);
	
	public Account makeAccount(String name, String password, double balance, String type)
	{
		boolean test = true;
		while (test)
		{
			if (type.equals("Savings"))
			{
				SavingsAccount s = new SavingsAccount(name, password, balance);
				
				return s;
			}
			else if (type.equals("Checking"))
			{
				CheckingAccount s = new CheckingAccount(name, password, balance);
				
				System.out.print("How much is the overdraft fee? $");
				double over = input.nextDouble();
				
				if (over != 0.0)
				{
					s.setOverdraftFee(over);
				}
				
				return s;
			}
			else
			{
				System.out.println("Error! The account type entered was incorrect. Please re-enter account type: (Savings / Checking) ");
				
				type = input.nextLine();
			}
		}
		
		return null;
	}
}