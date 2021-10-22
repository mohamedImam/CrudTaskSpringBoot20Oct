package com.assignment.task.controllers;


import com.assignment.task.Entities.Departments;
import com.assignment.task.models.DepartmentsModel;
import com.assignment.task.services.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "*")
public class DepartmentsController {

    @Autowired
    DepartmentsService departmentsService;


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll()
    {
       return new ResponseEntity<>( departmentsService.getAllDepartment(), HttpStatus.OK);
    }

    @PostMapping("/newDepartment")
    public ResponseEntity<?> addDepartment(@RequestBody DepartmentsModel departments)
    {
         departmentsService.addDepartment(departments);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping("/updateDepartment/{departmentId}")
    public ResponseEntity<?> updateDepartment(@PathVariable int departmentId,@RequestBody DepartmentsModel departments)
    {
        try {
            departmentsService.updateDepartment(departmentId,departments);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deleteDepartment")
    public ResponseEntity<?>  DeleteDepartment(@RequestParam(name = "id") int departmentId)
    {
        try {
            departmentsService.DeleteDepartment(departmentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

    }

}
