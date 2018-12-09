package com.linfeng.HibernateDemo;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.linfeng.entity.Student;

public class ReadStudentListDemo {
	/*
	 * here, we use the class name instead of table name.
	 * 'from Student' instead of 'from student'
	 * */
	public static String getQuery(int index) {
		switch(index) {
		case 0:return "from Student";
		case 1:return "from Student s where s.lastName = 'lee'";
		case 2:return "from Student s where s.firstName = 'Paul' OR s.lastName='lee'";
		case 3:return "from Student s where s.email LIKE '%afdtech.com'";
		default: return "from Student";
		}
	}
	
	private static void displayStudents(List<Student> studentList) {
		for(Student s :studentList) {
			System.out.println("reading from DB:"+s.toString());
		}
	}
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		List<Student> studentList = new ArrayList<>();
		try {
			System.out.println("Reading students!");
			session.beginTransaction();
			//reading info from DB;
			//studentList = session.createQuery(getQuery(0)).getResultList();
			//studentList = session.createQuery(getQuery(1)).getResultList();
		    /*studentList = session
		    		.createQuery(getQuery(2))
		    		.getResultList();
		    		*/
			studentList = session
					.createQuery(getQuery(3))
					.getResultList();
			//System.out.println("students number:"+studentList.size());
			displayStudents(studentList);
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
