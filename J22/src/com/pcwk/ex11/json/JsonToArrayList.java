package com.pcwk.ex11.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonToArrayList {

	public static void main(String[] args) {
		String jsonString = "[{\"name\":\"철수\",\"age\":9,\"gender\":\"남\"},\n"
				+ "{\"name\":\"영희\",\"age\":9,\"gender\":\"여\"},\n"
				+ "{\"name\":\"짱구\",\"age\":9,\"gender\":\"남\"}]\n"
				+ "";
		
		Gson gson = new Gson();
		Type typeOfT = new TypeToken<ArrayList<Person>>(){}.getType();
		
		ArrayList<Person> list = gson.fromJson(jsonString, typeOfT);
		
		for(Person p : list) {
			System.out.println(p);
		}
	}

}
