package com.crede.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tblarticles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "intarticleid")
	private int intArticleID;

	@Column(name = "strlegalinstitutionname")
	private String strLegalInstitutionName;

	@Column(name = "strarticlecontent")
	private String makale;

	@Column(name = "dtrelease")
	private Date dtRelease;

	@Column(name = "strbeginningofname")
	private String strBeginningOfName;

	@Column(name = "intcompanytype")
	private int intCompanyType;
	
	private String strArticleSubjects;

	
	/*
	 * @Column(name = "intcityid") private int intCityID;
	 * 
	 * @Column(name = "intdistrictid") private int intDistrictID;
	 * 
	 * @Column(name = "straddress") private String strAddress;
	 * 
	 * @Column(name = "strcommercialregistryofficename") private String
	 * strCommercialRegistryOfficeName;
	 * 
	 * @Column(name = "strmersisno") private String strMersisNo;
	 * 
	 * @Column(name = "intcapitalamount") private int intCapitalAmount;
	 * 
	 * @Column(name = "strcommercialregistryno") private String
	 * strCommercialRegistryNo;
	 * 
	 * @Column(name = "intpagenumber") private int intPageNumber;
	 */

	/*
	 * @OneToOne()
	 * 
	 * @JoinColumn(name = "strlegalinstitutionname", referencedColumnName =
	 * "strlegalinstitutionname")
	 * 
	 * @JsonBackReference private CompanySearchList companySearchList;
	 */

	// @OneToOne(mappedBy = "article")
	// private ArticleSubject articleSubject;

	public String getStrArticleSubjects() {
		return strArticleSubjects;
	}

	public void setStrArticleSubjects(String strArticleSubjects) {
		this.strArticleSubjects = strArticleSubjects;
	}

	public Article() {
	}

	/*
	 * @XmlTransient public ArticleSubject getArticleSubject() { return
	 * articleSubject; }
	 * 
	 * public void setArticleSubject(ArticleSubject articleSubject) {
	 * this.articleSubject = articleSubject; }
	 */

	/*
	 * public CompanySearchList getCompanySearchList() { return companySearchList; }
	 * 
	 * public void setCompanySearchList(CompanySearchList companySearchList) {
	 * this.companySearchList = companySearchList; }
	 */

	public Article(int intArticleID, String strLegalInstitutionName, String makale, Date dtRelease,
			String strBeginningOfName, int intCompanyType) {
		super();
		this.intArticleID = intArticleID;
		this.strLegalInstitutionName = strLegalInstitutionName;
		this.makale = makale;
		this.dtRelease = dtRelease;
		this.strBeginningOfName = strBeginningOfName;
		this.intCompanyType = intCompanyType;
	}

	public Date getDtRelease() {
		return dtRelease;
	}

	public int getId() {
		return intArticleID;
	}

	public int getIntArticleID() {
		return intArticleID;
	}

	public int getIntCompanyType() {
		return intCompanyType;
	}

	public String getMakale() {
		return makale;
	}

	public String getStrBeginningOfName() {
		return strBeginningOfName;
	}

	public String getStrLegalInstitutionName() {
		return strLegalInstitutionName;
	}

	public void setDtRelease(Date dtRelease) {
		this.dtRelease = dtRelease;
	}

	public void setId(int iintArticleIDd) {
		this.intArticleID = iintArticleIDd;
	}

	public void setIntArticleID(int intArticleID) {
		this.intArticleID = intArticleID;
	}

	public void setIntCompanyType(int intCompanyType) {
		this.intCompanyType = intCompanyType;
	}

	public void setMakale(String makale) {
		this.makale = makale;
	}

	public void setStrBeginningOfName(String strBeginningOfName) {
		this.strBeginningOfName = strBeginningOfName;
	}

	public void setStrLegalInstitutionName(String strLegalInstitutionName) {
		this.strLegalInstitutionName = strLegalInstitutionName;
	}

	@Override
	public String toString() {
		return "Article [intArticleID=" + intArticleID + ", strLegalInstitutionName=" + strLegalInstitutionName
				+ ", makale=" + makale + ", dtRelease=" + dtRelease + ", strBeginningOfName=" + strBeginningOfName
				+ ", intCompanyType=" + intCompanyType + "]";
	}

}
