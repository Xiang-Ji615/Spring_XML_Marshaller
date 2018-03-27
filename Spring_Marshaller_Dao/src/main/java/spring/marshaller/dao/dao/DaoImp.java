package main.java.spring.marshaller.dao.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

import main.java.spring.marshaller.dao.model.User;

@Component
public class DaoImp extends AbstractDao {

	@Override
	public Boolean saveUser(String filePath, User user) throws JAXBException, XmlMappingException, IOException {
		FileOutputStream os = null;
		os = new FileOutputStream(filePath);
		this.marshaller.marshal(user, new StreamResult(os));
		os.close();
		return true;
	}

	@Override
	public User readUser(String filePath) throws XmlMappingException, IOException {
		return (User) this.unmarshaller.unmarshal(new StreamSource(new File(filePath)));
	}

}
