package com.programacionbackend.programacionbackend.core.like;

import com.programacionbackend.programacionbackend.core.post.Post;
import com.programacionbackend.programacionbackend.core.user.User;

public interface Like {
    public Long getId();
    public void setId(Long value);

    public Boolean getHaveLike();
    public void setHaveLike(Boolean value);

    public User getUser();
    public void setUser(User user);

    public Post getPost();
    public void setPost(Post post);
}
