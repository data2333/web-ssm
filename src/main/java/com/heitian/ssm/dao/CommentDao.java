package com.heitian.ssm.dao;

import com.heitian.ssm.model.Comments;
import com.heitian.ssm.model.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Administrator on 2017/11/24.
 */
public interface CommentDao {
    List<Comments> getComment(@Param("post_id")Integer post_id);
    Boolean addComments(@Param("comment_contents")String contents, @Param("user_id")Integer user_id, @Param("post_id")Integer post_id, @Param("time")String time,@Param("Comments_id")Integer comments);
    void addTime(@Param("time")Timestamp time);
    Timestamp getTime(@Param("id")Integer id);
    List<Comments> getSonComment(@Param("father_comment_id")Integer comment_id);
    List<Comments> getChildComment(@Param("reply_obj_id")Integer post_id);
    User getAuthorName(@Param("Author_name")Integer author_name);
}
