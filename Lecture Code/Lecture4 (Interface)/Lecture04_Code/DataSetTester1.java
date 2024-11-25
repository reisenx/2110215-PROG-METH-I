public class DataSetTester1 {
	public static void main(String[] args) {
		class MeasurableRectangle implements Measurable {
			double area = 1;

			public double getMeasure() {
				return area;
			}
		}
		Measurable m = new MeasurableRectangle();
		DataSet data = new DataSet();
		data.add(m);
		System.out.println(data.getMaximum().getMeasure());
	}
}
