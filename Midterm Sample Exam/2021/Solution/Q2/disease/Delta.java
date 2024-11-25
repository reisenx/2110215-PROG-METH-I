package disease;

import util.R0;
import util.SevereLevel;

public class Delta extends Covid19{
	private int spikeProtein;


	public Delta() {
		setCountryOfFirstAppearance("India");
		setReproductionNumber(5,7);
		setSpikeProtein(10);
	}
	public int getSpikeProtein() {
		return spikeProtein;
	}

	public void setSpikeProtein(int spikeProtein) {
		this.spikeProtein = spikeProtein;
	}
}
