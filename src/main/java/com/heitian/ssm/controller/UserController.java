package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.heitian.ssm.model.Parts;
import com.heitian.ssm.model.Posts;
import com.heitian.ssm.model.SickContent;
import com.heitian.ssm.service.DepartmentService;
import com.heitian.ssm.service.PostService;
import com.heitian.ssm.service.UserService;
import com.heitian.ssm.service.impl.PartServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PostService post;
    private HoldData data = new HoldData();
    @Resource
    private PartServiceImpl parts;


    @RequestMapping(value = "/fuck_you", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> Test(HttpServletRequest request) {
        System.out.println(request.getParameter("userName"));
        Map<String, String> map = new HashMap<String, String>();
//        System.out.println(list.get(0).get("userName"));
        map.put("one", "shit");
        JSONObject json = new JSONObject();
        json.put("one", "shit");
        return map;
    }

    @RequestMapping("/getDepartments")
    @ResponseBody
    public List getAllDepartments() {
        List<String> list = departmentService.getDepartments();
        this.data.setDepartments(list);
        return list;
    }

    @RequestMapping("/getDepartments/{Department}")
    @ResponseBody
    public List getAllDepartment(@PathVariable String Department) {
        List<String> department = departmentService.getDepartment((String) data.getDepartments().get(Integer.parseInt(Department)));
        data.setDepartment(department);
        return department;
    }

    @RequestMapping("/getDepartments/{Department}/{sickName}")
    @ResponseBody
    public List getAllSicks(@PathVariable String Department, @PathVariable String sickName) {
//        List<String> sick_names = departmentService.getSicks((String) data.getDepartment().get(Integer.parseInt(sickName)));
//        data.setSick_name(sick_names);
//        System.out.println(Department + "sick:"+sickName);
//        for (String value : sick_names)
//            System.out.println(value);
        return  departmentService.getSicks(Integer.parseInt(Department),Integer.parseInt(sickName));
    }

    @RequestMapping("/getDepartments/{Department}/{sickName}/{contents}")
    @ResponseBody
    public SickContent getContents(@PathVariable String Department, @PathVariable String sickName, @PathVariable String contents) {
        return departmentService.getContents(Integer.parseInt(Department),Integer.parseInt(sickName),Integer.parseInt(contents));
    }

    @ResponseBody
    @RequestMapping("/getPosts/{abbreviation}")
    public List getPosts(@PathVariable("abbreviation") String abbreviation) {
        return post.getPosts(abbreviation);
    }

    @ResponseBody
    @RequestMapping("/getParts")
    public List getParts() {
        data.setParts_name(parts.getParts());
        return data.getParts_name();
    }

    @ResponseBody
    @RequestMapping("/getParts/{PartId}")
    public List getSickName(@PathVariable("PartId") String id) {
        data.setSicks_in_parts(parts.getSicks(data.getParts_name().get(Integer.parseInt(id)), "getParts"));
        return data.getSicks_in_parts();
    }
    @ResponseBody
    @RequestMapping("/getPosts/posts/{PostId}")
    public Posts getContent(@PathVariable("PostId") String id) {
        return post.getContent(Integer.parseInt(id));
    }

    @ResponseBody
    @RequestMapping("/getParts/{PartId}/{SickName}")
    public Parts getPartsSickContents(@PathVariable("PartId") String num, @PathVariable("SickName") String id) {
        return parts.getSicksContent(Integer.parseInt(id), data.getParts_name().get(Integer.parseInt(num)), "getParts");
    }

    @ResponseBody
    @RequestMapping("/getCrowdSick")
    public List getCrowdName() {
        List<String> list = new ArrayList();
        list.add("男人");
        list.add("女人");
        list.add("老人");
        list.add("小孩");
        data.setParts_name(list);
        return data.getParts_name();
    }

    @ResponseBody
    @RequestMapping("/getCrowdSick/{PartId}")
    public List getCrowdSickName(@PathVariable("PartId") String id) {
        data.setSicks_in_parts(parts.getSicks(data.getParts_name().get(Integer.parseInt(id)), "fuck"));
        return data.getSicks_in_parts();
    }

    @ResponseBody
    @RequestMapping("/getCrowdSick/{PartId}/{SickName}")
    public Parts getCrowdSickContent(@PathVariable("PartId") String num, @PathVariable("SickName") String id) {
        return parts.getSicksContent(Integer.parseInt(id), data.getParts_name().get(Integer.parseInt(num)), "fuck");
    }
}
