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

	
	//基于外键的one2one关系    需要配置unique="true" 确保外键唯一
	public static void main(String[] args) {
		
		test1();
		
	}

	//添加一组Person/idCard
	public static void test1() {
		Person p1=new Person();
		p1.setId(1234);
		p1.setName("顺平");
		
		IdCard idCard1=new IdCard();
		idCard1.setId(372330);
		idCard1.setValidateDte(new Date());
		//表示idCard对象是属于p1对象
		idCard1.setPerson(p1);
		//先保存人
		HibernateUtil.save(p1);
		HibernateUtil.save(idCard1);
	}
}
