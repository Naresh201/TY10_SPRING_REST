package com.te.springrest.dao;

import java.util.List;

import com.te.springrest.beans.AdminInfo;
import com.te.springrest.beans.Product;

public interface AdminDao {
	public AdminInfo  authenticate(int id, String password);
	public List<Product> getAllProductDetails(); 
	public boolean addproducts(Product product);
	public boolean updateProduct(Product product);
	public boolean deleteProduct( int id);

}
