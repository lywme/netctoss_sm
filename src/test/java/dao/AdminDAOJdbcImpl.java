/*
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import entity.Admin;

@Repository("adminDAOJBC")
public class AdminDAOJdbcImpl implements AdminDAO {

	//����ע�����ӳ�
		@Resource(name="ds")
		private DataSource ds;
		
		@Override
		public Admin findByAdminCode(String adminCode) {
			Connection conn=null;
			Admin admin=null;
			try
			{
				conn=ds.getConnection();
				String sql="select * from admin_info where admin_code=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, adminCode);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next())
				{
					admin=new Admin();
					admin.setAdminId(rs.getInt(1));
					admin.setAdminCode(rs.getString(2));
					admin.setPassword(rs.getString(3));
					admin.setName(rs.getString(4));
					admin.setTelephone(rs.getString(5));
					admin.setEmail(rs.getString(6));
					admin.setEnrolldate(rs.getTimestamp(7));
				}
			}
			catch(Exception e)
			{
				//����־(�����ֳ�)
				e.printStackTrace();
				throw new RuntimeException("��ѯ�û�����");
			}
			finally
			{
				if(conn!=null)
				{
					try
					{
						conn.close();
					}
					catch(Exception e)
					{
						e.printStackTrace();
						throw new RuntimeException("�ر������쳣");
					}
				}
			}
			return admin;
		}
}
*/