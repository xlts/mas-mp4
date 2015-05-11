package mh.proj4;

import java.util.Set;
import java.util.TreeSet;

public class BreweryEmployee {

	private String name;
	private int id;
	
	private Set<Beer> beersBrewed = new TreeSet<Beer>(new BeerComparator());         //
	private Set<Beer> beersInspected = new TreeSet<Beer>(new BeerComparator());      // -- {ordered}, {subset}
	
	public BreweryEmployee(String name, int id){
		setName(name);
		setId(id);
	}
	
	public void addBeersBrewed(Beer b){
		if (b == null) {
			throw new RuntimeException("Passed a null value");
		}
		beersBrewed.add(b);
		b.setBrewer(this);
	}
	
	public void addBeersInspected(Beer b) {
		if (b == null) {
			throw new RuntimeException("passed a null value");
		}
		if (!beersBrewed.contains(b)){
			throw new RuntimeException("This employee did not brew beer passed as parameter, thus he cannot inspect it");
		}
		beersInspected.add(b);
		b.setInspector(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new RuntimeException("passed a null value");
		}
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		if (id == null) {
			throw new RuntimeException("passed a null value");
		}
		this.id = id;
	}
}
