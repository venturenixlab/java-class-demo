package com.vtxlab.demo.post.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.repository.PostRepository;
import com.vtxlab.demo.post.service.PostService;

@Service
public class PostServiceImpl implements PostService {
  @Autowired
  PostRepository postRepository;

  @Override
  public List<Post> getAllPost() {
    return postRepository.findAll();
  }
}
