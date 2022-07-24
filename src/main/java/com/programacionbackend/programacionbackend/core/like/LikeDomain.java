package com.programacionbackend.programacionbackend.core.like;

public class LikeDomain {
    private LikeRepository _likeRepository;

    public LikeDomain(LikeRepository likeRepository) {
        this._likeRepository = likeRepository;
    }

    public Boolean putLike(Integer postId, String userEmail) {
        this._likeRepository.putLike(postId, userEmail);
        return true;
    }

    public Boolean disLike(Integer postId, String userEmail) {
        Boolean existLike = this._likeRepository.existLike(postId, userEmail);
        if(!existLike) return false;
        this._likeRepository.disLike(postId, userEmail);
        return true;
    }

    public Integer countLikes(Integer postId) {
        return this._likeRepository.countLikes(postId);
    }
}
