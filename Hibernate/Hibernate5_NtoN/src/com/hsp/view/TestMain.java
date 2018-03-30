package com.hsp.view;

import com.hsp.domain.*;
import com.hsp.utils.*;

public class TestMain {

	public static void main(String[] args) {
		
		test1();
		
	}

	public static void test1() {
		//添加学生
		Student s1=new Student();
		s1.setSname("林青霞");
		s1.setSsex("F");
		s1.setSdept("计算机系");
		s1.setSage((short) 22);
		s1.setSaddress("上海");
		Student s2=new Student();
		s2.setSname("刘德华");
		s2.setSsex("M");
		s2.setSdept("外语系");
		s2.setSage((short) 23);
		s2.setSaddress("南京");
		Student s3=new Student();
		s3.setSname("成龙");
		s3.setSsex("M");
		s3.setSdept("化学系");
		s3.setSage((short) 21);
		s3.setSaddress("山东");
		Student s4=new Student();
		s4.setSname("林可欣");
		s4.setSsex("F");
		s4.setSdept("计算机系");
		s4.setSage((short) 22);
		s4.setSaddress("北京");
		Student s5=new Student();
		s5.setSname("周华健");
		s5.setSsex("M");
		s5.setSdept("生物系");
		s5.setSage((short) 24);
		s5.setSaddress("山东");
		Student s6=new Student();
		s6.setSname("周润发");
		s6.setSsex("M");
		s6.setSdept("数学系");
		s6.setSage((short) 20);
		s6.setSaddress("湖北");
		
		//添加课程
		Course c1=new Course();
		c1.setCname("java编程");
		c1.setCcredit((short) 6);
		Course c2=new Course();
		c2.setCname("c++课程");
		c2.setCcredit((short) 4);
		Course c3=new Course();
		c3.setCname("oracle");
		c3.setCcredit((short) 3);
		Course c4=new Course();
		c4.setCname("javaEE");
		c4.setCcredit((short) 100);
		Course c5=new Course();
		c5.setCname("linux");
		c5.setCcredit((short) 1);
		
		//添加选课记录
		Studcourse sc1=new Studcourse();
		sc1.setStudent(s1);
		sc1.setCourse(c1);
		sc1.setGrade(90);
		Studcourse sc2=new Studcourse();
		sc2.setStudent(s2);
		sc2.setCourse(c2);
		sc2.setGrade(19);
		Studcourse sc3=new Studcourse();
		sc3.setStudent(s3);
		sc3.setCourse(c3);
		sc3.setGrade(45);
		Studcourse sc4=new Studcourse();
		sc4.setStudent(s4);
		sc4.setCourse(c4);
		sc4.setGrade(99);
		Studcourse sc5=new Studcourse();
		sc5.setStudent(s5);
		sc5.setCourse(c5);
		sc5.setGrade(39);
		
		//保存到数据库
		HibernateUtil.save(s1);
		HibernateUtil.save(s2);
		HibernateUtil.save(s3);
		HibernateUtil.save(s4);
		HibernateUtil.save(s5);
		HibernateUtil.save(s6);

		HibernateUtil.save(c1);
		HibernateUtil.save(c2);
		HibernateUtil.save(c3);
		HibernateUtil.save(c4);
		HibernateUtil.save(c5);

		HibernateUtil.save(sc1);
		HibernateUtil.save(sc2);
		HibernateUtil.save(sc3);
		HibernateUtil.save(sc4);
		HibernateUtil.save(sc5);
	}
	
}
