package com.formation.springwebflix.services;

import org.springframework.beans.factory.annotation.Value;

public class FileService {

	@Value("${app.upload.dir:${user.home}}")
	private String uploadDir;
	
	
}
