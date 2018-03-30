package cn.w3cschool.test;

import org.hibernate.*;
import org.hibernate.cfg.*;

import cn.w3cschool.domain.User;

public class Test {
	
	// 基本使用
	public static void main(String[] args) {
        // 1、加载配置文件
        Configuration configuration = new Configuration().configure();
        // 2、创建Session工厂
        SessionFactory factory = configuration.buildSessionFactory();
        // 3、创建Session对象
        Session session = factory.openSession();
        // 4、操作数据(DML操作需要事务管理Transaction)
        Transaction tx = session.beginTransaction();
        Integer userId = (Integer) session.save(new User("测试", "666666"));
        System.out.println("UserId:"+userId);
        tx.commit();
        // 5、关闭
        session.close();
	}
}
