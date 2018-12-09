package com.linfeng.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.linfeng.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")//if not explicit, project will look for "hibernate.cfg.xml" this default file.
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session=null;
		try {
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Updating one student!");
			//updating one student info from DB;
			int studentId = 2;
			Student studentFromDB = session.get(Student.class, studentId);
			studentFromDB.setFirstName("Arthur");
			System.out.println(studentFromDB.toString());
			session.getTransaction().commit();

			//updating student's email info from DB;
			System.out.println("updating students' emails");
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email='foo@gmail.com'")
						.executeUpdate();
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
