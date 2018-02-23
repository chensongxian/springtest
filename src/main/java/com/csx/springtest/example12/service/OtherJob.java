package com.csx.springtest.example12.service;

public class OtherJob implements Runnable {
	public void run() {
       System.out.println("do job in OtherJob.run()");
	}
}
