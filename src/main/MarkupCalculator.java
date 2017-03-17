package main;

import java.math.BigDecimal;

public class MarkupCalculator {

	private BigDecimal basePrice;
	private int peopleNeeded;
	
	public enum MATERIALS {
		FOOD(new BigDecimal(0.13)),
		PHARMACEUTICALS(new BigDecimal(0.075)),
		ELECTRONICS(new BigDecimal(0.02)),
		OTHER(new BigDecimal(0.0));
		
		private BigDecimal markup;

	    MATERIALS(BigDecimal markup) {
	        this.markup = markup;
	    }

	    public BigDecimal getMarkupVal() {
	        return markup;
	    }
	}
	
	private MATERIALS materialsType;
	
	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public void setPeopleNeeded(int peopleNeeded) {
		this.peopleNeeded = peopleNeeded;
	}
	
	public void setMaterialsType(MATERIALS type){
		this.materialsType = type;
	}
	
	private BigDecimal calculateFlatMarkup() {
		BigDecimal flatMarkup = new BigDecimal(1.05); 
		return this.basePrice.multiply(flatMarkup);
	}
	
	private BigDecimal calculateMarkupFromPeople() {
		if (this.peopleNeeded <= 0){
			return new BigDecimal(0.0);
		}
		
		BigDecimal peopleMarkup = new BigDecimal(1.0);
		BigDecimal markupPerPerson = new BigDecimal(0.012);
		
		for (int i = 0; i < this.peopleNeeded; i++) {
			peopleMarkup.multiply(markupPerPerson);
		}
		
		return peopleMarkup;
	}
	
	private BigDecimal calculateMarkupFromMaterials() {
		return this.materialsType.getMarkupVal();
	}
	
	public BigDecimal getFinalCost() {
		BigDecimal price; 
		BigDecimal one = new BigDecimal(1.0);
		
		price = calculateFlatMarkup();
		price.multiply(one.add(calculateMarkupFromPeople()));
		price.multiply(one.add(calculateMarkupFromMaterials()));
		
		return price;
	}
	
	

	
}
