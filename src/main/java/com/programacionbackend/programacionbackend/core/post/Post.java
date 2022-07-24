package com.programacionbackend.programacionbackend.core.post;

import java.util.List;

import com.programacionbackend.programacionbackend.core.like.Like;
import com.programacionbackend.programacionbackend.core.user.User;

public interface Post {
    public Long getId();
    public void setId(Long value);

    public String getTitle();
    public void setTitle(String value);

    public String getContent();
    public void setContent(String value);

    public User getUser();
    public void setUser(User user);

    public List<Like> getLikes();
    public void setLikes(List<Like> likes);

    public Integer getCountLikes();
}
