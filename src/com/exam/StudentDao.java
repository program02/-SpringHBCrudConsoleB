/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Administrator
 */
public class StudentDao {

    public void doAdd(Student st) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(st);
        s.getTransaction().commit();
        System.out.println("Save successfull");
        s.close();
    }

    public void doUp(Student st) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(st);
        s.getTransaction().commit();
        System.out.println("Update successfull");
        s.close();
    }

    public void doDel(Student st) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(st);
        s.getTransaction().commit();
        System.out.println("Delete successfull");
        s.close();
    }

    public List<Student> allStudent() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("from Student");
        List<Student> list = q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

    public List<Integer> allId() {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("select id from Student");
        List<Integer> list = q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }

    public List<Student> allStudentById(int id) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("from Student where id=" + id);
        List<Student> list = q.list();
        s.getTransaction().commit();
        s.close();
        return list;
    }
}
