package mh.proj4;

import java.util.HashSet;
import java.util.Set;


public class Hop {

	private String name;
	private double alphaAcidPercentage;
	
	private Set<HopInBeerRecipe> hopsInBeerRecipe = new HashSet<>(); // { bag }
	
	private Importer importer;                        // 
	private LocalPlantation localPlantation;		 // -- { XOR }
	
	public Hop(String name, double alphaAcidPercentage) {
		super();
		setName(name);
		setAlphaAcidPercentage(alphaAcidPercentage);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("passed a null value");
		}
		this.name = name;
	}

	public double getAlphaAcidPercentage() {
		return alphaAcidPercentage;
	}

	public void setAlphaAcidPercentage(Double alphaAcidPercentage) {
		if (alphaAcidPercentage == null) {
			throw new IllegalArgumentException("passed a null value");
		}
		this.alphaAcidPercentage = alphaAcidPercentage;
	}

	public void addHopInBeerRecipe(HopInBeerRecipe e) {
		if (e == null) {
			throw new IllegalArgumentException("passed a null value");
		}
		if (!hopsInBeerRecipe.contains(e)) {
			hopsInBeerRecipe.add(e);
			e.setHop(this);
		}
	}
	
	public void removeHopInBeerRecipe(HopInBeerRecipe e) {
		if (e == null) {
			throw new IllegalArgumentException("passed a null value");
		}
		if (hopsInBeerRecipe.contains(e)){
			hopsInBeerRecipe.remove(e);
			e.setHop(null);
			e.setBeerRecipe(null);
		
		}
	}

	public Importer getImporter() {
		return importer;
	}

	public void setImporter(Importer importer) {
		if (localPlantation != null) {
			setLocalPlantation(null);
		}
		if (this.importer != importer) {
			this.importer = importer;
			importer.addHop(this);
		}
	}

	public LocalPlantation getLocalPlantation() {
		return localPlantation;
	}

	public void setLocalPlantation(LocalPlantation localPlantation) {
		if (importer != null){
			setImporter(null);
		}
		if (localPlantation != this.localPlantation){
			this.localPlantation = localPlantation;
			localPlantation.addHop(this);
		}
	}
	
}
