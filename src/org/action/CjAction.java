package org.action;
import java.util.*;
import org.model.*;
import org.service.*;
import com.opensymphony.xwork2.*;
import org.tool.*;
public class CjAction extends ActionSupport{
	private Cjb cj;
	private XsService xsService;
	private KcService kcService;
	private CjService cjService;
	/* Action 模块：学生成绩查询 */
	private int pageNow = 1;					//默认第一页
	private int pageSize = 8;						//每页显示 8 条记录
	/* Action 模块：成绩信息录入 */
	public String execute() throws Exception{			//获取已有的所有学生和课程名列表
		List list1=xsService.findAll(1, xsService.findXsSize());		//通过XsService接口获取已有学生名
		List list2=kcService.findAll(1, kcService.findKcSize());	//通过KcService接口获取已有课程名
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list1", list1);				//把所有学生名列表存入请求中返回
		request.put("list2", list2);				//把所有课程名列表存入请求中返回
		return SUCCESS;
	}
	public String addorupdateXscj() throws Exception{	//执行成绩录入操作
		Cjb cj1 = null;
		CjbId cjId1=new CjbId();
		cjId1.setXh(cj.getId().getXh());
		cjId1.setKch(cj.getId().getKch());
		//通过CjService业务逻辑接口中的getXsCj()方法判断成绩记录是否已存在
		if(cjService.getXsCj(cj.getId().getXh(), cj.getId().getKch())==null){	//成绩记录不存在
			cj1 = new Cjb();
			cj1.setId(cjId1);
		}else{	//成绩记录已经存在
			cj1 = cjService.getXsCj(cj.getId().getXh(), cj.getId().getKch());
		}
		Kcb kc1=kcService.find(cj.getId().getKch());	//通过KcService接口获取相应课程的学分值
		cj1.setCj(cj.getCj());
		if(cj.getCj()> Integer.valueOf(60) ||cj.getCj()==Integer.valueOf(60)){			//判断成绩及格，才给学分
			cj1.setXf(kc1.getXf());
		}else
			cj1.setXf(Integer.valueOf(0));					//不及格的没有学分
		cjService.saveorupdateCj(cj1);			//通过CjService业务逻辑接口保存或更新成绩
		return SUCCESS;
	}
	public String xscjInfo() throws Exception{
		//直接使用CjService业务逻辑接口中的findAllCj()方法
		List list=cjService.findAllCj(this.getPageNow(), this.getPageSize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list",list);
		Pager page=new Pager(this.getPageNow(), cjService.findCjSize());
		request.put("page", page);
		return SUCCESS;
	}

	public String findXscj() throws Exception{
		//使用CjService业务逻辑接口中的getXsCjList()方法获取某学生的成绩列表
		List list=cjService.getXsCjList(cj.getId().getXh());
		if(list.size()>0){		//存在该生的成绩记录
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("list", list);
			return SUCCESS;
		}else
			return ERROR;
	}
	public String deleteOneXscj() throws Exception{
		String xh=cj.getId().getXh();
		String kch=cj.getId().getKch();
		cjService.deleteCj(xh, kch);		//通过CjService业务逻辑接口中的deleteCj()方法执行删除
		return SUCCESS;
	}

	public Cjb getCj(){
		return cj;
	}
	public void setCj(Cjb cj){
		this.cj = cj;
	}

	public XsService getXsService(){
		return xsService;
	}
	public void setXsService(XsService xsService){
		this.xsService = xsService;
	}

	public KcService getKcService(){
		return kcService;
	}
	public void setKcService(KcService kcService){
		this.kcService = kcService;
	}

	public CjService getCjService(){
		return cjService;
	}
	public void setCjService(CjService cjService){
		this.cjService = cjService;
	}

	/* Action 模块：学生成绩查询 */
	public int getPageNow(){
		return pageNow;
	}
	public void setPageNow(int pageNow){
		this.pageNow = pageNow;
	}

	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}
}
