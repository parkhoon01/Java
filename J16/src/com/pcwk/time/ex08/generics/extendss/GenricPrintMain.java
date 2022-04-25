package com.pcwk.time.ex08.generics.extendss;

public class GenricPrintMain {

	public static void main(String[] args) {
		
		// Powder type GenericPrint 생성
		GenericPrint<Powder> powderPrinter = new GenericPrint<>();
		
		// setMaterial
		powderPrinter.setMaterial(new Powder());
		Powder powder = powderPrinter.getMaterial();
		System.out.println("powder: " + powder);
		// getMaterial
		System.out.println(powderPrinter.toString());
		
		// Plastic getXXX(), setXXX()
		GenericPrint<Plastic> plasticPrinter = new GenericPrint<>();
		
		plasticPrinter.setMaterial(new Plastic());
		System.out.println("plasticPrinter: " + plasticPrinter);
		Plastic plastic = plasticPrinter.getMaterial();
		System.out.println(plastic);
	}
 
}
