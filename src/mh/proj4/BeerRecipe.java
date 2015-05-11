package mh.proj4;

import java.util.HashSet;
import java.util.Set;

public class BeerRecipe {

	private String name;
	private int id;
	
	private Set<HopInBeerRecipe> hopsInBeerRecipe = new HashSet<>(); // { bag }
	
	public BeerRecipe(String name, int id) {
		setName(name);
		setId(id);
	}
	
	public int getId() {
		return id;
	}
	
	private void setId(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("passed a null value");
		}
		this.id = id;
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

	public void addHopInBeerRecipe(HopInBeerRecipe e) {
		if (e == null) {
			throw new IllegalArgumentException("passed a null value");
		}
		if (hopsInBeerRecipe.size() == 5) {
			throw new RuntimeException("there may be at most 5 hops in a beer recipe"); //custom business constraint
		}
		if (!hopsInBeerRecipe.contains(e)) {
			hopsInBeerRecipe.add(e);
			e.setBeerRecipe(this);
		}
	}
	
	public void removeHopInBeerRecipe(HopInBeerRecipe e) {
		if (e == null) {
			throw new IllegalArgumentException("passed a null value");
		}
		if (hopsInBeerRecipe.contains(e)){
			hopsInBeerRecipe.remove(e);
			e.setBeerRecipe(null);
			e.setHop(null);
		}
	}
	
}
