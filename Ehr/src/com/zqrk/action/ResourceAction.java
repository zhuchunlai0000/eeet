package com.zqrk.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zqrk.service.ResourceService;

@Controller@Scope(value="prototype")
public class ResourceAction {
	@Autowired
	private ResourceService service;
}
