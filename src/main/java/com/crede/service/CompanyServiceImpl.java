package com.crede.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crede.dao.CompanyDAO;
import com.crede.entity.Article;
import com.crede.entity.Company;
import com.crede.entity.CompanySearchList;
import com.crede.entity.Person;
import com.crede.entity.Project;

@Transactional
@Service
public class CompanyServiceImpl implements CompanyService{

	private CompanyDAO companyDAO;
	
	@Autowired
	public CompanyServiceImpl(CompanyDAO theCompanyDAO) {
		companyDAO = theCompanyDAO;
	}
	
	@Override
	public List<Person> findAllPerson() {
		return companyDAO.findAllPerson();
	}
	
	@Override
	public Company save(Company thecompany) {
		companyDAO.save(thecompany);
		return thecompany;
	}

	@Override
	public List<Company> findAll() {
		return companyDAO.findAll();
	}

	@Override
	public Person savePerson(Person thePerson) {
		return companyDAO.savePerson(thePerson);
	}

	@Override
	public List<Article> findAllFirmaUnvan(String strLegalInstitutionName){
		return companyDAO.findAllFirmaUnvan(strLegalInstitutionName);
	}

	/*
	 * @Override public List<CompanySearchList> findAllCompanySearchList() { return
	 * companyDAO.findAllCompanySearchLists(); }
	 */

	@Override
	public List<Article> findAllArticle() {
		return companyDAO.findAllArticle();
	}

	@Override
	public Company updateCompany(Company company) {
		return companyDAO.updateCompany(company);
	}

	@Override
	public Company findCompanyID(int id) {
		return companyDAO.findCompanyID(id);
	}

	@Override
	public void deleteCompany(Company company) {
		companyDAO.deleteCompany(company);
	}

	@Override
	public void deletePerson(Person person) {
		companyDAO.deletePerson(person);
	}

	@Override
	public Person findPersonID(int id) {
		return companyDAO.findPersonID(id);
	}

}
