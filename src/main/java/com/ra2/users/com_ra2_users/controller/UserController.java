package com.ra2.users.com_ra2_users.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ra2.users.com_ra2_users.model.User;
import com.ra2.users.com_ra2_users.service.UserServices;

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
    private UserServices services;

    @GetMapping("/users")
    public ResponseEntity<List<User>> readUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(services.readUsers());
    }

    @GetMapping("/users/{user_id}")
    public ResponseEntity<User> readUser(@PathVariable long user_id) {
        return ResponseEntity.status(HttpStatus.OK).body(services.readUser(user_id));
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        services.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Usuari %s creat", user.toString()));
    }

    @PostMapping("/users/{user_id}/image")
    public ResponseEntity<String> addImage(@PathVariable long user_id, @RequestParam MultipartFile imageFile) {
        
        services.addImage(user_id, imageFile);
        return ResponseEntity.status(HttpStatus.OK).body(String.format(""));
        
    }
    
    @PostMapping("/users/upload-csv")
    public ResponseEntity<String> postMethodName(@RequestParam MultipartFile csvFile) {
        services.createUsers(csvFile);
        
        return ResponseEntity.status(HttpStatus.OK).body(String.format(""));
    }
    

    @PutMapping("/users/{user_id}")
    public ResponseEntity<String> updateUser(@PathVariable long user_id, @RequestBody User user){
        services.updateUser(user_id,user);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Usuari amb id %d actualitzat",user_id));
    }

    @PatchMapping("/users/{user_id}/name")
    public ResponseEntity<String> updateUser(@PathVariable long user_id, @RequestParam String name) {
        services.updateUser(user_id, name);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Nom de l'usuari %d actualitzat a %s",user_id,name));
    }

    @DeleteMapping("/users/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable long user_id){
        services.deleteUser(user_id);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Usuari amb id %d eliminat",user_id));

    }
    
    
}
