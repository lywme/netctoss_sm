package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.AdminDAO;
import entity.Admin;


public class TestCase {
	private AdminDAO dao;
	@Before
	//@Before���εķ������ڲ��Է�������֮ǰ��ִ��
	public void init()
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("springmvc.xml");
		dao=ac.getBean("adminDAO",AdminDAO.class);
	}
	
	@Test
	public void test1()
	{
		Admin admin=dao.findByCode("lywme");
		System.out.println(admin);
	}
}
