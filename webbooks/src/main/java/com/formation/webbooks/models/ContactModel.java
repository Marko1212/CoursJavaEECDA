package com.formation.webbooks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactModel {
	private String fullname;
	private String email;
	private String message;

	public Map<String, String> checkErrors() {
		Map<String, String> errors = new HashMap<>();
		if (!checkFullname().isEmpty()){
			errors.put("fullname",checkFullname());
		}
		if (!checkEmail().isEmpty()){
			errors.put("email",checkEmail());
		}
		if (!checkMessage().isEmpty()){
			errors.put("message",checkMessage());
		}

		return errors;
	}

	private String checkFullname() {
		Pattern pattern = Pattern.compile("[A-zÀ-ú\\s]{2,150}", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		if (pattern.matcher(this.getFullname()).matches()) {
			return "";
		}
		return "Your fullname is not correct";
	}

	private String checkEmail() {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		if (pattern.matcher(this.getEmail()).matches()) {
			return "";
		}
		return "Your Email is not correct";
	}

	private String checkMessage() {
		if (getMessage().length() >= 20 && getMessage().length() <= 1000){
			return "";
		}
		return "Your message must be between 20 and 1000 characters";
	}
}
