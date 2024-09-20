package com.deloitte.demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import java.util.List;

public class AddDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Add details :");
			String name = sc.next();
			double salary = sc.nextDouble();
			Employee newEmployee = new Employee(name, salary);

			session.beginTransaction();

			session.save(newEmployee);
			session.getTransaction().commit();

			System.out.println("Done.....");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
			factory.close();
		}
	}
}