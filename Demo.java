import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo
{
	static Scanner input = new Scanner(System.in);
	static Factory accountMaker = new Factory();
	static ArrayList<Account> accounts = new ArrayList<>();
	static int wait = 0;
	
	public static void main(String[] args)
	{
		System.out.println("Welcome to Werns Bank");
		boolean run = true;
		
		while (run)
		{
			run = menu();
		}
	}
	
	public static boolean menu()
	{
		int choice = 0;
		if (wait == 1)
		{
			System.out.print("Press enter to continue...");
			input.nextLine();
		}
		wait = 1;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("\nPlease choose from the options below:");
		System.out.println("=====================================================");
		System.out.println("Choice 1 -- Add new account");
		System.out.println("Choice 2 -- Account information");
		System.out.println("Choice 3 -- Change interest rate for savings accounts");
		System.out.println("Choice 4 -- Exit");
		System.out.print("\nYour choice: ");
		
		choice = input.nextInt();
		
		switch(choice)
		{
			case 1:
				addAccount();
				return true;
				
			case 2:
				updateAccount();
				return true;
				
			case 3:
				changeInterestRate();
				return true;
				
			case 4:
				System.out.println("\nThank you for choosing Werns Bank.");
				return false;
				
			default:
				System.out.println("\nError! The choice you have entered does not match any of the available choices.");
				input.nextLine();
				return true;
		}
	}
	
	public static void addAccount()
	{
		boolean again = false, againType = false;
		String n = "UnfinishedName", p = "UnfinishedPassword", type = "UnfinishedType";
		double b = 0.0;
		
		do
		{
			again = false;
			System.out.print("\nWhat is the account name? ");
			input.nextLine();
			n = input.nextLine();
			
			for (int i = 0; i < accounts.size(); i++)
			{
				if (accounts.get(i).getName().equals(n))
				{
					again = true;
				}
			}
			
			if (again)
			{
				System.out.println("That name is already taken!");
			}	
			else
			{
				System.out.print("What is the account's password? ");
				p = input.nextLine();
				
				System.out.print("What is the current balance? $");
				b = input.nextDouble();
				
				input.nextLine();
				do
				{
					againType = false;
					System.out.print("What kind of account is this? (Savings / Checking) ");
					
					type = input.nextLine();
					
					if (!type.equals("Savings") && !type.equals("Checking"))
					{
						againType = true;
						System.out.println("Incorrect account type, try again!");
					}
				} while (againType);
			}
		} while (again);
		
		accounts.add(accountMaker.makeAccount(n, p, b, type));
	}
	
	public static void updateAccount()
	{
		System.out.print("\nWhat is the name of the account? ");
		input.nextLine();
		String name = input.nextLine();
		
		Account a = null;
		
		for (int i = 0; i < accounts.size(); i++)
		{
			if (accounts.get(i).getName().equals(name))
			{
				a = accounts.get(i);
			}
		}
		
		if (a == null)
		{
			System.out.println("No account by that name exists. Please try again!");
		}
		else
		{
			if (a.getType().equals("Savings") || a.getType().equals("Checking"))
			{
				System.out.print("Please input the account password for " + a.getName() + "'s account: ");
				String pass = input.nextLine();
				
				if (!pass.equals(a.getPassword()))
				{
					System.out.println("Error, the password given is incorrect. Please try again!");
				}
				else
				{
					int choice = 0;
					boolean chosen = false;
					
					System.out.println();
					System.out.println("Account name: " + a.getName());
					System.out.println("Account balance: $" + a.getBalance());
					System.out.println("Account type: " + a.getType());
					
					System.out.println("\nWhat would you like to do?");
					System.out.println("Choice 1: Change account name");
					System.out.println("Choice 2: Change account password");
					System.out.println("Choice 3: Withdraw from account");
					System.out.println("Choice 4: Deposit to account");
					System.out.println("Choice 5: Exit to main menu");
					System.out.print("Your choice: ");
					choice = input.nextInt();
					
					while (!chosen)
					{
						switch(choice)
						{
							case 1:
								changeAccountName(a);
								chosen = true;
								break;
								
							case 2:
								changeAccountPassword(a);
								chosen = true;
								break;
								
							case 3:
								withdrawFromAccount(a);
								chosen = true;
								break;
								
							case 4:
								depositToAccount(a);
								chosen = true;
								break;
								
							case 5:
								chosen = true;
								break;
								
							default:
								System.out.print("Error, choice not in range! Please re-enter your choice: ");
								choice = input.nextInt();
								break;
						}
					}
				}
			}
			
			else
			{
				System.out.println("Something went wrong during account creation -- account is neither checking nor savings.");
			}
		}
	}
	
	public static void changeAccountName(Account a)
	{
		String accName = a.getName();
		System.out.print("\nWhat is the account's new name? ");
		input.nextLine();
		String name = input.nextLine();
		
		for (int i = 0; i < accounts.size(); i++)
		{
			if (accounts.get(i).getName().equals(accName))
			{
				accounts.get(i).setName(name);
				System.out.println("Account name changed to " + name);
			}
		}
	}
	
	public static void changeAccountPassword(Account a)
	{
		String accName = a.getName();
		System.out.print("\nWhat is the account's new password? ");
		input.nextLine();
		String password = input.nextLine();
		
		for (int i = 0; i < accounts.size(); i++)
		{
			if (accounts.get(i).getName().equals(accName))
			{
				accounts.get(i).setPassword(password);
				System.out.println("Account password changed to " + password);
			}
		}
	}
	
	public static void withdrawFromAccount(Account a)
	{
		String accName = a.getName();
		System.out.print("\nHow much to withdraw? $");
		double with = input.nextDouble();
		
		for (int i = 0; i < accounts.size(); i++)
		{
			if (accounts.get(i).getName().equals(accName))
			{
				accounts.get(i).withdraw(with);
				System.out.println("Withdrawn $" + with + " from your account.");
			}
		}
	}
	
	public static void depositToAccount(Account a)
	{
		String accName = a.getName();
		System.out.print("\nHow much to deposit? $");
		double dep = input.nextDouble();
		
		for (int i = 0; i < accounts.size(); i++)
		{
			if (accounts.get(i).getName().equals(accName))
			{
				accounts.get(i).deposit(dep);
				System.out.println("Deposited $" + dep + " into your account.");
			}
		}
	}
	
	public static void changeInterestRate()
	{
		System.out.println("\nThe current interest rate is: " + SavingsAccount.getInterestRate());
		System.out.print("What should the interest rate be changed to? ");
		double interest = input.nextDouble();
		input.nextLine();
		System.out.println();
		
		for (int i = 0; i < accounts.size(); i++)
		{
			if (accounts.get(i).getType().equals("Savings"))
			{
				((SavingsAccount)accounts.get(i)).updateInterest(interest);
			}
		}
		
		SavingsAccount.setInterestRate(interest);
	}
}