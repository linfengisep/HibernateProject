package com.linfeng.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.linfeng.entity.Student;

public class StudentDemo {
	public static void main(String[]args) {
		//connectDB();
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")//if not explicit, project will look for "hibernate.cfg.xml" this default file.
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				Session session = factory.getCurrentSession();
				
				try {
					System.out.println("creating students!");
					Student student = new Student("Adlane","dragon","adlane@afdtech.com");
					session.beginTransaction();
					session.save(student);
					session.getTransaction().commit();
					System.out.println("saving done!");
					
				}finally {
					factory.close();
				}
	}
}
