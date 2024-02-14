package com.btimfl.cruddemo;

import com.btimfl.cruddemo.dao.StudentDAO;
import com.btimfl.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleted " + studentDAO.deleteAll() + " rows");
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		System.out.println("Before: " + studentDAO.findById(3));
		studentDAO.deleteById(3);
		System.out.println("After: " + studentDAO.findById(3));
	}

	private void updateStudentLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Sharma");
		Student student = students.get(0);

		student.setLastName("Khatwani");
		studentDAO.update(student);

		List<Student> updatedStudents = studentDAO.findByLastName("Khatwani");
		updatedStudents.forEach(System.out::println);
	}

	private void readStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");
		students.forEach(System.out::println);
	}

	private void readAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		students.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("Nikhil", "Sharma", "nikhil@sharma.com");
		studentDAO.save(student);

		Student retrievedStudent = studentDAO.findById(student.getId());
		System.out.println(retrievedStudent);
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
