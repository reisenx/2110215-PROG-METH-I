
public class DataSetTester4 {

	public static void main(String[] args) {
		DataSet mixedData = new DataSet();
		int count = 10;
		
		// TODO Auto-generated method stub
		Measurable cash = new Measurable() {
				public double getMeasure() {
					return 1000;
				}
			};
		
		mixedData.add(cash);
		mixedData.add(new Measurable() {
			public double getMeasure() {
				return count*20;
			}
		});
		
		System.out.println(mixedData.getCount());
		System.out.println(mixedData.getSum());
	}

}
