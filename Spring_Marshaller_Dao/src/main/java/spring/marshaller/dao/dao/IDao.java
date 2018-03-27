package main.java.spring.marshaller.dao.dao;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.springframework.oxm.XmlMappingException;

import main.java.spring.marshaller.dao.model.User;

public interface IDao {

	Boolean saveUser(String filePath, User user) throws JAXBException, XmlMappingException, IOException;
	
	User readUser(String filePath) throws XmlMappingException, IOException;
}
