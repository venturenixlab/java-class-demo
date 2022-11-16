package com.vtxlab.demo.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.mysql.Entity.Post;
import com.vtxlab.demo.mysql.model.HelloWorldDto;
import com.vtxlab.demo.mysql.repository.PostRepository;
import com.vtxlab.demo.mysql.service.MysqlService;

@Service
public class MysqlServiceImpl implements MysqlService {
  @Autowired
  private PostRepository postRepository;

  public HelloWorldDto helloworldservice() {
    return new HelloWorldDto("helloworld");
  }

  // business logic, like computations
  // Return
  @Override
  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }
}
