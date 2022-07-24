package com.programacionbackend.programacionbackend.core.post;

import java.util.List;

public interface PostRepository {
    public Post create(Post post);
    public Post update(Integer id, Post post);
    public Boolean delete(Integer id);
    public List<Post> getPostsByUser(String email);
    public List<Post> getAllPosts();
    public Post getPostById(Integer id);
    public List<Post> getAllPostsWithCountLikes();
}
