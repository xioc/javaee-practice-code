

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
public class WaiterImpl
	implements Waiter
{
	// 模拟服务生上菜的方法
	public void serve(String food)
	{
		System.out.println("服务生已将" + food
			+ "端过来了，请慢用...");
	}
}

