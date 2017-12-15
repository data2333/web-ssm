package com.heitian.ssm.service;

import com.heitian.ssm.model.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */

public interface CommentService {
    void addComments(String contents, Integer user_id, Integer post_id,Integer comment_id);
    List<Comments> getComments(Integer post_id);
}
