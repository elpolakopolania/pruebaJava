package com.prueba.java.sprintboot.pruebaJava.repository;

import com.prueba.java.sprintboot.pruebaJava.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
