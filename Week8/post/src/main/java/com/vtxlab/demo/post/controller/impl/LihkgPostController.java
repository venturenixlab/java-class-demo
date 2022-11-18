package com.vtxlab.demo.post.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.post.controller.PostOperation;
import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.model.PostDto;
import com.vtxlab.demo.post.model.UserDto;
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
        .code(HttpStatus.OK.value()) // 200
        .message("OK") // you can build a enum to map code & message
        .data(postService.savePost(post))
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<Post>> deletePostById(Long id) {
    ApiResponse<Post> response = ApiResponse.<Post>builder() //
        .code(HttpStatus.OK.value()) // 200
        .message("OK")
        .data(postService.deletePostById(id))
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<List<Post>>> findPostByTitle(String title) {
    HttpStatus httpStatus = HttpStatus.OK;
    String apiMsg = "OK";
    if (postService.findPostByTitle(title) == null) {
      httpStatus = HttpStatus.BAD_REQUEST;
      apiMsg = "Not Found";
    }
    ApiResponse<List<Post>> response = ApiResponse.<List<Post>>builder() //
        .code(httpStatus.value()) // 200
        .message(apiMsg)
        .data(postService.findPostByTitle(title))
        .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<UserDto>> findPostsByUserId(
      String userId) {
    // TBC. if userId is null, early return
    List<PostDto> postDtos = postService.findPostsByUserId(userId);
    UserDto userDto = UserDto.builder() //
        .userId(userId)
        .posts(postDtos)
        .build();
    ApiResponse<UserDto> response = ApiResponse.<UserDto>builder() //
        .code(HttpStatus.OK.value()) // 200
        .message("OK")
        .data(userDto)
        .build();
    return ResponseEntity.ok().body(response);
  }

}
