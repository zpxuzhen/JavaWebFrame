package com.hsp.view;

import com.hsp.domain.*;
import com.hsp.utils.*;

public class TestMain {

	public static void main(String[] args) {
		
		test1();
		
	}

	public static void test1() {
		//���ѧ��
		Student s1=new Student();
		s1.setSname("����ϼ");
		s1.setSsex("F");
		s1.setSdept("�����ϵ");
		s1.setSage((short) 22);
		s1.setSaddress("�Ϻ�");
		Student s2=new Student();
		s2.setSname("���»�");
		s2.setSsex("M");
		s2.setSdept("����ϵ");
		s2.setSage((short) 23);
		s2.setSaddress("�Ͼ�");
		Student s3=new Student();
		s3.setSname("����");
		s3.setSsex("M");
		s3.setSdept("��ѧϵ");
		s3.setSage((short) 21);
		s3.setSaddress("ɽ��");
		Student s4=new Student();
		s4.setSname("�ֿ���");
		s4.setSsex("F");
		s4.setSdept("�����ϵ");
		s4.setSage((short) 22);
		s4.setSaddress("����");
		Student s5=new Student();
		s5.setSname("�ܻ���");
		s5.setSsex("M");
		s5.setSdept("����ϵ");
		s5.setSage((short) 24);
		s5.setSaddress("ɽ��");
		Student s6=new Student();
		s6.setSname("����");
		s6.setSsex("M");
		s6.setSdept("��ѧϵ");
		s6.setSage((short) 20);
		s6.setSaddress("����");
		
		//��ӿγ�
		Course c1=new Course();
		c1.setCname("java���");
		c1.setCcredit((short) 6);
		Course c2=new Course();
		c2.setCname("c++�γ�");
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
		
		//���ѡ�μ�¼
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
		
		//���浽���ݿ�
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
