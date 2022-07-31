package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.StudentDao;
import com.itheima.edu.info.manager.domain.Student;

public class StudentService {
    public boolean addStudent(Student stu) {
        StudentDao studentDao = new StudentDao();
        return studentDao.addStudent(stu);
    }

    public boolean isExists(String id) {
        StudentDao studentDao = new StudentDao();
        Student[] stus = studentDao.findAllStudent();
        //假设id在数组中不存在
        boolean exists = false;
        //遍历数组，获取每一个学生对象，准备进行判断
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if(student != null && student.getId().equals(id)){
                exists = true;
                break;
            }
        }
        return exists;
    }
}
