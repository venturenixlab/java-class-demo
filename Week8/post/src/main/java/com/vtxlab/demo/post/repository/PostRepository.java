package com.vtxlab.demo.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.model.PostDto;

/**
 * 
 */
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

  List<Post> findByTitleIgnoreCase(String title);

  // %something%
  // i.e. postRepository.findByTitleContaining("something")
  List<Post> findByTitleContaining(String title);

  List<Post> findByContentContaining(String content);

  List<Post> findByContentIsContaining(String content);

  List<Post> findByContentIsContains(String content);

  // something% , %something, %something%
  // you provide % in service layer yourself
  // i.e. postRepository.findByTitleLike("%something")
  List<Post> findByTitleLike(String title);

  List<Post> findByTitleNotLike(String title);

  // And Or
  List<Post> findByTitleAndId(String title, Long id);

  List<Post> findByTitleOrId(String title, Long id);

  @Query("select p.title as title, p.content as content from users u, posts p where u.user_id=p.user_id and u.user_id = :userId")
  List<PostDto> findPostsByUserId(@Param("userId") String userId);

}
