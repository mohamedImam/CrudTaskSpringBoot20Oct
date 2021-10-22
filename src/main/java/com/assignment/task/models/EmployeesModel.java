package com.assignment.task.models;

import com.assignment.task.Entities.Departments;
import lombok.Data;


import javax.validation.constraints.Size;
import java.sql.Date;
@Data
public class EmployeesModel {

    private String firstName;
    private String lastName;
    private String email;
    @Size(min = 10, max = 10)
    private String phoneNumber;
    private Date hireDate;
    private float salary;
    private int managerId;
    private int departmentId;
}
