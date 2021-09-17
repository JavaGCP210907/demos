package com.revature.models;

public class Dinosaur {

    int id;
    String species;
    int legs;
    double weight;
    boolean isScary;


    //boilerplate code-------------------------------------------------------------

    public Dinosaur() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Dinosaur(int id, String species, int legs, double weight, boolean isScary) {
        super();
        this.id = id;
        this.species = species;
        this.legs = legs;
        this.weight = weight;
        this.isScary = isScary;
    }


    public Dinosaur(String species, int legs, double weight, boolean isScary) {
        super();
        this.species = species;
        this.legs = legs;
        this.weight = weight;
        this.isScary = isScary;
    }


    @Override
    public String toString() {
        return "Dinosaur [id=" + id + ", species=" + species + ", legs=" + legs + ", weight=" + weight + ", isScary="
                + isScary + "]";
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public int getLegs() {
		return legs;
	}


	public void setLegs(int legs) {
		this.legs = legs;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public boolean isScary() {
		return isScary;
	}


	public void setScary(boolean isScary) {
		this.isScary = isScary;
	}
    
    
    
}
