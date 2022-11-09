package org.rbac.controller;

import lombok.extern.slf4j.Slf4j;
import org.rbac.auth.JwtTokenUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chase
 * @date 2022/11/4 5:37 PM
 */
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtTokenUtils jwtTokenUtils;

    public AuthController(JwtTokenUtils jwtTokenUtils) {
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @GetMapping(value = "/login")
    public String login(String user,String password){
        Map map = new HashMap();
        map.put("user",user);
        map.put("password",password);
        return jwtTokenUtils.createToken(map);
    }
}
