package peaksoft.repositories;

import org.springframework.stereotype.Repository;
import peaksoft.models.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

    @Repository
    public class CompanyRepository {
        private final EntityManager entityManager;

        public CompanyRepository(EntityManagerFactory entityManagerFactory) {
            this.entityManager = entityManagerFactory.createEntityManager();
        }
        public void saveCompany(Company company) {
            entityManager.getTransaction().begin();
            entityManager.persist(company);
            entityManager.getTransaction().commit();
        }


        public Company findCompanyById(Long companyId) {
            return entityManager.find(Company.class, companyId);
        }


        public List<Company> findAllCompanies() {
            return entityManager.createQuery("select c from Company c", Company.class)
                    .getResultList();
        }

        public void removeCompanyById(Long companyId) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(findCompanyById(companyId));
            transaction.commit();
        }

        public void updateCompany(Long companyId, Company newCompany) {
            entityManager.getTransaction().begin();
            Company company = findCompanyById(companyId);
            company.setCompanyName(newCompany.getCompanyName());
            company.setLocatedCountry(newCompany.getLocatedCountry());
            entityManager.persist(company);
            entityManager.getTransaction().commit();
        }
    }
