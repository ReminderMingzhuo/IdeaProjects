package com.itheima.edu.info.manager.domain;

public class Teacher {
    private String id;
    private String age;
    private String name;
    private String birthday;

    public Teacher(){}

    public Teacher(String id, String name, String age, String birthday){
        this.id = id;
        this.age = age;
        this.name = name;
        this.birthday = birthday;
    }

    public String getId(){return id;}
    public String getAge(){return age;}
    public String getName(){return name;}
    public String getBirthday(){return birthday;}

    public void setId(String id){this.id = id;}
    public void setAge(String age) {this.age = age;}
    public void setName(String name){this.name = name;}
    public void setBirthday(String birthday){this.birthday = birthday;}
}
