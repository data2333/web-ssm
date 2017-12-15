package com.heitian.ssm.dao;

import com.heitian.ssm.model.Foods;
import com.heitian.ssm.model.Le_ha_handler;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
public interface GetFoodsDao {
    List<String> getFoods(@Param("kind") String kind);
    Foods getFoodsInformation(@Param("name")String name,@Param("kind")String kind);
    Le_ha_handler getHandler(@Param("id")Integer id);
    List<String>getEffects();
    void addEffects(@Param("effects")String effects);
    List<Foods> getKeyFoods(@Param("key")String key_words);
    List<Foods> getFoodsByName(@Param("name")String name);
}
