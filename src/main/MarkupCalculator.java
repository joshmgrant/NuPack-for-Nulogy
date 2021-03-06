package main;

import java.text.NumberFormat;
import java.util.Locale;

public class MarkupCalculator {
	
	/**
	 * Members
	 */
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
	
	/**
	 * Constructors
	 */
	public MarkupCalculator() {
		super();
	}
	
	public MarkupCalculator(String basePrice, String peopleNeeded, String materialsType) {
		setBasePriceAsString(basePrice);
		setPeopleNeededAsString(peopleNeeded);
		setMaterialsTypeAsString(materialsType);
	}
	
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	public void setBasePriceAsString(String basePrice){
		basePrice = basePrice.replace("$", "");
		basePrice = basePrice.replace(",", "");
		setBasePrice(Double.parseDouble(basePrice));
	}
	
	public void setPeopleNeededAsString(String peopleNeeded) {
		peopleNeeded = peopleNeeded.replace("people", "");
		peopleNeeded = peopleNeeded.replace("person", "");
		peopleNeeded = peopleNeeded.trim();
		this.peopleNeeded = Integer.parseInt(peopleNeeded);
	}
	
	public void setMaterialsTypeAsString(String type) {
		type = type.toLowerCase();
		
		switch(type) {
			case "food":
				this.materialsType = MATERIALS.FOOD;
				break;
			case "pharmaceuticals": case "drugs":
				this.materialsType = MATERIALS.PHARMACEUTICALS;
				break;
			case "electronics":
				this.materialsType = MATERIALS.ELECTRONICS;
				break;
			default:
				this.materialsType = MATERIALS.OTHER;
				break;
		}
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
		
		double peopleMarkup = 0.0;
		
		for (int i = 0; i < this.peopleNeeded; i++) {
			peopleMarkup += 0.012;
		}
		
		return peopleMarkup;
	}
	
	private double calculateMarkupFromMaterials() {
		return this.materialsType.getMarkupVal();
	}
	
	private double roundToTwoDecimalPlaces(double d) {
		double result = d*100;
		result = Math.round(result);
		result = result/100;
		return result;
	}
	
	public double calculateFinalCost() {
		double price; 
		
		price = calculateFlatMarkup();
		price += calculateFlatMarkup()*calculateMarkupFromPeople();
		price += calculateFlatMarkup()*calculateMarkupFromMaterials();
		
		return roundToTwoDecimalPlaces(price);
	}
	
	public String getFinalCost() {
		double finalCost = calculateFinalCost();
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.CANADA);
		return formatter.format(finalCost);
	}

	
}
