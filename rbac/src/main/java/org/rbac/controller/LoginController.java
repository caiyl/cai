package org.rbac.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chase
 * @date 2022/11/3 5:23 PM
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @PostMapping("loginIn")
    public String login(){
        String token = "aaaa";
        return token;
    }
}
