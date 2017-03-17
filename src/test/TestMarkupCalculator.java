package test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import main.MarkupCalculator;
import main.MarkupCalculator.MATERIALS;

public class TestMarkupCalculator {
	
	@Test
	public void testExample1Calculation() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(new BigDecimal(1299.99)); 
		calculator.setPeopleNeeded(3);
		calculator.setMaterialsType(MATERIALS.FOOD);
		
		assertEquals(new BigDecimal(1591.58), calculator.getFinalCost());
	}
	
	@Test
	public void testExample2Calculation() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(new BigDecimal(5432.00)); 
		calculator.setPeopleNeeded(1);
		calculator.setMaterialsType(MATERIALS.PHARMACEUTICALS);
		
		assertEquals(new BigDecimal(6199.81), calculator.getFinalCost());
	}
	
	@Test
	public void testExample3Calculation() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(new BigDecimal(12456.95)); 
		calculator.setPeopleNeeded(4);
		calculator.setMaterialsType(MATERIALS.OTHER);
		
		assertEquals(new BigDecimal(13707.63), calculator.getFinalCost());
	}
	
	@Test
	public void testOnlyFlatMarkup() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(new BigDecimal(100.00)); 
		calculator.setPeopleNeeded(0);
		calculator.setMaterialsType(MATERIALS.OTHER);

		BigDecimal expected = new BigDecimal(105.00);
		
		assertEquals(expected, calculator.getFinalCost());
	}
	
}
