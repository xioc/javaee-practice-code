package lee;

import org.springframework.context.*;
import org.springframework.context.support.*;

import org.crazyit.app.service.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class SpringTest
{
	public static void main(String[] args)
	{
		// �������·���µ�beans.xml�����ļ�����Spring����
		ApplicationContext ctx = new
			ClassPathXmlApplicationContext("beans.xml");
		Being b1 = ctx.getBean("dog" , Being.class);
		b1.testBeing();
		Being b2 = ctx.getBean("cat" , Being.class);
		b2.testBeing();
	}
}