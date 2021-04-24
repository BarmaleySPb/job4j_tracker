package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Pupkin Vasiliy Ivanovich");
        student.setGroup(159);
        student.setInDate(new Date());
        System.out.println("Full name of student: " + student.getFio());
        System.out.println("Group: " + student.getGroup());
        System.out.println("Admission date: " + student.getInDate());
    }
}
