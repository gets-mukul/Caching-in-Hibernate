package com.telusko.com.caching.org;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args) {

		CreateCache obj = null;

		Configuration con = new Configuration().configure().addAnnotatedClass(CreateCache.class);

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

		SessionFactory sf = con.buildSessionFactory(reg); // deplicated method

		Session session1 = sf.openSession();		///first session
		
		Transaction t = session1.beginTransaction();
		Query q1 = session1.createQuery("From CreateCache where id=121");
		q1.setCacheable(true);
		obj = (CreateCache) q1.uniqueResult();
		System.out.println(obj);
		t.commit();
		
		session1.close();

		Session session2 = sf.openSession(); 	////Second session
		
		Transaction t1 = session2.beginTransaction();
		Query q2 = session2.createQuery("From CreateCache where id=121");
		q2.setCacheable(true);
		obj = (CreateCache) q2.uniqueResult();
		System.out.println(obj);
		t1.commit();
		
		session2.close();
	}

}
