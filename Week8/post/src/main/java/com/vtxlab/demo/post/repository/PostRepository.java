package com.vtxlab.demo.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.post.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  /**
   * This is selecting the Posts Table where title = something
   * 
   * @param title
   *          Title is a user input
   * @return List of Post
   */
  // equals to the exact value
  List<Post> findByTitle(String title);

  List<Post> findByTitleOrderByIdDesc(String title);

  List<Post> findByTitleIgnoreCase(String title);

  // %something%
  // i.e. postRepository.findByTitleContaining("something")
  List<Post> findByTitleContaining(String title);

  List<Post> findByContentContaining(String content);

  List<Post> findByContentIsContaining(String content);

  List<Post> findByContentContains(String content);

  // something% , %something, %something%
  // you provide % in service layer yourself
  // i.e. postRepository.findByTitleLike("%something")
  List<Post> findByTitleLike(String title);

  List<Post> findByTitleNotLike(String title);

  // And Or
  List<Post> findByTitleAndId(String title, Long id);

  List<Post> findByTitleOrId(String title, Long id);

  // Native SQL - Specific DBMS
  // MySQL
  @Query(nativeQuery = true, value = "select p.id, p.title, p.content from users u, posts p where u.user_id=p.user_id and u.user_id = :userId")
  List<Post> findPostsByUserId(@Param("userId") String userId);

  // JPQL
  // column name should be lowercase
  @Query("select p from Post p where p.id = :postid")
  List<Post> findPostsByIdByJpql(@Param("postid") Long id);

}
