package com.formation.springwebflix.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.formation.springwebflix.config.FileStorageException;

@Service
public class FileService {

	@Value("${app.upload.dir:${user.home}}")
	private String uploadDir;

	public String uploadfile(MultipartFile file) {
		//final String[] tab = file.getOriginalFilename().split("\\.");
		//final String ext = tab[tab.length - 1]; // il n'y a pas de point
		final String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		
		final String uuid = UUID.randomUUID().toString() + ext;

		try {
			Path copyLocation = Paths.get(
					uploadDir + File.separator + uuid);
			Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
			return copyLocation.toString();
			
		} catch(IOException e) {
			// e.printStackTrace();
			
		throw new FileStorageException(e.getMessage());
		}
	}
}
