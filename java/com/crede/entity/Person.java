package com.crede.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
@Entity
@Table(name = "tblindividualsearchlist")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "intindividualid")
	private int intIndividualID;

	@Column(name = "strpersonname")
	private String strPersonName;

	@Column(name = "strtckn")
	private String strTckn;

	@Column(name = "intidentificationid")
	private Integer intIdentificationID;

	@Column(name = "intprojectid")
	private int intProjectID;

	@Column(name = "isdeleted")
	private boolean isDeleted;

	@Column(name = "dtcreate")
	private Date dtCreate;

	@Column(name = "dtupdate")
	private Date dtUpdate;

	@Column(name = "intrelatedcompanyid")
	private int intRelatedCompanyID;

	@Column(name = "intrelatedpersonid")
	private int intRelatedPersonID;

	@Column(name = "intuserid")
	private int intUserID;

	public Person() {
	}

	public Person(String strPersonName, String strTckn, Integer intIdentificationID, int intProjectID, boolean isDeleted,
			Date dtCreate, Date dtUpdate, int intRelatedCompanyID, int intRelatedPersonID, int intUserID) {
		this.strPersonName = strPersonName;
		this.strTckn = strTckn;
		this.intIdentificationID = intIdentificationID;
		this.intProjectID = intProjectID;
		this.isDeleted = isDeleted;
		this.dtCreate = dtCreate;
		this.dtUpdate = dtUpdate;
		this.intRelatedCompanyID = intRelatedCompanyID;
		this.intRelatedPersonID = intRelatedPersonID;
		this.intUserID = intUserID;
	}

	public int getIntIndividualID() {
		return intIndividualID;
	}

	public void setIntIndividualID(int intIndividualID) {
		this.intIndividualID = intIndividualID;
	}

	public String getStrPersonName() {
		return strPersonName;
	}

	public void setStrPersonName(String strPersonName) {
		this.strPersonName = strPersonName;
	}

	public String getStrTckn() {
		return strTckn;
	}

	public void setStrTckn(String strTckn) {
		this.strTckn = strTckn;
	}

	public Integer getIntIdentificationID() {
		return intIdentificationID;
	}

	public void setIntIdentificationID(Integer intIdentificationID) {
		this.intIdentificationID = intIdentificationID;
	}

	public int getIntProjectID() {
		return intProjectID;
	}

	public int setIntProjectID(int intProjectID) {
		return this.intProjectID = intProjectID;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getDtCreate() {
		return dtCreate;
	}

	public void setDtCreate(Date dtCreate) {
		this.dtCreate = dtCreate;
	}

	public Date getDtUpdate() {
		return dtUpdate;
	}

	public void setDtUpdate(Date dtUpdate) {
		this.dtUpdate = dtUpdate;
	}

	public int getIntRelatedCompanyID() {
		return intRelatedCompanyID;
	}

	public void setIntRelatedCompanyID(int intRelatedCompanyID) {
		this.intRelatedCompanyID = intRelatedCompanyID;
	}

	public int getIntRelatedPersonID() {
		return intRelatedPersonID;
	}

	public void setIntRelatedPersonID(int intRelatedPersonID) {
		this.intRelatedPersonID = intRelatedPersonID;
	}

	public int getIntUserID() {
		return intUserID;
	}

	public void setIntUserID(int intUserID) {
		this.intUserID = intUserID;
	}

	@Override
	public String toString() {
		return "Person [intIndividualID=" + intIndividualID + ", strPersonName=" + strPersonName + ", strTckn="
				+ strTckn + ", intIdentificationID=" + intIdentificationID + ", intProjectID=" + intProjectID
				+ ", isDeleted=" + isDeleted + ", dtCreate=" + dtCreate + ", dtUpdate=" + dtUpdate
				+ ", intRelatedCompanyID=" + intRelatedCompanyID + ", intRelatedPersonID=" + intRelatedPersonID
				+ ", intUserID=" + intUserID + "]";
	}

}
