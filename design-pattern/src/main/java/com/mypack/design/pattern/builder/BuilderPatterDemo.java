package com.mypack.design.pattern.builder;

public class BuilderPatterDemo {

	public static void main(String[] args) {
		//Creating account with Account Number only
		BankAccount bankAccount1 = new BankAccount.BankAccountBuilder(100l)
				.build();
		
		System.out.println(bankAccount1);
		
		//Creating account with Account Number and Owner
		BankAccount bankAccount2 = new BankAccount.BankAccountBuilder(1001)
				.owner("Imran")
				.build();
		
		System.out.println(bankAccount2);
		
		//Creating account with Account Number, Owner and branch
		BankAccount bankAccount3 = new BankAccount.BankAccountBuilder(1001)
				.owner("Imran")
				.branch("Delhi")
				.build();
		
		System.out.println(bankAccount3);
		
		//Creating account with Account Number, Owner, branch and balance
		BankAccount bankAccount4 = new BankAccount.BankAccountBuilder(1001)
				.owner("Imran")
				.branch("Delhi")
				.balance(1000.12)
				.build();
		
		System.out.println(bankAccount4);
		
		//Creating account with Account Number, Owner, branch, balance and interest rate
		BankAccount bankAccount5 = new BankAccount.BankAccountBuilder(1001)
				.owner("Imran")
				.branch("Delhi")
				.balance(1000.12)
				.interestRate(2.6)
				.build();
		
		System.out.println(bankAccount5);

	}

}

/***
 * Immutable class
 * @author lenovo
 *
 */
class BankAccount {
	
	private long accountNumber; 
	private String owner;
	private String branch;
	private double balance;
	private double interestRate;
	
	private BankAccount(BankAccountBuilder bankAccountBuilder) {
		this.accountNumber = bankAccountBuilder.accountNumber;
		this.owner = bankAccountBuilder.owner;
		this.branch = bankAccountBuilder.branch;
		this.balance = bankAccountBuilder.balance;
		this.interestRate = bankAccountBuilder.interestRate;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public String getBranch() {
		return branch;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public String toString() {
		return "accountNumber: " + accountNumber +", owner: " + owner + ", branch: " + branch + ", balance: " + balance + ", interestRate: " + interestRate;
	}

	/***
	 * Builder class
	 * @author lenovo
	 *
	 */
	static class BankAccountBuilder {
		private long accountNumber; //maindatory field
		private String owner;
		private String branch;
		private double balance;
		private double interestRate;
		
		public BankAccountBuilder(long accountNumber) {
			this.accountNumber = accountNumber;
		}
		
		BankAccountBuilder owner(String owner) {
			this.owner = owner;
			return this;
		}
		
		BankAccountBuilder branch(String branch) {
			this.branch = branch;
			return this;
		}
		
		BankAccountBuilder balance(double balance) {
			this.balance = balance;
			return this;
		}
		
		BankAccountBuilder interestRate(double interestRate) {
			this.interestRate = interestRate;
			return this;
		}
		
		BankAccount build() {
			BankAccount bankAccount = new BankAccount(this);
			return bankAccount;
			
		}
	}
}
