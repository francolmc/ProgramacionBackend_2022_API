package com.programacionbackend.programacionbackend.core.post;

import java.util.List;

import com.programacionbackend.programacionbackend.core.like.LikeEntity;
import com.programacionbackend.programacionbackend.core.user.UserEntity;

public interface PostEntity {
    public Integer getId();
    public void setId(Integer value);

    public String getTitle();
    public void setTitle(String value);

    public String getContent();
    public void setContent(String value);

    public UserEntity getUser();
    public void setUser();

    public List<LikeEntity> getLikes();
    public void setLikes(List<LikeEntity> likes);
}
