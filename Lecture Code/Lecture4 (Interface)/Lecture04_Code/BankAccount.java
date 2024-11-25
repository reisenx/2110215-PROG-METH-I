public class BankAccount implements Measurable {
	private double balance;

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public double getMeasure() {
		return balance;
	}
}
