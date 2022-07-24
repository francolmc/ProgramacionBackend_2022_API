package com.programacionbackend.programacionbackend.core.like;

import com.programacionbackend.programacionbackend.core.post.Post;
import com.programacionbackend.programacionbackend.core.post.PostRepository;
import com.programacionbackend.programacionbackend.core.user.User;
import com.programacionbackend.programacionbackend.core.user.UserRepository;

public class LikeDomain {
    private LikeRepository _likeRepository;
    private UserRepository _userRepository;
    private PostRepository _postRepository;

    public LikeDomain(LikeRepository likeRepository, UserRepository userRepository, PostRepository postRepository) {
        this._postRepository = postRepository;
        this._likeRepository = likeRepository;
        this._userRepository = userRepository;
    }

    public Boolean putLike(Like like, Long postId, String userEmail) {
        User user = this._userRepository.findUserByEmail(userEmail);
        Post post = this._postRepository.findPostById(postId);
        like.setLike(true);
        like.setPost(post);
        like.setUser(user);
        this._likeRepository.saveLike(like);
        return true;
    }

    public Boolean disLike(Long postId, String userEmail) {
        Like like = this._likeRepository.findLikeByPostIdAndUserEmail(postId, userEmail);
        if(like == null) return false;
        like.setLike(false);
        this._likeRepository.saveLike(like);
        return true;
    }

    public Integer countLikes(Long postId) {
        return this._likeRepository.countLikesByPostId(postId);
    }
}
