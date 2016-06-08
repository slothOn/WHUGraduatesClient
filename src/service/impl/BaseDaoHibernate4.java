package service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import service.BaseDao;

public class BaseDaoHibernate4<T> implements BaseDao<T>{
	private SessionFactory sf;
	
	public void setSessionFactory(SessionFactory sf){
		this.sf = sf;
	}
	
	public SessionFactory getSessionFactory(){
		return sf;
	}
	
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		// TODO Auto-generated method stub
		return (T)getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		// TODO Auto-generated method stub
		return getSessionFactory().getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		// TODO Auto-generated method stub
		getSessionFactory().getCurrentSession().createQuery("delete " + entityClazz.getSimpleName() + 
				" en where en.id=?").setParameter(0, id).executeUpdate();
	}

	public void deleteByOneCol(Class<T> entityClazz, String colname, Serializable colval){
		getSessionFactory().getCurrentSession().createQuery("delete " + entityClazz.getSimpleName() +
				" en where en." + colname + "=?").setParameter(0, colval).executeUpdate();
	}
	
	@Override
	public List<T> findAll(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	@Override
	public long findCount(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		List<?> list = find("select count(*) from " + entityClazz.getSimpleName());
		if(list != null && list.size() == 1){
			return (long)list.get(0);
		}
		return 0;
	}
	//根据HQL语句查询
	public List<T> find(String hql){
		return getSessionFactory().getCurrentSession().createQuery(hql).list();
	}
	//根据带占位符参数的hql查询
	public List<T> find(String hql, Object...params){
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i = 0; i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		return query.list();
	}
	//使用hql语句分页查询
	public List<T> findByPage(String hql, int pageNo, int pageSize){
		return getSessionFactory().getCurrentSession().createQuery(hql)
				.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
	}
	//使用带占位符参数hql语句分页查询
	public List<T> findByPage(String hql, int pageNo, int pageSize, Object...params){
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for(int i = 0; i < params.length; i++){
			query.setParameter(i, params[i]);
		}
		query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize);
		return query.list();
	}
	
	public T findById(String id, Class<?> clazz){
		return (T) getSessionFactory().getCurrentSession().get(clazz, id);
	}
}
