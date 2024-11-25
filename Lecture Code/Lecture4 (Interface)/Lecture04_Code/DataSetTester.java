public class DataSetTester {

	public static void main(String[] args) {
		DataSet bankData = new DataSet();

		bankData.add(new BankAccount(0));
		bankData.add(new BankAccount(1000));
		bankData.add(new BankAccount(2000));
		Measurable max = bankData.getMaximum();
		System.out.println(max.getMeasure());

		DataSet coinData = new DataSet();
		coinData.add(new Coin(0.25, "quarter"));
		coinData.add(new Coin(0.1, "dime"));
		coinData.add(new Coin(0.05, "nickel"));
		max = coinData.getMaximum();
		System.out.println(max.getMeasure());
		
		
		DataSet mixedData = new DataSet();
		mixedData.add(new Coin(0.25, "quarter"));
		mixedData.add(new BankAccount(1000));		
		max = mixedData.getMaximum();
		System.out.println(max.getMeasure());
	}

}
