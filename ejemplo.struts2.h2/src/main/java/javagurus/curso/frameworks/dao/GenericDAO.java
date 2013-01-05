package javagurus.curso.frameworks.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javagurus.curso.frameworks.util.HibernateUtil;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GenericDAO<T, ID extends Serializable> extends HibernateDaoSupport {
		private Class<T> clasePersistente;
		
		public GenericDAO () {
			clasePersistente = (Class<T>)  ((ParameterizedType) getClass()
								.getGenericSuperclass()).
								getActualTypeArguments()[0];
			// TODO: Quitar cuando se ocupe spring...
			this.setSessionFactory(HibernateUtil.getSessionFactory());
		}
		
		public void save(T entidad) throws HibernateException {
			getHibernateTemplate().save(entidad);
		}
		
		
		public void update(T entidad) throws HibernateException {
			getHibernateTemplate().update(entidad);
		}
		
		public void delete(T entidad) throws HibernateException {
			getHibernateTemplate().delete(entidad);
		}
		
		public T get(ID id) throws HibernateException {
			return (T) getHibernateTemplate().get(clasePersistente, id);
		}
}
