/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class TestSpring {

    public static ApplicationContext ctx;
    public static StudentDao dao;
    public static ArrayList<Student> list;

    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/exam/appConfig.xml");
        ctx = new ClassPathXmlApplicationContext("com/exam/appConfig.xml");
        dao = (StudentDao) ctx.getBean("dao");
        //insert
        //Student s = new Student(103, "abc", "abc@gmail.com");
        //dao.doAdd(s);
        //update
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date c = new GregorianCalendar(2013, 03, 21).getTime();
        try {
            Date c2 = df.parse("2013-04-21");

            //String d = df.format(c);
            //Date d2=java.sql.Date.valueOf(d);
            //delete
            //Student s3 = new Student(101, "abc", "abc@gmail.com");
            //dao.doDel(s3);
            
            //Student s2 = new Student(101, "xyz", "xyzss@gmail.com", c);
            //Student s2 = new Student(101, "xyz", "xyzss@gmail.com", c2);
            //insert(s2);
            Student s2 = new Student(101, "xyz2", "xyzss@gmail.com", c2);
            //update(s2);
            //delete(s2);
            show();
        } catch (ParseException ex) {
            Logger.getLogger(TestSpring.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void insert(Student st) {
        dao.doAdd(st);
    }

    public static void update(Student st) {
        dao.doUp(st);
    }

    public static void delete(Student st) {
        dao.doDel(st);
    }

    public static void show() {
        list = (ArrayList<Student>) dao.allStudent();
        for (Student student : list) {
            System.out.println(student.getId() + "   " + student.getName() + "   " + student.getEmail() + " " + student.getDob());

        }
    }
}
