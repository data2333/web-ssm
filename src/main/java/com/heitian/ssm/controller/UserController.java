package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.UserService;
import com.heitian.ssm.service.test;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model) {
        log.info("查询所有用户信息");
        System.out.println(userService.getAllUser());
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "showUser";
    }

    @RequestMapping("/fuck")
    public String AJaxTest() {
        return "AjaxTest";
    }

    @RequestMapping(value = "/fuck_you",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> Test(HttpServletRequest request) {
        System.out.println(request.getParameter("userName"));
        Map<String,String> map=new HashMap<String, String>();
//        System.out.println(list.get(0).get("userName"));
        map.put("one","shit");
        JSONObject json=new JSONObject();
        json.put("one","shit");
        return map;
    }
    @ResponseBody
    @RequestMapping(value="/student",method=RequestMethod.POST)
    public String student(@RequestBody Map students ){
//        for(Map s : students){
            System.out.println("学生姓名:"+students.get("name"));
//        }
        return "ok";
    }
    @Test
    public void test() {
        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(userService.getAllUser());
    }
}
class Student{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}