package main.java.spring.marshaller.dao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.castor.CastorMarshaller;

public abstract class AbstractDao implements IDao {

	@Autowired
	@Qualifier(value="marshaller")
	protected Marshaller marshaller;

	@Autowired
	@Qualifier(value="unmarshaller")
	protected Unmarshaller unmarshaller;
}
