package com.crede.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crede.entity.Article;
import com.crede.entity.Company;
import com.crede.entity.CompanySearchList;
import com.crede.entity.Person;
import com.crede.entity.Project;

public interface CompanyService {
	
	public List<Company> findAll();
	
	public List<Person> findAllPerson();
	
	public List<Article> findAllArticle();
	
	//public List<CompanySearchList> findAllCompanySearchList();
	public Company findCompanyID(int id);
	
	public Person findPersonID(int id);
	
	public Company updateCompany(Company company);
	
	public void deleteCompany(Company company);
	
	public void deletePerson(Person person);
	
	public List<Article> findAllFirmaUnvan(String strLegalInstitutionName);
	
	public Company save(Company theCompany);
	
	public Person savePerson(Person thePerson);

	

}
