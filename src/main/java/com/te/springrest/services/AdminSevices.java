package com.te.springrest.services;

import java.util.List;

import com.te.springrest.beans.AdminInfo;
import com.te.springrest.beans.Product;

public interface AdminSevices {
	
	public AdminInfo autheticate(int id,String password);
	public List<Product> getAllProductDetails(); 
	
	public boolean addProducts(Product product);
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(int id );

}
