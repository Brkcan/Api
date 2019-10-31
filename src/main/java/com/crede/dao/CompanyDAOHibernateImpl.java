package com.crede.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.crede.entity.Article;
import com.crede.entity.Company;
import com.crede.entity.CompanySearchList;
import com.crede.entity.Person;
import com.crede.entity.Project;

@Repository
public class CompanyDAOHibernateImpl implements CompanyDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public CompanyDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Company> findAll() {
		Connection conn = null;
		Company company = new Company();
		List<Company> companyList = new ArrayList<Company>();
		List<Company> tt = new ArrayList<Company>();
		Session currentSession = entityManager.unwrap(Session.class);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		try {
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://crede.database.windows.net:1433;databaseName=CredePortalDB;user=Crededata;password=Idbehold12;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = ("SELECT intProjectID, username from CredePortalDB.dbo.tblProjects where username =  '"
				+ auth.getName() + "' ");
		try {
			PreparedStatement statement = conn.prepareStatement(sql); // statement.setString(1, "\"" + keyword + "\"");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				int t = company.setIntProjectID(rs.getInt("intProjectID"));
				companyList.add(company);
				@SuppressWarnings("unchecked")
				Query<Company> tquery = (Query<Company>) entityManager.createQuery(
						"Select id,companyName,brand,vkn,homePageUrl,keyword from Company Where intProjectID = '" + t
								+ "' ");
				tt = tquery.getResultList();
				System.out.println(tt);
				System.out.println(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tt;
	}

	@Override
	public List<Person> findAllPerson() {
		Connection conn = null;
		Person person = new Person();
		List<Person> personList = new ArrayList<Person>();
		List<Person> tt = new ArrayList<Person>();
		Session currentSession = entityManager.unwrap(Session.class);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		try {
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://crede.database.windows.net:1433;databaseName=CredePortalDB;user=Crededata;password=Idbehold12;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = ("SELECT intProjectID, username from CredePortalDB.dbo.tblProjects where username =  '"
				+ auth.getName() + "' ");
		try {
			PreparedStatement statement = conn.prepareStatement(sql); // statement.setString(1, "\"" + keyword + "\"");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				int t = person.setIntProjectID(rs.getInt("intProjectID"));
				personList.add(person);
				Query<Person> tquery = (Query<Person>) entityManager
						.createQuery("Select strPersonName,strTckn from Person Where intProjectID = '" + t + "' ");
				tt = tquery.getResultList();
				System.out.println(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tt;
	}

	private Authentication authenticateIfRequired() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication;
	}

	@Override
	public Company save(Company theCompany) {

		Connection conn = null;
		List<Company> companyList = new ArrayList<Company>();
		HttpServletRequest request = null;

		Session currentSession = entityManager.unwrap(Session.class);

		SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
		System.out.println(sessionFactory.openSession());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://crede.database.windows.net:1433;databaseName=CredePortalDB;user=Crededata;password=Idbehold12;");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = ("SELECT intProjectID, username from CredePortalDB.dbo.tblProjects where username =  '"
				+ auth.getName() + "' ");
		try {
			PreparedStatement statement = conn.prepareStatement(sql); // statement.setString(1, "\"" + keyword + "\"");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				// Company company = new Company();
				theCompany.setIntProjectID(rs.getInt("intProjectID"));
				companyList.add(theCompany);
				System.out.println(theCompany);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		currentSession.saveOrUpdate(theCompany);
		return theCompany;
	}

	@Override
	public Person savePerson(Person thePerson) {
		Connection conn = null;
		List<Person> personList = new ArrayList<Person>();
		HttpServletRequest request = null;

		Session currentSession = entityManager.unwrap(Session.class);

		SessionFactory sessionFactory = entityManager.getEntityManagerFactory().unwrap(SessionFactory.class);
		System.out.println(sessionFactory.openSession());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://crede.database.windows.net:1433;databaseName=CredePortalDB;user=Crededata;password=Idbehold12;");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = ("SELECT intProjectID, username from CredePortalDB.dbo.tblProjects where username =  '"
				+ auth.getName() + "' ");
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				thePerson.setIntProjectID(rs.getInt("intProjectID"));
				personList.add(thePerson);
				System.out.println(thePerson);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		currentSession.saveOrUpdate(thePerson);
		return thePerson;
	}

	// Hibernate doesn't support FTI, So we use SQL Connection
	@Override
	public List<Article> findAllFirmaUnvan(String keyword) {
		Connection conn = null;
		List<Article> articleList = new ArrayList<Article>();

		try {
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://31.169.66.146:1433;database=CommercialRegistryDB;user=CredeBotUser;password=Idbehold2012.;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "SELECT top(100) intArticleID,(SELECT STRING_AGG(strArticleSubject, ', ') AS strArticleSubject FROM CommercialRegistryDB.dbo.tblArticleSubjects WHERE intArticleID = t.intArticleID GROUP BY intArticleID) as strArticleSubject, t.dtRelease, t.strLegalInstitutionName, REPLACE(REPLACE(t.strArticleContent, CHAR(13), ''), CHAR(10), '') as strArticleContent from dbo.tblArticles as t "
				+ " where contains(t.strArticleContent,?)";
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "\"" + keyword + "\"");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setIntArticleID(rs.getInt("intArticleID"));
				article.setDtRelease(rs.getDate("dtRelease"));
				article.setStrLegalInstitutionName(rs.getString("strLegalInstitutionName"));
				article.setMakale(rs.getString("strArticleContent"));
				article.setStrArticleSubjects(rs.getString("strArticleSubject"));
				articleList.add(article);
				System.out.println(rs.getString("strArticleSubject"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articleList;
	}

	@Override
	public List<Article> findAllArticle() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Article> theQuery = currentSession.createQuery("from Article", Article.class);
		List<Article> article = theQuery.getResultList();
		return article;
	}

	@Override
	public Company updateCompany(Company company) {
		Session currentSession = entityManager.unwrap(Session.class);
		Connection conn = null;
		Company company2 = new Company();
		List<Company> update = new ArrayList<Company>();
		System.out.println(company);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://crede.database.windows.net:1433;databaseName=CredePortalDB;user=Crededata;password=Idbehold12;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = ("SELECT intProjectID, username from CredePortalDB.dbo.tblProjects where username =  '"
				+ auth.getName() + "' ");
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int t = company2.setIntProjectID(rs.getInt("intProjectID"));
				int f = company.getId();
				company.setHomePageUrl(rs.getString("strLegalInstitutionName"));
				update.add(company);
				/*
				 * @SuppressWarnings("unchecked") Query<Company> tquery = (Query<Company>)
				 * entityManager
				 * .createQuery("Select homePageUrl from Company Where intProjectID = '" + t +
				 * "' and intCompanyID = '" + f + "' "); update = tquery.getResultList();
				 */
				// update.add(company);
				/*
				 * if (t == company.getIntProjectID()) { System.out.println("company :" +
				 * company); System.out.println("Company2 : " + company2);
				 * 
				 * company.setHomePageUrl(company2.getHomePageUrl());
				 * company.setBrand(company2.getBrand()); company.setVkn(company2.getVkn());
				 * System.out.println(company); update.add(company);
				 * 
				 * } else { System.out.println("Güncelleme yapılamadı..."); }
				 */
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentSession.saveOrUpdate(company);
		return company;
	}

	@Override
	public Person findPersonID(int id) {
		return entityManager.find(Person.class, id);
	}

	@Override
	public Company findCompanyID(int id) {
		return entityManager.find(Company.class, id);
	}

	@Override
	public void deleteCompany(Company company) {
		Connection conn = null;
		Company company2 = new Company();
		List<Company> update = new ArrayList<Company>();
		int k = company.getId();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://crede.database.windows.net:1433;databaseName=CredePortalDB;user=Crededata;password=Idbehold12;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = ("SELECT intProjectID, username from CredePortalDB.dbo.tblProjects where username =  '"
				+ auth.getName() + "' ");

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int t = company2.setIntProjectID(resultSet.getInt("intProjectID"));

				@SuppressWarnings("unchecked")
				Query<Company> query = (Query<Company>) entityManager
						.createQuery("Select intProjectID from Company Where intProjectID =  '" + t + "'");
				update = query.getResultList();
				if (t == company.getIntProjectID()) {
					update.add(company);
					System.out.println(update);
					System.out.println("Compnay 2  =  " + company2);
					System.out.println("company =  " + company);
					entityManager.remove(entityManager.getReference(Company.class, k));
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public void deletePerson(Person person) {
		Connection conn = null;
		Person person2 = new Person();
		List<Person> update = new ArrayList<Person>();
		int k = person.getIntIndividualID();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://crede.database.windows.net:1433;databaseName=CredePortalDB;user=Crededata;password=Idbehold12;");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = ("SELECT intProjectID, username from CredePortalDB.dbo.tblProjects where username =  '"
				+ auth.getName() + "' ");

		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int t = person2.setIntProjectID(resultSet.getInt("intProjectID"));
				@SuppressWarnings("unchecked")
				Query<Person> query = (Query<Person>) entityManager
						.createQuery("Select intProjectID from Person Where intProjectID = '" + t + "'");
				update = query.getResultList();
				if (t == person.getIntProjectID()) {
					update.add(person);
					entityManager.remove(entityManager.getReference(Person.class, k));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
