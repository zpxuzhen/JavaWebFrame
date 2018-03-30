package com.hsp.utils;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	// 使用线程局部模式(threadLocal变量的作用域是此线程)
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	private HibernateUtil() {
	};

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	//显示关闭sessionFactory
	public static void closeSessionFactory(){
		sessionFactory.close();
	}

	// 获取全新的全新的sesession
	public static Session openSession() {
		return sessionFactory.openSession();
	}

	// 获取和线程关联的session
	public static Session getCurrentSession() {

		Session session = threadLocal.get();
		// 判断是否得到
		if (session == null) {
			session = sessionFactory.openSession();
			// 把session对象设置到 threadLocal,相当于该session已经和线程绑定
			threadLocal.set(session);
		}
		return session;
	}
	
	//统一的修改和删除
	public static boolean update(String hql, String[] parameters){
		boolean res=true;
		
		Transaction transaction = null;
		Session session = null;
		Query query =null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			query = session.createQuery(hql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					query.setString(i, parameters[i]);
				}
			}
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			res=false;
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		
		return res;
	}
	//统一的添加
	public static boolean save(Object object){
		boolean res=true;
		
		Transaction transaction = null;
		Session session = null;
		try {
			session = openSession();
			transaction = session.beginTransaction();
			session.save(object);
			transaction.commit();
		} catch (Exception e) {
			res=false;
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		
		return res;
	}

	// 统一的查询方法     带分页     ( hql形式 from 类 where 条件=? )
	public static List list(String hql, String[] parameters, int pageSize, int pageNow) {

		Session session = null;
		List list = null;
		Query query =null;
		try {
			session = openSession();
			query = session.createQuery(hql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					query.setString(i, parameters[i]);
				}
			}
			query.setFirstResult(pageNow * pageSize);
			query.setMaxResults(pageSize);
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return list;
	}

	// 统一的查询方法
	public static List list(String hql, String[] parameters) {
		Session session = null;
		List list = null;
		Query query = null;
		try {
			session = openSession();
			query = session.createQuery(hql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					query.setString(i, parameters[i]);
				}
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return list;
	}
	// 统一的查询方法   uniqueResult只返回0或1条数据
	public static Object uniqueResult(String hql, String[] parameters) {
		Session session = null;
		Object object = null;
		Query query = null;
		try {
			session = openSession();
			query = session.createQuery(hql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					query.setString(i, parameters[i]);
				}
			}
			object = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return object;
	}

}
