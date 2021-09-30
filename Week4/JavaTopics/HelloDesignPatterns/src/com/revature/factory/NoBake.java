package com.revature.factory;

public class NoBake implements Cookie {

	@Override
	public void getBaked() {
		System.out.println("NoBake Cookie is getting baked!");
	}

}
