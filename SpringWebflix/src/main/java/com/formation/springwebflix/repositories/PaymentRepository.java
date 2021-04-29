package com.formation.springwebflix.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formation.springwebflix.entities.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}
