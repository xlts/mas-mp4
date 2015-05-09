package mh.proj4;

import java.util.HashSet;
import java.util.Set;

public class Importer {

	private String name;
	private double customsChargeValue;
	
	private Set<Hop> hops = new HashSet<Hop>();
	
	public Importer(String name, double customsChargeValue) {
		super();
		setName(name);
		setCustomsChargeValue(customsChargeValue);
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
	public double getCustomsChargeValue() {
		return customsChargeValue;
	}
	public void setCustomsChargeValue(Double customsChargeValue) {
		if (customsChargeValue == null) {
			throw new IllegalArgumentException("passed a null value");
		}
		this.customsChargeValue = customsChargeValue;
	}
	public void addHop(Hop hop) {
		if (!this.hops.contains(hop)) {
			hops.add(hop);
			hop.setImporter(this);
		}
		
	}
	
	public Set<Hop> getHops(){
		return new HashSet<Hop>(hops);
	}
}
