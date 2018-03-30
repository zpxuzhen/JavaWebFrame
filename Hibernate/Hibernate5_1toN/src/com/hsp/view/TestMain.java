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
		
		test1();//获取sessionFactory
//		test2();
//		test3();
//		test4();
//		test5();
		
	}
	
	//one2many 添加  需要配置级联
	public static void test5() {
		Department d1=new Department();
		d1.setName("财务部2");

		Students s1=new Students();
		s1.setName("顺平");
		s1.setDepartment(d1);
		Students s2=new Students();
		s2.setName("小明");
		s2.setDepartment(d1);
		
		Set<Students> students=new HashSet<Students>();
		students.add(s1);
		students.add(s2);
		
		d1.setStudents(students);

		//需要配置级联cascade="save-update"
		HibernateUtil.save(d1);

	}
	//one2many 查询
	public static void test4() {
		//需求: 通过一个部门号(6)，来获取该部门的所有学生?
		Session session=HibernateUtil.getCurrentSession();
		Department d1=(Department) session.get(Department.class, 6);
		//取出该部门的学生
		Set<Students> students=d1.getStudents();
		for(Students s:students){
			System.out.println(s.getName());
		}
	}
			
	
	//懒加载
	public static void test3() {
		
		Transaction transaction = null;
		Session session = null;
		Students student=null;
		try {
			session=HibernateUtil.getCurrentSession();
			transaction=session.beginTransaction();
			student=(Students) session.get(Students.class, 8);//8是student的id
			//禁用懒加载需要:显示初始化代理对象(将Department的信息绑定到student)
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
		System.out.println("名字:"+student.getName());
		//当获取所在部门(外键)的时候就出错了（需要禁用懒加载）
		System.out.println("名字:"+student.getName()+" 所在部门:"+student.getDepartment().getName());
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
