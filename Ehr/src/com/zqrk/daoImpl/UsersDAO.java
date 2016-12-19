package com.zqrk.daoImpl;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.zqrk.dao.IUsersDAO;
import com.zqrk.model.Users;

/**
 * A data access object (DAO) providing persistence and search support for Users
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zqrk.model.Users
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UsersDAO implements IUsersDAO {
	private static final Logger log = LoggerFactory.getLogger(UsersDAO.class);
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.zqrk.daoImpl.IUsersDAO#setSessionFactory(org.hibernate.SessionFactory
	 * )
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zqrk.daoImpl.IUsersDAO#save(com.zqrk.model.Users)
	 */
	@Override
	public void save(Users transientInstance) {
		log.debug("saving Users instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zqrk.daoImpl.IUsersDAO#delete(com.zqrk.model.Users)
	 */
	@Override
	public void delete(Users persistentInstance) {
		log.debug("deleting Users instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zqrk.daoImpl.IUsersDAO#findById(java.lang.String)
	 */
	@Override
	public Users findById(java.lang.String id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) getCurrentSession().get(
					"com.zqrk.model.Users", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zqrk.daoImpl.IUsersDAO#findByExample(com.zqrk.model.Users)
	 */
	@Override
	public List<Users> findByExample(Users instance) {
		log.debug("finding Users instance by example");
		try {
			List<Users> results = (List<Users>) getCurrentSession()
					.createCriteria("com.zqrk.model.Users")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zqrk.daoImpl.IUsersDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Users instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Users as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zqrk.daoImpl.IUsersDAO#findByName(java.lang.Object)
	 */
	@Override
	public List<Users> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zqrk.daoImpl.IUsersDAO#findByPwd(java.lang.Object)
	 */
	@Override
	public List<Users> findByPwd(Object pwd) {
		return findByProperty(PWD, pwd);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zqrk.daoImpl.IUsersDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Users instances");
		try {
			String queryString = "from Users";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zqrk.daoImpl.IUsersDAO#merge(com.zqrk.model.Users)
	 */
	@Override
	public Users merge(Users detachedInstance) {
		log.debug("merging Users instance");
		try {
			Users result = (Users) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zqrk.daoImpl.IUsersDAO#attachDirty(com.zqrk.model.Users)
	 */
	@Override
	public void attachDirty(Users instance) {
		log.debug("attaching dirty Users instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zqrk.daoImpl.IUsersDAO#attachClean(com.zqrk.model.Users)
	 */
	@Override
	public void attachClean(Users instance) {
		log.debug("attaching clean Users instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IUsersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IUsersDAO) ctx.getBean("UsersDAO");
	}

	public List viewByPage(String className, int first, int max, String order,
			String field) {
		// TODO Auto-generated method stub
		String hql = "from " + className;
		if (StringUtils.isNotEmpty(field))
			if (StringUtils.isNotEmpty(order))
				hql += " order by " + field + " " + order;
			else
				hql += " order by " + field + " asc";
		Query query = getCurrentSession().createQuery(hql)
				.setFirstResult(first).setMaxResults(max);
		return query.list();
	}

	@Override
	public List searchByPage(Users user, int first, int max, String order,
			String field) {
		// TODO Auto-generated method stub
		String hql = "from " + user.getClass().getName();
		if (StringUtils.isNotEmpty(user.getName()))
			hql += " where name='" + user.getName() + "'";
		if (StringUtils.isNotEmpty(field))
			if (StringUtils.isNotEmpty(order))
				hql += " order by " + field + " " + order;
			else
				hql += " order by " + field + " asc";

		Query query = getCurrentSession().createQuery(hql)
				.setFirstResult(first).setMaxResults(max);
		return query.list();
	}

}
