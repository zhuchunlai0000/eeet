package com.zqrk.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.zqrk.model.Resource;

public interface IResourceDAO {

	// property constants
	public static final String NAME = "name";
	public static final String URL = "url";
	public static final String ICO = "ico";

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract void save(Resource transientInstance);

	public abstract void delete(Resource persistentInstance);

	public abstract Resource findById(java.lang.String id);

	public abstract List<Resource> findByExample(Resource instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List<Resource> findByName(Object name);

	public abstract List<Resource> findByUrl(Object url);

	public abstract List<Resource> findByIco(Object ico);

	public abstract List findAll();

	public abstract Resource merge(Resource detachedInstance);

	public abstract void attachDirty(Resource instance);

	public abstract void attachClean(Resource instance);

}