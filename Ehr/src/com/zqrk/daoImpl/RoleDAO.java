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

import com.zqrk.dao.IRoleDAO;
import com.zqrk.model.Role;

/**
 * A data access object (DAO) providing persistence and search support for Role
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zqrk.model.Role
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class RoleDAO implements IRoleDAO {
	private static final Logger log = LoggerFactory.getLogger(RoleDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IRoleDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see com.zqrk.daoImpl.IRoleDAO#save(com.zqrk.model.Role)
	 */
	@Override
	public void save(Role transientInstance) {
		log.debug("saving Role instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IRoleDAO#delete(com.zqrk.model.Role)
	 */
	@Override
	public void delete(Role persistentInstance) {
		log.debug("deleting Role instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IRoleDAO#findById(java.lang.String)
	 */
	@Override
	public Role findById(java.lang.String id) {
		log.debug("getting Role instance with id: " + id);
		try {
			Role instance = (Role) getCurrentSession().get(
					"com.zqrk.model.Role", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IRoleDAO#findByExample(com.zqrk.model.Role)
	 */
	@Override
	public List<Role> findByExample(Role instance) {
		log.debug("finding Role instance by example");
		try {
			List<Role> results = (List<Role>) getCurrentSession()
					.createCriteria("com.zqrk.model.Role")
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
	 * @see com.zqrk.daoImpl.IRoleDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Role instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Role as model where model."
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
	 * @see com.zqrk.daoImpl.IRoleDAO#findByName(java.lang.Object)
	 */
	@Override
	public List<Role> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IRoleDAO#findByDescr(java.lang.Object)
	 */
	@Override
	public List<Role> findByDescr(Object descr) {
		return findByProperty(DESCR, descr);
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IRoleDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Role instances");
		try {
			String queryString = "from Role";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IRoleDAO#merge(com.zqrk.model.Role)
	 */
	@Override
	public Role merge(Role detachedInstance) {
		log.debug("merging Role instance");
		try {
			Role result = (Role) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IRoleDAO#attachDirty(com.zqrk.model.Role)
	 */
	@Override
	public void attachDirty(Role instance) {
		log.debug("attaching dirty Role instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IRoleDAO#attachClean(com.zqrk.model.Role)
	 */
	@Override
	public void attachClean(Role instance) {
		log.debug("attaching clean Role instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IRoleDAO) ctx.getBean("RoleDAO");
	}
}