package cn.w3cschool.test;

import org.hibernate.*;
import org.hibernate.cfg.*;

import cn.w3cschool.domain.User;

public class Test {
	
	// ����ʹ��
	public static void main(String[] args) {
        // 1�����������ļ�
        Configuration configuration = new Configuration().configure();
        // 2������Session����
        SessionFactory factory = configuration.buildSessionFactory();
        // 3������Session����
        Session session = factory.openSession();
        // 4����������(DML������Ҫ�������Transaction)
        Transaction tx = session.beginTransaction();
        Integer userId = (Integer) session.save(new User("����", "666666"));
        System.out.println("UserId:"+userId);
        tx.commit();
        // 5���ر�
        session.close();
	}
}
