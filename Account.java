public class Account
{
	protected String name, password;
	protected double balance;
	
	public Account()
	{
		name = "Default User";
		password = "mypassword";
		balance = 0.0;
	}
	
	public Account(String n, String p, double b)
	{
		name = n;
		password = p;
		balance = b;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String p)
	{
		password = p;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void setBalance(double b)
	{
		balance = b;
	}
	
	public void withdraw(double b)
	{
		balance -= b;
	}
	
	public void deposit(double b)
	{
		balance += b;
	}
	
	public String getType()
	{
		return "account";
	}
}