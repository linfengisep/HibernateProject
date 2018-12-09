package com.linfeng.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.linfeng.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")//if not explicit, project will look for "hibernate.cfg.xml" this default file.
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Reading one student!");
			Student student = new Student("Vinccent","Dupont","vinccent@afdtech.com");
			session.beginTransaction();
			session.save(student);
			System.out.println("student id :"+student.getId());
			//reading info from DB;
			Student studentFromDB = session.get(Student.class, student.getId());
			System.out.println("reading from DB:"+studentFromDB.toString());
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
