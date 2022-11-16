package com.vtxlab.demo.mysql.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vtxlab.demo.mysql.model.HelloWorldDto;
import com.vtxlab.demo.mysql.model.PostDto;
import com.vtxlab.demo.mysql.service.MysqlService;

@Controller
@ResponseBody
@RequestMapping(value = "/api/mysql")

public class MysqlController {
  @Autowired
  ModelMapper modelMapper;

  @Autowired
  MysqlService mysqlService;

  @GetMapping(value = "/helloworld")
  public HelloWorldDto helloWorld() {
    return mysqlService.helloworldservice();
  }

  @GetMapping(value = "/posts")
  public ResponseEntity<List<PostDto>> getAllPosts() {
    List<PostDto> postDto = mysqlService.getAllPosts().stream()
        .map(post -> modelMapper.map(post, PostDto.class))
        .collect(Collectors.toList());
    return ResponseEntity.ok().body(postDto);
  }
}
