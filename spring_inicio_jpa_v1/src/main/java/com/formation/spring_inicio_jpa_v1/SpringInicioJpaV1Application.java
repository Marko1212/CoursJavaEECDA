package com.formation.spring_inicio_jpa_v1;

import com.formation.spring_inicio_jpa_v1.entities.EventEntity;
import com.formation.spring_inicio_jpa_v1.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Calendar;

@SpringBootApplication
public class SpringInicioJpaV1Application {

	private EventService eventService;

	@Autowired
	public SpringInicioJpaV1Application(EventService eventService) {
		this.eventService = eventService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringInicioJpaV1Application.class, args);
	}

	@Bean
	void testService(){
		EventEntity e1 = new EventEntity();
		e1.setTitle("Meetup Flutter");
		e1.setDescription("Meetup pour découvrir le framework flutter");
		e1.setBeginDate(Calendar.getInstance());
		e1.setAllDay(false);

		EventEntity e2 = new EventEntity();
		e2.setTitle("Daily meeting");
		e2.setDescription("Réunion tous les matins pour faire un point sur l'avancée du projet");
		e2.setBeginDate(Calendar.getInstance());
		e2.setAllDay(true);

//		eventService.save(e1);
//		eventService.save(e2);

		System.out.println("------------------------------------------------------");
		eventService.findAll().forEach(System.err::println);

//		e1.setTitle("coucou");
//
//		eventService.save(e1);
//		eventService.findAll().forEach(System.err::println);
		System.out.println("------------------------------------------------------");

		eventService.findTitle("Daily meeting").forEach(System.err::println);

		System.out.println("------------------------------------------------------");

		eventService.findDescriptionByKeyword("flutter").forEach(System.err::println);
	}
}
