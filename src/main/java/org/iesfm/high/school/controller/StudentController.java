package org.iesfm.high.school.controller;

import org.iesfm.high.school.exceptions.GroupNotExistException;
import org.iesfm.high.school.pojos.Student;
import org.iesfm.high.school.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/groups/{groupId}/students")
    public List<Student> list(@PathVariable("groupId") Integer groupId) {
        try {
            return studentService.getStudentsByGroup(groupId);
        } catch (GroupNotExistException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El grupo indicado no existe.");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/students/{nif}")
    public void deleteByNif(String nif) {
        if (!studentService.deleteByNif(nif)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El alumno no existe");
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/students")
    public void insert(@RequestBody Student student) {
        if (!studentService.createStudent(student)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El estudiante ya existe");
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "students")
    public void updateStudent(@RequestBody Student student) {
        if (!studentService.updateStudent(student)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estudiante no encontrado");
        }
    }

}
