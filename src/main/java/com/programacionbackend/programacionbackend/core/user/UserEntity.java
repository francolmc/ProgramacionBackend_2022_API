package com.programacionbackend.programacionbackend.core.user;

import java.util.List;

import com.programacionbackend.programacionbackend.core.post.PostEntity;

public interface UserEntity {
    public void setId(Integer value);
    public Integer getId();

    public void setEmail(String value);
    public String getEmail();

    public void setFirstName(String value);
    public String getFirstName();

    public void setLastName(String value);
    public String getLastName();

    public void setPasswordName(String value);
    public String getPasswordName();

    public List<PostEntity> getPosts();
    public void setPosts(List<PostEntity> posts);
}
