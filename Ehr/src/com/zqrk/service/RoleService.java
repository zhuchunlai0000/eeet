package com.zqrk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqrk.dao.IRoleDAO;
import com.zqrk.model.Role;

@Service
public class RoleService {
	@Autowired
	private IRoleDAO dao;
	public List<Role> findAll(){
		return dao.findAll();
	}
}
