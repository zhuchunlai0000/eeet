package com.zqrk.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zqrk.service.RoleService;

@Controller@Scope(value="prototype")
public class RoleAction {
	@Autowired
	private RoleService service;
}
