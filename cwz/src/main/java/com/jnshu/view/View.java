package com.jnshu.view;

import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class View {
    private static final Logger log = LogManager.getLogger(View.class);
    public static void main(String[] args){
        //xml文件配置数据源
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Annotation配置数据源
        // ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        StudentService studentService = (StudentService) context.getBean("studentService");

        //增加数据
        try{
            Student student = new Student();
            log.info("-----------------插入数据--------------------");
            //设置计时开始
            long start = System.currentTimeMillis();
            student.setName("弟弟");
            student.setQq(11111);
            student.setSubject("java");
            student.setJoinTime(22225);
            student.setSchool("家里蹲");
            student.setWish("老大最帅");
            student.setTeacher("全全");
            student.setWhereKnow("知乎");
            student.setCreateAt(23123123);
            student.setUpdateAt(32314141);
            studentService.insertMethod(student);
            //计时结束
            long end = System.currentTimeMillis();
            log.info("+++++++++++++++++插入数据完成++++++++++++++++++");
            log.info("用时："+(end-start)+"毫秒");
            long studentId = student.getId();
            // 执行添加记录之后读取POJO的主键id属性
            log.info("insert id is"+studentId);
        }catch (Exception e){
            e.printStackTrace();
            log.error("ERROR");

        }
        //删除数据
        try {
            log.info("++++++++++++++++++删除数据+++++++++++++++++++");
            Student student = new Student();
            student.setName("k132");
            int result= studentService.deleteMethod(student);
            boolean flag=result>0? true:false;
            log.info(flag);
            log.info("+++++++++++++++++删除数据完成++++++++++++++++");
        }catch (Exception e){
            e.printStackTrace();
            log.error("ERROR");
            log.error("false");
        }
        //更新数据
        try{
            log.info("++++++++++++++++++更新数据+++++++++++++++++++");
            Student student = new Student();
            student.setId(8494L);
            student.setWish("'go to the moon'");
            int result = studentService.updateMethod(student);

            boolean flag=result>0? true:false;
            log.info(flag);
            log.info("+++++++++++++++++更新数据完成++++++++++++++++++");
        }catch (Exception e) {
            e.printStackTrace();
            log.error("ERROR");
            log.error("return false");
        }

        //根据姓名查找数据
        try{
            log.info("+++++++++++++++根据姓名查找数据++++++++++++++++");
            Student student=studentService.queryStudentByName("keshiyang");
            log.info("结果是：" + student);
        }catch (Exception e){
            e.printStackTrace();
            log.error("ERROR");
        }
        //根据Id查找数据
        try {
            log.info("+++++++++++++++根据ID查找数据++++++++++++++++");
            Student student = studentService.queryStudentById(16585L);
            log.info("结果是： " + student);
        }catch (Exception e){
            e.printStackTrace();
            log.error("ERROR");
        }

    }
}
