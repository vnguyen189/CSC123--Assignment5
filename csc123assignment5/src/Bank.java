import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Bank {
	private static ArrayList<Transactions> transactions = new ArrayList<Transactions>();
	public static int accountNumber = 999;
	public static int transactionID = 5744;	
	static Map<Integer, Account> accountLists = new TreeMap<Integer, Account>();

	private Bank() {
	}
	
	public static Account openAccount(String firstName, String lastName, String SSN, String accountType, double limit) {
		
		Customer customer = new Customer(firstName, lastName, SSN);
		if (accountType == "Saving") {
		Account account = new Saving (accountNumber,accountType, customer,limit);
		accountLists.put(accountNumber, account);
		accountNumber++;
		return account;
		}
		else if (accountType == "Checking") {
		Account account = new Checking (accountNumber,accountType, customer,limit);
		accountLists.put(accountNumber, account);
		accountNumber++;
		return account;
		}
		return null;

	}
	
	public static void printAccounts(int accountNumbers) {
		Set<Integer> keys= accountLists.keySet();
		for(Integer key:keys) {
			if (accountLists.get(key).isOpen() == true) 
		System.out.println(accountLists.get(key).getAccountNumber() + accountLists.get(key).toString() + accountLists.get(key).getBalance() + " : " +  "Account Open");
			else
		System.out.println(accountLists.get(key).getAccountNumber() + accountLists.get(key).toString() + accountLists.get(key).getBalance() + " : " +  "Account Closed");
		}
	}	
	
	public static int getUserNumber() {
		return accountNumber;
		}
	
	public static ArrayList<String> viewTransactions(int accountNumber) {
		ArrayList<String> transactionsList = new ArrayList<String>();
		for(Transactions t: transactions) {
			if (t.getUserNumber() == accountNumber) 	
		transactionsList.add(t.getTransactionID() + " : " +t.getTypeTransactions() + " : " + t.getAmount() + "\n");
	}
		transactionsList.add("Balance: \n");
		transactionsList.add(""+ findAccount(accountNumber).getBalance() + "");
		return transactionsList;
		}

	public static Account findAccount(int accountNumber) {
		Set<Integer> keys= accountLists.keySet();
		for(Integer key:keys) {
			if (key == accountNumber) 
				return accountLists.get(key);
		}
		return null;
	}
	
	public static boolean deposit(int accountNumber, double amount) throws NoSuchAccountException, AccountClosedException {
		if (findAccount(accountNumber).deposit(amount) == true) 
			transactions.add(new Transactions(transactionID++, accountNumber, "Credit", amount));	
			return true; 
    }

	public static boolean withdraw(int accountNumber, double amount) throws NoSuchAccountException, InsufficientBalanceException, AccountClosedException{
		if (findAccount(accountNumber).withdraw(amount) == true) {
			transactions.add(new Transactions(transactionID++, accountNumber, "Debit", amount));	
			return true;
		}
		else throw new InsufficientBalanceException("Account do not exist");
			
	}
    
	public  static double viewBalance (int accountNumber) throws NoSuchAccountException {
		if (findAccount(accountNumber) == null) throw new NoSuchAccountException("Account do not exist");		
		else if (findAccount(accountNumber) != null) {
			Set<Integer> keys= accountLists.keySet();
			for(Integer key:keys) {
				if (accountLists.get(key).getAccountNumber() == accountNumber) 
			return accountLists.get(key).getBalance();
			}
		} return 0.0;
			}
    	
	public static boolean closeAccount(int accountNumber) throws NoSuchAccountException {
		if (findAccount(accountNumber) == null) throw new NoSuchAccountException("Account do not exist"); 
		else {
			findAccount(accountNumber).closeAccount();
			return true;
		}
    }
    
	
}
