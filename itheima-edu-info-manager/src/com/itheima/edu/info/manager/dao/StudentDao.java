package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

public class StudentDao {
    private static Student[] stus = new Student[5];

    public boolean addStudent(Student stu) {

        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if(student == null){
                index = i;
                break;
            }
        }
        //装满了
        if(index == -1){
            return false;
        }else{
            stus[index] = stu;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentById(String delId) {
        int index = getIndex(delId);
        stus[index] = null;
    }

    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if(stu != null && stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String updateId, Student newStu) {
        //1.查找updateId在容器中的索引位置
        int index = getIndex(updateId);
        //2.将该索引位置，使用新的学生对象替换
        stus[index] = newStu;
    }
}
