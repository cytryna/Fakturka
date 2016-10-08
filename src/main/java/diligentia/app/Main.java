package diligentia.app;


import java.util.Locale;

import diligentia.model.Company;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pl","PL"));
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring-config.xml");


	}



}
