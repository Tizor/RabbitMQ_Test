package app.controller;

import app.entity.User;
import app.service.UserService;
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
    public void sendUser(@RequestBody User user){
        userService.sendUserMessage(user);
    }

    @PostMapping("/message/fanout")
    public void sendUserToFanoutExchange(@RequestBody User user){
        userService.sendUserMessageToFanoutQueue(user);
    }

    @PostMapping("/message/direct")
    public void sendUserToDirectExchange(@RequestBody User user){
        userService.sendUserMessageToDirectExchange(user);
    }

    @PostMapping("/message/topic")
    public void sendUserToTopicExchange(@RequestBody User user){
        userService.sendUserMessageToTopicExchange(user);
    }

    @PostMapping("/message/remote")
    public void sendUserMessageForRemoteProcedureCall(@RequestBody User user){
        userService.sendUserMessageForRemoteProcedureCall(user);
    }
}
