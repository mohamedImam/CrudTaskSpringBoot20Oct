package com.assignment.task.controllers;

import com.assignment.task.models.DepartmentsModel;
import com.assignment.task.models.EmployeesModel;
import com.assignment.task.services.DepartmentsService;
import com.assignment.task.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeesController {
    @Autowired
    EmployeesService employeesService;


    @GetMapping("/getAll/{pageSize}")
    public ResponseEntity<?> getAll(@PathVariable int pageSize)
    {
        return new ResponseEntity<>( employeesService.getAllEmployee(pageSize), HttpStatus.OK);
    }

    @PostMapping("/newEmployees")
    public ResponseEntity<?> addDepartment(@RequestBody EmployeesModel employeesModel)
    {
        try {
            employeesService.addEmployee(employeesModel);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/updateEmployees/{employeetId}")
    public ResponseEntity<?> updateDepartment(@PathVariable int employeetId, @RequestBody EmployeesModel employeesModel)
    {
        try {
            employeesService.updateEmployee(employeetId,employeesModel);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deleteEmployees")
    public ResponseEntity<?>  DeleteDepartment(@RequestParam(name = "id") int employeetId)
    {
        try {
            employeesService.DeleteEmployee(employeetId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

    }
}
