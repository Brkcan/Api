//Auther: Burak Can
//Date: 16-10-2019
//Table structure of tblArticleSubject
package com.crede.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tblarticlesubjects")
public class ArticleSubject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "intsubjectid")
	private int id;
	
	@Column(name = "intarticlesubject")
	private int intArticleID;

	@Column(name = "strarticlesubject")
	private String konu;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "intarticleid")
	 * 
	 * @JsonBackReference private Article article;
	 */

	public ArticleSubject() {
	}

	/*
	 * public Article getArticle() { return article; }
	 * 
	 * public void setArticle(Article article) { this.article = article; }
	 */
	public ArticleSubject(String konu) {
		this.konu = konu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKonu() {
		return konu;
	}

	public void setKonu(String konu) {
		this.konu = konu;
	}

	@Override
	public String toString() {
		return "ArticleSubject [id=" + id + ", konu=" + konu + "]";
	}

}
