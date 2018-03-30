package com.hsp.view;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.domain.Department;
import com.hsp.domain.Students;
import com.hsp.utils.HibernateUtil;

public class TestMain {

	public static void main(String[] args) {
		
		test1();//获取sessionFactory
//		test2();
//		test3();
		
	}
	
	//懒加载
	public static void test3() {
		
		Students s1=getStudent();
		System.out.println("名字:"+s1.getName());
		//当获取所在部门(外键)我的时候就出错了（需要禁用懒加载）
		System.out.println("名字:"+s1.getName()+" 所在部门:"+s1.getDepartment().getName());
	}

	private static Students getStudent() {
		Transaction transaction = null;
		Session session = null;
		Students student=null;
		try {
			session=HibernateUtil.getCurrentSession();
			transaction=session.beginTransaction();
			student=(Students) session.get(Students.class, 16);//学生编号16
			//如果禁用懒加载需要：显示初始化代理对象(将Department的信息绑定到student)
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
	
	//添加数据
	public static void test2() {
		//注意：先保存没有外键的表(部门)，然后保存有外键的表(学生)
		Department d1=new Department();
		d1.setName("财务部");
		Department d2=new Department();
		d2.setName("人事部");
		Students s1=new Students();
		s1.setName("宋江");
		s1.setDepartment(d1);
		Students s2=new Students();
		s2.setName("林冲");
		s2.setDepartment(d1);
		Students s3=new Students();
		s3.setName("孙二娘");
		s3.setDepartment(d2);
		HibernateUtil.save(d1);
		HibernateUtil.save(d2);
		HibernateUtil.save(s1);
		HibernateUtil.save(s2);
		HibernateUtil.save(s3);
	}

	public static void test1() {
		//通过获取一个session，让Hibernate框架运行（config-->加载hibernate.cfg.xml）
		HibernateUtil.openSession();
	}

}
