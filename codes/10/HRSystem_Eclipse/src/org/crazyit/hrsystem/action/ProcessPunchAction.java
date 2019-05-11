package org.crazyit.hrsystem.action;

import static org.crazyit.hrsystem.service.EmpManager.PUNCHED;
import static org.crazyit.hrsystem.service.EmpManager.PUNCH_FAIL;
import static org.crazyit.hrsystem.service.EmpManager.PUNCH_SUCC;

import org.crazyit.hrsystem.service.EmpManager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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
public class ProcessPunchAction extends ActionSupport
{
	private static final long serialVersionUID = 48L;
	// 该Action所依赖的业务逻辑组件
	private EmpManager empMgr;
	// 依赖注入业务逻辑组件的setter方法
	public void setEmpManager(EmpManager empMgr)
	{
		this.empMgr = empMgr;
	}
	// 处理上班打卡的方法
	public String come()
		throws Exception
	{
		return process(true);
	}
	// 处理下班打卡的方法
	public String leave()
		throws Exception
	{
		return process(false);
	}
	private String process(boolean isCome)
		throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String user = (String)ctx.getSession()
			.get(WebConstant.USER);
		System.out.println("-----打卡----" + user);
		String dutyDay = new java.sql.Date(
			System.currentTimeMillis()).toString();
		// 调用业务逻辑方法处理打卡请求
		int result = empMgr.punch(user ,dutyDay , isCome);
		switch(result)
		{
			case PUNCH_FAIL:
				addActionMessage("打卡失败");
				break;
			case PUNCHED:
				addActionMessage("您已经打过卡了，不要重复打卡");
				break;
			case PUNCH_SUCC:
				addActionMessage("打卡成功");
				break;
		}
		return SUCCESS;
	}
}