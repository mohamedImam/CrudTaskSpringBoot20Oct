package com.assignment.task.Entities;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id",columnDefinition="NUMBER(6)")
    private int employeeId;

    @Column(name = "first_name",columnDefinition="varchar2(20)",nullable = false)
    private String firstName;

    @Column(name = "last_name",columnDefinition="varchar2(25)",nullable = false)
    private String lastName;

    @Column(name = "email",columnDefinition="varchar2(25)")
    private String email;

    @Column(name = "phone_number",columnDefinition="varchar2(20)")
    private String phoneNumber;

    @Column(name = "hire_date",columnDefinition="Date")
    private Date hireDate;

    @Column(name = "salary",columnDefinition="NUMBER(8,2)")
    private float salary;

    @Column(name = "manager_id",columnDefinition="NUMBER(6)")
    private int manager_id;

   // @ManyToOne
  //  @JoinColumn(name="department_id", nullable=false)
    private int departmentId;

}
