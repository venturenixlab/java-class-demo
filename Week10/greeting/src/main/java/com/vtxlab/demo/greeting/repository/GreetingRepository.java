package com.vtxlab.demo.greeting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.greeting.entity.Book;

@Repository
public interface GreetingRepository extends JpaRepository<Book, Long> {
  
}
