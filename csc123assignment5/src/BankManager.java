import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BankManager {

	public static void main(String[] args) throws NoSuchAccountException, AccountClosedException, InsufficientBalanceException, FileNotFoundException {
		Scanner input = new Scanner(System.in);
		int uChoice;
		String firstName, lastName;
		String SNN;
		int uNumber;
		double overDraftLimit, amount;
		int uOriNumber = 999;
		
		System.out.println("1 - Open a Checking account \n"
				+ "2 - Open Saving Account \n"
				+ "3 - List Accounts \n"
				+ "4 - Account Statement \n"
				+ "5 - Deposit funds \n"
				+ "6 - Withdraw funds \n"
				+ "7 - Close an account \n"
				+ "8 - Save Transactions \n"
				+ "9 - Exit");
		
		System.out.println("Please enter your choice: ");
		uChoice = input.nextInt();
		
		while (uChoice == 7 || uChoice == 8) {
			System.out.println("1 - Open a Checking account \n"
					+ "2 - Open Saving Account \n"
					+ "3 - List Accounts \n"
					+ "4 - Account Statement \n"
					+ "5 - Deposit funds \n"
					+ "6 - Withdraw funds \n"
					+ "7 - Close an account \n"
					+ "8 - Save Transactions \n"
					+ "9 - Exit");
			
		System.out.println("Please enter your choice: ");
		uChoice = input.nextInt();
		}
		
		while (uChoice != 1 && uChoice != 2 && uChoice != 3 && uChoice != 4 && uChoice != 5 && uChoice != 6 && uChoice != 7 && uChoice != 8) {
			System.out.println("1 - Open a Checking account \n"
					+ "2 - Open Saving Account \n"
					+ "3 - List Accounts \n"
					+ "4 - Account Statement \n"
					+ "5 - Deposit funds \n"
					+ "6 - Withdraw funds \n"
					+ "7 - Close an account \n"
					+ "8 - Save Transactions \n"
					+ "9 - Exit");
				
			System.out.println("Please enter your choice: ");
			uChoice = input.nextInt();
		}
		
		while (uChoice == 1 || uChoice == 2 || uChoice == 3 || uChoice == 4 || uChoice == 5 || uChoice == 6 || uChoice == 7 || uChoice == 8) {
			if (uChoice == 1) {
				System.out.println("Enter first name: ");
				input.nextLine();
				firstName = input.nextLine();
				
				System.out.println("Enter last name: ");
				lastName = input.nextLine();
				
				System.out.println("Enter social security number: ");
				SNN = input.nextLine();
				
				System.out.println("Enter overdraft limit: ");
				overDraftLimit = input.nextDouble();
				
				Bank.openAccount(firstName, lastName, SNN, "Checking", overDraftLimit);
				Customer customer = new Customer(firstName,lastName,SNN);
				Account account = new Checking(uOriNumber++,"Checking", customer, overDraftLimit);
			
				System.out.println("Thank you, account number is " + account.getAccountNumber());
				
				System.out.println("1 - Open a Checking account \n"
						+ "2 - Open Saving Account \n"
						+ "3 - List Accounts \n"
						+ "4 - Account Statement \n"
						+ "5 - Deposit funds \n"
						+ "6 - Withdraw funds \n"
						+ "7 - Close an account \n"
						+ "8 - Save Transactions \n"
						+ "9 - Exit");
					
				System.out.println("Please enter your choice: ");
				uChoice = input.nextInt();
			}
			else if (uChoice == 2) {
				System.out.println("Enter first name: ");
				input.nextLine();
				firstName = input.nextLine();
				
				System.out.println("Enter last name: ");
				lastName = input.nextLine();
				
				System.out.println("Enter social security number: ");
				SNN = input.nextLine();
				
				Bank.openAccount(firstName, lastName, SNN, "Saving", 0);
				Customer customer = new Customer(firstName,lastName,SNN);
				Account account = new Saving (uOriNumber++, "Saving", customer,0);
				
				System.out.println("Thank you, account number is " + account.getAccountNumber());
				
				System.out.println("1 - Open a Checking account \n"
						+ "2 - Open Saving Account \n"
						+ "3 - List Accounts \n"
						+ "4 - Account Statement \n"
						+ "5 - Deposit funds \n"
						+ "6 - Withdraw funds \n"
						+ "7 - Close an account \n"
						+ "8 - Save Transactions \n"
						+ "9 - Exit");
				
				System.out.println("Please enter your choice: ");
				uChoice = input.nextInt();
			}
			
			else if (uChoice == 3) {			
				System.out.println("Enter account number: ");
				uNumber = input.nextInt();
				try {
				if (Bank.findAccount(uNumber)==null) throw new NoSuchAccountException("Account not found");
				else
					Bank.printAccounts(uNumber); }
				catch (NoSuchAccountException a) {
					System.out.println("Account not found");
				}
				
				System.out.println("1 - Open a Checking account \n"
						+ "2 - Open Saving Account \n"
						+ "3 - List Accounts \n"
						+ "4 - Account Statement \n"
						+ "5 - Deposit funds \n"
						+ "6 - Withdraw funds \n"
						+ "7 - Close an account \n"
						+ "8 - Save Transactions \n"
						+ "9 - Exit");
					
				System.out.println("Please enter your choice: ");
				uChoice = input.nextInt();
			}
			
			else if (uChoice == 4) {
				System.out.println("Enter account number: ");
				uNumber = input.nextInt();
				
				try {
				if (Bank.findAccount(uNumber)==null) throw new NoSuchAccountException("Account not found");
				else
					Bank.viewTransactions(uNumber);	
				}
				catch (NoSuchAccountException a) {
					System.out.println("Account not found");
				}
				System.out.println("1 - Open a Checking account \n"
						+ "2 - Open Saving Account \n"
						+ "3 - List Accounts \n"
						+ "4 - Account Statement \n"
						+ "5 - Deposit funds \n"
						+ "6 - Withdraw funds \n"
						+ "7 - Close an account \n"
						+ "8 - Save Transactions \n"
						+ "9 - Exit");
					
				System.out.println("Please enter your choice: ");
				uChoice = input.nextInt();
			}
			else if (uChoice == 5) {
				System.out.println("Enter account number: ");
				uNumber = input.nextInt();
				
				System.out.println("Enter the amount to deposit: ");
				amount = input.nextDouble();
				
				try {
				if (Bank.findAccount(uNumber)==null ) throw new NoSuchAccountException("Account not found");
				else if (Bank.findAccount(uNumber).isOpen() == false)
					System.out.printf("Deposit failed, the balance is: %.2f \n", Bank.viewBalance(uNumber));
				else if (Bank.findAccount(uNumber).isOpen() == true) {
					Bank.deposit(uNumber, amount);
				System.out.printf("Deposit successful, the new balance is: %.2f \n", Bank.viewBalance(uNumber)); }
				}
				catch(NoSuchAccountException a) {
					System.out.println("Account not found");
				}
				catch(AccountClosedException b) {
					System.out.printf("Deposit failed, the balance is: %.2f \n", Bank.viewBalance(uNumber));
				}
				System.out.println("1 - Open a Checking account \n"
						+ "2 - Open Saving Account \n"
						+ "3 - List Accounts \n"
						+ "4 - Account Statement \n"
						+ "5 - Deposit funds \n"
						+ "6 - Withdraw funds \n"
						+ "7 - Close an account \n"
						+ "8 - Save Transactions \n"
						+ "9 - Exit");
					
				System.out.println("Please enter your choice: ");
				uChoice = input.nextInt();
			}
			
			else if (uChoice == 6) {
				System.out.println("Enter account number: ");
				uNumber = input.nextInt();
				
				System.out.println("Enter the amount to withdraw: ");
				amount = input.nextDouble();
				try {
				if (Bank.findAccount(uNumber)==null) throw new NoSuchAccountException("Account not found");
			
				if (Bank.withdraw(uNumber, amount) == true)
				System.out.printf("Withdrawal successful, the new balance is: %.2f \n",Bank.viewBalance(uNumber));
				else 
					System.out.printf("Withdrawal failed, the balance is: %.2f \n", Bank.viewBalance(uNumber));
				}
				catch (NoSuchAccountException a) {
					System.out.println("Account not found");
				}
				catch (InsufficientBalanceException b) {
					System.out.printf("Withdrawal failed, the balance is: %.2f \n", Bank.viewBalance(uNumber));
				}
				catch (AccountClosedException c) {
					System.out.printf("Withdrawal failed, the balance is: %.2f \n", Bank.viewBalance(uNumber));
				}
				
				System.out.println("1 - Open a Checking account \n"
						+ "2 - Open Saving Account \n"
						+ "3 - List Accounts \n"
						+ "4 - Account Statement \n"
						+ "5 - Deposit funds \n"
						+ "6 - Withdraw funds \n"
						+ "7 - Close an account \n"
						+ "8 - Save Transactions \n"
						+ "9 - Exit");
					
				System.out.println("Please enter your choice: ");
				uChoice = input.nextInt();
			}
			else if (uChoice == 7) {
				System.out.println("Enter account number: ");
				uNumber = input.nextInt();
				
				try {
				if (Bank.findAccount(uNumber)==null) throw new NoSuchAccountException("Account not found");
				else {
					Bank.closeAccount(uNumber);
					
				System.out.printf("Account closed, current balance is %.2f, deposits are no longer possible \n", Bank.viewBalance(uNumber));
					}}
				catch (NoSuchAccountException a) {
				System.out.println("Account not found");
				}
				
				System.out.println("1 - Open a Checking account \n"
						+ "2 - Open Saving Account \n"
						+ "3 - List Accounts \n"
						+ "4 - Account Statement \n"
						+ "5 - Deposit funds \n"
						+ "6 - Withdraw funds \n"
						+ "7 - Close an account \n"
						+ "8 - Save Transactions \n"
						+ "9 - Exit");
					
				System.out.println("Please enter your choice: ");
				uChoice = input.nextInt();
				
			}
			else if(uChoice == 8) {
				System.out.println("Enter account number: ");
				uNumber = input.nextInt();
				
				File targetFile = new File("transactions.txt");
				PrintWriter writer = null;
				writer = new PrintWriter(targetFile);
				writer.println(Bank.viewTransactions(uNumber));
				writer.close();
				
				System.out.println("Success! Your transaction is saved in transactions.txt");
				
				System.out.println("1 - Open a Checking account \n"
						+ "2 - Open Saving Account \n"
						+ "3 - List Accounts \n"
						+ "4 - Account Statement \n"
						+ "5 - Deposit funds \n"
						+ "6 - Withdraw funds \n"
						+ "7 - Close an account \n"
						+ "8 - Save Transactions \n"
						+ "9 - Exit");
					
				System.out.println("Please enter your choice: ");
				uChoice = input.nextInt();
			}
		
			else if (uChoice == 9) {
				System.exit(0);
				input.close();	
			}	
	}
		
		
}}
		
	
	