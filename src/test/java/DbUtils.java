


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

public class DbUtils {
	private static String driver;
	private static String url;
	private static String userName;
	private static String passWord;
	private static int initSize;
	private static int maxActive;
	private static BasicDataSource ds;
	
	//��ȡ�ļ��е����ݿ����Ӳ���
	static{
		//��ʼ����̬����
		ds=new BasicDataSource();
		//1>����Properties��ȡ�����ļ�
		Properties cfg=new Properties();
		try{
			//2>�������ļ��в�����Ӧ����ֵ
			InputStream in=DbUtils.class.getClassLoader().getResourceAsStream("db.properties");
			cfg.load(in);
			//System.out.println(cfg);
			
			driver=cfg.getProperty("jdbc.driver");
			url=cfg.getProperty("jdbc.url");
			userName=cfg.getProperty("jdbc.userName");
			passWord=cfg.getProperty("jdbc.passWord");
			initSize=Integer.parseInt(cfg.getProperty("initSize"));
			maxActive=Integer.parseInt(cfg.getProperty("maxActive"));
			in.close();
			
			//��ʼ�����ӳ�
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(userName);
			ds.setPassword(passWord);
			ds.setInitialSize(initSize);
			ds.setMaxActive(maxActive);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ��װ�������ݿ����ӵĹ���
	 * �����ݿ�����
	 */
	public static Connection getConnection()
	{
		try{
			//ע������
			//Class.forName(driver);
			//���ӵ����ݿ�
			//getConnection()�������Ҳ��������ӵ����ݿ⣬������ɹ��������쳣
			Connection conn=ds.getConnection();
			return conn;   //�����ĵ����ߣ�Ҫô�õ�һ����ȷ�Ľ����Ҫô�õ�һ���쳣
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);   //���쳣�������߷���һ���쳣
		}
	}
	
	public static void close(Connection conn)
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
			}
		}
	}
	
	//Test DbUtils
	public static void main(String[] args)
	{
		Connection con=DbUtils.getConnection();
		System.out.println(con);
		DbUtils.close(con);
	}
}
