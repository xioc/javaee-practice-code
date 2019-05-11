package org.crazyit.hrsystem.dao.impl;

import java.util.List;

import org.crazyit.common.dao.impl.BaseDaoHibernate5;
import org.crazyit.hrsystem.dao.ApplicationDao;
import org.crazyit.hrsystem.domain.Application;
import org.crazyit.hrsystem.domain.Employee;

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
public class ApplicationDaoHibernate5 extends BaseDaoHibernate5<Application>
	implements ApplicationDao
{
	/**
	 * 根据员工查询未处理的异动申请
	 * @param emp 需要查询的员工
	 * @return 该员工对应的未处理的异动申请
	 */
	public List<Application> findByEmp(Employee emp)
	{
		return find("select a from Application as a where "
			+ "a.attend.employee=?0" , emp);
	}
}
