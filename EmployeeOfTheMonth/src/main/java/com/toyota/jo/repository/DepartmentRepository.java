package com.toyota.jo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toyota.jo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
