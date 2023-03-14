public class Account {
	public Customer customer;
	private String type;
	private boolean accountOpen;
	private double balance;
	private double limit;
	private int accountNumber;
	
	public Account(int accountNumber, String type, Customer accountHolder, double limit) {	
		this.accountNumber = accountNumber;
		this.type = type;
		this.customer = accountHolder;
		this.limit = limit;
		accountOpen=true;
	
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public boolean withdraw(double amount) throws AccountClosedException, InsufficientBalanceException {
		if(this.balance <= limit && !isOpen()) throw new AccountClosedException("Withdrawal failed, account is closed and you have zero or positive balance");
		
		else if(this.balance-amount < limit) throw new InsufficientBalanceException("Balance is less than the withdrawal amount");
		
		else if (this.balance-amount >= limit && isOpen() == true) 
		this.balance=this.balance-amount;
		return true; 
		
	}
	
	public boolean deposit(double amount) throws AccountClosedException {
		if(amount < 0 || !isOpen()) {
			if(this.balance >= 0 && !isOpen()) throw new AccountClosedException("Deposit failed, account is closed and you have zero or positive balance");
		return false; }
		this.balance += amount;
		return true;
	}
	
	public boolean isOpen() {
		return this.accountOpen;
	}
	
	public void closeAccount() {
		this.accountOpen = false;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public String toString() {
		return "("+this.type+")"+ customer + " : ";
		
	}
	
}