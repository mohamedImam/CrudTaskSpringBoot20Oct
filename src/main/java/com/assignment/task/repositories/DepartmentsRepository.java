package com.assignment.task.repositories;

import com.assignment.task.Entities.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {
}
