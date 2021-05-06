package com.te.springrest.marshelling;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class EmployeeInfo implements Serializable {
	
	@XmlElement
	private int empid;
	@XmlElement
	private String empname;
	@XmlElement
	private String role;
	@XmlElement
	private int experience;
	@XmlElement
	private String password;

}
