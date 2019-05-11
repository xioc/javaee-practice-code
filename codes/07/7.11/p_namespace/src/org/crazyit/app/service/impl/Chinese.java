package org.crazyit.app.service.impl;

import org.crazyit.app.service.*;
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
	private Axe axe;
	private int age;
	public Chinese(){ }
	// axe的setter方法
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}
	// age的setter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	// 实现Person接口的useAxe()方法
	public void useAxe()
	{
		System.out.println(axe.chop());
		System.out.println("age成员变量的值：" + age);
	}
}