package com.amcsoftware.parameters.jsonDataItem;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RegisterDataItem{

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("password")
	private String password;

	@SerializedName("invalidEmailFormat")
	private String invalidEmailFormat;

	@SerializedName("phoneNumber")
	private String phoneNumber;

	@SerializedName("occupation")
	private String occupation;

	@SerializedName("wrongConfirmPassword")
	private String wrongConfirmPassword;

	@SerializedName("gender")
	private String gender;

	@SerializedName("options")
	private List<String> options;

	@SerializedName("formTitle")
	private String formTitle;

	@SerializedName("shortPassword")
	private String shortPassword;

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

	public String getInvalidEmailFormat(){
		return invalidEmailFormat;
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

	public List<String> getOptions(){
		return options;
	}

	public String getFormTitle(){
		return formTitle;
	}

	public String getShortPassword(){
		return shortPassword;
	}

	public String getEmail(){
		return email;
	}
}