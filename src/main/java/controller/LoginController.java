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
		//调用业务层服务
		try
		{
			Admin admin=service.checkLogin(adminCode, pwd);
			//登录成功后，把admin对象绑定到session，用于session验证
			HttpSession session=request.getSession();
			session.setAttribute("admin", admin);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			if(e instanceof ApplicationException)
			{
				//应用异常，应该明确提示用户采取正确的操作
				request.setAttribute("login_failed", e.getMessage());
				return "login";
			}
			
			//系统异常，提示用户稍后重试
			return "error";
		}
		//登录成功
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
