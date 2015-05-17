package mh.proj4;

import java.util.ArrayList;
import java.util.List;

public class BeerRecipe {

	private String name;
	private int id;
	
	private List<HopInBeerRecipe> hopsInBeerRecipe = new ArrayList<>(); // { bag }
	
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
		if (hopsInBeerRecipe.size() == 10) {
			throw new RuntimeException("there may be at most 10 hops in a beer recipe (but they can repeat)"); //custom business constraint
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
		if (hopsInBeerRecipe.size() == 1){
			throw new RuntimeException("there must be at least 1 hop in beer recipe");
		}
		if (hopsInBeerRecipe.contains(e)){
			hopsInBeerRecipe.remove(e);
			e.setBeerRecipe(null);
			e.setHop(null);
		}
	}
	
	public List<HopInBeerRecipe> getHopsInBeerRecipe(){
		return new ArrayList<>(hopsInBeerRecipe);
	}
	
}
