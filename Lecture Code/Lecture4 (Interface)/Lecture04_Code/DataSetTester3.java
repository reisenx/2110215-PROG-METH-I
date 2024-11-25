public class DataSetTester3 {
	static int outData;
	public static void main(String[] args) {		
		class MeasurableRectangle implements Measurable {
			double area = 1;			

			public double getMeasure() {
				outData = 10;
				return area;				
			}
		}
		Measurable m = new MeasurableRectangle();
		DataSet data = new DataSet();
		data.add(m);
		System.out.println(data.getMaximum().getMeasure());
		System.out.println(outData);		
	}
}
