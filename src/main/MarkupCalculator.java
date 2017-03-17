package main;

public class MarkupCalculator {

	private double basePrice;
	private int peopleNeeded;
	
	public enum MATERIALS {
		FOOD(0.13),
		PHARMACEUTICALS(0.075),
		ELECTRONICS(0.02),
		OTHER(0.0);
		
		private double markup;

	    MATERIALS(double markup) {
	        this.markup = markup;
	    }

	    public double getMarkupVal() {
	        return markup;
	    }
	}
	
	private MATERIALS materialsType;
	
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public void setPeopleNeeded(int peopleNeeded) {
		this.peopleNeeded = peopleNeeded;
	}
	
	public void setMaterialsType(MATERIALS type){
		this.materialsType = type;
	}
	
	private double calculateFlatMarkup() {
		return this.basePrice*1.05;
	}
	
	private double calculateMarkupFromPeople() {
		if (this.peopleNeeded <= 0){
			return 0.0;
		}
		
		double peopleMarkup = 1.0;
		
		for (int i = 0; i < this.peopleNeeded; i++) {
			peopleMarkup *= (0.012);
		}
		
		return peopleMarkup;
	}
	
	private double calculateMarkupFromMaterials() {
		return this.materialsType.getMarkupVal();
	}
	
	public double getFinalCost() {
		double price; 
		
		price = calculateFlatMarkup()*(1.00 + calculateMarkupFromPeople())*(1.00 + calculateMarkupFromMaterials());
		
		return price;
	}
	
	

	
}
