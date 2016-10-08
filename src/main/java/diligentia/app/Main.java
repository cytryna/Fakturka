package diligentia.app;


import java.util.Locale;

import diligentia.model.Company;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pl","PL"));
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring-config.xml");

		prepareTemporaryData();
	}

	private static void prepareTemporaryData() {
		entityManager.getTransaction().begin();

		Company company = new Company();
		company.setTaxIdentificationNumber("971-060-22-10");
		company.setName("Diligentia");
		company.setCity("Warszawa");
		company.setPostCode("04-113");
		company.setStreet("Łukowska 1/156");
		entityManager.persist(company);

		company = new Company();
		company.setTaxIdentificationNumber("775-000-46-84");
		company.setName("Wich-Mot");
		company.setCity("Gostynin");
		company.setPostCode("09-500");
		company.setStreet("Chopina 4");
		entityManager.persist(company);

		entityManager.getTransaction().commit();
	}

}
