package org.iesfm.high.school.services;

import org.iesfm.high.school.exceptions.GroupNotExistException;
import org.iesfm.high.school.pojos.Student;
import org.iesfm.high.school.repositories.GroupRepository;
import org.iesfm.high.school.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private GroupRepository groupRepository;

    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public List<Student> getStudentsByGroup(int groupId) throws GroupNotExistException {

        if (!groupRepository.existsById(groupId)) {
            throw new GroupNotExistException(groupId);
        } else {
            return studentRepository.findByGroupId(groupId);
        }
    }

    public boolean deleteByNif(String nif) {
        if (!studentRepository.existsById(nif)) {
            return false;
        } else {
            studentRepository.deleteById(nif);
            return true;
        }
    }

    public boolean createStudent(Student student) {
        if (studentRepository.existsById(student.getNif())) {
            return false;
        } else {
            studentRepository.insert(student);
            return true;
        }
    }

    public boolean updateStudent(Student student) {
        if (!studentRepository.existsById(student.getNif())) {
            return false;
        } else {
            studentRepository.save(student);
            return true;
        }
    }
}
