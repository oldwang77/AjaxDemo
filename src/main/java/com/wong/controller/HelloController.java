package com.wong.controller;

import com.wong.entry.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.put("msg", "SpringBoot Ajax 示例");
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public String home() {
        // responseBody表示返回的是json
        return "home";
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public List<User> data() {
        List<User> list = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setName("springboot" + i);
            user.setSex("male");
            user.setAge(i + 1);
            user.setRole("developer");
            list.add(user);
        }
        return list;
    }

}
