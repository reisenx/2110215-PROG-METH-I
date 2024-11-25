package disease;

import util.*;

public class Covid19 extends Disease{//is kind of disease
	private R0 reproductionNumber;
	private String countryOfFirstAppearance;

	public Covid19() {
		setCountryOfFirstAppearance("China");
		setReproductionNumber(2,3);
	}
	@Override
	public SevereLevel severeLevel(boolean isVaccinated) {
		if(isVaccinated){if(this instanceof Delta){//If this is Delta,different Severelevel
			return SevereLevel.MildOrLess;
		}
		else{
		return SevereLevel.Less;}}
		return SevereLevel.SevereIllness;
	}
	public int minimumInfectionSpread (int n){
		int minimumInfectionSpread=0;
		for(int i=1;i<=n;i++){//Check Figure 1
			minimumInfectionSpread+=(int) Math.pow(getReproductionNumber().getMin(),i);
		}
		return minimumInfectionSpread;
	}

	@Override
	public String toString() {

		return this.getClass().getSimpleName();
	}
	public R0 getReproductionNumber() {
		return reproductionNumber;
	}

	public void setReproductionNumber(int min,int max) {
		this.reproductionNumber = new R0(min,max);
	}

	public String getCountryOfFirstAppearance() {
		return countryOfFirstAppearance;
	}

	public void setCountryOfFirstAppearance(String countryOfFirstAppearance) {
		this.countryOfFirstAppearance = countryOfFirstAppearance;
	}



	

	
}
