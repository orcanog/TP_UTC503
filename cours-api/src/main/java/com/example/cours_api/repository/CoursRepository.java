package com.example.cours_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cours_api.model.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {
	List<Cours> findByMatiereContainingIgnoreCase(String matiere);

}
