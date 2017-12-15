package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.PostDao;
import com.heitian.ssm.dao.UserDao;
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
public class PostServiceImpl implements PostService {
    @Resource
    private PostDao dao;
    @Resource
    private UserDao user;
    public List<Posts> getPosts(String abbreviation) {
        List<Posts> list = dao.getPostsByAbbreviation(abbreviation);
        for (Posts index : list) {
            index.setUrl(GetHost.url + "/user/getPosts/posts/" + index.getId());
            index.setImageAddress(index.getImageAddress());
            index.setComments_url(GetHost.url+"/user/getComments/"+index.getId());
        }
        return list;
    }
    public Posts getContent(Integer user_id, Integer post_id) {
        Posts posts = dao.getPostsById(post_id);
        posts.setIs_user_praise(user.isUserHasPraise(user_id,post_id)!=null);
        dao.addScan_num(post_id);
        return posts;
    }
    public Posts sendRedirect(Integer post_id) {
        return dao.sendRedirect(post_id);
    }
}
