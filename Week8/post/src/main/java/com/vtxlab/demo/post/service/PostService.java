package com.vtxlab.demo.post.service;

import java.util.List;

import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;
import com.vtxlab.demo.post.model.PostDto;

/**
 * @author vincent.lau
 */
public interface PostService {
  List<Post> findAllPost();

  Post findPostById(Long id);

  List<Post> saveAllPost(List<Post> posts);

  Post savePost(Post post) throws KeyExistException;

  Post deletePostById(Long id);

  List<Post> findPostByTitle(String title);

  List<PostDto> findPostsByUserId(String userId);
}
