package com.heitian.ssm.dao;

import com.heitian.ssm.model.Posts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/11/11.
 */
public interface PostDao {
    List<Posts> getPostsByAbbreviation(@Param("abbreviation") String abbreviation);
    Posts getContentsById(@Param("id") Integer id);
    Integer selectPraise(@Param("post_id") Integer post_id);
    Posts sendRedirect(@Param("post_id") Integer post_id);
    List<Integer> getPosts(@Param("user_id") Integer user_id);
    Posts getPostsById(@Param("post_id")Integer id);
    void addScan_num(@Param("post_id")Integer post_id);
}
