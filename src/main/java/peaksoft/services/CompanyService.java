package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Company;
import peaksoft.repositories.CompanyRepository;

import java.util.List;
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void saveCompany(Company company) {
        companyRepository.saveCompany(company);
    }


    public Company findCompanyById(Long companyId) {
        return companyRepository.findCompanyById(companyId);
    }


    public List<Company> findAllCompanies() {
        return companyRepository.findAllCompanies();
    }

    public void removeCompanyById(Long companyId) {
        companyRepository.removeCompanyById(companyId);
    }

    public void updateCompany(Long companyId, Company company) {
        companyRepository.updateCompany(companyId, company);
    }
}
