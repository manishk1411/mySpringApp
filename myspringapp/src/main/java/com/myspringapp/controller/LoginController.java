package com.myspringapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.man.test.model.Student;
import com.man.test.model.StudentDetail;
import com.man.test.repository.StudentRepository;
import com.myspringapp.jee.LoginService;

@Controller
public class LoginController {

	static long studentId = 1000002;

	StudentRepository studentRepository = new StudentRepository();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String sayHello() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView logMeIn(@RequestParam("name") String userName, @RequestParam("password") String password) {
		boolean validUser = new LoginService().validateUser(userName, password);
		ModelAndView modelAndView = new ModelAndView();
		if (validUser) {
			modelAndView.setViewName("welcome");
			modelAndView.addObject("name", userName);
			return modelAndView;
		}
		modelAndView.setViewName("login");
		modelAndView.addObject("errorMessage", "Unable to login.. Enter correct username and password");
		// modelAndView.addObject("name", "");
		return modelAndView;

	}

	@RequestMapping(value = "/getStudentForm", method = RequestMethod.GET)
	public String sendStudentForm() {
		return "studentForm";
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@RequestParam("fName") String firstName, @RequestParam("lName") String lastName,
			@RequestParam("email") String email, @RequestParam("address") String address) {
		List<Student> studentList = new ArrayList<>();
		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setAddress(address);
		studentDetail.setEmailId(email);
		studentDetail.setFirstName(firstName);
		studentDetail.setLastName(lastName);
		Student student = new Student(studentId, studentDetail);
		studentList.add(student);
		studentRepository.addNewStudents(studentList);
		studentId++;

		return "displayStudent";

	}

	
	@RequestMapping(value = "/searchStudentForm", method = RequestMethod.GET)
	public String searchStudents() {
		System.out.println("I am in get method");
		return "searchStudentForm";
	}
	
	@RequestMapping(value = "/manish", method = RequestMethod.GET)
	public String searchStudentws() {
		System.out.println("I am in get method");
		return "searchStudentForm";
	}
	
	
	
	@RequestMapping(value = "/searchStudent", method = RequestMethod.POST)
	public ModelAndView searchStudentByP(@RequestParam("item") int type, @RequestParam("search") String searchID) {
		Student student;
		long id;
		
		System.out.println("I am entering post method of search student");
		id=Long.valueOf(searchID);
		StudentRepository a = new StudentRepository();
		student=a.searchStudentByID(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("studentDetail");
		if(student==null) {
			modelAndView.addObject("errorMessage", "No record Exist..");
			return modelAndView;
		}
		 modelAndView.addObject("student", student);
		return modelAndView;

	}
	
	@RequestMapping(value = "/showAllStudents", method = RequestMethod.GET)
	public ModelAndView getAllStudents() {
		List<Student> studentList = studentRepository.retreiveAllStudents();
		System.out.println(studentList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayStudent");
		modelAndView.addObject("studentList", studentList);
		System.out.println();

		return modelAndView;
	}

	

	

}



