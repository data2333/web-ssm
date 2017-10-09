package com.heitian.ssm.service.impl;

import com.heitian.ssm.service.test;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/3.
 */
@Service
public class testImpl implements test {
    public Integer shit() {
        System.out.println("fuck");
        return 2;
    }
}
