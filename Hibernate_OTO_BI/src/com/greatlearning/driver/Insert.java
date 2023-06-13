package com.greatlearning.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Teacher;
import com.greatlearning.entity.TeacherDetails;

public class Insert {

	public static void main(String[] args) {
		
		SessionFactory sf= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.buildSessionFactory();
		
		Session s= null;
		Transaction tx= null;
		
		try {
			s= sf.getCurrentSession();
			tx= s.beginTransaction();
			
			Teacher t1= new Teacher("Raj Ashis", "Das","rajdas@gl.com" );
			Teacher t2= new Teacher("Namrata", "Das","namratadas@gl.com");
			Teacher t3= new Teacher("Nivedita", "Jena","NiveditaJena@gl.com");

			TeacherDetails td1= new TeacherDetails("Cuttack", "Designing");
			TeacherDetails td2= new TeacherDetails("Cuttack", "Reading");
			TeacherDetails td3= new TeacherDetails("Cuttack", "Sleeping");

			s.save(t1);
			s.save(t2);
			s.save(t3);
			
			s.save(td1);
			s.save(td2);
			s.save(td3);
			tx.commit();
		}catch(Exception e) {
			System.out.println("ERROR!!!!!!!1");
			e.printStackTrace();
			tx.rollback();
			
		}finally {
			sf.close();
			s.close();
		
		}
	}

}
