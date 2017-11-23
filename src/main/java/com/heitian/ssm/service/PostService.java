package com.heitian.ssm.service;

import com.heitian.ssm.model.Posts;

import java.util.List;

/**
 * Created by Administrator on 2017/11/11.
 */
public interface PostService {
    List<Posts> getPosts(String abbreviation);
    Posts getContent(Integer id);
}
