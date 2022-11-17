package com.vtxlab.demo.post.service;

import java.util.List;

import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;

public interface PostService {
  List<Post> findAllPost();

  Post findPostById(Long id);

  List<Post> saveAllPost(List<Post> posts);

  Post savePost(Post post) throws KeyExistException;

}
