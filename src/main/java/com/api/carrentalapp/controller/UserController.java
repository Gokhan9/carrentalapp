package com.api.carrentalapp.controller;

import com.api.carrentalapp.model.User;
import com.api.carrentalapp.repository.UserRepository;
import com.api.carrentalapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserRepository userRepository) {
        this.userService = userService;
    }

    //yukarıdaki users path'i için çalışıcak
    @GetMapping
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);
    }

    @GetMapping("/{userId}")    //youtube videosunda ki isimlendirme getOneUser
    public User getByUserId(@PathVariable Long userId){
        //custom exception yapılıcak!!
        return userService.getOneUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateByUser(@PathVariable Long userId, @RequestBody User newUser){
        return userService.updateOneUser(userId, newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteById(userId);
    }

}
/*
private UserRepository userRepository;

public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
}

//yukarıdaki users path'i için çalışıcak
@GetMapping
public List<User> getAllUsers(){
    return userRepository.findAll();
}

@PostMapping
public User createUser(@RequestBody User newUser){
    return userRepository.save(newUser);
}

@GetMapping("/{userId}")    //youtube videosunda ki isimlendirme getOneUser
public User getByUserId(@PathVariable Long userId){
    //custom exception yapılıcak!!
    return userRepository.findById(userId).orElse(null);
}

@PutMapping("/{userId}")
public User updateByUser(@PathVariable Long userId, @RequestBody User newUser){
    Optional<User> user = userRepository.findById(userId);
    if(user.isPresent()) {
        User foundUser = user.get();
        foundUser.setUsername(newUser.getUsername());
        foundUser.setPassword(newUser.getPassword());
        userRepository.save(foundUser);
        return foundUser;
    } else {
        return null;
    }
}

@DeleteMapping("/{userId}")
public void deleteUser(@PathVariable Long userId){
    userRepository.deleteById(userId);
}

 */

