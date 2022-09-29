package com.example.greetinday3cfp.serveice;

import com.example.greetinday3cfp.model.Greeting;
import com.example.greetinday3cfp.model.User;
import com.example.greetinday3cfp.repository.GreetRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
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
//    public Greeting userPost(Greeting greeting){
//        rep.save(greeting);
//        return greeting;
//    }
    public List<Greeting> getDatacontent(){
        return rep.findAll();

    }
    public Greeting getByIdD(Integer id){
        return rep.findAll().get(id);
    }

    public void deleteId(Integer id){
        rep.deleteById(id);
    }
    public Greeting editByUSer(Integer id, Greeting greetingModel) {
        Greeting greetingModel1 = rep.findById(id).orElse(null);
        if(greetingModel1 != null){
            greetingModel1.setContent(greetingModel.getContent());
            return rep.save(greetingModel1);
        }
        return null;
    }

}
