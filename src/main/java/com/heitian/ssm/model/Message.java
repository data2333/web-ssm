package com.heitian.ssm.model;

/**
 * Created by Administrator on 2017/12/2.
 */
public class Message {
    private Boolean user_name_exits;
    private Boolean user_phone_exits=true;
    private Boolean add_user_success;
    private Boolean Login_in_success=false;
    private User user_message;

    public User getUser_message() {
        return user_message;
    }

    public void setUser_message(User user_message) {
        this.user_message = user_message;
    }

    public Boolean getLogin_in_success() {
        return Login_in_success;
    }

    public void setLogin_in_success(Boolean login_in_success) {
        Login_in_success = login_in_success;
    }

    public Boolean getAdd_user_success() {
        return add_user_success;
    }

    public void setAdd_user_success(Boolean add_user_success) {
        this.add_user_success = add_user_success;
    }

    public Boolean getUser_name_exits() {
        return user_name_exits;
    }

    public void setUser_name_exits(Boolean user_name_exits) {
        this.user_name_exits = user_name_exits;
    }

    public Boolean getUser_phone_exits() {
        return user_phone_exits;
    }

    public void setUser_phone_exits(Boolean user_phone_exits) {
        this.user_phone_exits = user_phone_exits;
    }
}
