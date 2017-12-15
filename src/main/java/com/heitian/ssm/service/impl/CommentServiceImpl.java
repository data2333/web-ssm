package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.CommentDao;
import com.heitian.ssm.model.Comments;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.CommentService;
import com.heitian.ssm.util.TimeHandler;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentDao dao;

    public void addComments(String contents, Integer user_id, Integer post_id, Integer comments_id) {
        String time = TimeHandler.getTimeNow();
        dao.addComments(contents, user_id, post_id, time, comments_id);
    }

    public List<Comments> getComments(Integer post_id) {
        List<Comments> comments = dao.getComment(post_id);
        for (Comments commentList : comments) {
            List<Comments> ChildCommentList = dao.getSonComment(commentList.getId());
            for (Comments ChildComments : ChildCommentList) {
                if (ChildComments.getReply_obj_id() != -1)
                {
                    ChildComments.setReplyPerson(dao.getAuthorName(ChildComments.getReply_obj_id()));
                }
                ChildComments.setCreate_time(TimeHandler.getTime(ChildComments.getCreate_time()));
            }
            commentList.setComments(ChildCommentList);
        }
        for (Comments comment : comments) {
            comment.setCreate_time(TimeHandler.getTime(comment.getCreate_time()));
        }
        return comments;
    }
}
