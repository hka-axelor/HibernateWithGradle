package com.axelor.demo.hibgradle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		config.addAnnotatedClass(Player.class);

		StandardServiceRegistryBuilder reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory sf = config.buildSessionFactory(reg.build());
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		//Operation: Normal DB Operation with hbm2ddl.auto value as Update 
		Player p=new Player(); 
		p.setId(1);
		p.setName("Virat"); 
		p.setTeam("India");
		session.save(p);
		 		
		transaction.commit();
		session.close();
	}
}
