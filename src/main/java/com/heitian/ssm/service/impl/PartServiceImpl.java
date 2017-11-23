package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.GetPartsDao;
import com.heitian.ssm.model.Parts;
import com.heitian.ssm.service.PartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/19.
 */
@Service
public class PartServiceImpl implements PartsService {
    @Resource
    GetPartsDao dao;

    public List<String> getParts() {
        return dao.getPartsName();
    }

    public List<String> getSicks(String parts, String getSignal) {
        if (getSignal.equals("getParts"))
            return dao.getSicksName(parts);
        else
            return dao.getCrowdSickName(parts);
    }

    public Parts getSicksContent(Integer parts, String sicksName, String getSignal) {
        if (getSignal.equals("getParts"))
            return dao.getSicksContent(parts, sicksName);
        else
            return dao.getCrowdSicksContent(parts, sicksName);
    }
}
