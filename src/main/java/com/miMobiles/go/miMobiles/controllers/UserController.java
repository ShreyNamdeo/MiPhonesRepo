package com.miMobiles.go.miMobiles.controllers;

import com.miMobiles.go.miMobiles.dto.UserDto;
import com.miMobiles.go.miMobiles.models.Role;
import com.miMobiles.go.miMobiles.models.User;
import com.miMobiles.go.miMobiles.repositories.RoleRepository;
import com.miMobiles.go.miMobiles.repositories.UserRepository;
import doryan.windowsnotificationapi.fr.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shrey on 2/18/2019.
 */

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<UserDto> getAllUsers(){
        List<UserDto> users = new ArrayList<>();
        userRepository.getById(1L).forEach(user -> users.add(new UserDto(user)));
        try {
            Notification.sendNotification("This is index called", "Some good details here", TrayIcon.MessageType.NONE);
        } catch (AWTException | MalformedURLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @PostMapping
    public @ResponseBody User createUsers(@Valid @RequestBody UserDto userDto){
        Role role = roleRepository.getRoleById(userDto.getRole());
        //return Response.status(CREATED).entity(userRepository.save(new User(userDto,role))).build();
        return userRepository.save(new User(userDto,role));
    }

}
