package com.heitian.ssm.service;

import com.heitian.ssm.model.Foods;
import com.heitian.ssm.model.Le_ha_handler;
import com.heitian.ssm.model.Pages;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
public interface FoodsService {
    List<String> getFoodsByKind(String kind);

    Foods getFoodsInformation(String kind, Integer name_num);

    Pages getHandler(Integer id);
    List<Foods> getFoodsByKey(String key);
    Foods getFoodsInformationByName(String name);
}
