package com.zqrk.daoImpl;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.zqrk.dao.IResourceDAO;
import com.zqrk.model.Resource;

/**
 * A data access object (DAO) providing persistence and search support for
 * Resource entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.zqrk.model.Resource
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ResourceDAO implements IResourceDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ResourceDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#save(com.zqrk.model.Resource)
	 */
	@Override
	public void save(Resource transientInstance) {
		log.debug("saving Resource instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#delete(com.zqrk.model.Resource)
	 */
	@Override
	public void delete(Resource persistentInstance) {
		log.debug("deleting Resource instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#findById(java.lang.String)
	 */
	@Override
	public Resource findById(java.lang.String id) {
		log.debug("getting Resource instance with id: " + id);
		try {
			Resource instance = (Resource) getCurrentSession().get(
					"com.zqrk.model.Resource", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#findByExample(com.zqrk.model.Resource)
	 */
	@Override
	public List<Resource> findByExample(Resource instance) {
		log.debug("finding Resource instance by example");
		try {
			List<Resource> results = (List<Resource>) getCurrentSession()
					.createCriteria("com.zqrk.model.Resource")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Resource instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Resource as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#findByName(java.lang.Object)
	 */
	@Override
	public List<Resource> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#findByUrl(java.lang.Object)
	 */
	@Override
	public List<Resource> findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#findByIco(java.lang.Object)
	 */
	@Override
	public List<Resource> findByIco(Object ico) {
		return findByProperty(ICO, ico);
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Resource instances");
		try {
			String queryString = "from Resource";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#merge(com.zqrk.model.Resource)
	 */
	@Override
	public Resource merge(Resource detachedInstance) {
		log.debug("merging Resource instance");
		try {
			Resource result = (Resource) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#attachDirty(com.zqrk.model.Resource)
	 */
	@Override
	public void attachDirty(Resource instance) {
		log.debug("attaching dirty Resource instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IResourceDAO#attachClean(com.zqrk.model.Resource)
	 */
	@Override
	public void attachClean(Resource instance) {
		log.debug("attaching clean Resource instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IResourceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IResourceDAO) ctx.getBean("ResourceDAO");
	}
}