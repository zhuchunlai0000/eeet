package com.zqrk.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zqrk.service.DeptService;

@Controller@Scope(value="prototype")
public class DeptAction {
	@Autowired
	private DeptService service;
}
