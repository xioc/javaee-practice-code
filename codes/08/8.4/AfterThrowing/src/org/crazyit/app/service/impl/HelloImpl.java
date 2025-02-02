package org.crazyit.app.service.impl;

import org.springframework.stereotype.Component;

import org.crazyit.app.service.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@Component("hello")
public class HelloImpl implements Hello
{
	// 定义一个deleteUser方法，模拟应用中删除用户的方法
	public void deleteUser(Integer id)
	{
		if (id < 0)
		{
			throw new IllegalArgumentException("被删除用户的id不能小于0：" + id);
		}
		System.out.println("执行Hello组件的deleteUser删除用户：" + id);
	}
	// 定义一个addUser()方法，模拟应用中的添加用户的方法
	public int addUser(String name , String pass)
	{
		System.out.println("执行Hello组件的addUser添加用户：" + name);
		return 20;
	}
}
