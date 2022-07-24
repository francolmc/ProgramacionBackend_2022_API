package com.programacionbackend.programacionbackend.core.like;

public interface LikeRepository <T extends Like> {
    public T save(T like);
    public T findLikeById(Long id);
    public Integer countLikesByPostId(Long postId);
    public T findLikeByPostIdAndUserEmail(Long postId, String email);
}
