public class SavingsAccount extends Account implements Observer
{
	protected static double interestRate;
	
	public SavingsAccount()
	{
		super();
	}
	
	public SavingsAccount(String n, String p, double b)
	{
		super(n, p, b);
	}
	
	public static void setInterestRate(double i)
	{
		interestRate = i;
	}
	
	public static double getInterestRate()
	{
		return interestRate;
	}
	
	public String getType()
	{
		return "Savings";
	}

	public void updateInterest(double i)
	{
		System.out.println("Dear " + super.name + ", the interest rate on your savings account has changed from " + interestRate + " to " + i + ".");
	}
}