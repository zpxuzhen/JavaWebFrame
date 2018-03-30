package cn.w3cschool.test;

import java.io.*;
import java.util.*;

import org.apache.ibatis.io.*;
import org.apache.ibatis.session.*;

import cn.w3cschool.dao.UserMapper;
import cn.w3cschool.domain.*;

/**
 * Oracle建表 
 * create table user4 (id number(11) PRIMARY KEY, username varchar2(20),
 * password varchar2(20), age number(11) ); 
 * 建序列 
 * create sequence user4_seq start with 1 increment by 1 minvalue 1 nomaxvalue nocycle nocache;
 */
public class Test {

	public static void main(String[] args) throws Exception {
//		insertTest();
//		findUserByID();
//		findAll();
//		deleteUserById();
//		updateUserPassword();
	}

	public static void findUserByID() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession session = factory.openSession();
		// ---------------
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.findUserById(2);
		System.out.println(user);
		// --------------
		session.close();
	}

	public static void findAll() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession session = factory.openSession();
		// ---------------------
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> user = mapper.findUserAll();
		for (User user2 : user) {
			System.out.println(user2);
		}
		// ----------------------
		session.close();
	}

	public static void insertTest() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession session = factory.openSession();
		// ---------------------
		User user = new User();
		user.setUsername("lalala");
		user.setPassword("asdf");
		user.setAge(12);

		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.insertUser(user);
		session.commit();
		// ----------------------
		session.close();
	}

	public static void deleteUserById() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession session = factory.openSession();
		// ---------------------
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.deleteUserById(2);
		session.commit();
		// ----------------------
		session.close();
	}

	public static void updateUserPassword() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		SqlSession session = factory.openSession();
		// ---------------------
		User user = new User();
		user.setId(3);
		user.setPassword("newPassword3");

		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.updateUserPassword(user);
		session.commit();
		// ----------------------
		session.close();
	}
}
