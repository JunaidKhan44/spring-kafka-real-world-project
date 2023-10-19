package com.jk.springboot.repository;

import com.jk.springboot.entity.WikiMediaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiMediaRepository
        extends JpaRepository<WikiMediaModel,Long> {
}
