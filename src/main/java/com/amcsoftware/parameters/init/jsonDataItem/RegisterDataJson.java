package com.amcsoftware.parameters.init.jsonDataItem;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RegisterDataJson{

	@SerializedName("RegisterData")
	private List<RegisterDataItem> registerData;

	public List<RegisterDataItem> getRegisterData(){
		return registerData;
	}
}