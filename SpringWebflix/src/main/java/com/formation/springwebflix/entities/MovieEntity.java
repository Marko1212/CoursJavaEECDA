package com.formation.springwebflix.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="movie")
public class MovieEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(nullable = false)
private String title;

@Column(nullable = false)
private Calendar releaseDate;

@Column(columnDefinition="TEXT", nullable = false)
private String description;

@Column(nullable = false)
private Integer duration;

private String cover;




}
