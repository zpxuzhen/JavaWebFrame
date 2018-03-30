package com.hsp.view;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.domain.Department;
import com.hsp.domain.Students;
import com.hsp.utils.HibernateUtil;

public class TestMain {

	public static void main(String[] args) {
		
		test1();//��ȡsessionFactory
//		test2();
//		test3();
		
	}
	
	//������
	public static void test3() {
		
		Students s1=getStudent();
		System.out.println("����:"+s1.getName());
		//����ȡ���ڲ���(���)�ҵ�ʱ��ͳ����ˣ���Ҫ���������أ�
		System.out.println("����:"+s1.getName()+" ���ڲ���:"+s1.getDepartment().getName());
	}

	private static Students getStudent() {
		Transaction transaction = null;
		Session session = null;
		Students student=null;
		try {
			session=HibernateUtil.getCurrentSession();
			transaction=session.beginTransaction();
			student=(Students) session.get(Students.class, 16);//ѧ�����16
			//���������������Ҫ����ʾ��ʼ���������(��Department����Ϣ�󶨵�student)
			Hibernate.initialize(student.getDepartment());
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return student;
	}
	
	//�������
	public static void test2() {
		//ע�⣺�ȱ���û������ı�(����)��Ȼ�󱣴�������ı�(ѧ��)
		Department d1=new Department();
		d1.setName("����");
		Department d2=new Department();
		d2.setName("���²�");
		Students s1=new Students();
		s1.setName("�ν�");
		s1.setDepartment(d1);
		Students s2=new Students();
		s2.setName("�ֳ�");
		s2.setDepartment(d1);
		Students s3=new Students();
		s3.setName("�����");
		s3.setDepartment(d2);
		HibernateUtil.save(d1);
		HibernateUtil.save(d2);
		HibernateUtil.save(s1);
		HibernateUtil.save(s2);
		HibernateUtil.save(s3);
	}

	public static void test1() {
		//ͨ����ȡһ��session����Hibernate������У�config-->����hibernate.cfg.xml��
		HibernateUtil.openSession();
	}

}
