package com.itheima.edu.info.manager.controller;

public class StudentController {
    //开启学生管理系统，并展示学生管理系统
    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------欢迎来到 <学生> 管理系统--------");
        System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
        String choice = sc.next();
        switch(choice){
            case "1":
                System.out.println("添加");
                addStudent();

                break;
            case "2":
                System.out.println("删除");
                break;
            case "3":
                System.out.println("修改");
                break;
            case "4":
                System.out.println("查询");
                break;
            case "5":
                System.out.println("感谢您使用学生管理系统，再见！");
                break studentLoop;
            default:
                System.out.println("您的输入有误，请重新输入");
                break;
        }
    }
}

