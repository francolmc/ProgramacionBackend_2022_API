package com.programacionbackend.programacionbackend.core.post;

import java.util.Set;

public interface PostRepository {
    public Post savePost(Post post);
    public void deleteById(Long id);
    public Set<Post> findPostsByUserEmail(String email);
    public Set<Post> findAllPosts();
    public Post findPostById(Long id);
}
