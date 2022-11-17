package com.vtxlab.demo.post.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;
import com.vtxlab.demo.post.repository.PostRepository;
import com.vtxlab.demo.post.service.PostService;

@Service
public class LihkgPostService implements PostService {

  @Autowired // = new PostRepository();
  PostRepository postRepository;

  @Override
  public List<Post> findAllPost() {
    return postRepository.findAll();
  }

  @Override
  public Post findPostById(Long id) {
    return postRepository.findById(id).orElse(null);
  }

  @Override
  public List<Post> saveAllPost(List<Post> posts) {
    return postRepository.saveAll(posts);
  }

  @Override
  public Post savePost(Post post) throws KeyExistException {
    if (findPostById(post.getId()) == null) {
      return postRepository.save(post);
    }
    throw new KeyExistException();
  }
}
