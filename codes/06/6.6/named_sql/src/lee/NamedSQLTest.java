package lee;

import org.hibernate.*;
import org.hibernate.transform.*;

import java.util.*;

import org.crazyit.app.domain.*;

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
public class NamedSQLTest
{
	public static void main(String[] args)
	{
		NamedSQLTest test = new NamedSQLTest();
//		test.simpleQuery();
//		test.query();
		test.callProcedure();
		HibernateUtil.sessionFactory.close();
	}

	// 执行简单的命名SQL查询
	private void simpleQuery()
	{
		// 打开Session和事务
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 调用命名查询，直接返回结果
		List<Student> list = session.getNamedQuery("simpleQuery")
			.getResultList();
		tx.commit();
		HibernateUtil.closeSession();
		// 遍历结果集
		for(Student s : list)
		{
			// 每个集合元素是Student对象
			System.out.println(s.getName() + "\t");  // ①
		}
	}

	// 执行命名SQL查询
	private void query()
	{
		// 打开Session和事务
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 调用命名查询，直接返回结果
		List<Object[]> list = session.getNamedQuery("queryTest")
			.setParameter("targetYear" , 2005)
			.getResultList();
		tx.commit();
		HibernateUtil.closeSession();
		// 遍历结果集
		for(Object[] objs : list)
		{
			// 每个集合元素是Student、Enrolment
			// 和stuName三个元素的数组
			Student s = (Student)objs[0];
			Enrolment e = (Enrolment)objs[1];
			Course c = (Course)objs[2];
			String stuName = (String)objs[3];
			System.out.println(s.getName() + "\t"
				+ e.getYear() + "\t" + e.getSemester()
				+ "\t=" + e.getCourse().getName() + "=\t" + stuName);
		}
	}

	// 调用存储过程
	private void callProcedure()
	{
		// 打开Session和事务
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		// 调用命名查询，直接返回结果
		List<Student> list = session.getNamedQuery("callProcedure")
			.getResultList();
		tx.commit();
		HibernateUtil.closeSession();
		// 遍历结果集
		for(Student s : list)
		{
			// 每个集合元素是Student对象
			System.out.println(s.getName());
		}
	}
}
