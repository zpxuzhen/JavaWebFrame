package com.hsp.utils;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;
	// ʹ���ֲ߳̾�ģʽ(threadLocal�������������Ǵ��߳�)
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	private HibernateUtil() {
	};

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	//��ʾ�ر�sessionFactory
	public static void closeSessionFactory(){
		sessionFactory.close();
	}

	// ��ȡȫ�µ�ȫ�µ�sesession
	public static Session openSession() {
		return sessionFactory.openSession();
	}

	// ��ȡ���̹߳�����session
	public static Session getCurrentSession() {

		Session session = threadLocal.get();
		// �ж��Ƿ�õ�
		if (session == null) {
			session = sessionFactory.openSession();
			// ��session�������õ� threadLocal,�൱�ڸ�session�Ѿ����̰߳�
			threadLocal.set(session);
		}
		return session;
	}
	
	//ͳһ���޸ĺ�ɾ��
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
	//ͳһ�����
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

	// ͳһ�Ĳ�ѯ����     ����ҳ     ( hql��ʽ from �� where ����=? )
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

	// ͳһ�Ĳ�ѯ����
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
	// ͳһ�Ĳ�ѯ����   uniqueResultֻ����0��1������
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
