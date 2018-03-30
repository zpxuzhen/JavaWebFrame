package com.hsp.view;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hsp.domain.IdCard;
import com.hsp.domain.Person;
import com.hsp.utils.HibernateUtil;

public class TestMain {

	
	//����������one2one��ϵ  idCard��id���������������---->ָ��Person��id
	public static void main(String[] args) {
		
		test1();
		
	}

	//���һ��Person/idCard
	public static void test1() {
		Person p1=new Person();
		p1.setId(1234);
		p1.setName("˳ƽ");
		
		IdCard idCard1=new IdCard();
		idCard1.setValidateDte(new Date());
		//��ʾidCard����������p1����
		idCard1.setPerson(p1);
		//�ȱ�����
		HibernateUtil.save(p1);
		HibernateUtil.save(idCard1);
	}
}
