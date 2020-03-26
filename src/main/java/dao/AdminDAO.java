package dao;

import entity.Admin;

public interface AdminDAO {
	public Admin findByCode(String adminCode);
}


