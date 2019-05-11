package org.crazyit.app.service.impl;

import org.crazyit.app.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
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
public class Chinese implements Person
{
	private Dog dog;
	@Required
	public void setGunDog(Dog dog)
	{
		this.dog = dog;
	}
	public void test()
	{
		System.out.println("我是一个普通人,养了一条狗："
			+ dog.run());
	}
}