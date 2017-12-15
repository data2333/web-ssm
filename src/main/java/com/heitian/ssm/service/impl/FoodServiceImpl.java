package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.GetFoodsDao;
import com.heitian.ssm.model.Foods;
import com.heitian.ssm.model.Le_ha_handler;
import com.heitian.ssm.model.Pages;
import com.heitian.ssm.service.FoodsService;
import com.heitian.ssm.util.GetHost;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/4.
 */
@Service
public class FoodServiceImpl implements FoodsService {
    @Resource
    GetFoodsDao dao;

    public List<String> getFoodsByKind(String kind) {
        return dao.getFoods(kind);
    }

    public Foods getFoodsInformation(String kind, Integer name_num) {
        String name = dao.getFoods(kind).get(name_num);
        Foods object = dao.getFoodsInformation(name, kind);
        String[] list = object.getHead().split("]");
        object.setHead_array(list);
        object.setImageUrl(GetHost.url + "/img/Foods/" + kind + "/" + name + ".png");
        return object;
    }

    public Pages getHandler(Integer id) {
        Le_ha_handler handler = dao.getHandler(id);
        Pages pages = new Pages();
        String[] fuck = handler.getMother_and_baby().split("]");
        pages.mother = fuck[0];
        pages.baby = fuck[1];
        pages.not_eat_together = handler.getNot_eat_togger().equals("") ? "暂无相关相克食物" : handler.getNot_eat_togger();
        pages.about_warning = handler.getAbout_waning().equals("") ? null : handler.getAbout_waning();
        System.out.println(handler.getAbout_waning().equals(""));
        pages.name = handler.getName();
        return pages;
    }

    public List<Foods> getFoodsByKey(String key) {
        List<Foods> foods = dao.getKeyFoods(key);
        for (Foods food : foods) {
            food.setIconUrl(GetHost.url + "/img/icon/" + food.getKind() + "/" + food.getName() + ".png");
            food.setContent_url(GetHost.url+"/user/getFoodsByName/"+food.getName());
        }
        return foods;
    }
    public Foods getFoodsInformationByName(String name) {
        List<Foods> foods = dao.getFoodsByName(name);
        Foods food = foods.get(0);
        String[] list = food.getHead().split("]");
        food.setHead_array(list);
        food.setImageUrl(GetHost.url + "/img/Foods/" + food.getKind() + "/" + name + ".png");
        return food;
    }
}
