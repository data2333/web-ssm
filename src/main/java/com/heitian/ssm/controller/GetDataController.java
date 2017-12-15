package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.heitian.ssm.model.*;
import com.heitian.ssm.service.DepartmentService;
import com.heitian.ssm.service.FoodsService;
import com.heitian.ssm.service.PostService;
import com.heitian.ssm.service.UserService;
import com.heitian.ssm.service.impl.PartServiceImpl;
import com.heitian.ssm.service.impl.Experiment;
import com.heitian.ssm.util.HoldData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class GetDataController {
    private Logger log = Logger.getLogger(GetDataController.class);
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PostService post;
    private HoldData data = new HoldData();
    @Resource
    private PartServiceImpl parts;
    @Resource
    Experiment fuck;
    @Resource
    FoodsService foods;

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
        return departmentService.getSicks(Integer.parseInt(Department), Integer.parseInt(sickName));
    }

    @RequestMapping("/getDepartments/{Department}/{sickName}/{contents}")
    @ResponseBody
    public SickContent getContents(@PathVariable String Department, @PathVariable String sickName, @PathVariable String contents) {
        return departmentService.getContents(Integer.parseInt(Department), Integer.parseInt(sickName), Integer.parseInt(contents));
    }

    @ResponseBody
    @RequestMapping("/getPosts/{abbreviation}")
    public List getPosts(@PathVariable("abbreviation") String abbreviation) {
        return post.getPosts(abbreviation);
    }

    @ResponseBody
    @RequestMapping("/getParts")
    public List getParts() {
        return parts.getParts();
    }

    @ResponseBody
    @RequestMapping("/getParts/{PartId}")
    public List getSickName(@PathVariable("PartId") Integer id) {
        return parts.getSicks(parts.getParts().get(id), "getParts");
    }

    @ResponseBody
    @RequestMapping("/getParts/{PartId}/{SickName}")
    public Parts getPartsSickContents(@PathVariable("PartId") Integer num, @PathVariable("SickName") Integer id) {
        return parts.getSicksContent(id, parts.getParts().get(num), "getParts");
    }

    @ResponseBody
    @RequestMapping("/getPosts/posts/{PostId}/{UserId}")
    public Posts getContent(@PathVariable("PostId") Integer post_id, @PathVariable("UserId") Integer user_id) {
        return post.getContent(user_id, post_id);
    }

    @RequestMapping("/getPosts/sendRedirect/{PostId}")
    public String sendRedirect(@PathVariable("PostId") Integer id, ModelMap map) {
        map.addAttribute("post", post.sendRedirect(id));
        return "sendToOthers";
    }


    @ResponseBody
    @RequestMapping("/getCrowdSick")
    public List getCrowdName() {
        List<String> list = new ArrayList();
        list.add("男人");
        list.add("女人");
        list.add("老人");
        list.add("小孩");
//        data.setParts_name(list);
        return list;
    }

    @ResponseBody
    @RequestMapping("/getCrowdSick/{PartId}")
    public List getCrowdSickName(@PathVariable("PartId") Integer id) {
        List<String> list = new ArrayList();
        list.add("男人");
        list.add("女人");
        list.add("老人");
        list.add("小孩");
        return parts.getSicks(list.get(id), "fuck");
    }

    @ResponseBody
    @RequestMapping("/getCrowdSick/{PartId}/{SickName}")
    public Parts getCrowdSickContent(@PathVariable("PartId") Integer num, @PathVariable("SickName") Integer id) {
        List<String> list = new ArrayList();
        list.add("男人");
        list.add("女人");
        list.add("老人");
        list.add("小孩");
        return parts.getSicksContent(id, list.get(num), "fuck");
    }

    @ResponseBody
    @RequestMapping("/addTime")
    public void addTime() {
        fuck.addTime();
    }

    @ResponseBody
    @RequestMapping("/getTime")
    public Time getTime() {
        String time = fuck.getTime();
        System.out.println(time);
        Time obj = new Time();
        obj.setTime(time);
        return obj;
    }

    @ResponseBody
    @RequestMapping("/getFoods/{kind}")
    public List<String> getFoodsByKind(@PathVariable("kind") String kind) {
        return foods.getFoodsByKind(kind);
    }

    @ResponseBody
    @RequestMapping("/getFoods/{kind}/{foodsNum}")
    public Foods getFoodsInformation(@PathVariable("kind") String kind, @PathVariable("foodsNum") Integer foodNum) {
        return foods.getFoodsInformation(kind, foodNum);
    }
    @ResponseBody
    @RequestMapping("/getKey/{KeyWord}")
    public List<Foods> getKeyWords(@PathVariable("KeyWord") String key) {
        return foods.getFoodsByKey(key);
    }
    @ResponseBody
    @RequestMapping("/getFoodsByName/{FoodsName}")
    public Foods getFoodsByWords(@PathVariable("FoodsName") String FoodsName) {
        return foods.getFoodsInformationByName(FoodsName);
    }
}
