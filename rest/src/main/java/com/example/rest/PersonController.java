package com.example.rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/person")
public class PersonController {

    private List<Person> people = new ArrayList<Person>() {
        {
            add(new Person("Dima", 29));
            add(new Person("Arik", 2));
            add(new Person("Anna", 29));
        }
    };

    @GetMapping("/getall")
    //Usage: http://localhost:8080/person/getall
    public List<Person> getAll() {
        return this.people;
    }

    @PutMapping("/update")
    public String update(@RequestParam("name") String name,
                         @RequestParam("age") int age) {
        AtomicReference<String> result = new AtomicReference<>(name + " isn't registered");
        this.people.forEach(person -> {
            if (person.getName().equals(name)) {
                person.setName(name);
                person.setAge(age);
                String text = String.format("%ss' age was updated to %d", person.getName(), person.getAge());
                result.set(text);
            }
        });
        return result.get();
    }
}
