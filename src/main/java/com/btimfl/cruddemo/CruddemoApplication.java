package com.btimfl.cruddemo;

import com.btimfl.cruddemo.dao.StudentDAO;
import com.btimfl.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1 = new Student("Jack", "Fletcher", "jack@fletcher.com");
		Student student2 = new Student("Jack", "Reacher", "jack@reacher.com");

		System.out.println("ID before saving: " + student1.getId());
		System.out.println("ID before saving: " + student2.getId());

		studentDAO.save(student2);
		studentDAO.save(student1);

		System.out.println("ID after saving: " + student1.getId());
		System.out.println("ID after saving: " + student2.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("John", "Doe", "john@doe.com");
		System.out.println("ID before saving: " + student.getId());

		studentDAO.save(student);

		System.out.println("ID after saving: " + student.getId());
	}
}
