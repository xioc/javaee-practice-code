package org.crazyit.app.service.impl;

import org.crazyit.app.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
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
	private Dog dog;
	@Autowired
	public void setGunDog(Dog dog)
	{
		this.dog = dog;
	}
	public void test()
	{
		System.out.println("����һ����ͨ��,����һ������"
			+ dog.run());
	}
}