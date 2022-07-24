package com.programacionbackend.programacionbackend.core.like;

public interface LikeRepository {
    public Boolean putLike(Integer postId, String userEmail);
    public Boolean disLike(Integer postId, String userEmail);
    public Boolean existLike(Integer postId, String userEmail);
    public Integer countLikes(Integer postId);
}
