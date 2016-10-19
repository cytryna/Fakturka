package diligentia.app;

import diligentia.entity.Company;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Component
public class PrepareDataUtil {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void prepareTemporaryData() {
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
