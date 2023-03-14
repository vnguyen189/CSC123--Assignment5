
public class Checking extends Account {
	private double balance = 0;
	private double overDraftLimit;
	
	public Checking(int accountNumber, String type, Customer accountHolder, double limit) {
		super(accountNumber, type, accountHolder, limit);
		this.overDraftLimit = limit;
	}

	public boolean withdraw(double amount) throws AccountClosedException {
		if(balance-amount < overDraftLimit) {
			if(this.balance <= 0 && !isOpen()) throw new AccountClosedException("Withdrawal failed, account is closed and you have zero or positive balance");
			return false;}
		else 
		balance = balance-amount;
			return true;
	}
	
	public boolean deposit(double amount) throws AccountClosedException {
		if(amount < 0 || !isOpen()) {
			if(this.balance >= 0 && !isOpen()) throw new AccountClosedException("Deposit failed, account is closed and you have zero or positive balance");
		return false; }
		else 
		this.balance = this.balance + amount;
		return true;
	
	}

	public double getBalance() {
		return balance;
	}
	

}
