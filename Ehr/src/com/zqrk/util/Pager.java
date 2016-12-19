package com.zqrk.util;

public class Pager {
	
	private String url;
	private int size;
	private int rows;
	private int cpage;
	private int pagers;
	private int nums;
	
	/**
	 * 构造方法
	 * @param url 链接
	 * @param size 每页显示数量
	 * @param cpage	当前页数
	 * @param rows 总数据行数
	 */
	private Pager(String url,int size,int rows,int cpage,int nums) {
		this.url = url.indexOf("?")>-1?url+"&pager=":url+"?pager=";
		this.size = size;
		this.rows = rows;
		this.pagers = rows%size>0?rows/size+1:rows/size;
		this.cpage = cpage<1?1:cpage>this.pagers?this.pagers:cpage;
		this.nums = nums<5?5:nums;
	}
	
	
	/**
	 * 获得分页字符串
	 * @param url 链接
	 * @param size 每页显示数量
	 * @param cpage	当前页数
	 * @param rows 总数据行数
	 * @return 分页字符串
	 */
	public static String getPagerStr(String url,int size,int rows,int cpage,int nums) {
		StringBuffer page=new StringBuffer();
		Pager pager=new Pager(url,size,rows,cpage,nums);
		page.append("<table border=\"0\" align='center' cellspacing=\"2\" cellpadding=\"0\"><tr>");
		//page.append("<td><div\">&nbsp;&nbsp;&nbsp;<a href=\""+pager.url+1+"\">首页</a>&nbsp;&nbsp;</div></td>");
		page.append("<td valign='middle'><a href=\""+pager.url+pager.getPrivior()+"\">上一页</a>&nbsp;</td>");
		
		for(int i= pager.getStart(); i<pager.getEnd()+1; i++) {
			if(i==pager.cpage)
				page.append("<td valign='middle'><span style='border:1px solid #cdcdcd;padding:0px 2px'>"+i+"</span>&nbsp;</td>");
			else
				page.append("<td valign='middle'><a href=\""+pager.url+i+"\" style='border:1px solid #cdcdcd;padding:0px 2px'>"+i+"</a>&nbsp;</td>");
		}
		
		page.append("<td valign='middle'><a href=\""+pager.url+pager.getNext()+"\">下一页</a>&nbsp;&nbsp;</td>");
		//page.append("<td><div\"><a href=\""+pager.url+pager.pagers+"\">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;</div></td>");
		/*page.append("<td><select onchange=\"window.location='"+pager.url+"'+this.value;\" style='border:1px solid #eeeeee'>");
		for(int i=1; i<pager.pagers+1; i++) {
			if(i==cpage)
				page.append("<option selected=selected value=\""+i+"\">"+i+"</option> ");
			else
				page.append("<option value=\""+i+"\">"+i+"</option> ");
		}
		page.append("</select>&nbsp;&nbsp;</td>");*/
		page.append("<td><div class=\"STYLE1\"\">当前页数/总页数："+pager.cpage+"/"+pager.pagers+"&nbsp;&nbsp;</div></td>");
		page.append("<td><div class=\"STYLE1\"\">每页"+pager.size+"条数据 &nbsp;&nbsp;共"+pager.rows+"条数据</div></td>");
		page.append("</tr></table>");
		return page.toString();
	}
	public static String getPagerStrsubmit(String url,int size,int rows,int cpage,int nums) {
		StringBuffer page=new StringBuffer();
		Pager pager=new Pager(url,size,rows,cpage,nums);
		page.append("<form method='post' id='ff' action='"+url+"'><table border=\"0\" align='center' cellspacing=\"2\" cellpadding=\"0\"><tr>");
		//page.append("<td><div\">&nbsp;&nbsp;&nbsp;<a href=\""+pager.url+1+"\">首页</a>&nbsp;&nbsp;</div></td>");
		//<a href="#">${pager }<img src="images/img/previous.jpg" style="vertical-align:middle;"></a>
		page.append("<td valign='middle'><a href=\"javaScript:document.getElementById('ff').action='"+pager.url+pager.getPrivior()+"';document.getElementById('ff').submit();\">上一页</a>&nbsp;</td>");
		
		for(int i= pager.getStart(); i<pager.getEnd()+1; i++) {
			if(i==pager.cpage)
				page.append("<td valign='middle'><span style='border:1px solid #cdcdcd;padding:0px 2px'>"+i+"</span>&nbsp;</td>");
			else
				page.append("<td valign='middle'><a href=\""+pager.url+i+"\" style='border:1px solid #cdcdcd;padding:0px 2px'>"+i+"</a>&nbsp;</td>");
		}
		
		page.append("<td valign='middle'><a href=\"javaScript:document.getElementById('ff').action='"+pager.url+pager.getNext()+"';document.getElementById('ff').submit();\">下一页</a>&nbsp;&nbsp;</td>");
		//page.append("<td><div\"><a href=\""+pager.url+pager.pagers+"\">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;</div></td>");
		/*page.append("<td><select onchange=\"window.location='"+pager.url+"'+this.value;\" style='border:1px solid #eeeeee'>");
		for(int i=1; i<pager.pagers+1; i++) {
			if(i==cpage)
				page.append("<option selected=selected value=\""+i+"\">"+i+"</option> ");
			else
				page.append("<option value=\""+i+"\">"+i+"</option> ");
		}
		page.append("</select>&nbsp;&nbsp;</td>");*/
		//page.append("<td><div class=\"STYLE1\"\">当前页数/总页数："+pager.cpage+"/"+pager.pagers+"&nbsp;&nbsp;</div></td>");
		//page.append("<td><div class=\"STYLE1\"\">每页"+pager.size+"条数据 &nbsp;&nbsp;共"+pager.rows+"条数据</div></td>");
		page.append("</tr></table>");
		page.append("</form>");
		return page.toString();
	}
	/**
	 * 本页开始数字
	 * @return 数字
	 */
	private int getStart() {
		return this.cpage%this.nums>0?this.cpage/this.nums*this.nums+1:(this.cpage-1)/this.nums*this.nums+1;
	}
	
	/**
	 * 本页结束数字
	 * @return 数字
	 */
	private int getEnd() {
		int temp = (this.cpage/this.nums+1)*this.nums;
		return this.cpage%this.nums>0?temp>this.pagers?this.pagers:temp:this.cpage;
	}
	/**
	 * 上一页
	 * @return 上一页页码
	 */
	private int getPrivior() {
		return cpage>1?cpage-1:1;
	}
	/**
	 * 下一页
	 * @return 下一页页码
	 */
	private int getNext() {
		return cpage<this.pagers?cpage+1:this.pagers;
	}
	
	public static void main(String[] args) {
		System.out.println(Pager.getPagerStr("/aaa/aaa/",10,303,1,10));
	}
	/**
	 * 前台分页
	 */
	/**
	 * 获得分页字符串
	 * @param url 链接
	 * @param size 每页显示数量
	 * @param cpage	当前页数
	 * @param rows 总数据行数
	 * @return 分页字符串
	 */
	public static String getPagerStr(String url,int size,int rows,int cpage,int nums,boolean isfore) {
		StringBuffer page=new StringBuffer();
		Pager pager=new Pager(url,size,rows,cpage,nums);
		page.append("<div class=\"grace\">");
		page.append("<a href=\""+pager.url+1+"\">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		page.append("<a href=\""+pager.url+pager.getPrivior()+"\">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		
		/*for(int i= pager.getStart(); i<pager.getEnd()+1; i++) {
			//if(i==pager.cpage)
			//	page.append(i);
			//else
				page.append("<a href=\""+pager.url+i+"\">"+i+"</a>");
		}*/
		
		page.append("<a href=\""+pager.url+pager.getNext()+"\">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		page.append("<a href=\""+pager.url+pager.pagers+"\">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		/*page.append("<select class=\"fenye_select\" onchange=\"window.location='"+pager.url+"'+this.value;\">");
		for(int i=1; i<pager.pagers+1; i++) {
			if(i==cpage)
				page.append("<option selected=selected value=\""+i+"\">"+i+"</option> ");
			else
				page.append("<option value=\""+i+"\">"+i+"</option> ");
		}
		page.append("</select>");*/
		page.append("&nbsp;&nbsp;&nbsp;&nbsp;当前页数/总页数："+pager.cpage+"/"+pager.pagers+"&nbsp;&nbsp;");
		page.append("&nbsp;&nbsp;每页"+pager.size+"条数据 &nbsp;&nbsp;共"+pager.rows+"条数据");
		page.append("</div>");
		return page.toString();
	}
}
