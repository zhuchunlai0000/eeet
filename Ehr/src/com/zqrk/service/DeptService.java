package com.zqrk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqrk.dao.IDeptDAO;

@Service
public class DeptService {
	@Autowired
	private IDeptDAO dao;
}
