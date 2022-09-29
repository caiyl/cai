package es.controller;

import es.bean.User;
import es.dto.PageInfo;
import es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chase
 * @date 2022/9/26 5:43 PM
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("save")
    public String save(@RequestBody User user) {
        long id = System.currentTimeMillis();
        user.setId(id);
        userService.save(user);
        return "新增成功,id为：" + id;
    }


    @PostMapping("/page")
    public Page<User> page(@RequestBody PageInfo pageInfo) {
        return userService.getPage(pageInfo);
    }
}
