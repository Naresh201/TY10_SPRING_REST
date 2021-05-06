package com.te.springrest.marshelling;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class EmployeeMarshelling {

	public static void main(String[] args) {
		
		EmployeeInfo info = new EmployeeInfo();
		
		info.setEmpid(101);
		info.setEmpname("naresh");
		info.setExperience(2);
		info.setPassword("nareshroyal@2");
		info.setRole("deveops");
		
		
		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeInfo.class);
			
		             Marshaller marshsller = 	context.createMarshaller();
		             
		        marshsller.marshal(info, new File("employee.xml"));
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
