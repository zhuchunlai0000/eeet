package com.zqrk.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller@Scope(value="prototype")
public class LogoutAction {
	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute("users");
		session.invalidate();
		return "login";
	}
}
