package com.jnshu.servicelmpl;

import com.jnshu.mapper.StudentMapper;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "studentService")
public class StudentServicelmpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public boolean insertMethod(Student student) {
        boolean result = studentMapper.insertStudent(student);
        return true;
    }

    @Override
    public int deleteMethod(Student student) {
        studentMapper.deleteStudent(student);
        return 1;
    }

    @Override
    public int updateMethod(Student student) {
        studentMapper.updateStudent(student);
        return 1;
    }


    @Override
    public Student queryStudentByName(String name) {
        return studentMapper.queryStudentByName(name);
    }

    @Override
    public Student queryStudentById(long id) {
        return studentMapper.queryStudentById(id);
    }
}
