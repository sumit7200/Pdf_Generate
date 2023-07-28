package com.example.school.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school.model.Studentt;

@Repository
public interface StudentReposatory extends JpaRepository<Studentt, Integer> {

}
