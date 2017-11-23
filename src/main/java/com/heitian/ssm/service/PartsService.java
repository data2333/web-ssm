package com.heitian.ssm.service;

import com.heitian.ssm.model.Parts;

import java.util.List;

/**
 * Created by Administrator on 2017/11/19.
 */
public interface PartsService {
    List<String> getParts();

    List<String> getSicks(String parts,String getSignal);

    Parts getSicksContent(Integer parts, String sicksName,String getSignal);
}