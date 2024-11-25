package test.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import disease.Covid19;
import util.SevereLevel;

public class Covid19Test {

	@Test
	public void testConstructor()
	{
		Covid19 covid19 = new Covid19();
		assertEquals(2,covid19.getReproductionNumber().getMin());
		assertEquals(3,covid19.getReproductionNumber().getMax());
		assertEquals("China",covid19.getCountryOfFirstAppearance());
	}
	
	@Test
	public void testGetSevereLevel()
	{
		Covid19 covid19 = new Covid19();
		assertEquals(SevereLevel.Less,covid19.getSevereLevel(true));
		assertEquals(SevereLevel.SevereIllness,covid19.getSevereLevel(false));
	}
	
	@Test
	public void testMinimumInfectionSpread()
	{
		Covid19 covid19 = new Covid19();
		assertEquals(2,covid19.minimumInfectionSpread(1));
		assertEquals(6,covid19.minimumInfectionSpread(2));
		assertEquals(14,covid19.minimumInfectionSpread(3));
		assertEquals(30,covid19.minimumInfectionSpread(4));
		assertEquals(62,covid19.minimumInfectionSpread(5));
	}
	
	@Test
	public void testToString()
	{
		Covid19 covid19 = new Covid19();
		assertEquals("Covid19",covid19.toString());
	}
}
