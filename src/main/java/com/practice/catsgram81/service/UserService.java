package com.practice.catsgram81.service;

import com.practice.catsgram81.exception.InvalidEmailException;
import com.practice.catsgram81.exception.UserAlreadyExistException;
import com.practice.catsgram81.exception.UserNotFoundException;
import com.practice.catsgram81.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UserService {
    private final HashMap<String, User> users = new HashMap();
//    User user1 = new User("abc@mail.ru", "Alex", LocalDate.of(2001, 01, 30));
//    User user2 = new User("1243@mail.ru", "Tom", LocalDate.of(2005, 05, 05));
//    User user3 = new User("nnn@mail.ru", "Bob", LocalDate.of(1990, 06, 05));
//
//    {
//        users.put(user1.getEmail(), user1);
//        users.put(user2.getEmail(), user2);
//        users.put(user3.getEmail(), user3);
//    }

    public Collection<User> findAll(){
        return users.values();
    }

    public User create(@RequestBody User user){

        if (users.containsKey(user.getEmail())){
            throw new UserAlreadyExistException("почта занят");
        } else if(user.getEmail() == null || user.getEmail().isBlank()){
            throw new InvalidEmailException("почту не добавили");
        }

        users.put(user.getEmail(), user);
        return user;
    }
    public User update(@RequestBody User user){
        if(user.getEmail() == null || user.getEmail().isBlank()){
            throw new InvalidEmailException("почту не добавили");
        }


        users.put(user.getEmail(), user);
        return user;
    }
    public User findUserByEmail(String email){
        for (User user : users.values()) {
        // если почта пользователя равняется email
        //  retunr user
            if(user.getEmail().equals(email)){
                return user;
            }
        }
        throw new UserNotFoundException("пользовател не найден");
    }

}
