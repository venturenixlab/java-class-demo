package com.vtxlab.demo.post.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.post.controller.PostOperation;
import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;
import com.vtxlab.demo.post.respsonse.ApiResponse;
import com.vtxlab.demo.post.service.PostService;

@RestController
@RequestMapping(value = "/lihkg/api/v1")
public class LihkgPostController implements PostOperation {

  @Autowired
  PostService postService; // Interface

  @Override
  public List<Post> findAllPost() {
    return postService.findAllPost();
  }

  @Override
  public Post findPostById(Long id) {
    return postService.findPostById(id);
  }

  @Override
  public List<Post> saveAllPost(List<Post> posts) {
    return postService.saveAllPost(posts);
  }

  @Override
  public ResponseEntity<ApiResponse<Post>> savePost(Post post)
      throws Exception {
    ApiResponse<Post> response = ApiResponse.<Post>builder() //
        .code(HttpStatus.OK.value())
        .message("OK")
        .data(postService.savePost(post))
        .build();
    return ResponseEntity.ok().body(response);
  }

}
