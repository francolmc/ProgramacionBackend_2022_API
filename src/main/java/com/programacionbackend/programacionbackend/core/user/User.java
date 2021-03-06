package com.programacionbackend.programacionbackend.core.user;

import java.util.List;

import com.programacionbackend.programacionbackend.core.like.Like;
import com.programacionbackend.programacionbackend.core.post.Post;

public interface User {
    public void setId(Long value);
    public Long getId();

    public void setEmail(String value);
    public String getEmail();

    public void setFirstName(String value);
    public String getFirstName();

    public void setLastName(String value);
    public String getLastName();

    public void setPassword(String value);
    public String getPassword();

    public List<Post> getPosts();
    public void setPosts(List<Post> posts);

    public List<Like> getLikes();
    public void setLikes(List<Like> likes);
}
