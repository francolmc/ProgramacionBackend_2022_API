package com.programacionbackend.programacionbackend.core.post;

import java.util.List;

import com.programacionbackend.programacionbackend.core.user.User;
import com.programacionbackend.programacionbackend.core.user.UserRepository;

public class PostDomain<P extends Post, U extends User> {
    private PostRepository<P> _postRepository;
    private UserRepository<U> _userRepository;

    /* public PostDomain(PostRepository<P> postRepository, UserRepository<U> userRepository) {
        this._postRepository = postRepository;
        this._userRepository = userRepository;
    } */

    public P create(String email, P post) {
        U user = this._userRepository.findUserByEmail(email);
        post.setUser(user);
        return this._postRepository.save(post);
    }

    public P update(String ownerEmail, Long id, P post) {
        P originalPost = this.getPostById(id);
        if(originalPost.getUser().getEmail() != ownerEmail) {
            throw new Error("You not have access for modify this post.");
        }
        originalPost.setContent(post.getContent());
        originalPost.setTitle(post.getTitle());
        return this._postRepository.save(originalPost);
    }

    public void delete(String ownerEmail, Long id) {
        P originalPost = this.getPostById(id);
        if(originalPost.getUser().getEmail() != ownerEmail) {
            throw new Error("You not have access for delete this post.");
        }
        this._postRepository.deleteById(id);
    }

    public List<P> getPostsByUserEmail(String email) {
        return this._postRepository.findPostsByUserEmail(email);
    }

    public P getPostById(Long id) {
        return this._postRepository.findPostById(id);
    }

    public List<P> getAllPosts() {
        return this._postRepository.findAll();
    }
}
