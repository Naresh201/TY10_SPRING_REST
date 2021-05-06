package com.te.springrest.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@JsonRootName("response")
@XmlRootElement(name="response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse implements Serializable {
    @JsonProperty("status")
    @XmlElement(name="status-code")
	private int status;
    
	private String msg;
	@JsonProperty("product_info")
    @XmlElement(name="product-info")
	private Product product;
	private List<Product> products;
}
