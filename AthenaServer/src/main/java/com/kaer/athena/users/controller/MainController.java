package com.kaer.athena.users.controller;

import com.kaer.athena.users.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * （1）@Controller注解：采用注解的方式，可以明确地定义该类为处理请求的Controller类；
 * <p>
 * （2）@RequestMapping()注解：用于定义一个请求映射，value为请求的url，值为 / 说明，该请求首页请求，method用以指定该请求类型，一般为get和post；
 * <p>
 * （3）return "index"：处理完该请求后返回的页面，此请求返回 index.jsp页面。
 */
@Controller
public class MainController {

    private static final String TAG = MainController.class.getSimpleName();

    @Resource
    private UserService userService;

    @RequestMapping(value = "/")
    public String index(Model model) {
//        return "users/login";
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }
}

