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
		
		assertEquals(1591.58, calculator.getFinalCost(), 0.0001);
	}
	
	@Test
	public void testExample2Calculation() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(5432.00); 
		calculator.setPeopleNeeded(1);
		calculator.setMaterialsType(MATERIALS.PHARMACEUTICALS);
		
		assertEquals(6199.81, calculator.getFinalCost(), 0.000001);
	}
	
	@Test
	public void testExample3Calculation() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(12456.95); 
		calculator.setPeopleNeeded(4);
		calculator.setMaterialsType(MATERIALS.OTHER);
		
		assertEquals(13707.63, calculator.getFinalCost(), 0.0001);
	}
	
	@Test
	public void testOnlyFlatMarkup() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(100.00); 
		calculator.setPeopleNeeded(0);
		calculator.setMaterialsType(MATERIALS.OTHER);

		double expected = 105.00;
		
		assertEquals(expected, calculator.getFinalCost(), 0.0001);
	}

	@Test
	public void testExample1CalculationWithStrings() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePriceAsString("$1,299.99"); 
		calculator.setPeopleNeededAsString("3");
		calculator.setMaterialsTypeAsString("food");
		
		assertEquals("$1,591.58", calculator.getFinalCostAsString());
	}
	
	@Test
	public void testExample2CalculationWithStrings() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePriceAsString("$5432.00"); 
		calculator.setPeopleNeededAsString("1");
		calculator.setMaterialsTypeAsString("drugs");
		
		assertEquals("$6,199.81", calculator.getFinalCostAsString());
	}
	
	@Test
	public void testExample3CalculationWithStrings() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePriceAsString("$12,456.95"); 
		calculator.setPeopleNeededAsString("4");
		calculator.setMaterialsTypeAsString("books");
		
		assertEquals("$13,707.63", calculator.getFinalCostAsString());
	}
	
}
