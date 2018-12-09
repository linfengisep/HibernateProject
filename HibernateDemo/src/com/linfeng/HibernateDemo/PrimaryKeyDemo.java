package com.linfeng.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.linfeng.entity.Post;
import com.linfeng.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")//if not explicit, project will look for "hibernate.cfg.xml" this default file.
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Creating three students!");
			Student student = new Student("Paul","Wall","paul@afdtech.com");
			student.addPost(new Post("glad to work at AFD.TECH"));
			student.addPost(new Post("eager to find a mission"));
			session.save(student);			
			session.getTransaction().commit();
			System.out.println("saving done!");
			
		}finally {
			factory.close();
		}

	}

}
