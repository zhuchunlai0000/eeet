package com.zqrk.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqrk.dao.IRoleDAO;
import com.zqrk.dao.IUsersDAO;
import com.zqrk.model.Role;
import com.zqrk.model.Users;
import com.zqrk.util.Pager;
import com.zqrk.util.ShaEncrypt;

@Service
public class UsersService {
	@Autowired
	private IUsersDAO dao;
	@Autowired
	private IRoleDAO rdao;
	public Users login(String name,String pwd){
		Users u=new Users(name,pwd);
		List<Users> list=dao.findByExample(u);
		return list.size()>0?list.get(0):null;
	}
	public List<Users> findAll(){
		return dao.findAll();
	}
	public void save(Users user){
		try {
			user.setPwd(ShaEncrypt.shaEncode(user.getPwd()));
		} catch (Exception e) {
			// TODO Auto-generated catch block sha  md5   cmd5.com
			e.printStackTrace();
		}
		this.dao.save(user);
	}
	public Users findById(String id){
		return dao.findById(id);
	}
	public void delete(String id){
		dao.delete(findById(id));
	}
	public void update(Users user){
		Users u=dao.findById(user.getId());
		String pwd=u.getPwd();
		user.setPwd(pwd);
		dao.merge(user);
	}
	public void deleteCheck(String[] ids){
		if (ids!=null)
			for (String id:ids)
				delete(id);
	}
	public HttpServletRequest viewByPage(HttpServletRequest request){
		int max = 5;//每页显示行数
		int offset = request.getParameter("pager") == null ? 1 : Integer
				.parseInt(request.getParameter("pager"));
		int count=findAll().size();//总记录数
		String pager = Pager.getPagerStr(request.getContextPath() + "/usersview.action",
				max, count, offset, 1);
		request.setAttribute("pager", pager);
		List list = dao.viewByPage("Users",offset * max - max, max,null,null);
		request.setAttribute("list", list);
		return request;
		
	}
	public HttpServletRequest searchByPage(HttpServletRequest request,
			Users user) {
		int max = 5;
		int offset = request.getParameter("pager") == null ? 1 : Integer
				.parseInt(request.getParameter("pager"));
		int count=dao.findByName(user.getName()).size();
		String pager = Pager.getPagerStr(request.getContextPath() + "/userssearch.action",
				max, count, offset, 1);
		request.setAttribute("pager", pager);
		List list = dao.searchByPage(user,offset * max - max, max,null,null);
		request.setAttribute("list", list);
		return request;
	}
	public void bindRole(Users user, String[] rids) {
		Set<Role> roles=new HashSet<>();
		if (rids!=null){
			for (String rid:rids){
				Role role=rdao.findById(rid);
				roles.add(role);
			}
			user.setRoles(roles);
			update(user);
		}
	}
}

















