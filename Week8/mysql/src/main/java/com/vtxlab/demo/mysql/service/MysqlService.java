package com.vtxlab.demo.mysql.service;

import java.util.List;

import com.vtxlab.demo.mysql.Entity.Post;
import com.vtxlab.demo.mysql.model.HelloWorldDto;

public interface MysqlService {
  HelloWorldDto helloworldservice();

  List<Post> getAllPosts();
}
