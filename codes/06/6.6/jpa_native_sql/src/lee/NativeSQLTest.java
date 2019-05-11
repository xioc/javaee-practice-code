package lee;

import javax.persistence.*;

import java.util.*;

import org.crazyit.app.domain.*;
import org.crazyit.app.vo.*;

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
public class NativeSQLTest
{
	final static EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("query_pu");
	public static void main(String[] args)
	{
		NativeSQLTest test = new NativeSQLTest();
//		test.simpleQuery();
//		test.entityQuery();
		test.mappingQuery();
		emf.close();
	}

	public void simpleQuery()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// 传入SQL语句，创建原生SQL查询
		Query query = em.createNativeQuery("select student_id, name "
			+ "from student_inf "
			+ "where student_id > ?");
		// 为SQL中第一个参数设置值。
		List<Object[]> list = query.setParameter(1 , 2)
			// 获取查询到的结果
			.getResultList();
		for (Object[] item : list)
		{
			System.out.println(Arrays.toString(item));
		}
		em.getTransaction().commit();
		em.close();
	}

	public void entityQuery()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// 传入SQL语句，创建原生SQL查询，将结果集映射成Student对象
		Query query = em.createNativeQuery("select *"
			+ " from student_inf"
			+ " where student_id > ?" , Student.class);
		//为SQL中第一个参数设置值。
		List<Student> list = query.setParameter(1 , 2)
			// 获取查询到的结果
			.getResultList();
		for (Student s : list)
		{
			System.out.println(s.getStudentNumber() + "->" +
				s.getName());
		}
		em.getTransaction().commit();
		em.close();
	}

	public void mappingQuery()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// 创建原生SQL查询，传入SQL映射的名字
		Query query = em.createNativeQuery("select s.* , e.*"
			+ " from student_inf s"
			+ " join enrolment_inf e"
			+ " on s.student_id = e.student_id"
			+ " where s.student_id > ?" , "stu_mapping");
		//为SQL中第一个参数设置值。
		List<Object[]> list = query.setParameter(1 , 2)
			// 获取查询到的结果
			.getResultList();
		for (Object[] row : list)
		{
			System.out.println(Arrays.toString(row));
		}
		em.getTransaction().commit();
		em.close();
	}
}
