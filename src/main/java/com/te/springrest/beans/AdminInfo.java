package com.te.springrest.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Table(name="admin")
@Entity
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonRootName("employee_info")
public class AdminInfo implements Serializable {
	@Id
	@Column
	private int adminid;
	@Column
	private String adminpwd;
}
