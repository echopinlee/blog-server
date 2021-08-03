package com.jambo.controller;


import com.jambo.common.lang.Result;
import com.jambo.entity.User;
import com.jambo.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jambo
 * @since 2021-07-09
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("index")
    public Result getId() {
        User user  = userService.getById(1L);
        return  Result.succ(user);
    }

    /**
     * @validated 字段校验
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result add( @Validated  @RequestBody User user){


        return Result.succ(user);
    }

}
