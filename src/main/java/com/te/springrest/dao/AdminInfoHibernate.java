package com.te.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.springrest.beans.AdminInfo;
import com.te.springrest.beans.Product;
import com.te.springrest.customexception.ProductException;
@Repository
public class AdminInfoHibernate implements AdminDao{
	//@PersistenceUnit
	public AdminInfo  authenticate(int id, String password) {
    	  AdminInfo bean = null;
    	  
		try {
			EntityManagerFactory	factory = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			String query = "from AdminInfo where adminid=:id and adminpwd=:pwd";
			Query issuedQuery = manager.createQuery(query);
			issuedQuery.setParameter("id", id);
			issuedQuery.setParameter("pwd", password);
			transaction.begin();
			 bean = (AdminInfo) issuedQuery.getSingleResult();
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	@SuppressWarnings("unchecked")
	public List<Product> getAllProductDetails() {
		System.out.println("dao is executing ");
		List<Product> productbeans = null;
		try {
			EntityManagerFactory factory1 = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory1.createEntityManager();
			Query query = manager.createQuery("from Product");
			productbeans = query.getResultList();
		} catch (Exception e) {
			productbeans = null;
			e.printStackTrace();
		}
		return productbeans;
		
	}
	
	public boolean addproducts(Product product) {
		try {
			EntityManagerFactory factory2 = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory2.createEntityManager();
			EntityTransaction trans = manager.getTransaction();
			
			manager.persist(product);
			trans.commit();
			return true;
			
		
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean updateProduct(Product product) {
		try {
			EntityManagerFactory factory3 = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory3.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Product orgData = manager.find(Product.class ,product.getProductid());

			if (product.getProductname() != null && product.getProductname() != "") {
				orgData.setProductname(product.getProductname());
			}

			if (product.getProductprice() != 0 ) {
				orgData.setProductprice(product.getProductprice());
			}

			if (product.getQuantity() != 0) {
				orgData.setQuantity(product.getQuantity());
			}

			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteProduct(int id) {
		try {
    		EntityManagerFactory factory4 = Persistence.createEntityManagerFactory("springdb");
			EntityManager manager = factory4.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Product infoBean = manager.find(Product.class, id);
			manager.remove(infoBean);
			transaction.commit();
			return true;
		} catch (Exception e) {

			e.printStackTrace();

			throw new ProductException("The Data is not present");
		}
	}
}
