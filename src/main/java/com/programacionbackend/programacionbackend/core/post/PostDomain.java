package com.programacionbackend.programacionbackend.core.post;

import java.util.Set;

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
        User user = this._userRepository.findUserByEmail(email);
        post.setUser(user);
        return this._postRepository.savePost(post);
    }

    public Post update(String ownerEmail, Long id, Post post) {
        Post originalPost = this.getPostById(id);
        if(originalPost.getUser().getEmail() != ownerEmail) {
            throw new Error("You not have access for modify this post.");
        }
        originalPost.setContent(post.getContent());
        originalPost.setTitle(post.getTitle());
        return this._postRepository.savePost(originalPost);
    }

    public void delete(String ownerEmail, Long id) {
        Post originalPost = this.getPostById(id);
        if(originalPost.getUser().getEmail() != ownerEmail) {
            throw new Error("You not have access for delete this post.");
        }
        this._postRepository.deleteById(id);
    }

    public Set<Post> getPostsByUserEmail(String email) {
        return this._postRepository.findPostsByUserEmail(email);
    }

    public Post getPostById(Long id) {
        return this._postRepository.findPostById(id);
    }

    public Set<Post> getAllPosts() {
        return this._postRepository.findAllPosts();
    }
}
