package com.mainacad.controller.jsp;

import com.mainacad.model.User;
import com.mainacad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Profile("jsp")
@RequestMapping("user")
public class UserJspController {

    @Autowired
    UserService userService;

    @PutMapping()
    public String save(Model model,
                       @RequestParam(value = "login") String login,
                       @RequestParam(value = "password") String password,
                       @RequestParam(value = "firstName") String firstName,
                       @RequestParam(value = "lastName") String lastName) {


        User user = userService.save(new User(login, password, firstName, lastName));
        if (user != null) {
            model.addAttribute("userId", user.getId());
            model.addAttribute("firstName", user.getFirstName());
            model.addAttribute("lastName", user.getLastName());
            return "user-cabinet";
        } else {
            model.addAttribute("message", "Sorry, but this login exists");
            return "registration";
        }
    }

}
