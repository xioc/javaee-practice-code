package org.crazyit.hrsystem.action;

import java.util.List;

import org.crazyit.hrsystem.action.base.EmpBaseAction;
import org.crazyit.hrsystem.vo.PaymentBean;

import com.opensymphony.xwork2.ActionContext;

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

public class ViewSalaryAction extends EmpBaseAction
{
	private static final long serialVersionUID = 48L;
	// 封装所有发薪信息的List
	private List<PaymentBean> salarys;
	// salarys的setter和getter方法
	public void setSalarys(List<PaymentBean> salarys)
	{
		this.salarys = salarys;
	}
	public List<PaymentBean> getSalarys()
	{
		return this.salarys;
	}
	// 处理用户请求的方法
	public String execute()
		throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String user = (String)ctx.getSession()
			.get(WebConstant.USER);
		List<PaymentBean> salarys =  mgr.empSalary(user);
		setSalarys(salarys);
		return SUCCESS;
	}
}