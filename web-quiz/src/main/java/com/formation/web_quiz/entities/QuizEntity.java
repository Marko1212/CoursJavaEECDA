package com.formation.web_quiz.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="quiz")
public class QuizEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String langue;
	private String categorie;
	private String theme;
	private String difficulte;
	private String question;
	@Column(name="reponse_correcte")
	private String reponseCorrecte;
	@OneToMany(mappedBy = "quiz")
	private List<ChoiceEntity> choices;
	private String anecdote;
	private String wikipedia;
	
	
	

}
