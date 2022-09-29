package com.example.greetinday3cfp.controller;

import com.example.greetinday3cfp.model.Greeting;
import com.example.greetinday3cfp.model.User;
import com.example.greetinday3cfp.serveice.GreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GreetController {
public static final String greet = "hello %s";
private final AtomicInteger counter = new AtomicInteger();
@GetMapping("/get")
     public Greeting getMessage(@RequestParam String mess){
     return new Greeting(counter.incrementAndGet(), String.format(greet, mess));

}
@Autowired
     GreetService greetService;
@PostMapping("/post")
     public Greeting postMessage(@RequestBody Greeting greeting){
     return new Greeting(counter.getAndIncrement(), String.format(greet, greeting.getContent()));

}

@GetMapping("/smess")
     ResponseEntity<String> getMess(@RequestParam String message){
     return new ResponseEntity<>(greetService.getMessage(message), HttpStatus.OK);
}
//uc3
@GetMapping("/username")
     public Greeting greeting(@RequestParam String name){
     User user = new User();
     user.setFirstName(name);
     return greetService.addGreeting(user);
}
//uc4
@PostMapping("/postg")
public ResponseEntity<Greeting> postGreet(@RequestBody Greeting greeting){
return new ResponseEntity<>(greetService.sav(greeting.getContent(), greeting), HttpStatus.OK);

}



}
