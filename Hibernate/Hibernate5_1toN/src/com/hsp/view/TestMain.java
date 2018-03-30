package com.hsp.view;

import java.util.HashSet;
import java.util.Set;

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
//		test4();
//		test5();
		
	}
	
	//one2many ���  ��Ҫ���ü���
	public static void test5() {
		Department d1=new Department();
		d1.setName("����2");

		Students s1=new Students();
		s1.setName("˳ƽ");
		s1.setDepartment(d1);
		Students s2=new Students();
		s2.setName("С��");
		s2.setDepartment(d1);
		
		Set<Students> students=new HashSet<Students>();
		students.add(s1);
		students.add(s2);
		
		d1.setStudents(students);

		//��Ҫ���ü���cascade="save-update"
		HibernateUtil.save(d1);

	}
	//one2many ��ѯ
	public static void test4() {
		//����: ͨ��һ�����ź�(6)������ȡ�ò��ŵ�����ѧ��?
		Session session=HibernateUtil.getCurrentSession();
		Department d1=(Department) session.get(Department.class, 6);
		//ȡ���ò��ŵ�ѧ��
		Set<Students> students=d1.getStudents();
		for(Students s:students){
			System.out.println(s.getName());
		}
	}
			
	
	//������
	public static void test3() {
		
		Transaction transaction = null;
		Session session = null;
		Students student=null;
		try {
			session=HibernateUtil.getCurrentSession();
			transaction=session.beginTransaction();
			student=(Students) session.get(Students.class, 8);//8��student��id
			//������������Ҫ:��ʾ��ʼ���������(��Department����Ϣ�󶨵�student)
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
		System.out.println("����:"+student.getName());
		//����ȡ���ڲ���(���)��ʱ��ͳ����ˣ���Ҫ���������أ�
		System.out.println("����:"+student.getName()+" ���ڲ���:"+student.getDepartment().getName());
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
