//package com.doubtsoverflow.app;
//
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import com.doubtsoverflow.app.Model.User;
//
//import org.hibernate.Transaction;
//
//public class xyz {
//	public static void main(String args[]) {
//		System.out.println("Project Started...");
//		SessionFactory factory = new Configuration()
//				.configure("hibernate.cfg.xml")
//				.buildSessionFactory(); 
//		System.out.println(factory);
//		
//		User usr = new User();
//		usr.setId(102);
//		usr.setName("Babu");
//		usr.setEmail("babu1@gmail.com");
//		System.out.println(usr);
//		
//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(usr);
//		tx.commit();
//		session.close();
//	}
//}
//	