package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import main.MarkupCalculator;
import main.MarkupCalculator.MaterialsType;

public class TestMarkupCalculator {
	
	@Test
	public void testExampleCalculation() {
		MarkupCalculator calculator = new MarkupCalculator();
		
		calculator.setBasePrice(5432.00); 
		calculator.setPeopleNeeded(1);
		calculator.setMaterialsType(MaterialsType.PHARMACEUTICALS);
		
		assertEquals(calculator.getFinalCost(), 6199.81, 0.001);
	}
	

}
