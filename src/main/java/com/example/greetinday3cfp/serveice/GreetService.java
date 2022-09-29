package com.example.greetinday3cfp.serveice;

import com.example.greetinday3cfp.model.Greeting;
import com.example.greetinday3cfp.model.User;
import com.example.greetinday3cfp.repository.GreetRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GreetService {
    public static final  String greet = "hello %s";
    private final AtomicInteger counter = new AtomicInteger();
    @Autowired
    GreetRep rep;
    public String getMessage(String mess){
        return String.format(greet, mess);

    }
    public Greeting addGreeting(User user){
        String message = String.format(greet, user.getFirstName());
        return new Greeting(counter.getAndIncrement(), message);

    }
    public Greeting sav(String content, Greeting greeting){
        greeting.setContent(content);
    Greeting newGreeting = new Greeting(String.format(greet, greeting.getContent()));
    return rep.save(newGreeting);

    }
}
