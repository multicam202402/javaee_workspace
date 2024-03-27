package com.sds.testapp.parsing.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class JSONTest {

	public static void main(String[] args) {
		List<Store> storeList = new ArrayList<Store>();

		for(int i=1;i<=10;i++) {
			Store store = new Store();
			store.setName("흥부상회"+i);
			store.setTel("03"+i);
			store.setAddr("서울"+i);
			storeList.add(store);
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(storeList);
		
		System.out.println(json);
		
	}

}
