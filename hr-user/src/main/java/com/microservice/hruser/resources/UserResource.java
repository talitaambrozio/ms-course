package com.microservice.hruser.resources;

import com.microservice.hruser.entities.User;
import com.microservice.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        User obj = repository.findByEmail(email);
        return ResponseEntity.ok(obj);
    }
}
