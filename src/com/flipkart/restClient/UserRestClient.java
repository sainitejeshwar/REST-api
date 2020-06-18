package com.flipkart.restClient;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.DAO.AuthorCredentialDAO;
import com.flipkart.bean.Admin;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.service.AdminOperations;
import com.flipkart.service.StudentOperations;

@Path("/user")
public class UserRestClient {
	//Demo function
	@GET
	@Path("/me")
	@Produces(MediaType.TEXT_PLAIN)
	public String getme() {
		return "Tejeshwar";
	}
	
	@GET
	@Path("/allstudent")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Student> veiwAllStudent(){
		AdminOperations adminOperations = new AdminOperations();
		return adminOperations.getAllStudents();
	}
	@GET
	@Path("/alladmin")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Admin> veiwAllAdmin(){
		AdminOperations adminOperations = new AdminOperations();
		return adminOperations.getAllAdmins();
	}
	@GET
	@Path("/allprof")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Professor> veiwAllProfessor(){
		AdminOperations adminOperations = new AdminOperations();
		return adminOperations.getAllProfessors();
	}
	
	@GET
	@Path("/allstudent/{sid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student veiwCourse(@PathParam("sid") String emailid){
		StudentOperations studentOperations = new StudentOperations();
		return studentOperations.getStudent(emailid);
	}
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	@Produces(MediaType.TEXT_PLAIN)
	
	public Response createTrackInJSON(User user) {
		AuthorCredentialDAO authorCredentialDAO = new AuthorCredentialDAO();
		authorCredentialDAO.addUser(user);
		String result = "User  saved";
		return Response
				.status(201)
				.entity(result)
				.build();
	}
	@DELETE
	@Path("/delete/{emailid}")
	public Response deleteCourse(@PathParam("emailid") String emailid) {
		AuthorCredentialDAO authorCredentialDAO = new AuthorCredentialDAO();
		authorCredentialDAO.deleteUser(emailid);
		return Response
				.status(200)
				.entity("user successfully deleted")
				.build();
	}
	
}
