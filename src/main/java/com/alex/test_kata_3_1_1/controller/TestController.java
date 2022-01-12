package com.alex.test_kata_3_1_1.controller;

import com.alex.test_kata_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;

//@Secured("ROLE_ADMIN")
//@RolesAllowed("ROLE_ADMIN")
@Controller
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
