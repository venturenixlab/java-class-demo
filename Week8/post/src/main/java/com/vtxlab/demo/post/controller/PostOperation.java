package com.vtxlab.demo.post.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;
import com.vtxlab.demo.post.respsonse.ApiResponse;

@RequestMapping(value = "/default")
public interface PostOperation {

  @GetMapping(value = "/posts")
  List<Post> findAllPost();

  @GetMapping(value = "/posts/id/{id}")
  Post findPostById(@PathVariable Long id);

  @PostMapping(value = "/posts")
  List<Post> saveAllPost(@RequestBody List<Post> posts);

  @PostMapping(value = "/post")
  ResponseEntity<ApiResponse<Post>> savePost(@RequestBody Post post)
      throws KeyExistException;

}
