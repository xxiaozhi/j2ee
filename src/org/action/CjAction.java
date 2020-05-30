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
	/* Action ģ�飺ѧ���ɼ���ѯ */
	private int pageNow = 1;					//Ĭ�ϵ�һҳ
	private int pageSize = 8;						//ÿҳ��ʾ 8 ����¼
	/* Action ģ�飺�ɼ���Ϣ¼�� */
	public String execute() throws Exception{			//��ȡ���е�����ѧ���Ϳγ����б�
		List list1=xsService.findAll(1, xsService.findXsSize());		//ͨ��XsService�ӿڻ�ȡ����ѧ����
		List list2=kcService.findAll(1, kcService.findKcSize());	//ͨ��KcService�ӿڻ�ȡ���пγ���
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list1", list1);				//������ѧ�����б���������з���
		request.put("list2", list2);				//�����пγ����б���������з���
		return SUCCESS;
	}
	public String addorupdateXscj() throws Exception{	//ִ�гɼ�¼�����
		Cjb cj1 = null;
		CjbId cjId1=new CjbId();
		cjId1.setXh(cj.getId().getXh());
		cjId1.setKch(cj.getId().getKch());
		//ͨ��CjServiceҵ���߼��ӿ��е�getXsCj()�����жϳɼ���¼�Ƿ��Ѵ���
		if(cjService.getXsCj(cj.getId().getXh(), cj.getId().getKch())==null){	//�ɼ���¼������
			cj1 = new Cjb();
			cj1.setId(cjId1);
		}else{	//�ɼ���¼�Ѿ�����
			cj1 = cjService.getXsCj(cj.getId().getXh(), cj.getId().getKch());
		}
		Kcb kc1=kcService.find(cj.getId().getKch());	//ͨ��KcService�ӿڻ�ȡ��Ӧ�γ̵�ѧ��ֵ
		cj1.setCj(cj.getCj());
		if(cj.getCj()> Integer.valueOf(60) ||cj.getCj()==Integer.valueOf(60)){			//�жϳɼ����񣬲Ÿ�ѧ��
			cj1.setXf(kc1.getXf());
		}else
			cj1.setXf(Integer.valueOf(0));					//�������û��ѧ��
		cjService.saveorupdateCj(cj1);			//ͨ��CjServiceҵ���߼��ӿڱ������³ɼ�
		return SUCCESS;
	}
	public String xscjInfo() throws Exception{
		//ֱ��ʹ��CjServiceҵ���߼��ӿ��е�findAllCj()����
		List list=cjService.findAllCj(this.getPageNow(), this.getPageSize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list",list);
		Pager page=new Pager(this.getPageNow(), cjService.findCjSize());
		request.put("page", page);
		return SUCCESS;
	}

	public String findXscj() throws Exception{
		//ʹ��CjServiceҵ���߼��ӿ��е�getXsCjList()������ȡĳѧ���ĳɼ��б�
		List list=cjService.getXsCjList(cj.getId().getXh());
		if(list.size()>0){		//���ڸ����ĳɼ���¼
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("list", list);
			return SUCCESS;
		}else
			return ERROR;
	}
	public String deleteOneXscj() throws Exception{
		String xh=cj.getId().getXh();
		String kch=cj.getId().getKch();
		cjService.deleteCj(xh, kch);		//ͨ��CjServiceҵ���߼��ӿ��е�deleteCj()����ִ��ɾ��
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

	/* Action ģ�飺ѧ���ɼ���ѯ */
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
