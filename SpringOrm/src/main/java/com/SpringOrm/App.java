package com.SpringOrm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.SpringOrm.Entity.*;

/**
 * Hello world!
 *
 */
public class App {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private static void save(EntityManager em) throws Exception {

		System.out.println("Enter Student id:-");
		int id = Integer.parseInt(reader.readLine());
		System.out.println("Enter Student Name:-");
		String name = reader.readLine();
		System.out.println("Enter Student age:-");
		int age = Integer.parseInt(reader.readLine());
		Student s = new Student(id, name, age);

		em.getTransaction().begin();

		em.persist(s);

		em.getTransaction().commit();
		System.out.println("Student is saved");
	}

	public static Student find(EntityManager em) throws Exception {

		System.out.println("Enter Student id:-");
		int id = Integer.parseInt(reader.readLine());
		Student s = em.find(Student.class, id);
		System.out.println(s);
		return s;
	}

	public static void update(EntityManager em) throws Exception {
		System.out.println("Enter Student id:-");
		int id = Integer.parseInt(reader.readLine());
		Student s = find(em);

		System.out.println("Enter Student id:-");
		int uid = Integer.parseInt(reader.readLine());
		System.out.println("Enter Student Name:-");
		String uname = reader.readLine();
		System.out.println("Enter Student age:-");
		int uage = Integer.parseInt(reader.readLine());
		s.setId(uid);
		s.setName(uname);
		s.setAge(uage);

		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}

	public static void delete(EntityManager em) throws Exception {
		System.out.println("Enter Student id:-");
		int id = Integer.parseInt(reader.readLine());
		Student s = find(em);

		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
		System.out.println("Student is removed..");
	}

	public static void menu(EntityManager em) {

		while (true) {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Save Student");
			System.out.println("2. Find Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			try {
				int choice = Integer.parseInt(reader.readLine());
				switch (choice) {

				case 1:
					save(em);
					break;

				case 2:
					find(em);
					break;

				case 3:
					update(em);
					break;

				case 4:
					delete(em);
					break;

				case 5:
					System.out.println("Exiting");
					for(int i = 0 ; i < 3 ; i++) {
						System.out.print(".");
					}
					String exit = "\nThanks for using this app..";
					for(char ch:exit.toCharArray()) {
						Thread.sleep(100);
						System.out.print(ch);
					}
					return;

				default:
					System.out.println("Invalid choice!");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");
		EntityManager em = emf.createEntityManager();
		menu(em);
		em.close();
		emf.close();
	}
}
