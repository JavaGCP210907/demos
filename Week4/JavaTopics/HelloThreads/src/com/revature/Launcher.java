package com.revature;

public class Launcher {

	public static void main(String[] args) {
		
		CoolThread t1 = new CoolThread();
		CoolThread t2 = new CoolThread();
		
		//setting priority for t1, which is a value between 1-10
		//the higher the number, the more priority the Thread has over others
		t1.setPriority(1); //this makes t1 start last
		//t1.setPriority(10); //this would make t1 start first (but not necessarily stay first)

		System.out.println("Before Threads start() methods------------");
		
		t1.start();
		t2.start();
		
		CoolThread t3 = new CoolThread();
		t3.start();
		
		CoolThread t4 = new CoolThread();
		t4.start();

	}

}
