package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Admin;
import com.flipkart.bean.User;
import com.flipkart.helper.clientHelper;

/*
 * CLASS DESCRIPTION
 * Manages all Admin Functionalities that he can perform
 * 
 */

public class AdminClient implements clientHelper {
	
	private static  Logger logger = Logger.getLogger(AdminClient.class);
	private static Admin admin = new Admin();
	
	public void landingPage(User user, Scanner input) {
		
		//Fetching admin details from database
		admin = adminOperations.getAdmin(user.getEmailID());
		//Printing admin name with salutation
		logger.debug("Logged in as Admin: "+getSalutation(user.getGender())+admin.getName());
		
		//ADMIN FUNCTIONALITIES
		int choice  = 7;
		do {
			logger.info("\nChoices\n"
						+ "1.Add User\n"
						+ "2.Update User\n"
						+ "3.View All Users\n"
						+ "4.Delete User\n"
						+ "5.Add Course\n"
						+ "6.Reset Course\n"
						+ "7.View Courses\n"
						+ "8.Logout");
			choice = input.nextInt();
			
			switch (choice) {
			case 1:
				adminOperations.addUser(input);
				break;
			case 2:
				adminOperations.updateUser(input);
				break;
			case 3:
				adminOperations.viewUsers(input);
				break;
			case 5:
				adminOperations.addCourse(input);
				break;
			case 6:
				adminOperations.updateCourse(input);
				break;
			case 7:
				adminOperations.viewCourseCatalog();
				break;
			case 4:
				adminOperations.deleteUser(input);
				break;
				
			default:
				break;
			}
		}
		while(choice == 1 || choice == 2|| choice == 3|| choice == 4|| choice == 5|| choice == 6 || choice == 7);

	logger.info("Logging Out at "+ DTUtils.currDateandTime());
	
	}
	
}
