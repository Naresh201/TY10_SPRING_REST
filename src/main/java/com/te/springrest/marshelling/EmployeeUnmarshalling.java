package com.te.springrest.marshelling;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class EmployeeUnmarshalling {

	public static void main(String[] args) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(EmployeeInfo.class);
			
		           Unmarshaller unmarshal =   context.createUnmarshaller();
		    //  EmployeeInfo info =  unmarshal.unmarshal(new file("employee.xml"));
		} catch (JAXBException e) {
			
			e.printStackTrace();
		}
		

	}

}
