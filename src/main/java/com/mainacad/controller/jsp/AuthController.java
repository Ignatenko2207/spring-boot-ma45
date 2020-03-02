package com.mainacad.controller.jsp;

import com.mainacad.model.User;
import com.mainacad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Profile("jsp")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public String getAuthUser(Model model,
                              @RequestParam(value = "login") String login,
                              @RequestParam(value = "password") String password) {

        User user = userService.getByLoginAndPassword(login, password);
        if (user != null) {
            model.addAttribute("userId", user.getId());
            model.addAttribute("firstName", user.getFirstName());
            model.addAttribute("lastName", user.getLastName());
            return "user-cabinet";
        } else {
            model.addAttribute("message", "Login or password are wrong!");
            return "wrong-login";
        }
    }

}
