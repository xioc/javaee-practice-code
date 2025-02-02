package org.crazyit.app.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;

import java.util.Date;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class RegistAction extends ActionSupport
{
	// 定义4个成员变量封装请求参数
	private String name;
	private String pass;
	private int age;
	private Date birth;

	// name的setter和getter方法
	// 使用注解指定必填、正则表达式两个校验规则
	@RequiredStringValidator(key = "name.requried"
		, message = "")
	@RegexFieldValidator(regex = "\\w{4,25}"
		,key = "name.regex" , message = "")
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// pass的setter和getter方法
	@RequiredStringValidator(key = "pass.requried"
		,message = "")
	@RegexFieldValidator(regex = "\\w{4,25}"
		,key = "pass.regex" ,message = "")
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}

	// age的setter和getter方法
	@IntRangeFieldValidator(message = ""
		, key = "age.range", min = "1"
		, max = "150")
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

	// birth的setter和getter方法
	@DateRangeFieldValidator(message = ""
		, key = "birth.range", min = "1900/01/01"
		, max = "2050/01/21")
	public void setBirth(Date birth)
	{
		this.birth = birth;
	}
	public Date getBirth()
	{
		return this.birth;
	}
}