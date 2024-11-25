package test.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import disease.Covid19;
import disease.Delta;
import util.SevereLevel;

public class DeltaTest {
	@Test
	public void testConstructor()
	{
		Covid19 delta = new Delta();
		assertEquals(5,delta.getReproductionNumber().getMin());
		assertEquals(7,delta.getReproductionNumber().getMax());
		assertEquals("India",delta.getCountryOfFirstAppearance());
		assertEquals(10,((Delta)delta).getSpikeProtein());
	}
	
	@Test
	public void testGetSevereLevel()
	{
		Covid19 delta = new Delta();
		assertEquals(SevereLevel.MildOrLess,delta.getSevereLevel(true));
		assertEquals(SevereLevel.SevereIllness,delta.getSevereLevel(false));
	}
	
	@Test
	public void testMinimumInfectionSpread()
	{
		Covid19 delta = new Delta();
		assertEquals(5,delta.minimumInfectionSpread(1));
		assertEquals(30,delta.minimumInfectionSpread(2));
		assertEquals(155,delta.minimumInfectionSpread(3));
		assertEquals(780,delta.minimumInfectionSpread(4));
		assertEquals(3905,delta.minimumInfectionSpread(5));
	}
	
	@Test
	public void testToString()
	{
		Delta delta = new Delta();
		assertEquals("Delta",delta.toString());
	}
	
	
}
