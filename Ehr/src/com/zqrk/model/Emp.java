package com.zqrk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "emp", catalog = "hr")
public class Emp implements java.io.Serializable {

	// Fields

	private Integer id;
	private String empName;
	private String gender;
	private String tel;
	private String age;

	// Constructors

	/** default constructor */
	public Emp() {
	}

	/** full constructor */
	public Emp(String empName, String gender, String tel, String age) {
		this.empName = empName;
		this.gender = gender;
		this.tel = tel;
		this.age = age;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "empName")
	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Column(name = "gender")
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "tel")
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "age")
	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}