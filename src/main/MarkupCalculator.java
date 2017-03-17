package main;

public class MarkupCalculator {

	private double basePrice;
	private int peopleNeeded;
	
	public enum MaterialsType {
		FOOD(1.13),
		PHARMACEUTICALS(1.075),
		ELECTRONICS(1.02),
		OTHER(1.0);
		
		private double markup;

	    MaterialsType(double markup) {
	        this.markup = markup;
	    }

	    public double getMarkupVal() {
	        return markup;
	    }
	}
	
	private MaterialsType materialsType;
	
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public void setPeopleNeeded(int peopleNeeded) {
		this.peopleNeeded = peopleNeeded;
	}
	
	public void setMaterialsType(MaterialsType type){
		this.materialsType = type;
	}
	
	private double calculateFlatMarkup() {
		return this.basePrice*1.05;
	}
	
	private double calculateMarkupFromPeople() {
		double peopleMarkup = 1.0;
		
		for (int i = 0; i < this.peopleNeeded; i++) {
			peopleMarkup *= (1.012);
		}
		
		return peopleMarkup;
	}
	
	private double calculateMarkupFromMaterials() {
		return this.materialsType.getMarkupVal();
	}
	
	public double getFinalCost() {
		double price; 
		
		price = calculateFlatMarkup();
		price *= calculateMarkupFromPeople();
		price *= calculateMarkupFromMaterials();
		
		return price;
	}
	
	

	
}
