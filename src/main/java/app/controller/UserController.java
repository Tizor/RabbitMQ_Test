package app.controller;

import app.entity.User;
import app.repository.UserRepo;
import app.service.RabbitListener;
import app.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/all")
    public Collection<User> getUserList(){
        return userService.getUserList() ;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserById(id );
    }

    @GetMapping("/message/{message}")
    public void getUser(@PathVariable String message){
        userService.sendStringMessage(message);
    }

    @PostMapping("/message/user")
    public void getUser(@RequestBody User user){
        userService.sendUserMessage(user);
    }
}
