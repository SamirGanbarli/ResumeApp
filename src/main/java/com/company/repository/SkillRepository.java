package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer>{
}
