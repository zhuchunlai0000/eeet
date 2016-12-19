package com.zqrk.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zqrk.model.Dept;

public interface IDeptDAO {

	// property constants
	public static final String DEPT_NAME = "deptName";
	public static final String DEPT_NO = "deptNo";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(Dept transientInstance);

	public abstract void delete(Dept persistentInstance);

	public abstract Dept findById(java.lang.Integer id);

	public abstract List<Dept> findByExample(Dept instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Dept> findByDeptName(Object deptName);

	public abstract List<Dept> findByDeptNo(Object deptNo);

	public abstract List findAll();

	public abstract Dept merge(Dept detachedInstance);

	public abstract void attachDirty(Dept instance);

	public abstract void attachClean(Dept instance);

}