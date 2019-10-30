package com.crede.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

@Entity
@Table(name = "tblcompanysearchlist")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "intcompanyid")
	private int id;

	@Column(name = "intprojectid")
	private int intProjectID;

	@Column(name = "strlegalinstitutionname")
	private String companyName;

	@Column(name = "strbrand")
	private String brand;

	@Column(name = "strvkn")
	private String vkn;

	@Column(name = "strhomepageurl")
	private String homePageUrl;

	@Column(name = "strkeyword")
	private String keyword;

	@Column(name = "islocalnewsenabled")
	private boolean isLocalNewsEnabled;

	@Column(name = "intrelatedcompanyid")
	private Integer ustfirmaid;

	@Column(name = "intuserid")
	private int userID;

	public Company() {
	}

	public Company(int intProjectID, String companyName, String brand, String vkn, String homePageUrl, String keyword,
			boolean isLocalNewsEnabled, Integer ustfirmaid, int userID) {
		this.intProjectID = intProjectID;
		this.companyName = companyName;
		this.brand = brand;
		this.vkn = vkn;
		this.homePageUrl = homePageUrl;
		this.keyword = keyword;
		this.isLocalNewsEnabled = isLocalNewsEnabled;
		this.ustfirmaid = ustfirmaid;
		this.userID = 0;
	}

	public int getId() {
		return id;
	}

	public int setId(int id) {
		return this.id = id;
	}

	public int getIntProjectID() {
		return intProjectID;
	}

	public int setIntProjectID(int intProjectID) {
		return this.intProjectID = intProjectID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVkn() {
		return vkn;
	}

	public void setVkn(String vkn) {
		this.vkn = vkn;
	}

	public String getHomePageUrl() {
		return homePageUrl;
	}

	public void setHomePageUrl(String homePageUrl) {
		this.homePageUrl = homePageUrl;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public boolean isLocalNewsEnabled() {
		return isLocalNewsEnabled;
	}

	public void setLocalNewsEnabled(boolean isLocalNewsEnabled) {
		this.isLocalNewsEnabled = isLocalNewsEnabled;
	}

	public Integer getUstfirmaid() {
		return ustfirmaid;
	}

	public void setUstfirmaid(Integer ustfirmaid) {
		this.ustfirmaid = ustfirmaid;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", intProjectID=" + intProjectID + ", companyName=" + companyName + ", brand="
				+ brand + ", vkn=" + vkn + ", homePageUrl=" + homePageUrl + ", keyword=" + keyword
				+ ", isLocalNewsEnabled=" + isLocalNewsEnabled + ", ustfirmaid=" + ustfirmaid + ", userID=" + userID
				+ "]";
	}

}
