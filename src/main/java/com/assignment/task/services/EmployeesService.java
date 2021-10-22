package com.assignment.task.services;

import com.assignment.task.Entities.Employees;
import com.assignment.task.models.EmployeesModel;
import com.assignment.task.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployeesService {
@Autowired
    EmployeesRepository employeesRepository;

    public List<Employees> getAllEmployee(int pageSize)
    {
        if(pageSize!=0)

        return employeesRepository.findAll(Pageable.ofSize(pageSize)).getContent();
        else
            return employeesRepository.findAll();
    }

    public Employees getEmployeeById(int employeetId) throws Exception {
        Employees employees=new Employees();

        employees= employeesRepository.findById(employeetId)
                .orElseThrow(() -> new Exception("employee not found - " + employeetId));
        return employees;
    }

    public void addEmployee(EmployeesModel employeesModel) throws Exception {
    Employees employees=new Employees();
    if(employeesModel.getFirstName().equals("")||employeesModel.getLastName().equals(""))
        throw new Exception("First name and last should not be null");

        if(employeesModel.getSalary()==0)
        throw new Exception("Salary should not be zero");
/*
        if(! isValidPhoneNumber(employeesModel.getPhoneNumber()))
            throw new Exception("phone number must be digits ");*/


        employees.setFirstName(employeesModel.getFirstName());
        employees.setLastName(employeesModel.getLastName());
        employees.setEmail(employeesModel.getEmail());
        employees.setPhoneNumber(employeesModel.getPhoneNumber());
        employees.setHireDate(employeesModel.getHireDate());
        employees.setSalary(employeesModel.getSalary());
        employees.setManager_id(employeesModel.getManagerId());
        employees.setDepartmentId(employeesModel.getDepartmentId());
        employeesRepository.save(employees);
    }

    public void updateEmployee(int employeetId,EmployeesModel employeesModel) throws Exception
    {
        Employees employees=employeesRepository.findById(employeetId)
                .orElseThrow(() -> new Exception("employee not found - " + employeetId));

        employees.setFirstName(employeesModel.getFirstName());
        employees.setLastName(employeesModel.getLastName());
        employees.setEmail(employeesModel.getEmail());
        employees.setPhoneNumber(employeesModel.getPhoneNumber());
        employees.setHireDate(employeesModel.getHireDate());
        employees.setSalary(employeesModel.getSalary());
        employees.setManager_id(employeesModel.getManagerId());
        employees.setDepartmentId(employeesModel.getDepartmentId());
        employeesRepository.save(employees);
    }

    public void DeleteEmployee(int employeetId) throws Exception
    {
        Employees employees=employeesRepository.findById(employeetId)
                .orElseThrow(() -> new Exception("employee not found - " + employeetId));
        employeesRepository.deleteById(employeetId);
    }

    public static boolean isValidPhoneNumber(String phone_number) {
        boolean isValid =  phone_number.matches("\\d{3}-\\d{4}");
        System.out.println(phone_number+" : "+isValid);
        return isValid;
    }
}
