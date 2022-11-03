package rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chase
 * @date 2022/11/3 4:37 PM
 */
@RestController
@RequestMapping("/hello")
public class HelloController {


    @GetMapping("helloWorld")
    public String helloWorld(){
        return "hello world";
    }
}
