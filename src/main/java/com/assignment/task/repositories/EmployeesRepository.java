package com.assignment.task.repositories;

import com.assignment.task.Entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees,Integer> {
}
