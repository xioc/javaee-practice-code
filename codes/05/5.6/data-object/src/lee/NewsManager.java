package lee;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.tool.hbm2ddl.*;
//import org.hibernate.service.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;
import org.hibernate.tool.schema.*;
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
public class NewsManager
{
	public static void main(String[] args) throws Exception
	{
		// Hibernate 5.x启动Hibernate的标准方式
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			// configure()方法默认加载hibernate.cfg.xml文件
			.configure()
			.build();
		Metadata metadata = new MetadataSources(registry)
			.buildMetadata();
		// 使用Metadata创建SessionFactory
		metadata.buildSessionFactory();
		// 创建SchemaExport对象
		SchemaExport se = new SchemaExport();
		// 设置输出格式良好的SQL脚本
		se.setFormat(true)
			// 设置保存SQL脚本的文件名
			.setOutputFile("new.sql")
			// 输出SQL脚本
			.create(EnumSet.of(TargetType.SCRIPT), metadata);
	}
}
