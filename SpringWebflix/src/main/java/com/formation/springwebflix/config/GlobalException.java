package com.formation.springwebflix.config;

import javax.naming.SizeLimitExceededException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(SizeLimitExceededException.class)
	public String handleMultipartSizeMaxException(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("fileError", "movie.add.form.file.too.big.message");
		return "redirect:/admin/movie";
	}

}
