package com.vtxlab.demo.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.mysql.Entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
