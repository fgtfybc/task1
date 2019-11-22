package com.jnshu.dao;

import com.jnshu.db.DBUtil;
import com.jnshu.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class StudentDao {
    public void addStudent(Student student) throws SQLException {
        //添加数据 传入对象
        //创建数据库连接
        Connection conn = DBUtil.getConnection();
        //编写SQL
        String sql = "INSERT INTO student"+"(user_name,sex,age,birthday,email,mobile,create_user," +
                "update_user,isdel)"+"VALUE("+"?,?,?,?,?,?,?,?,?)";
        //   s.setUser_name("全全");
        //        s.setAge(18);
        //        s.setBirthday(19940101);
        //        s.setEmail("didi@163.com");
        //        s.setMobile("138777776");
        //        s.setSex("男");
        //        s.setCreate_date(12);
        //        s.setUpdate_data(1113);
        //        s.setIsdel(1);
        //预编译SQL语句
      PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //将对象传入SQL语句中
        preparedStatement.setString(1,student.getUser_name());
        preparedStatement.setString(2,student.getSex());
        preparedStatement.setInt(3,student.getAge());
        preparedStatement.setInt(4,student.getBirthday());
        preparedStatement.setString(5,student.getEmail());
        preparedStatement.setString(6,student.getMobile());
        preparedStatement.setString(7,student.getCreate_user());
        preparedStatement.setString(8,student.getUpdate_user());
        preparedStatement.setInt(9,student.getIsdel());

        //输入PS对象内容
        System.out.println(preparedStatement.toString());
        //执行SQL语句
        preparedStatement.execute();

    }

}
