package main;

public class MarkupCalculator {

	private double basePrice;
	private int peopleNeeded;
	
	public enum MaterialsType {
		FOOD,
		PHARMACEUTICALS,
		BOOKS,
		ELECTRONICS
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
	
	public double getFinalCost() {
		return this.basePrice;
	}
	
	

	
}
