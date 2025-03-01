package com.practice.catsgram81.controller;
import com.practice.catsgram81.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task1")
public class Task1PersonController {
    List<Person> persons = new ArrayList<>() {{
        add(new Person("David", 25, "London"));
        add(new Person("Alice", 30, "Paris"));
        add(new Person("John", 22, "New York"));
        add(new Person("Maria", 25, "Madrid"));
        add(new Person("Alex", 35, "Berlin"));
        add(new Person("Sophie", 28, "Paris"));
        add(new Person("Michael", 30, "New York"));
        add(new Person("Emma", 40, "Rome"));
        add(new Person("Thomas", 22, "Berlin"));
        add(new Person("Olivia", 33, "London"));
        add(new Person("Christopher", 28, "London"));
        add(new Person("Emily", 32, "Paris"));
        add(new Person("William", 26, "New York"));
        add(new Person("Isabella", 29, "Madrid"));
        add(new Person("Ethan", 31, "Berlin"));
        add(new Person("Ava", 24, "London"));
        add(new Person("James", 36, "Paris"));
        add(new Person("Sophia", 27, "New York"));
        add(new Person("Daniel", 34, "Madrid"));
        add(new Person("Mia", 23, "Berlin"));
        add(new Person("Benjamin", 30, "Rome"));
        add(new Person("Charlotte", 26, "London"));
        add(new Person("Henry", 32, "Paris"));
        add(new Person("Evelyn", 25, "New York"));
    }};

    //   /task1/users?city=Berlin&age=23
    //   /task1/users?city=Berlin
    //   /task1/users?age=23
    //   /task1/users
    @GetMapping("/persons")
    public List<Person> filterPerson(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) Integer age,
                                     @RequestParam(required = false) String city) {
        List<Person> filteredPersons = new ArrayList<>();
        for (Person person : persons) {
            boolean matches = true;
            if (name != null && !person.getName().equalsIgnoreCase(name)) {
                matches = false;
            }
            if (age != null && person.getAge() != age) {
                matches = false;
            }
            if (city != null && !person.getCity().equalsIgnoreCase(city)) {
                matches = false;
            }
            if (matches) {
                filteredPersons.add(person);
            }
//
//            if (person.getCity().equals(city) && person.getAge() == age) {
//                filteredPersons.add(person);
//            } else if (person.getCity().equals(city)) {
//                filteredPersons.add(person);
//            } else if (person.getAge() > age) {
//                filteredPersons.add(person);
//            }
        }

        return filteredPersons;
    }
}

