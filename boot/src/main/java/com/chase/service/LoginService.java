package com.chase.service;

/**
 * @author chase
 * @date 2023/3/3 3:03 PM
 */
public class LoginService {
    private UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }
}
