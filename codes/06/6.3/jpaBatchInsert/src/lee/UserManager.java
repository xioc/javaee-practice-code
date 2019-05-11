package lee;

import javax.persistence.*;

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
public class UserManager
{
	// 使用Persistence创建EntityManagerFactory
	private static EntityManagerFactory emf =
		Persistence.createEntityManagerFactory("batch_pu");
	public static void main(String[] args)throws Exception
	{
		final EntityManager em = emf.createEntityManager();
		//开启事务
		em.getTransaction().begin();
		// 循环100000次，插入100000条记录
		for (int i = 0 ; i < 100000 ; i++ )
		{
			// 创建User实例
			User u1 = new User();
			u1.setName("xxxxx" + i);
			u1.setAge(i);
			u1.setNationality("china");
			// 在EntityManager级别缓存User实例
			em.persist(u1);
			// 每当累加器是20的倍数时，将EntityManager中数据刷入数据库，
			// 并清空Session缓存。
			if (i % 20 == 0)
			{
				em.flush();
				em.clear();
			}
		}
		//提交事务
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}