package com.jnshu.mapper;

import com.jnshu.pojo.Student;

public interface StudentMapper {

    /**
     * 定义增加学生数据操作
     * @param student
     * @return
     */
    public boolean insertStudent(Student student);

    /**
     * 定义删除学生操作
     * @param student
     * @return
     */
    public int deleteStudent(Student student);

    /**
     * 定义更新学生操作
     * @param student
     * @return
     */
    public int updateStudent(Student student);

    /**
     * 根据学生姓名查找数据
     * @param name
     * @return
     */
    Student queryStudentByName(String name);

    /**
     * 根据学生id查找数据
     * @param id
     * @return
     */
    Student queryStudentById(long id);
}
