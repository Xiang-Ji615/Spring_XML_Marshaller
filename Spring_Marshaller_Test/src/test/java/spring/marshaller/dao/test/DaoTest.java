package test.java.spring.marshaller.dao.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import main.java.spring.marshaller.dao.config.DaoConfig;
import main.java.spring.marshaller.dao.dao.IDao;
import main.java.spring.marshaller.dao.model.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {DaoConfig.class})
public class DaoTest implements ApplicationContextAware{
	
	@Autowired
	IDao dao;
	
	ApplicationContext context;

	@Test
	@Timed(millis=300)
	public void helloWorldTest() {
		assertNotNull("Hello world");
	}
	
	@Test
	public void marshallerTest() throws XmlMappingException, JAXBException, IOException {
		User user = getUser();
		user.setUsername("user2");
		user.setPassword("pass2");
		user.setAge(22);
		user.setGender(true);
		dao.saveUser("Marshaller.xml", user);
	}
	
	@Test
//	@Timed(millis=300)
	public void unmarshallerTest() throws XmlMappingException, IOException {
		User user = dao.readUser("Marshaller.xml");
		assertNotNull(user);
	}
	
	public User getUser() {
		return context.getBean(User.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.context = applicationContext;
	};
}
