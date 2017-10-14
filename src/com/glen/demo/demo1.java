package com.glen.demo;

import java.util.Date;

public class demo1 {

	public static void main(String[] args) {

		Integer a=1000,b=1000;
		Integer c=100,d=100;
		System.out.println(a==b);
		System.out.println(c==d);
		
		demo1 demo=new demo1();
		demo.a();
		
		Date date=new Date();
		System.out.println(date.getTime());
		
		double d1=Math.ceil(12.34);
		System.out.println(d1);

	}
	
	public  void a(){

		String s=String.format("%s","我");
		System.out.println(s);

	}

}
