package com.te.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springrest.beans.AdminInfo;
import com.te.springrest.beans.Product;
import com.te.springrest.dao.AdminDao;

@Service
public class AdminServicesImp implements AdminSevices{
	@Autowired
	AdminDao dao;
	
	public AdminInfo autheticate(int id, String password) {
		return dao.authenticate(id, password);
	}
	public List<Product> getAllProductDetails() {
		System.out.println("service is executing");
		return dao.getAllProductDetails();
	}
	public boolean addProducts(Product product) {
		return dao.addproducts(product);
	}
	public boolean updateProduct(Product product) {
		return dao.addproducts(product);
	}
	public boolean deleteProduct(int  id) {
		return dao.deleteProduct(id);
	}
}
