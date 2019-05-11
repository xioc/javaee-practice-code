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
public class CriteriaQueryTest
{
	final static EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("query_pu");
	public static void main(String[] args)
	{
		CriteriaQueryTest criteriaTest = new CriteriaQueryTest();
		criteriaTest.query();
		criteriaTest.paramQuery();
//		criteriaTest.update();
		criteriaTest.multiselect();
		criteriaTest.queryDto();
		criteriaTest.queryTuple();
		criteriaTest.multiRootQuery();
		emf.close();
	}
	private void query()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// 创建CriteriaBuilder
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// 创建CriteriaQuery，传入的类型参数代表该条件查询返回结果集里的元素类型
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		// 设置要查询的根实体类
		Root<Student> root = criteria.from(Student.class);
		// 下面语句不是必须的，条件查询默认会查询唯一的Root实体
		criteria.select(root);
		// 使用builder生成查询条件
		Predicate pred = builder.greaterThan(root.get(Student_.name), "a"); // ①
		// 使用CriteriaQuery的where()方法添加查询条件
		criteria.where(pred);
		List<Student> list = em.createQuery(criteria)
			.getResultList();
		System.out.println("=====简单条件查询获取所有学生记录=====");
		for(Student s : list)
		{
			System.out.println(s.getName());
			Set<Enrolment> enrolments = s.getEnrolments();
			System.out.println("=====获取-" + s.getName()
				+ "-的选课记录=====");
			for(Enrolment e : enrolments)
			{
				System.out.println(e.getCourse().getName());
			}
		}
		em.getTransaction().commit();
		em.close();
	}

	private void paramQuery()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// 创建CriteriaBuilder
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// 创建CriteriaQuery，传入的类型参数代表该条件查询返回结果集里的元素类型
		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);
		// 设置要查询的根实体类
		Root<Student> root = criteria.from(Student.class);
		// 下面语句不是必须的，条件查询默认会查询唯一的Root实体
		criteria.select(root);
		// 定义一个参数
		ParameterExpression<String> nameParam = builder
			.parameter(String.class);
		// 使用builder来生成查询条件,查询条件使用nameParam参数
		Predicate pred = builder.greaterThan(root.get(Student_.name), nameParam);
		// 使用CriteriaQuery的where()方法添加查询条件
		criteria.where(pred);
		List<Student> list = em.createQuery(criteria)
			// 为nameParam设置参数
			.setParameter(nameParam, "a")
			.getResultList();
		System.out.println("=====带参数的条件查询获取学生记录=====");
		for(Student s : list)
		{
			System.out.println(s.getName());
		}
		em.getTransaction().commit();
		em.close();
	}

	private void update()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// 创建CriteriaBuilder
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// 创建CriteriaUpdate
		CriteriaUpdate<Student> update = builder
			.createCriteriaUpdate(Student.class);
		// 设置要查询的根实体类
		Root<Student> root = update.from(Student.class);
		// 设置要更新的新值（相当于设置update的set子句）
		update.set(root.get(Student_.name), "新名字");
		// 使用builer来生成条件,
		Predicate pred = builder.greaterThan(
			root.get(Student_.studentNumber), 20050230);
		// 使用CriteriaUpdate的where()方法添加条件（相当于设置where子句）
		update.where(pred);
		int result = em.createQuery(update)
			.executeUpdate();
		System.out.printf("=====共有%d条学生记录被修改=====%n", result);
		em.getTransaction().commit();
		em.close();
	}

	private void multiselect()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// 创建CriteriaBuilder
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// 创建CriteriaQuery，传入的类型参数代表该条件查询返回结果集里的元素类型
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		// 设置要查询的根实体类
		Root<Student> root = criteria.from(Student.class);
		// 使用multiselect设置查询属性和实体的组合
		criteria.multiselect(root.get(Student_.name), root);
		// 上面代码等同于如下语句
		//criteria.select(builder.array(root.get(Student_.name), root));
		// 使用builder生成查询条件
		Predicate pred = builder.greaterThan(root.get(Student_.name), "a");
		// 使用CriteriaQuery的where()方法添加查询条件
		criteria.where(pred);
		List<Object[]> list = em.createQuery(criteria)
			.getResultList();
		System.out.println("=====查询属性和实体的组合=====");
		for(Object[] row : list)
		{
			System.out.println(row[0] + "->" + row[1]);
		}
		em.getTransaction().commit();
		em.close();
	}

	private void queryDto()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// 创建CriteriaBuilder
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// 创建CriteriaQuery，传入的类型参数代表该条件查询返回结果集里的元素类型
		CriteriaQuery<EnrolmentDto> criteria = builder
			.createQuery(EnrolmentDto.class);
		// 设置要查询的根实体类
		Root<Enrolment> root = criteria.from(Enrolment.class);
		// 将查询的两个属性封装成EnrolmentDto对象
		criteria.select(builder.construct(EnrolmentDto.class,
			root.get(Enrolment_.year), root.get(Enrolment_.semester)));
		// 使用builder生成查询条件
		Predicate pred = builder.gt(
			root.get(Enrolment_.enrolmentId), 2);
		// 使用CriteriaQuery的where()方法添加查询条件
		criteria.where(pred);
		List<EnrolmentDto> list = em.createQuery(criteria)
			.getResultList();
		System.out.println("=====将查询的多个属性封装成DTO=====");
		for(EnrolmentDto dto : list)
		{
			System.out.println(dto.getYear() + "->" + dto.getSem());
		}
		em.getTransaction().commit();
		em.close();
	}

	private void queryTuple()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// 创建CriteriaBuilder
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// 创建CriteriaQuery，传入的类型参数代表该条件查询返回结果集里的元素类型
		CriteriaQuery<Tuple> criteria = builder
			.createQuery(Tuple.class);
		// 设置要查询的根实体类
		Root<Enrolment> root = criteria.from(Enrolment.class);
		// 定义要查询的2个属性
		Path<Integer> yearPath = root.get(Enrolment_.year);
		Path<Integer> semesterPath = root.get(Enrolment_.semester);
		// 查询多个属性或实体，查询得到的结果集的元素是Tuple
		criteria.multiselect(yearPath, semesterPath);
		// 使用builder生成查询条件
		Predicate pred = builder.gt(
			root.get(Enrolment_.enrolmentId), 2);
		// 使用CriteriaQuery的where()方法添加查询条件
		criteria.where(pred);
		List<Tuple> list = em.createQuery(criteria)
			.getResultList();
		System.out.println("=====将查询的多个属性封装成Tuple=====");
		for(Tuple tuple : list)
		{
			// 通过元组来获取各属性的值
			System.out.println(tuple.get(yearPath) + "->"
				+ tuple.get(semesterPath));
		}
		em.getTransaction().commit();
		em.close();
	}

	private void multiRootQuery()
	{
		// 打开EntityManager和事务
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// 创建CriteriaBuilder
		CriteriaBuilder builder = em.getCriteriaBuilder();
		// 创建CriteriaQuery，传入的类型参数代表该条件查询返回结果集里的元素类型
		CriteriaQuery<Tuple> criteria = builder
			.createQuery(Tuple.class);
		// 设置要查询的根实体类
		Root<Student> stuRoot = criteria.from(Student.class);
		Root<Enrolment> enrolRoot = criteria.from(Enrolment.class);
		// 查询多个属性或实体，查询得到的结果集的元素是Tuple
		criteria.multiselect(stuRoot, enrolRoot);
		// 使用builder生成查询条件（实际上是连接条件）
		Predicate pred = builder.equal(
			enrolRoot.get(Enrolment_.student), stuRoot);
		// 使用CriteriaQuery的where()方法添加查询条件（实际上是连接条件）
		criteria.where(pred);
		List<Tuple> list = em.createQuery(criteria)
			.getResultList();
		System.out.println("=====将查询的多个Root实体封装成Tuple=====");
		for(Tuple tuple : list)
		{
			// 通过元组来获取各Root实体
			System.out.println(tuple.get(stuRoot) + "->"
				+ tuple.get(enrolRoot));
		}
		em.getTransaction().commit();
		em.close();
	}

}
