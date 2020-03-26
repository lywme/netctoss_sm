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
			//账号不存在
			//抛出一个应用异常(用户操作引起的异常)
			throw new ApplicationException("账号不存在");
		}
		
		if(!admin.getPassword().equals(pwd))
		{
			throw new ApplicationException("密码错误");
		}
		
		//登录成功
		return admin;
	}

}
