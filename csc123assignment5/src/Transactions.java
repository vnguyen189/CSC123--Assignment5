
public class Transactions {
	private int accountNumber;
	private String typeTransactions;
	private double amount;
	private double balance;
	private double creditBalance = 0;
	private double debitBalance = 0;
	private int transactionID;
		
	public Transactions(int transactionID, int accountNumber, String typeTransactions, double amount) {
		super();
		this.transactionID = transactionID;
		this.accountNumber = accountNumber;
		this.typeTransactions = typeTransactions;
		this.amount = amount;
		
		if (typeTransactions == "Credit" || typeTransactions == "credit") {
			creditBalance += amount;
		}
		else if (typeTransactions == "Debit" || typeTransactions == "debit") {
			debitBalance -= amount;
			
		this.balance = this.balance - (creditBalance - debitBalance);
		}
	
	}

	public double accountBalance () {
		return this.balance;
	}

	public String getTypeTransactions() {
		return typeTransactions;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return ""+transactionID+" : " + typeTransactions + " : " + amount + "\n" + "Balance:" + balance;
	}

	public int getUserNumber() {
		return accountNumber;
	}
	
	
}