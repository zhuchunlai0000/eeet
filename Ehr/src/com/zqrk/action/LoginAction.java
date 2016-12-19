package com.zqrk.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zqrk.model.Users;
import com.zqrk.service.UsersService;

@Controller@Scope(value="prototype")
public class LoginAction {
	private String name;
	private String pwd;
	private String rand;
	@Autowired
	private UsersService service;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRand() {
		return rand;
	}
	public void setRand(String rand) {
		this.rand = rand;
	}
	
	public String execute() throws IOException{
		
		//从session中提取验证码和用户录入的比对
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		String code=(String) session.getAttribute("rand");
		PrintWriter out=response.getWriter();
		if (!StringUtils.equals(code, rand)){
			out.print("{\"msg\":\"codeError\"}");
			return null;
		}
		Users u=service.login(name, pwd);
		if (u==null){
			out.print("{\"msg\":\"fail\"}");
		}else{
			session.setAttribute("users", u);
			out.print("{\"msg\":\"success\"}");
		}
		return null;
		
	}
}














