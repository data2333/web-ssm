package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.PostDao;
import com.heitian.ssm.model.Posts;
import com.heitian.ssm.service.PostService;
import com.heitian.ssm.util.GetHost;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/11.
 */
@Service
public class PostServiceImpl implements PostService{
    @Resource
    private PostDao dao;
    public List<Posts> getPosts(String abbreviation) {
        List<Posts> list=dao.getPostsByAbbreviation(abbreviation);
        for (Posts index:list) {
            index.setUrl(GetHost.url+"/user/getPosts/posts/"+index.getId());
            index.setImageAddress(GetHost.url+index.getImageAddress());
        }
        return list;
    }

    public Posts getContent(Integer id) {
        return dao.getContentsById(id);
    }
}
