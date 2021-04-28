package com.formation.springwebflix.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name="movie")
public class MovieEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(nullable = false)
@NotEmpty
private String title;

@Column(nullable = false)
@DateTimeFormat(pattern="yyyy-MM-dd")
@NotNull
private Date releaseDate;

@Column(columnDefinition="TEXT", nullable = false)
@NotEmpty
private String description;

@Column(nullable = false)
@Min(0)
@NotNull(message = "{movie.add.form.duration.notNull.message}")
private Integer duration;

private String cover;




}
