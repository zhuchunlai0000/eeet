package com.zqrk.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zqrk.model.Users;

public interface IUsersDAO {

	// property constants
	public static final String NAME = "name";
	public static final String PWD = "pwd";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(Users transientInstance);

	public abstract void delete(Users persistentInstance);

	public abstract Users findById(java.lang.String id);

	public abstract List<Users> findByExample(Users instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Users> findByName(Object name);

	public abstract List<Users> findByPwd(Object pwd);

	public abstract List findAll();

	public abstract Users merge(Users detachedInstance);

	public abstract void attachDirty(Users instance);

	public abstract void attachClean(Users instance);

	public abstract List viewByPage(String className, int first, int max,
			String order, String field);

	public abstract List searchByPage( Users user, int first,
			int max, String order, String field);

}