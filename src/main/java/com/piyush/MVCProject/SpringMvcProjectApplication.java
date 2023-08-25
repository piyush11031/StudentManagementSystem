package com.piyush.MVCProject;

import com.piyush.MVCProject.entity.Student;
import com.piyush.MVCProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// CommandLineRunner provides method "run" which executes when we run out application
public class SpringMvcProjectApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProjectApplication.class, args);
	}

	private final StudentRepository studentRepository;

	@Autowired
	public SpringMvcProjectApplication(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public void run(String... args) throws Exception {

//		Student student1 = new Student("Piyush", "Pareek", "piyush@gmail");
//		studentRepository.save(student1);
//
//		Student student2 = new Student("Sunjay", "Singh", "sunjay@gmail");
//		studentRepository.save(student2);
//
//		Student student3 = new Student("Ram", "Singh", "ram@gmail");
//		studentRepository.save(student3);
	}
}
