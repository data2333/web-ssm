package com.heitian.ssm.dao;

import com.heitian.ssm.model.Parts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/11/19.
 */
public interface GetPartsDao {

    List<String> getPartsName();
    List<String> getSicksName(@Param("PartsName")String PartsName);
    Parts getSicksContent(@Param("SicksNum")Integer num,@Param("PartsName")String PartsName);
    Parts getCrowdSicksContent(@Param("SicksNum")Integer num,@Param("PartsName")String PartsName);
    List<String>getCrowdSickName(@Param("PartsName")String PartsName);
}
