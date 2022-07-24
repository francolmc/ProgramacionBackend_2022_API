package com.programacionbackend.programacionbackend.core.post;

import java.util.List;

public interface PostRepository <T extends Post> {
    public T save(T post);
    public void deleteById(Long id);
    public List<T> findPostsByUserEmail(String email);
    public List<T> findAll();
    public T findPostById(Long id);
}
