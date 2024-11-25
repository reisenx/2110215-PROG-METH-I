public class Coin implements Measurable {
	private double value;
	
	public Coin(double value, String coinName){
		this.value = value;
	}

	public double getMeasure() {
		return value;
	}

}
