package com.mawulidev.blogservice.repository;

import com.mawulidev.blogservice.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogRepository extends JpaRepository<Blog, UUID> {
}
