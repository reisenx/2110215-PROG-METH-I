public class DataSetTester2 {

	public static void main(String[] args) {
		 DataSetTester2 ds2 = new DataSetTester2();
		 Measurable m = ds2.new MeasurableRectangle();
		 
		 DataSet data = new DataSet();
		 data.add(m);
		 System.out.println(data.getMaximum().getMeasure());
	}

	class MeasurableRectangle implements Measurable {
		double area = 1;

		public double getMeasure() {
			return area;
		}
	}
}
