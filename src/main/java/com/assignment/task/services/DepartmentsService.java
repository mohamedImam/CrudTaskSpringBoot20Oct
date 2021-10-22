package com.assignment.task.services;

import com.assignment.task.Entities.Departments;
import com.assignment.task.models.DepartmentsModel;
import com.assignment.task.repositories.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentsService {

    @Autowired
    DepartmentsRepository departmentsRepository;

    public List<Departments> getAllDepartment()
    {

        return departmentsRepository.findAll();
    }

    public Departments getDepartmentById(int departmentId) throws Exception {

        Departments department=departmentsRepository.findById(departmentId)
                .orElseThrow(() -> new Exception("department not found - " + departmentId));
        return department;

    }

    public void addDepartment(DepartmentsModel departmentsModel)
    {
       Departments department=new Departments();
        department.setDepartmentName(departmentsModel.getDepartmentName());
        department.setManagerId(departmentsModel.getManagerId());
        departmentsRepository.save(department);
    }

    public void updateDepartment(int departmentId,DepartmentsModel departmentsModel) throws Exception
    {
        Departments  department=departmentsRepository.findById(departmentId)
                .orElseThrow(() -> new Exception("department not found - " + departmentId));
        department.setDepartmentName(departmentsModel.getDepartmentName());
        department.setManagerId(departmentsModel.getManagerId());
       departmentsRepository.save(department);
    }

    public void DeleteDepartment(int departmentId) throws Exception
    {
        Departments  department=departmentsRepository.findById(departmentId)
                .orElseThrow(() -> new Exception("department not found - " + departmentId));
        departmentsRepository.deleteById(departmentId);
    }
}
