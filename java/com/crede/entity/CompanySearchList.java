package com.crede.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name = "tblcompanysearchlist")
public class CompanySearchList {

	@NaturalId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "intcompanyid")
	private int id;

	@Id
	@Column(name = "strlegalinstitutionname")
	private String firmaUnvani;

	@Column(name = "dtcreate")
	private Date tarih;

//	@Column(name = "icerik")
//	private String icerik;

//	@Column(name = "api")
//	private String apiKey;

//	@OneToOne(mappedBy = "companySearchList")
//	private ArticleSubject articleSubject;

	// @OneToOne(mappedBy = "companySearchList")
	// private Article article;

	public CompanySearchList() {
	}

	public CompanySearchList(String firmaUnvani, Date tarih) {
		this.firmaUnvani = firmaUnvani;
		this.tarih = tarih;
	}

	/*
	 * @XmlTransient public Article getArticle() { return article; }
	 * 
	 * public void setArticle(Article article) { this.article = article; }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirmaUnvani() {
		return firmaUnvani;
	}

	public void setFirmaUnvani(String firmaUnvani) {
		this.firmaUnvani = firmaUnvani;
	}

	public Date getTarih() {
		return tarih;
	}

	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}

	@Override
	public String toString() {
		return "CompanySearchList [id=" + id + ", firmaUnvani=" + firmaUnvani + ", tarih=" + tarih + "]";
	}

}
