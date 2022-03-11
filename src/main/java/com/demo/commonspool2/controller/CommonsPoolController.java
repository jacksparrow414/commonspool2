package com.demo.commonspool2.controller;

import com.demo.commonspool2.entity.User;
import com.demo.commonspool2.pool.UserPoolWrapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CommonsPoolController {

    @Autowired
    private UserPoolWrapper pool;

    @GetMapping("/user/{id}")
    @SneakyThrows
    public User getUser(@PathVariable int id) {
        User user = pool.borrow();
        pool.returnObject(user);
        return user;
    }
}
