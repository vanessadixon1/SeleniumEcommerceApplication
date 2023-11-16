package com.amcsoftware.parameters.jsonDataItem;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class LoginDataJson{

	@SerializedName("LoginData")
	private List<LoginDataItem> loginData;

	public List<LoginDataItem> getLoginData(){
		return loginData;
	}
}