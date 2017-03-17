package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.MarkupCalculator;
import main.MarkupCalculator.MATERIALS;

public class TestMarkupCalculator {
	
	@Test
	public void testExample1Calculation() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(1299.99); 
		calculator.setPeopleNeeded(3);
		calculator.setMaterialsType(MATERIALS.FOOD);
		
		assertEquals(1591.58, calculator.getFinalCost(), 0.001);
	}
	
	@Test
	public void testExample2Calculation() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(5432.00); 
		calculator.setPeopleNeeded(1);
		calculator.setMaterialsType(MATERIALS.PHARMACEUTICALS);
		
		assertEquals(6199.81, calculator.getFinalCost(), 0.001);
	}
	
	@Test
	public void testExample3Calculation() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(12456.95); 
		calculator.setPeopleNeeded(4);
		calculator.setMaterialsType(MATERIALS.OTHER);
		
		assertEquals(13707.63, calculator.getFinalCost(), 0.001);
	}
	
	@Test
	public void testOnlyFlatMarkup() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(100.00); 
		calculator.setPeopleNeeded(0);
		calculator.setMaterialsType(MATERIALS.OTHER);

		double expected = 105.00;
		
		assertEquals(expected, calculator.getFinalCost(), 0.001);
	}
	
}
