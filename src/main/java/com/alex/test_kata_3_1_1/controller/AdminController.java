package com.alex.test_kata_3_1_1.controller;

import com.alex.test_kata_3_1_1.model.User;
import com.alex.test_kata_3_1_1.service.RoleService;
import com.alex.test_kata_3_1_1.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostMapping("/")
    public String create(@ModelAttribute("user") User user){
        log.info("Add user: "+user.toString());
        userService.add(user);
        return "redirect:/admin";
    }


    @PatchMapping("/userId{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("user") User updatedUser){
        userService.update(updatedUser);
        return "redirect:/admin";
    }

    @DeleteMapping("/userId{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete((long) id);
        return "redirect:/admin";
    }
    @GetMapping("")
    public String getTable(ModelMap modelMap){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        log.info("Info about user: "+user.toString());
        modelMap.addAttribute("authorize_user", user);
        modelMap.addAttribute("new_user", new User());
        modelMap.addAttribute("edit_user", new User());
        modelMap.addAttribute("userService", userService);
        modelMap.addAttribute("roles", roleService.getAll());
        modelMap.addAttribute("users", userService.getAll());
        return "admin_users";
    }


}
