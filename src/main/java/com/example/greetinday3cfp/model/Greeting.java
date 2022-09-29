package com.example.greetinday3cfp.model;

import org.springframework.http.ResponseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Greeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String content;

    public Greeting() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Greeting(Integer id, String content) {
        super();
        this.id = id;
        this.content = content;
    }
    public Greeting(Greeting greeting){
        this.content = greeting.content;
    }
    public Greeting(String message){
        this.content = message;
    }

}
