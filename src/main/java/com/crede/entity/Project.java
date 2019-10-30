package com.crede.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.CodePointLength;

@Entity
@Table(name = "tblProjects")
public class Project {
	
	@Id
	@Column(name = "intprojectid")
	private int intProjectID;

	@Column(name = "strapiusername")
	private String username;

	@Column(name = "strapipasswordhashed")
	private String password;

	public Project() {
	}

	public Project(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getIntProjectID() {
		return intProjectID;
	}

	public void setIntProjectID(int intProjectID) {
		this.intProjectID = intProjectID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Project [intProjectID=" + intProjectID + ", username=" + username
				+ ", password=" + password + "]";
	}

}
