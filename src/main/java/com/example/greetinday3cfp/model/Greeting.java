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
    public Greeting(String message){
        this.content = message;
    }

}
