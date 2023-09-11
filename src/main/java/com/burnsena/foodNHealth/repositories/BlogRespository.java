package com.burnsena.foodNHealth.repositories;

import com.burnsena.foodNHealth.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRespository extends JpaRepository<Blog, Long> {
}
