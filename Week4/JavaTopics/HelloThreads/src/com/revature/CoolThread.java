package com.revature;

//This Thread will extend Thread and override the run() method
public class CoolThread extends Thread {

	//the run() method is the process/behavior you want your Thread to have
	@Override
	public void run() {
		
		for(int i = 0; i<10; ++i) {
			//this StringBuffer will be populated with the name of the current Thread we're in
			StringBuffer sb = new StringBuffer(Thread.currentThread().getName());
			sb.append(" is working...");
			
			System.out.println(sb);
			
			//This is so that we can see the Thread working...
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Thread is Finished!");
		
	}
	
}
