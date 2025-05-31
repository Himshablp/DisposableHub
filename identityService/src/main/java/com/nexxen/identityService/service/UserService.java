package com.nexxen.identityService.service;

import com.nexxen.identityService.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private List<User> store = new ArrayList<>();
    private UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Himanshu Sharma","sharmaji.blp123@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Harsh Sharma","harsh.blp123@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Ankit Sharma","ankit.blp123@gmail.com"));
        store.add(new User(UUID.randomUUID().toString(),"Mayank Dubey","mayank.gkp123@gmail.com"));
    }

    public List<User> getUsers(){
        return this.store;
    }
}
