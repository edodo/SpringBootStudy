package com.basic.myspringboot.controller;

import com.basic.myspringboot.entity.User;
import com.basic.myspringboot.exception.ResourceNotFoundException;
import com.basic.myspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserRestController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User insertUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @RequestMapping(value = "/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        User existUser = userOptional.orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
        return existUser;
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(email + " User가 존재하지 않습니다.");
        }

        User existUser = userOptional.get();
        return ResponseEntity.ok(existUser);
    }

    @PatchMapping("/{email}")
    public ResponseEntity<?> updateUserByEmail(@PathVariable String email, @RequestBody User userDetail) {

        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(email + " User가 존재하지 않습니다.");
        }

        User existUser = userOptional.get();
        existUser.setName(userDetail.getName());
        User updatedUser = userRepository.save(existUser);
        return ResponseEntity.ok(updatedUser);
    }

    @RequestMapping(produces = {"application/json"})
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.setName(userDetail.getName());
        user.setEmail(userDetail.getEmail());

        User updateUser = userRepository.save(user);
        return updateUser;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.status(404).body(id + "User Not Found");
        }
        User user = optional.get();
        userRepository.delete(user);
        return ResponseEntity.ok().body(id + " User Delete OK");
    }
}
