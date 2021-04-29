package com.formation.springwebflix.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	@Value("${app.upload.dir:${user.home}}")
	private String uploadDir;

	public String uploadfile(MultipartFile file) {
		
		
		try {
			Path copyLocation = Paths.get(
					uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename())
					);
			Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
			return copyLocation.toString();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	return null;
	}
}
