package com.vtxlab.demo.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.post.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  
}
