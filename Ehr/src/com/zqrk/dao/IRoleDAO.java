package com.zqrk.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zqrk.model.Role;

public interface IRoleDAO {

	// property constants
	public static final String NAME = "name";
	public static final String DESCR = "descr";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(Role transientInstance);

	public abstract void delete(Role persistentInstance);

	public abstract Role findById(java.lang.String id);

	public abstract List<Role> findByExample(Role instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Role> findByName(Object name);

	public abstract List<Role> findByDescr(Object descr);

	public abstract List findAll();

	public abstract Role merge(Role detachedInstance);

	public abstract void attachDirty(Role instance);

	public abstract void attachClean(Role instance);

}