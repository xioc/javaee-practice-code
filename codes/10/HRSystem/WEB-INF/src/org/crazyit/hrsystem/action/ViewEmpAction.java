package org.crazyit.hrsystem.action;

import java.util.List;

import org.crazyit.hrsystem.action.base.MgrBaseAction;
import org.crazyit.hrsystem.vo.EmpBean;

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
public class ViewEmpAction extends MgrBaseAction
{
	private static final long serialVersionUID = 48L;
	// 封装当前经理所有员工的List
	private List<EmpBean> emps;
	// emps的setter和getter方法
	public void setEmps(List<EmpBean> emps)
	{
		this.emps = emps;
	}
	public List<EmpBean> getEmps()
	{
		return this.emps;
	}
	public String execute()
		throws Exception
	{
		// 创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		// 获取HttpSession中的user属性
		String mgrName = (String)ctx.getSession()
			.get(WebConstant.USER);
		setEmps(mgr.getEmpsByMgr(mgrName));
		return SUCCESS;
	}
}