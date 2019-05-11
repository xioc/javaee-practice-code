package lee;

import org.crazyit.app.domain.*;
import javax.persistence.*;
import javax.persistence.criteria.*;
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
public class GroupByTest
{
	final static EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("query_pu");
	public static void main(String[] args)
	{
		GroupByTest gbt = new GroupByTest();
		gbt.query();
		gbt.queryAndOrder();
		emf.close();
	}

	private void query()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// 创建CriteriaQuery，类型参数代表该条件查询返回结果集的元素类型
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		// 指定要查询的根实体类
		Root<Enrolment> root = criteria.from(Enrolment.class);
		// 执行关联查询，Enrolment.student是@ManyToOne关联
		Join<Enrolment, Student> stuJoin = root.join(Enrolment_.student);
		// 设置根据Enrolment的course属性分组
		criteria.groupBy(root.get(Enrolment_.course)); // ①
		// 设置select出来数据
		criteria.multiselect(builder.count(root),
			builder.greatest(stuJoin.get(Student_.name)),
			root.get(Enrolment_.course));
		List<Object[]> list = em.createQuery(criteria)
			.getResultList();
		for(Object[] objs : list)
		{
			Course c = (Course)objs[2];
			System.out.println("=====<" + c.getName()
				+ ">课程的选课统计=====");
			System.out.println("选课人数:" + objs[0]);
			System.out.println("选课的姓名最大的学生为：" + objs[1]);
		}
		em.getTransaction().commit();
		em.close();
	}

	private void queryAndOrder()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// 创建CriteriaQuery，类型参数代表该条件查询返回结果集的元素类型
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		// 指定要查询的根实体类
		Root<Enrolment> root = criteria.from(Enrolment.class);
		// 设置根据Enrolment的course属性分组
		criteria.groupBy(root.get(Enrolment_.course));
		// 设置select出来数据
		criteria.multiselect(root.get(Enrolment_.course),
			builder.count(root));
		// 创建升序排列的排序对象
		Order order = builder.desc(builder.count(root));
		// 增加排序
		criteria.orderBy(order); // ①
		List<Object[]> list = em.createQuery(criteria)
			.getResultList();
		for(Object[] ele : list)
		{
			System.out.println(java.util.Arrays.toString(ele));
		}
		em.getTransaction().commit();
		em.close();
	}
}