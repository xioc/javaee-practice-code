package org.crazyit.hrsystem.action;

import java.util.List;

import org.crazyit.hrsystem.action.base.MgrBaseAction;
import org.crazyit.hrsystem.vo.SalaryBean;

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

public class ViewDeptAction extends MgrBaseAction
{
	private static final long serialVersionUID = 48L;
	// 封装发薪列表的List成员变量
	private List<SalaryBean> sals;
	// sals的setter和getter方法
	public void setSals(List<SalaryBean> sals)
	{
		this.sals = sals;
	}
	public List<SalaryBean> getSals()
	{
		return this.sals;
	}

	public String execute()
		throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String)ctx.getSession()
			.get(WebConstant.USER);
		// 调用业务逻辑方法取得当前员工的全部发薪列表
		List<SalaryBean> result = mgr.getSalaryByMgr(mgrName);
		setSals(result);
		return SUCCESS;
	}
}