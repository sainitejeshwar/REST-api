package com.flipkart.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flipkart.bean.Customer;

@Path("/customer")
public class customerClient {
	@Path("/json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomerDetails() {
		Customer customer = new Customer();
		customer.setId(101);
		customer.setName("Tejeshwar");
		return customer;
	}
}
