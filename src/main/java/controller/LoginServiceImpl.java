package controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.AdminDAO;
import entity.Admin;
import service.ApplicationException;
import service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Resource(name="adminDAO")
	private AdminDAO dao;
	
	
	public Admin checkLogin(String adminCode, String pwd) {
		Admin admin=null;
		admin=dao.findByCode(adminCode);
		
		if(admin==null)
		{
			//�˺Ų�����
			//�׳�һ��Ӧ���쳣(�û�����������쳣)
			throw new ApplicationException("�˺Ų�����");
		}
		
		if(!admin.getPassword().equals(pwd))
		{
			throw new ApplicationException("�������");
		}
		
		//��¼�ɹ�
		return admin;
	}

}
