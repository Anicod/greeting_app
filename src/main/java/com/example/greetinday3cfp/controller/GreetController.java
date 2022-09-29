package com.example.greetinday3cfp.controller;

import com.example.greetinday3cfp.model.Greeting;
import com.example.greetinday3cfp.model.User;
import com.example.greetinday3cfp.serveice.GreetService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
//@PostMapping("/user")
//     public ResponseEntity<Greeting> postUser(@RequestBody Greeting greeting){
//     return new ResponseEntity<>(greetService.userPost(greeting), HttpStatus.OK);
//}

  //uc5
@GetMapping("/getdata")
public List<Greeting> getDatacont(){
     return greetService.getDatacontent();
}
//uc6
@GetMapping("/getbyid")
public Greeting getById(@RequestParam Integer id){
     return greetService.getByIdD(id);
}

//uc7

@DeleteMapping("/deletebyid")
     public String deleteById(@RequestParam Integer id){
     greetService.deleteId(id);
     return "delete id successfully";
}

//uc8
@PutMapping("/editByUser/{id}")
public Greeting editByUser(@PathVariable Integer id,@RequestBody Greeting greetingModel) {
     return greetService.editByUSer(id,greetingModel);
}











}
