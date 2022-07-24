package com.programacionbackend.programacionbackend.core.like;

import com.programacionbackend.programacionbackend.core.post.Post;
import com.programacionbackend.programacionbackend.core.post.PostRepository;
import com.programacionbackend.programacionbackend.core.user.User;
import com.programacionbackend.programacionbackend.core.user.UserRepository;

public class LikeDomain <U extends User, P extends Post, L extends Like> {
    private LikeRepository<L> _likeRepository;
    private UserRepository<U> _userRepository;
    private PostRepository<P> _postRepository;

    public LikeDomain(LikeRepository<L> likeRepository, UserRepository<U> userRepository, PostRepository<P> postRepository) {
        this._postRepository = postRepository;
        this._likeRepository = likeRepository;
        this._userRepository = userRepository;
    }

    public Boolean putLike(L like, Long postId, String userEmail) {
        U user = this._userRepository.findUserByEmail(userEmail);
        P post = this._postRepository.findPostById(postId);
        like.setHaveLike(true);
        like.setPost(post);
        like.setUser(user);
        this._likeRepository.save(like);
        return true;
    }

    public Boolean disLike(Long postId, String userEmail) {
        L like = this._likeRepository.findLikeByPostIdAndUserEmail(postId, userEmail);
        if(like == null) return false;
        like.setHaveLike(false);
        this._likeRepository.save(like);
        return true;
    }

    public Integer countLikes(Long postId) {
        return this._likeRepository.countLikesByPostId(postId);
    }
}
