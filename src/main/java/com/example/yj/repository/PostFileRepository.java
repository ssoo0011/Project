package com.example.yj.repository;

import com.example.yj.entity.Owner;
import com.example.yj.entity.PostFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostFileRepository  extends JpaRepository<PostFile, Long> {

    List<PostFile> findByPostBno(Long postBno);
}
