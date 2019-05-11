package lee;

import org.hibernate.Transaction;
import org.hibernate.Session;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class HqlQuery
{
	public static void main(String[] args)
		throws Exception
	{
		HqlQuery mgr = new HqlQuery();
		// 调用查询方法
		mgr.findPersons();
		// 调用第二个查询方法
		mgr.findPersonsByHappenDate();
		mgr.findPersonsFetchMyEvent();
	}

	//c第一个查询方法
	private void findPersons()
	{
		// 获得Hibernate Session
		Session sess = HibernateUtil.currentSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 以HQL语句创建Query对象,HQL语句使用隐式连接
		List<Person> pl = sess.createQuery("from Person p where p.myEvent.title > :title"
			, Person.class)
			// 执行setString()方法为HQL语句的参数赋值
			.setParameter("title", " ")
			//Query调用list()方法访问查询的全部实例
			.getResultList();
		// 遍历查询的全部结果
		for (Person p : pl)
		{
			System.out.println(p.getName());
		}
		// 提交事务
		tx.commit();
		HibernateUtil.closeSession();
	}
	// 第二个查询方法
	private void findPersonsByHappenDate()throws Exception
	{
		// 获得Hibernate Session对象
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		System.out.println("====开始通过日期查找人====");
		// 以HQL语句创建Query对象,HQL语句使用显式连接
		// 因为没有使用fetch关键字，所以返回List集合元素是被查询实体
		List<Person> pl = sess.createQuery("select p from Person p left join "
			+ "p.myEvent event where event.happenDate < :endDate", Person.class)
			.setParameter("endDate",new Date())
			.getResultList();
		// 遍历结果集
		for (Person p : pl)
		{
			System.out.println(p.getName());
			// 因为执行HQL时没有使用fetch，
			// 所以只能在Session没有关闭时访问Person关联实体的属性
			System.out.println(p.getMyEvent().getTitle());
		}
		tx.commit();
		HibernateUtil.closeSession();
	}

	// 第三个查询方法，测试fetch关键字
	private void findPersonsFetchMyEvent()throws Exception
	{
		// 获得Hibernate Session对象
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		System.out.println("====测试fetch查询====");
		// 以HQL语句创建Query对象,HQL语句使用显式连接
		// 因为使用了fetch关键字，所以返回结果中已有包含关联实体
		List<Person> pl = sess.createQuery("from Person p left join fetch "
			+ "p.myEvent event where event.happenDate < :endDate", Person.class)
			.setParameter("endDate",new Date())
			.getResultList();
		tx.commit();
		HibernateUtil.closeSession();
		// 遍历结果集
		for (Person p : pl)
		{
			System.out.println(p.getName());
			// 因为HQL语句中使用了fecth关键字
			// 所以可以在Session关闭后访问Person关联实体的属性
			System.out.println(p.getMyEvent().getTitle());
		}
	}
}