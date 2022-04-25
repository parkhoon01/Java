package com.pcwk.time.ex;


public class GenericPrintMain {
	
	public static void main(String[] args) {
		
		GenericPrint<Powder> powderPrint = new GenericPrint<>();
		
		powderPrint.setMaterial(new Powder());
		System.out.println("powderPrint: " + powderPrint.toString());
		Powder powder = powderPrint.getMaterial();
		System.out.println(powder.toString());
		powder.doPrinting();
		
		GenericPrint<Plastic> plastic = new GenericPrint<>();
		
		plastic.setMaterial(new Plastic());
		System.out.println(plastic.toString());
		Plastic plastic2 = plastic.getMaterial();
		System.out.println(plastic2.toString());
		
	}

}
