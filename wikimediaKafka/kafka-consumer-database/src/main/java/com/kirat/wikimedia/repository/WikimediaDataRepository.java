package com.kirat.wikimedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kirat.wikimedia.entity.WikimediaData;

@Repository
public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long>{

}
