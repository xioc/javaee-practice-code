package org.crazyit.app.dao.impl;

import org.crazyit.app.dao.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class BaseDaoImpl<T> implements BaseDao<T>
{
	public void save(T e)
	{
		System.out.println("���򱣴����" + e);
	}
}
