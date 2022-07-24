package com.programacionbackend.programacionbackend.core.user;

import java.util.Set;

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

    public void setPasswordName(String value);
    public String getPasswordName();

    public Set<Post> getPosts();
    public void setPosts(Set<Post> posts);

    public Set<Like> getLikes();
    public void setLikes(Set<Like> likes);
}
