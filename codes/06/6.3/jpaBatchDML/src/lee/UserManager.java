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
		String hqlUpdate = "update User u set name = :newName";
		// 执行更新
		int updatedEntities = em.createQuery(hqlUpdate)
			.setParameter("newName", "JPA新名字")
			.executeUpdate();
		//提交事务
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}