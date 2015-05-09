package mh.proj4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Beer {

	private int batchNumber; // {unique}
	private double abv; // 0 < abv < 20 (constraint of attribute)
	
	public static List<Beer> extent = new ArrayList<Beer>();
	private static final String FILENAME = "beer.txt";
	
	public Beer() {
		extent.add(this);
	}
	
	public Beer(int batchNumber, double abv){
		setBatchNumber(batchNumber);
		setAbv(abv);
		
		extent.add(this);
	}
	
	
	public int getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(Integer batchNumber) {
		if (batchNumber == null) {
			throw new IllegalArgumentException("Passed a null value");
		}
		if (containsBatchNumber(batchNumber)) {
			throw new IllegalArgumentException("A beer exists with this batch number");
		}
		this.batchNumber = batchNumber;
	}
	
	private boolean containsBatchNumber(int batchNumber){
		for (Beer b : Beer.extent) {
			if (b.getBatchNumber() == batchNumber) {
				return true;
			}
		}
		return false;
	}

	public double getAbv() {
		return abv;
	}

	public void setAbv(Double abv) {
		if (abv == null) {
			throw new IllegalArgumentException("Passed a null value");
		}
		if (abv <= 0 || abv > 20) {
			throw new IllegalArgumentException("parameter exceeds bounded values");
		}
		this.abv = abv;
	}
	
	public static void saveExtent(){
		ObjectOutputStream stream = null;
		
		try {
			
			stream = new ObjectOutputStream(new FileOutputStream(new File(FILENAME)));
			stream.writeObject(extent);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void loadExtent(){
		ObjectInputStream stream = null;
		
		try {
			stream = new ObjectInputStream(new FileInputStream(new File(FILENAME)));
			extent = (ArrayList<Beer>) stream.readObject();
		} catch (IOException e){
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static List<Beer> getExtent() {
		return new ArrayList<Beer>(extent);
	}
	
}
