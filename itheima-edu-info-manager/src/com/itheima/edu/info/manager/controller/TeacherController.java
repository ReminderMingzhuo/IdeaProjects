package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Teacher;
import com.itheima.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    public TeacherService teacherService = new TeacherService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        TeacherLooper:while(true){
            System.out.println("--------欢迎来到 <教师> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加教师  2.删除教师  3.修改教师  4.查看教师  5.退出");
            String choice = sc.next();
            switch(choice){
                case "1":
                    //System.out.println("添加");
                    addTeacher();
                    break;
                case "2":
                    //System.out.println("删除");
                    deleteTeacherById();
                    break;
                case "3":
                    //System.out.println("修改");
                    updateTeacher();
                    break;
                case "4":
                    //System.out.println("查询");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("感谢您使用教师管理系统，再见！");
                    break TeacherLooper;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }

    private void findAllTeacher() {
    }

    private void updateTeacher() {
        String updateId = inputTeacherId();
        Teacher newTeacher = inputTeacherInfo(updateId);
    }

    private Teacher inputTeacherInfo(String teacherId) {
        System.out.println("请输入教师姓名：");
        String teacherName = sc.next();
        System.out.println("请输入教师年龄：");
        String teacherAge = sc.next();
        System.out.println("请输入教师生日：");
        String teacherBirthday = sc.next();
        Teacher newTeacher = new Teacher(teacherId,teacherName,teacherAge,teacherBirthday);
        return newTeacher;
    }

    private String inputTeacherId() {
        String id;
        while(true){
            System.out.println("请输入教师id:");
            id = sc.next();
            boolean exists = teacherService.isExists(id);
            if(!exists){
                System.out.println("您输入的id不存在，请重新输入：");
            }else{
                break;
            }
        }
        return id;
    }

    private void deleteTeacherById() {
    }

    private void addTeacher() {
    }
}
