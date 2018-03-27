package main.java.spring.marshaller.dao.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.castor.CastorMarshaller;

import main.java.spring.marshaller.dao.model.User;

@Configuration
@ComponentScan(basePackages= {"main.java"})
public class DaoConfig {

	@Bean(name="marshaller")
	public Marshaller getMarshaller() {
		return  new CastorMarshaller();
	}
	
	@Bean(name="unmarshaller")
	public Unmarshaller getUnmarshaller() {
		return  new CastorMarshaller();
	}
}
