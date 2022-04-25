package com.pcwk.ex08.enum9;

public class EnumMain {

	public static void main(String[] args) {
		
		Direction[] directionArr = Direction.values();
		for(Direction d: directionArr) {
			System.out.println(d.name() + "," +d.getValue());
		}

	}

}
