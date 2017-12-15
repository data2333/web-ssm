package com.heitian.ssm.controller;

import com.heitian.ssm.model.Comments;
import com.heitian.ssm.model.Message;
import com.heitian.ssm.model.Pages;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.CommentService;
import com.heitian.ssm.service.FoodsService;
import com.heitian.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    CommentService commentService;
    @Resource
    FoodsService foodsService;
    @Resource
    UserService userService;

    @RequestMapping("/addComments/{contents}/{user_id}/{post_id}/{comments_id}")
    public void addComments(@PathVariable("contents") String content, @PathVariable("user_id") Integer user_id, @PathVariable("post_id") Integer post_id,@PathVariable("comments_id")Integer comments_id){
        commentService.addComments(content, user_id, post_id,comments_id);
    }

    @RequestMapping("/getComments/{post_id}")
    @ResponseBody
    public List<Comments> getComments(@PathVariable("post_id") Integer post_id) {
        return commentService.getComments(post_id);
    }

    @RequestMapping("/addPraise/{user_id}/{post_id}")
    public void addPraise(@PathVariable("user_id") Integer user_id, @PathVariable("post_id") Integer post_id) {
        userService.addPraise(user_id, post_id);
    }

    @RequestMapping("/getHandler/{id}")
    public String getHandler(@PathVariable("id") Integer id, ModelMap map) {
        Pages pages = foodsService.getHandler(id);
        map.addAttribute("eat_together", pages.not_eat_together);
        map.addAttribute("about_warning", pages.about_warning);
        map.addAttribute("mother", pages.mother);
        map.addAttribute("baby", pages.baby);
        return "cnkang";
    }

    @RequestMapping("/addUsers/{user_name}/{user_pwd}/{user_phone}")
    @ResponseBody
    public Message getLoginMessage(@PathVariable("user_name") String user_name, @PathVariable("user_pwd") String user_pwd, @PathVariable("user_phone") String user_phone) {
        return userService.addUserWithPhone(user_name, user_pwd, user_phone);
    }
    @RequestMapping("/checkUsers/{user_phone}/{user_pwd}")
    @ResponseBody
    public Message LoginCheck(@PathVariable("user_phone") String user_phone, @PathVariable("user_pwd") String user_pwd) {
        return userService.checkLogin(user_phone, user_pwd);
    }
    @RequestMapping("/getCollection/{user_id}")
    @ResponseBody
    public User getCollection(@PathVariable("user_id") Integer user_id) {
        return userService.getCollection(user_id);
    }
}
