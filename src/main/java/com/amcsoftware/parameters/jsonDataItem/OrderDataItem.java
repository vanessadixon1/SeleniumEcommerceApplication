package com.amcsoftware.parameters.jsonDataItem;

import com.google.gson.annotations.SerializedName;

public class OrderDataItem{

	@SerializedName("country")
	private String country;

	@SerializedName("password")
	private String password;

	@SerializedName("item2")
	private String item2;

	@SerializedName("cvv")
	private String cvv;

	@SerializedName("item1")
	private String item1;

	@SerializedName("name")
	private String name;

	@SerializedName("item3")
	private String item3;

	@SerializedName("username")
	private String username;

	public String getCountry(){
		return country;
	}

	public String getPassword(){
		return password;
	}

	public String getItem2(){
		return item2;
	}

	public String getCvv(){
		return cvv;
	}

	public String getItem1(){
		return item1;
	}

	public String getName(){
		return name;
	}

	public String getItem3(){
		return item3;
	}

	public String getUsername(){
		return username;
	}
}