package com.heitian.ssm.model;

import java.util.List;

/**
 * Created by Administrator on 2017/11/24.
 */
public class Comments {
    private Integer id;
    private String content;
    private User ReplyPerson;

    public User getReplyPerson() {
        return ReplyPerson;
    }

    public void setReplyPerson(User replyPerson) {
        ReplyPerson = replyPerson;
    }

    private String create_time;
    private Integer author_id;
    private String author_name;
    private User author;

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", ReplyPerson='" + ReplyPerson + '\'' +
                ", create_time='" + create_time + '\'' +
                ", author_id=" + author_id +
                ", author_name='" + getAuthor_name() + '\'' +
                ", author=" + author +
                ", father_comment_id=" + father_comment_id +
                ", reply_obj_id=" + reply_obj_id +
                ", comments=" + comments +
                '}';
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getReply_obj_id() {
        return reply_obj_id;
    }

    public void setReply_obj_id(Integer reply_obj_id) {
        this.reply_obj_id = reply_obj_id;
    }

    private Integer father_comment_id;

    public Integer getFather_comment_id() {
        return father_comment_id;
    }

    public void setFather_comment_id(Integer father_comment_id) {
        this.father_comment_id = father_comment_id;
    }

    private Integer reply_obj_id;
    List<Comments> comments;

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }



    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }


    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }


}
