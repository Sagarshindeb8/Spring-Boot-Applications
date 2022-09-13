package com.practice.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginData {

	@NotBlank(message = "User name cannot be empty.") //validations
	@Size(min = 3, max = 12, message = "User name must be between 3-12 characters.")
	private String UserName;
	
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="Invalid Email.") //@Email can also be used.
	private String email;
	
	@AssertTrue(message = "Must agree Terms & Conditions.")
	private boolean agreed;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public boolean isAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	@Override
	public String toString() {
		return "LoginData [UserName=" + UserName + ", email=" + email + "]";
	}
	
	
}
