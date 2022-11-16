package com.vtxlab.demo.post.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.post.entity.Post;

@RequestMapping(value = "/default")
public interface PostOperation {

  @GetMapping(value = "/posts")
  ResponseEntity<List<Post>> getAllPost();

}
