package com.formation.webbooks.entities;

import com.formation.webbooks.PermissionEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@Email
	private String email;

	@Pattern(regexp = ".{6,64}")
	private String password;

	@Transient
	@Pattern(regexp = ".{6,64}")
	private String rePassword;

	private byte[] salt;

	@Pattern(regexp = "[A-zÀ-ú\\s]{2,150}", flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.DOTALL})
	private String fullname;

	@Enumerated(EnumType.STRING)
	private PermissionEnum permission;

	public boolean isSamePassword(){
		return this.password.equals(this.rePassword);
	}

	private void generateSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		this.salt = salt;
	}

	public void generatePassword() {
		if (this.salt == null)
			generateSalt();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(this.salt);
			byte[] hashedPassword = md.digest(this.password.getBytes(StandardCharsets.UTF_8));
			this.password = Base64.getEncoder().encodeToString(hashedPassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}
}
