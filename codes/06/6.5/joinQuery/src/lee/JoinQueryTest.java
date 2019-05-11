package lee;

import org.crazyit.app.domain.*;
import org.crazyit.app.dto.*;
import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.*;

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
public class JoinQueryTest
{
	final static EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("query_pu");
	public static void main(String[] args)
	{
		JoinQueryTest joinTest = new JoinQueryTest();
		joinTest.queryWithJoin();
		joinTest.queryWithFecth();
		emf.close();
	}

	// 示范根据关联实体的属性过滤数据
	private void queryWithJoin()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// 创建CriteriaQuery，类型参数代表该条件查询返回结果集的元素类型
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		// 指定要查询的根实体类
		Root<Student> root = criteria.from(Student.class);
		// 下面语句不是必须的，条件查询默认会选择唯一的Root实体
		criteria.select(root);
		// 建立关联，Student.enrolments是@OneToMany关联
		SetJoin<Student, Enrolment> enrolJoin = root
			.join(Student_.enrolments, JoinType.LEFT); // ①
		Predicate stuPred = builder.and(
			builder.greaterThan(root.get(Student_.studentNumber), 20050231),
			builder.gt(enrolJoin.get(Enrolment_.semester), 2)
		);
		// 使用builer来生成查询条件,使用where()方法添加查询条件
		criteria.where(stuPred);
		List<Student> list = em.createQuery(criteria)
			.getResultList();
		System.out.println("=====关联条件查询获取所有学生记录=====");
		for (Student s : list)
		{
			System.out.println(s.getName());
			// 获取该学生关联的选课记录
			System.out.println(s.getEnrolments());   // ②
		}
		em.getTransaction().commit();
		em.close();
	}
// 示范FetchMode的用法
private void queryWithFecth()
{
	// 打开EntityManager和事务
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	CriteriaBuilder builder = em.getCriteriaBuilder();
	// 创建CriteriaQuery，类型参数代表该条件查询返回结果集的元素类型
	CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
	// 指定要查询的根实体类
	Root<Student> root = criteria.from(Student.class);
	// 下面语句不是必须的，条件查询默认会选择唯一的Root实体
	criteria.select(root);
	// 建立关联，Student.enrolments是@OneToMany关联
	SetJoin<Student, Enrolment> enrolJoin = root
		.join(Student_.enrolments, JoinType.LEFT); // ①
	// 建立fetch关联，Student.enrolments是@OneToMany关联
	Fetch<Student, Enrolment> enrolFetch = root
		.fetch(Student_.enrolments, JoinType.LEFT); // ③
	Fetch<Enrolment, Course> courseFetch = enrolFetch
		.fetch(Enrolment_.course); // ④
	Predicate stuPred = builder.and(
		builder.greaterThan(root.get(Student_.studentNumber), 20050231),
		builder.gt(enrolJoin.get(Enrolment_.semester), 2)
	);
	// 使用builer来生成查询条件,使用where()方法添加查询条件
	criteria.where(stuPred);
	List<Student> list = em.createQuery(criteria)
		.getResultList();
	em.getTransaction().commit();
	em.close();
	System.out.println("=====关联条件查询获取所有学生记录=====");
	for (Student s : list)
	{
		System.out.println(s.getName());
		// 在EntityManager关闭之后获取该学生关联的选课记录
		System.out.println(s.getEnrolments());   // ②
	}
}
}
