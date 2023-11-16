package com.amcsoftware.parameters.jsonDataItem;

import com.google.gson.annotations.SerializedName;

public class LoginDataItem{

	@SerializedName("incorrectUsername")
	private String incorrectUsername;

	@SerializedName("password")
	private String password;

	@SerializedName("incorrectHeader")
	private String incorrectHeader;

	@SerializedName("header")
	private String header;

	@SerializedName("username")
	private String username;

	public String getIncorrectUsername(){
		return incorrectUsername;
	}

	public String getPassword(){
		return password;
	}

	public String getIncorrectHeader(){
		return incorrectHeader;
	}

	public String getHeader(){
		return header;
	}

	public String getUsername(){
		return username;
	}
}