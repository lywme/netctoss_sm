/*
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Admin;

@Repository("adminDAOS")
public class AdminDAOSpringJdbcImpl implements AdminDAO{
	//“¿¿µ◊¢»Î¡¨Ω”≥ÿ
	@Resource(name="jt")
	private JdbcTemplate template;

	@Override
	public Admin findByAdminCode(String adminCode) {
		Admin admin=null;
		String sql="select * from admin_info where admin_code=?";
		Object[] args=new Object[]{adminCode};
		List<Admin> admins=template.query(sql,args,new AdminRowMapper());
		if(admins!=null && admins.size()>0)
			admin=admins.get(0);
		return admin;
	}
	
	class AdminRowMapper implements RowMapper<Admin>
	{

		@Override
		public Admin mapRow(ResultSet rs, int index) throws SQLException {
			Admin admin=new Admin();
			admin.setAdminId(rs.getInt("id"));
			admin.setAdminCode(rs.getString("admin_code"));
			admin.setPassword(rs.getString("password"));
			admin.setName(rs.getString("name"));
			admin.setTelephone(rs.getString("telephone"));
			admin.setEmail(rs.getString("email"));
			admin.setEnrolldate(rs.getTimestamp("enrolldate"));
			return admin;
		}
		
	}

}
*/