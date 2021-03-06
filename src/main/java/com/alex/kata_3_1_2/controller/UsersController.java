package com.alex.kata_3_1_2.controller;


import com.alex.kata_3_1_2.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Log4j2
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
public class UsersController {

    @GetMapping("/user")
    public String user(ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        log.info("Info about user: "+user.toString());
        modelMap.addAttribute("authorize_user", user);
        return "user";
    }

}
