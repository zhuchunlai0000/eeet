package com.zqrk.daoImpl;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.zqrk.dao.IDeptDAO;
import com.zqrk.model.Dept;

/**
 * A data access object (DAO) providing persistence and search support for Dept
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zqrk.model.Dept
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DeptDAO implements IDeptDAO {
	private static final Logger log = LoggerFactory.getLogger(DeptDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IDeptDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see com.zqrk.daoImpl.IDeptDAO#save(com.zqrk.model.Dept)
	 */
	@Override
	public void save(Dept transientInstance) {
		log.debug("saving Dept instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IDeptDAO#delete(com.zqrk.model.Dept)
	 */
	@Override
	public void delete(Dept persistentInstance) {
		log.debug("deleting Dept instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IDeptDAO#findById(java.lang.Integer)
	 */
	@Override
	public Dept findById(java.lang.Integer id) {
		log.debug("getting Dept instance with id: " + id);
		try {
			Dept instance = (Dept) getCurrentSession().get(
					"com.zqrk.model.Dept", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IDeptDAO#findByExample(com.zqrk.model.Dept)
	 */
	@Override
	public List<Dept> findByExample(Dept instance) {
		log.debug("finding Dept instance by example");
		try {
			List<Dept> results = (List<Dept>) getCurrentSession()
					.createCriteria("com.zqrk.model.Dept")
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
	 * @see com.zqrk.daoImpl.IDeptDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Dept instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Dept as model where model."
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
	 * @see com.zqrk.daoImpl.IDeptDAO#findByDeptName(java.lang.Object)
	 */
	@Override
	public List<Dept> findByDeptName(Object deptName) {
		return findByProperty(DEPT_NAME, deptName);
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IDeptDAO#findByDeptNo(java.lang.Object)
	 */
	@Override
	public List<Dept> findByDeptNo(Object deptNo) {
		return findByProperty(DEPT_NO, deptNo);
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IDeptDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Dept instances");
		try {
			String queryString = "from Dept";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IDeptDAO#merge(com.zqrk.model.Dept)
	 */
	@Override
	public Dept merge(Dept detachedInstance) {
		log.debug("merging Dept instance");
		try {
			Dept result = (Dept) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IDeptDAO#attachDirty(com.zqrk.model.Dept)
	 */
	@Override
	public void attachDirty(Dept instance) {
		log.debug("attaching dirty Dept instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IDeptDAO#attachClean(com.zqrk.model.Dept)
	 */
	@Override
	public void attachClean(Dept instance) {
		log.debug("attaching clean Dept instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IDeptDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IDeptDAO) ctx.getBean("DeptDAO");
	}
}