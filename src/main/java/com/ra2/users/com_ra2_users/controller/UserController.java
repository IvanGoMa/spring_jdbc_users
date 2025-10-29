package com.ra2.users.com_ra2_users.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ra2.users.com_ra2_users.model.User;
import com.ra2.users.com_ra2_users.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

// Usar timestamp para fechas


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> readUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<User> readUser(@PathVariable long user_id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.readUser(user_id));
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        repository.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Usuari %s creat", user.toString()));
    }

    @PutMapping("/users/{user_id}")
    public ResponseEntity<String> updateUser(@PathVariable long user_id, @RequestBody User user) {
        repository.updateUser(user_id,user);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Usuari amb id %d actualitzat",user_id));
    }

    @PatchMapping("/users/{user_id}/name")
    public ResponseEntity<String> updateUser(@PathVariable long id, @RequestParam String name) {
        repository.updateUser(id, name);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Nom de l'usuari %d actualitzat a %s",id,name));
    }

    @DeleteMapping("/users/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        repository.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Usuari amb id %d eliminat",id));

    }
    
    
}
