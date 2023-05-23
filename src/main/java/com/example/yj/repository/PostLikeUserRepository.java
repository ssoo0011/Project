package com.example.yj.repository;

import com.example.yj.entity.PostLikeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostLikeUserRepository extends JpaRepository<PostLikeUser, Long> {

    List<PostLikeUser> findByBnoAndLikeUserId(Long bno, String userId);
    @Query(value = "DELETE FROM post_like_user WHERE like_user_id = :userId AND bno = :bno",  nativeQuery = true)
    void deleteLikeUser(Long bno, String userId);
}
