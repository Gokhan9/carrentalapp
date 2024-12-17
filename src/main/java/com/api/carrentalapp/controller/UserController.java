package com.api.carrentalapp.controller;

import com.api.carrentalapp.model.User;
import com.api.carrentalapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
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


