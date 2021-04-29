package com.formation.springwebflix.config;

import java.nio.file.NoSuchFileException;
import java.util.Locale;

import javax.naming.SizeLimitExceededException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalException {
	
	private final MessageSource messageSource;
	
	@Autowired
	public GlobalException(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@Value("${spring.servlet.multipart.max-file-size}")
	private String maxFileSize;	

	@ExceptionHandler(SizeLimitExceededException.class)
	public String handleMultipartSizeMaxException(RedirectAttributes redirectAttributes) {
		String[] args = {maxFileSize};
		redirectAttributes.addFlashAttribute("fileError",messageSource.getMessage("movie.add.form.file.too.big.message", args, LocaleContextHolder.getLocale()));
		return "redirect:/admin/movie";
	}
	
	@ExceptionHandler(FileStorageException.class)
	public String handlerFileStorageException(RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("fileError", "movie.add.form.file.no.such.message");
		
		return "/redirect:/admin/movie";
	}

}
