package com.programacionbackend.programacionbackend.core.post;

import java.util.Set;

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

    public Set<Like> getLikes();
    public void setLikes(Set<Like> likes);

    public Integer getCountLikes();
}
