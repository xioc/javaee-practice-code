package org.crazyit.app.service.impl;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import javax.annotation.*;

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
@Component
public class Chinese implements Person
{
	@Value("#{T(Math).PI}")
	private String name;
	private Axe axe;
	// axe的setter方法
	@Resource(name="stoneAxe")
	public void setAxe(Axe axe)
	{
		this.axe = axe;
	}
	// 实现Person接口的useAxe()方法
	public void useAxe()
	{
		System.out.println(name + "正在砍柴");
		// 调用axe的chop()方法，
		// 表明Person对象依赖于axe对象
		System.out.println(axe.chop());
	}
}