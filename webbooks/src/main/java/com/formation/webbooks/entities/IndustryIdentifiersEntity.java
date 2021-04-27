package com.formation.webbooks.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "industry_id")
public class IndustryIdentifiersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String identifier;
	private String type;

	@ManyToOne
	@JoinColumn(name = "book_model_id")
	private BookEntity book;
}
