package com.programacionbackend.programacionbackend.core.post;

import java.util.List;

import com.programacionbackend.programacionbackend.core.user.User;
import com.programacionbackend.programacionbackend.core.user.UserRepository;

public class PostDomain {
    private PostRepository _postRepository;
    private UserRepository _userRepository;

    public PostDomain(PostRepository postRepository, UserRepository userRepository) {
        this._postRepository = postRepository;
        this._userRepository = userRepository;
    }

    public Post create(String email, Post post) {
        User user = this._userRepository.getUserByEmail(email);
        post.setUser(user);
        return this._postRepository.create(post);
    }

    public Post update(String ownerEmail, Integer id, Post post) {
        Post originalPost = this._postRepository.getPostById(id);
        if(originalPost.getUser().getEmail() != ownerEmail) {
            throw new Error("You not have access for modify this post.");
        }
        originalPost.setContent(post.getContent());
        originalPost.setTitle(post.getTitle());
        return this._postRepository.update(id, originalPost);
    }

    public Boolean delete(String ownerEmail, Integer id) {
        Post originalPost = this._postRepository.getPostById(id);
        if(originalPost.getUser().getEmail() != ownerEmail) {
            throw new Error("You not have access for delete this post.");
        }
        return this._postRepository.delete(id);
    }

    public List<Post> getPostsByUserEmail(String email) {
        return this._postRepository.getPostsByUser(email);
    }

    public Post getPostById(Integer id) {
        return this._postRepository.getPostById(id);
    }

    public List<Post> getAllPosts() {
        return this._postRepository.getAllPosts();
    }

    public List<Post> getAllPostsWithCountLike() {
        return this._postRepository.getAllPostsWithCountLikes();
    }
}
