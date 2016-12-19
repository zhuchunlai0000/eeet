package com.zqrk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqrk.dao.IResourceDAO;

@Service
public class ResourceService {
	@Autowired
	private IResourceDAO dao;
}
