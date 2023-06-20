package com.example.yj.repository;

import com.example.yj.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByVisitSpotContains (@Param("visitSpot") String visitSpot, Pageable pageable);
    Page <Post> findByPubOrderByPostDateDesc(String t, Pageable pageable);
    Page<Post> findAll(Pageable pageable);
    @Query(value = "SELECT * FROM post WHERE pub = 't' ORDER BY like_num DESC LIMIT 4", nativeQuery = true)
    List<Post> findPopPost(); //인기 젤 많은 글 찾기
    Optional<Post> findByScdIdAndPub(Long scdId, String pub);

}
