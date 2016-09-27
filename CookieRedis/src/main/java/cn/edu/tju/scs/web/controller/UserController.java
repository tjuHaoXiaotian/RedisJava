package cn.edu.tju.scs.web.controller;

import cn.edu.tju.scs.web.annotation.Login;
import cn.edu.tju.scs.entity.User;
import cn.edu.tju.scs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by haoxiaotian on 2016/9/26 21:56.
 */

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Login(required = true)
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Object getAll(){
        return userService.getAll();
    }
}
