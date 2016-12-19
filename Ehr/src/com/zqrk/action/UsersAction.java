package com.zqrk.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zqrk.model.Role;
import com.zqrk.model.Users;
import com.zqrk.service.RoleService;
import com.zqrk.service.UsersService;

@Controller@Scope(value="prototype")
public class UsersAction {
	private Users user;
	private String[] ids;
	private String[] rids;
	
	public String[] getRids() {
		return rids;
	}
	public void setRids(String[] rids) {
		this.rids = rids;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Autowired
	private UsersService service;
	@Autowired
	private RoleService rservice;
	public String view(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request=service.viewByPage(request);
		return "view";
	}
	public String search(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		if (user==null)
			user=(Users) session.getAttribute("us");
		session.setAttribute("us", user);
		request=service.searchByPage(request,user);
		return "view";
	}
	public String save(){
		this.service.save(user);
		return view();
	}
	public String preUpdate(){
		user=this.service.findById(user.getId());
		ServletActionContext.getRequest().setAttribute("u", user);
		return "update";
	}
	public String delete(){
		this.service.delete(user.getId());
		return view();
	}
	public String update(){
		this.service.update(user);
		return view();
	}
	public String deleteCheck(){
		this.service.deleteCheck(ids);
		return view();
	}
	public String preBindRole(){
		user=service.findById(user.getId());
		//取出当前用户所具有的角色
		Set<Role> roles=user.getRoles();
		String bindIds="";//111,222
		for (Role r:roles)
			bindIds+=r.getId()+",";
		ServletActionContext.getRequest().setAttribute("bindIds", bindIds);
		List<Role> list=rservice.findAll();
		ServletActionContext.getRequest().setAttribute("roleList", list);
		return "bindRole";
	}
	public String bindRole(){
		user=service.findById(user.getId());
		service.bindRole(user,rids);
		return view();
	}
	
}













