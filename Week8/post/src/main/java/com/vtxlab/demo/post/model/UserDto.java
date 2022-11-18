package com.vtxlab.demo.post.model;

import java.util.List;

import com.vtxlab.demo.post.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// CameCase
public class UserDto {

  private String userId;

  private List<PostDto> posts;

}
