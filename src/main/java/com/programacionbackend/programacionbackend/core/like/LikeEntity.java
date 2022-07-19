package com.programacionbackend.programacionbackend.core.like;

import com.programacionbackend.programacionbackend.core.post.PostEntity;
import com.programacionbackend.programacionbackend.core.user.UserEntity;

public interface LikeEntity {
    public Integer getId();
    public void setId(Integer value);

    public Boolean getLike();
    public void setLike(Boolean value);

    public UserEntity getUser();
    public void setUser(UserEntity user);

    public PostEntity getPost();
    public void setPost(PostEntity post);
}
