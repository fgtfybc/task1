package com.jnshu.action;

import com.jnshu.dao.StudentDao;
import com.jnshu.model.Student;

import java.sql.SQLException;

public class StudentAction {
    public static void main(String[] args) throws SQLException {
        Student s = new Student();

        s.setUser_name("全全");
        s.setAge(18);
        s.setBirthday(19940101);
        s.setEmail("didi@163.com");
        s.setMobile("138777776");
        s.setSex("男");
        s.setUser_name("dadsa");
        s.setUpdate_user("dasdsa");
        s.setIsdel(1);

        StudentDao sd = new StudentDao();
        for(int i = 0; i < 10; i++ ){
            sd.addStudent(s);
            System.out.println(i);
        }
        System.out.println("插入完成");
    }
}
