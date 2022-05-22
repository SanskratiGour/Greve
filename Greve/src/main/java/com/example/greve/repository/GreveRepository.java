package com.example.greve.repository;

import com.example.greve.dao.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GreveRepository extends JpaRepository<Plant, Long> {

}
