package com.linfeng.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.linfeng.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")//if not explicit, project will look for "hibernate.cfg.xml" this default file.
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session=null;
		try {
			/*
			session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Updating one student!");
			//deleting one student info from DB;
			
			int studentId = 2;
			Student studentFromDB = session.get(Student.class, studentId);
			session.delete(studentFromDB);
			System.out.println(studentFromDB.toString());
			session.getTransaction().commit();
			*/
			//another way to delete student from DB;
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id=4")
								.executeUpdate();
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}

	}

}
