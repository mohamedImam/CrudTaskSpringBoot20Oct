package com.assignment.task.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id",columnDefinition="NUMBER(4)")
   private int departmentId;

    @Column(name = "department_name",columnDefinition="varchar2(30)")
    private String departmentName;


    @Column(name = "manager_id",columnDefinition="NUMBER(6)")
    private int managerId;


}
/*( department_id NUMBER(4)
        , department_name VARCHAR2(30)
        , manager_id NUMBER(6)
        ) ;

        ALTER TABLE departments
        ADD (
        PRIMARY KEY(department_id)
        ) ;*/
