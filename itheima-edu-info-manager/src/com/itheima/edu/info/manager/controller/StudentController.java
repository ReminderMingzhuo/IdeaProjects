package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);
    //开启学生管理系统，并展示学生管理系统
    public void start() {
        StudentLooper:while(true){
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            String choice = sc.next();
            switch(choice){
                case "1":
                    System.out.println("添加");
                    addStudent();
                    break;
                case "2":
                    //System.out.println("删除");
                    deleteStudentById();
                    break;
                case "3":
                    System.out.println("修改");
                    break;
                case "4":
                    //System.out.println("查询");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统，再见！");
                    break StudentLooper;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }

    }

    public void deleteStudentById() {
        String delId;
        while(true){
            System.out.println("请输入您要删除的学生id：");
            delId = sc.next();


            boolean exists = studentService.isExists(delId);
            if(!exists){
                System.out.println("您输入的id不存在，请重新输入：");
            }else{
                break;
            }
        }
        studentService.deleteSudentById(delId);
        System.out.println("删除成功！");

    }

    public void findAllStudent() {
        Student[] stus = studentService.findAllStudent();
        if(stus == null){
            System.out.println("查无信息，请添加后重试");
            return;
        }
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if(stu != null){
                System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t\t"+stu.getBirthday());
            }
        }
    }

    public void addStudent() {
        String id;
        while(true){
            System.out.println("请输入学生id：");
            id = sc.next();
            boolean flag = studentService.isExists(id);
            if(flag){
                System.out.println("学号已被占用，请重新输入：");
            }else{
                break;
            }
        }
        //接收学生信息
        System.out.println("请输入学生姓名：");
        String name = sc.next();
        System.out.println("请输入学生年龄：");
        String age = sc.next();
        System.out.println("请输入学生生日：");
        String birthday = sc.next();
        //将学生信息封装为Stdente类
        Student stu = new Student();
        stu.setId(id);
        stu.setAge(age);
        stu.setBirthday(birthday);
        stu.setName(name);
        //将学生对象，传递给StudentService（业务员）中的addStudent方法

        boolean result = studentService.addStudent(stu);
        if(result){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }

    }
}

