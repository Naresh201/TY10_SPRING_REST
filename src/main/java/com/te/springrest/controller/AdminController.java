package com.te.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springrest.beans.Product;
import com.te.springrest.beans.ProductResponse;
import com.te.springrest.services.AdminSevices;

@RestController
public class AdminController {
	@Autowired
	private AdminSevices services;
	
	@GetMapping(path = "/get" , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse getallProduct() {
		ProductResponse response = new ProductResponse();
		
		List<Product>beans =  services.getAllProductDetails();
		if(beans!=null) {
			response.setStatus(200);
			response.setMsg("sucesss");
			response.setProducts(beans);
		}else {
			response.setStatus(400);
			response.setMsg("unable to ge the products Please try again later (*|*)");
		}
		return response;
	}
	@PutMapping(path = "/update" , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse update(@RequestBody Product product) {
		ProductResponse response = new ProductResponse();
		if(services.updateProduct(product)) {
			response.setStatus(200);
			response.setMsg("sucessfully updated the mentioned record");
		}else {
			response.setStatus(400);
			response.setMsg("unable to update (*|*)");
		}
		return response;
	}
	@PostMapping(path = "/add" , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse add(@RequestBody Product product) {
		ProductResponse response = new ProductResponse();
		if(services.addProducts(product)) {
			response.setStatus(200);
			response.setMsg("sucessfully added the record");
		}else {
			response.setStatus(400);
			response.setMsg("unable to add the product please try again (*|*)");
		}
		return response;
	}
	
	@DeleteMapping(path = "/add/{productid}" , produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ProductResponse add(@PathVariable(name = "productid")int id) {
		ProductResponse response = new ProductResponse();
		if(services.deleteProduct(id)) {
			response.setStatus(200);
			response.setMsg("sucessfully deleted the record");
		}else {
			response.setStatus(400);
			response.setMsg("unable to add the product please try again (*|*)");
		}
		return response;
	}
}
