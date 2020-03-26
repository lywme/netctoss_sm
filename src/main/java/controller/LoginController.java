package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Admin;
import service.ApplicationException;
import service.LoginService;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService service;
	
	@RequestMapping("/toLogin.do")
	public String toLogin()
	{
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) throws Exception
	{

		String adminCode=request.getParameter("adminCode");
		String pwd=request.getParameter("pwd");
		System.out.println("username="+adminCode);
		System.out.println("pwd="+pwd);
		//����ҵ������
		try
		{
			Admin admin=service.checkLogin(adminCode, pwd);
			//��¼�ɹ��󣬰�admin����󶨵�session������session��֤
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			if(e instanceof ApplicationException)
			{
				//Ӧ���쳣��Ӧ����ȷ��ʾ�û���ȡ��ȷ�Ĳ���
				request.setAttribute("login_failed", e.getMessage());
				return "login";
			}
			
			//ϵͳ�쳣����ʾ�û��Ժ�����
			return "error";
		}
		//��¼�ɹ�
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex()
	{
		return "index";
	}
	
	@ExceptionHandler
	public String exceptionHandle(Exception e)
	{
		return "error";
	}
}
