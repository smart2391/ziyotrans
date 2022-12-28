package com.abuziyo.ziyotrans.controller;
import com.abuziyo.ziyotrans.entity.Role;
import com.abuziyo.ziyotrans.entity.User;
import com.abuziyo.ziyotrans.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registraation(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String,Object> model){
      User userFromDb =  userRepo.findByUsername(user.getUsername());

        if(userFromDb != null){
            model.put("message","User exists");
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }

}
