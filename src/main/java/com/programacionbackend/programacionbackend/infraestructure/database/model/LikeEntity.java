package com.programacionbackend.programacionbackend.infraestructure.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.programacionbackend.programacionbackend.core.like.Like;
import com.programacionbackend.programacionbackend.core.post.Post;
import com.programacionbackend.programacionbackend.core.user.User;

@Entity()
@Table(name = "likes")
public class LikeEntity implements Like {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Boolean haveLike;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private PostEntity post;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long value) {
        this.id = value;
    }

    @Override
    public Boolean getHaveLike() {
        return this.haveLike;
    }

    @Override
    public void setHaveLike(Boolean value) {
        this.haveLike = value;
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public void setUser(User user) {
        this.user = (UserEntity) user;
    }

    @Override
    public Post getPost() {
        return this.post;
    }

    @Override
    public void setPost(Post post) {
        this.post = (PostEntity) post;
    }
}
