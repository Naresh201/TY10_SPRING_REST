package com.te.springrest.beans;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@JsonRootName("product_ingo")
@XmlRootElement(name="product")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Serializable{
     @Id
     @Column(name="productid")
	private int productid;
     @Column(name="productname")
     private String productname;
     @Column(name="productprice")
     private int productprice;
     @Column(name="quantity")
     private int quantity;
}
