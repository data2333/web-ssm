package com.heitian.ssm.dao;

import com.heitian.ssm.model.Posts;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */
@Repository
public interface PostsDao {
    List<Posts> getAll(@Param("kind") String kind);
    List<Posts> getAllPosts();
}
