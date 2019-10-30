package com.crede.rest;

import java.net.URI;
import java.security.Principal;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crede.dao.CompanyDAOHibernateImpl;
import com.crede.entity.Article;
import com.crede.entity.Company;
import com.crede.entity.CompanySearchList;
import com.crede.entity.Person;
import com.crede.service.CompanyService;

@RestController
@RequestMapping("/rest")
public class CompanyRestController {

	private CompanyService companyService;

	public CompanyRestController(CompanyService theCompanyService) {
		companyService = theCompanyService;
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deletePerson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deletePerson(@PathVariable("id") int id, Person personRequest){
		Person person = companyService.findPersonID(id);
		companyService.deletePerson(person);
		return ResponseEntity.ok().build();
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteCompany/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteCompany(@PathVariable("id") int id, Company companyRequest){
		Company company = companyService.findCompanyID(id);
		companyService.deleteCompany(company);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/UpdateCompany/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateCompany(@PathVariable("id") int id, @RequestBody Company companyRequest) {

		Company company = (Company) companyService.findCompanyID(id);
		company.setHomePageUrl(companyRequest.getHomePageUrl());
		companyService.updateCompany(company);
		return ResponseEntity.ok().build();

	}

	@GetMapping(value = "/SearchCompany", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Company> findAll() {
		return companyService.findAll();
	}

	@GetMapping(value = "/SearchPerson", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAllPerson() {
		return companyService.findAllPerson();
	}

	@GetMapping(value = "/SearchArticle")
	public List<Article> findAllArticle() {
		return companyService.findAllArticle();
	}

	/*
	 * @GetMapping(value = "/company") public List<CompanySearchList>
	 * findAllCompanySearchList() { return
	 * companyService.findAllCompanySearchList(); }
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/SearchTSKeyword", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Article>> getCompanySearch(@RequestParam("firma") String strLegalInstitutionName)
			throws InterruptedException {
		List<Article> companySearchLists = companyService.findAllFirmaUnvan(strLegalInstitutionName);
		return ResponseEntity.ok(companySearchLists);
	}

	@PostMapping(value = "/InsertCompany", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<URI> save(@RequestBody Company theCompany) {
		try {
		
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			System.out.println(auth.getAuthorities() + auth.getName() + auth.toString());
			// theCompany.getIntProjectID();
			System.out.println(auth.getDetails()); // session null geliyor

			companyService.save(theCompany);

			// companyService.save(theCompany);
			System.out.println(auth.getDetails());
			int id = theCompany.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping(value = "/InsertPerson", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person savePerson(@RequestBody Person thePerson) {
		thePerson.setIntIndividualID(0);

		companyService.savePerson(thePerson);

		return thePerson;
	}

}
