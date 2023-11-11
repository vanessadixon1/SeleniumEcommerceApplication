package com.amcsoftware.parameters.jsonDataItem;

import com.google.gson.annotations.SerializedName;

public class RegisterDataItem{

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("password")
	private String password;

	@SerializedName("phoneNumber")
	private String phoneNumber;

	@SerializedName("occupation")
	private String occupation;

	@SerializedName("wrongConfirmPassword")
	private String wrongConfirmPassword;

	@SerializedName("gender")
	private String gender;

	@SerializedName("formTitle")
	private String formTitle;

	@SerializedName("email")
	private String email;

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getPassword(){
		return password;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public String getOccupation(){
		return occupation;
	}

	public String getWrongConfirmPassword(){
		return wrongConfirmPassword;
	}

	public String getGender(){
		return gender;
	}

	public String getFormTitle(){
		return formTitle;
	}

	public String getEmail(){
		return email;
	}
}