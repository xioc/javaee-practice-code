package lee;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;
import org.hibernate.boot.registry.*;
import org.crazyit.app.domain.*;
import java.io.*;

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
public class PersonManager
{
	public static void main(String[] args)
		throws Exception
	{
		// 实例化Configuration，
		Configuration conf = new Configuration()
			.configure();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 创建Person对象
		Person person = new Person();
		// 为Person对象的属性设置值
		person.setName("crazyit.org");
		File file = new File("logo.jpg");
		byte[] content = new byte[(int)file.length()];
		new FileInputStream(file).read(content);
		person.setPic(content);
		// 保存Person对象
		sess.save(person);
//		Person p = sess.load(Person.class, 1);
//		System.out.println(p.getName());
		// 提交事务
		tx.commit();
		// 关闭Session
		sess.close();
		sf.close();
	}
}
