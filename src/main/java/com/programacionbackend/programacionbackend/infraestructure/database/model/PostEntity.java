package com.programacionbackend.programacionbackend.infraestructure.database.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.programacionbackend.programacionbackend.core.like.Like;
import com.programacionbackend.programacionbackend.core.post.Post;
import com.programacionbackend.programacionbackend.core.user.User;

@Entity()
@Table(name = "post")
public class PostEntity implements Post {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 120, nullable = false)
    private String title;

    @Column(length = 250, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @OneToMany(mappedBy = "like", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Like> likes;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long value) {
        this.id = value;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String value) {
        this.title = value;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public void setContent(String value) {
        this.content = value;
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Set<Like> getLikes() {
        return this.likes;
    }

    @Override
    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    @Override
    public Integer getCountLikes() {
        return this.likes.size();
    }

}