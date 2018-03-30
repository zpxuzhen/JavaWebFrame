package com.transaction.t1;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.transaction.*;

public class MainApp {

	/**
	 * Spring �������
	 * ���ʽ vs. ����ʽ
		Spring ֧���������͵��������:
		���ʽ������� :����ζ�����ڱ�̵İ������й�������������㼫��������,��ȴ����ά����
		����ʽ������� :����ζ�����ҵ������з���������������ʹ��ע�ͻ� XML ��������������
		����ʽ�������ȱ��ʽ����������ȡ,������������ʽ����������,����������ͨ�������������
		����Ϊһ�ֺ��й�ע��,����ʽ����������ʹ�� AOP ��������ģ�黯��
		Spring ֧��ʹ�� Spring AOP ��ܵ�����ʽ�������
	 */
	/**
	 * Oracle����
		CREATE TABLE Student(
		ID   NUMBER(11) PRIMARY KEY,
		NAME VARCHAR2(20) NOT NULL,
		AGE  NUMBER(11) NOT NULL
		);
		CREATE TABLE Marks(
		SID   NUMBER(11) PRIMARY KEY References Student(id),
		MARKS NUMBER(11) NOT NULL,
		YEAR  NUMBER(11) NOT NULL
		);
	 */
	public static void main(String[] args) {
		/*���ʽ*/
		ApplicationContext context = new ClassPathXmlApplicationContext("TransactionBeans1.xml");

		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context
				.getBean("studentJDBCTemplate");
		System.out.println("------Records creation--------");
		studentJDBCTemplate.create(1, "Zara", 11, 99, 2010);
		studentJDBCTemplate.create(2, "Nuha", 20, 97, 2010);
		studentJDBCTemplate.create(3, "Ayan", 25, 100, 2011);
		System.out.println("------Listing all the records--------");
		List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
		for (StudentMarks record : studentMarks) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.print(", Marks : " + record.getMarks());
			System.out.print(", Year : " + record.getYear());
			System.out.println(", Age : " + record.getAge());
		}
	}
}
