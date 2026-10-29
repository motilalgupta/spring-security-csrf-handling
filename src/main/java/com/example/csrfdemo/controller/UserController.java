package com.example.csrfdemo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    Map<String,String> userData = new HashMap<>();

    @GetMapping("/public")
    public String publicMethod(){
        return "this is pubilc method";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody Map<String,String> data){
        userData.put(data.get("username"),userData.get("password"));
        return "user saved in memory";
    }
}
