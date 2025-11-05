package com.ra2.users.com_ra2_users.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ra2.users.com_ra2_users.model.User;
import com.ra2.users.com_ra2_users.repository.UserRepository;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public List<User> readUsers(){
        return repository.findAll();
    }

    public User readUser(long id){
        return repository.readUser(id);
    }

    public void createUser(User user){
        user.setDataCreated(new Timestamp(System.currentTimeMillis()));
        user.setDataUpdated(new Timestamp(System.currentTimeMillis()));
        repository.createUser(user);
    }

    public void updateUser(long id, User user){
        user.setDataUpdated(new Timestamp(System.currentTimeMillis()));
        repository.updateUser(id,user);
    }

    public void updateUser(long id, String name){
        Timestamp dataUpdated = new Timestamp(System.currentTimeMillis());
        repository.updateUser(id, name, dataUpdated);
    }

    public void deleteUser(long id){
        repository.deleteUser(id);
    }

    public String addImage(long id, MultipartFile imageFile){

        User user = repository.readUser(id);
        if (user == null){
            return String.format("No s'ha trobat cap usuari amb id %d",id) ;
        }
        String path = "";
        repository.addImage(id,path,new Timestamp(System.currentTimeMillis()));
        return path;
    }

    public int createUsers(MultipartFile csvFile){

        int comptador = 0;
        String[] users = {};

        for(String userString:users){
            String[] userFields = userString.split(",");
            Timestamp now = new Timestamp(System.currentTimeMillis());
            User user = new User(Long.parseLong(userFields[0]), userFields[1], userFields[2], userFields[3], userFields[4], null, now, now);
            createUser(user);
            comptador++;
        }
        return comptador;
    }

}
