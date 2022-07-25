package com.programacionbackend.programacionbackend.infraestructure.database.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.programacionbackend.programacionbackend.core.like.Like;
import com.programacionbackend.programacionbackend.core.post.Post;
import com.programacionbackend.programacionbackend.core.user.User;

@Entity()
@Table(name = "user")
public class UserEntity implements User {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 120, nullable = false, unique = true)
    private String email;

    @Column(length = 25, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 160, nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostEntity> posts;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LikeEntity> likes;

    @Override
    public void setId(Long value) {
        this.id = value;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setEmail(String value) {
        this.email = value;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setFirstName(String value) {
        this.firstName = value;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setLastName(String value) {
        this.lastName = value;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setPassword(String value) {
        this.password = value;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public List<Post> getPosts() {
        return this.posts != null ? this.posts.stream().map(e -> (Post) e).collect(Collectors.toList()) : Collections.emptyList();
    }

    @Override
    public void setPosts(List<Post> posts) {
        this.posts = posts.stream().map(e -> (PostEntity) e).collect(Collectors.toList());
    }

    @Override
    public List<Like> getLikes() {
        return this.likes != null ? this.likes.stream().map(e -> (Like) e).collect(Collectors.toList()) : Collections.emptyList();
    }

    @Override
    public void setLikes(List<Like> likes) {
        this.likes = likes.stream().map(e -> (LikeEntity) e).collect(Collectors.toList());
    }
}