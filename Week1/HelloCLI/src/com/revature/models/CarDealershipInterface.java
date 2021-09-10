package com.revature.models;

public interface CarDealershipInterface {

	public Car[] getAllCars();
	
	public Car getCarById(int id);
	
	public void addCar(Car car);
	
	public void getCarsByColor(String color);
	
}
