package service;

import entity.Admin;

public interface LoginService {
	public Admin checkLogin(String adminCode,String pwd);
}
