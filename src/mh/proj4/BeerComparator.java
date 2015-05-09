package mh.proj4;

import java.util.Comparator;

public class BeerComparator implements Comparator<Beer> {

	@Override
	public int compare(Beer arg0, Beer arg1) {
		return new Integer(arg0.getBatchNumber()).compareTo(new Integer(arg1.getBatchNumber()));
	}

}
