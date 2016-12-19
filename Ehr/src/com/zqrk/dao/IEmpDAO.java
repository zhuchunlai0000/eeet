package com.zqrk.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zqrk.model.Emp;

public interface IEmpDAO {

	// property constants
	public static final String EMP_NAME = "empName";
	public static final String GENDER = "gender";
	public static final String TEL = "tel";
	public static final String AGE = "age";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(Emp transientInstance);

	public abstract void delete(Emp persistentInstance);

	public abstract Emp findById(java.lang.Integer id);

	public abstract List<Emp> findByExample(Emp instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Emp> findByEmpName(Object empName);

	public abstract List<Emp> findByGender(Object gender);

	public abstract List<Emp> findByTel(Object tel);

	public abstract List<Emp> findByAge(Object age);

	public abstract List findAll();

	public abstract Emp merge(Emp detachedInstance);

	public abstract void attachDirty(Emp instance);

	public abstract void attachClean(Emp instance);

}