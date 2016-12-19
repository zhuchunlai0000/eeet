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

import com.zqrk.dao.IEmpDAO;
import com.zqrk.model.Emp;

/**
 * A data access object (DAO) providing persistence and search support for Emp
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.zqrk.model.Emp
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class EmpDAO implements IEmpDAO {
	private static final Logger log = LoggerFactory.getLogger(EmpDAO.class);
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#setSessionFactory(org.hibernate.SessionFactory)
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
	 * @see com.zqrk.daoImpl.IEmpDAO#save(com.zqrk.model.Emp)
	 */
	@Override
	public void save(Emp transientInstance) {
		log.debug("saving Emp instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#delete(com.zqrk.model.Emp)
	 */
	@Override
	public void delete(Emp persistentInstance) {
		log.debug("deleting Emp instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#findById(java.lang.Integer)
	 */
	@Override
	public Emp findById(java.lang.Integer id) {
		log.debug("getting Emp instance with id: " + id);
		try {
			Emp instance = (Emp) getCurrentSession().get("com.zqrk.model.Emp",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#findByExample(com.zqrk.model.Emp)
	 */
	@Override
	public List<Emp> findByExample(Emp instance) {
		log.debug("finding Emp instance by example");
		try {
			List<Emp> results = (List<Emp>) getCurrentSession()
					.createCriteria("com.zqrk.model.Emp").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Emp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Emp as model where model."
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
	 * @see com.zqrk.daoImpl.IEmpDAO#findByEmpName(java.lang.Object)
	 */
	@Override
	public List<Emp> findByEmpName(Object empName) {
		return findByProperty(EMP_NAME, empName);
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#findByGender(java.lang.Object)
	 */
	@Override
	public List<Emp> findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#findByTel(java.lang.Object)
	 */
	@Override
	public List<Emp> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#findByAge(java.lang.Object)
	 */
	@Override
	public List<Emp> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Emp instances");
		try {
			String queryString = "from Emp";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#merge(com.zqrk.model.Emp)
	 */
	@Override
	public Emp merge(Emp detachedInstance) {
		log.debug("merging Emp instance");
		try {
			Emp result = (Emp) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#attachDirty(com.zqrk.model.Emp)
	 */
	@Override
	public void attachDirty(Emp instance) {
		log.debug("attaching dirty Emp instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.zqrk.daoImpl.IEmpDAO#attachClean(com.zqrk.model.Emp)
	 */
	@Override
	public void attachClean(Emp instance) {
		log.debug("attaching clean Emp instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IEmpDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IEmpDAO) ctx.getBean("EmpDAO");
	}
}