package mh.proj4;

import java.util.HashSet;
import java.util.Set;

public class LocalPlantation {

	private String name;
	private double productionOutput;
	
	private Set<Hop> hops = new HashSet<Hop>();
	
	public LocalPlantation(String name, double productionOutput) {
		super();
		setName(name);
		setProductionOutput(productionOutput);
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
	public double getProductionOutput() {
		return productionOutput;
	}
	public void setProductionOutput(Double productionOutput) {
		if (productionOutput == null) {
			throw new IllegalArgumentException("passed a null value");
		}
		this.productionOutput = productionOutput;
	}
	public void addHop(Hop hop) {
		if (!this.hops.contains(hop)) {
			hops.add(hop);
			hop.setLocalPlantation(this);
		}
		
	}
	public Set<Hop> getHops(){
		return new HashSet<Hop>(hops);
	}
}
