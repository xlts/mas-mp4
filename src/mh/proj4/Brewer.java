package mh.proj4;

import java.util.Set;
import java.util.TreeSet;

public class Brewer {

	private Set<Beer> beersBrewer = new TreeSet<Beer>(new BeerComparator());
	private Set<Beer> beersQualityTester = new TreeSet<Beer>(new BeerComparator());
}
