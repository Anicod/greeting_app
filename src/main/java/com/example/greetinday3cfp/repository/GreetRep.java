package com.example.greetinday3cfp.repository;

import com.example.greetinday3cfp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetRep extends JpaRepository<Greeting, Integer> {

}
