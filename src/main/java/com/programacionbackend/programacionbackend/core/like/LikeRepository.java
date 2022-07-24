package com.programacionbackend.programacionbackend.core.like;

public interface LikeRepository {
    public Like saveLike(Like like);
    public Like findLikeById(Long id);
    public Integer countLikesByPostId(Long postId);
    public Like findLikeByPostIdAndUserEmail(Long postId, String email);
}
