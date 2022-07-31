package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.StudentDao;
import com.itheima.edu.info.manager.domain.Student;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public boolean addStudent(Student stu) {

        return studentDao.addStudent(stu);
    }

    public boolean isExists(String id) {
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

    public Student[] findAllStudent() {
        //1.调用库管对象的findAllStudent获取学生对象数组
        Student[] allStudent = studentDao.findAllStudent();
        //2.判断数组中是否有学生信息（有：返回地址，没有：返回null）
        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            Student stu = allStudent[i];
            if(stu != null){
                flag = true;
                break;
            }
        }

        if(flag){
            return allStudent;
        }else{
            return null;
        }
    }

    public void deleteSudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }
}
