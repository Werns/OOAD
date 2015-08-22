public class CheckingAccount extends Account
{
	protected double overdraftFee;
	
	public CheckingAccount()
	{
		super();
		overdraftFee = 0;
	}
	
	public CheckingAccount(String n, String p, double b)
	{
		super(n, p, b);
		overdraftFee = 0;
	}
	
	public CheckingAccount(String n, String p, double b, double o)
	{
		super(n, p, b);
		overdraftFee = o;
	}
	
	public double getOverdraftFee()
	{
		return overdraftFee;
	}
	
	public void setOverdraftFee(double o)
	{
		overdraftFee = o;
	}
	
	public String getType()
	{
		return "Checking";
	}
}