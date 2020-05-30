package org.action;
import java.util.*;
import java.io.*;
import org.model.*;
import org.service.*;
import org.tool.*;
import com.opensymphony.xwork2.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts2.*;
public class XsAction extends ActionSupport{
	private int pageNow = 1;
	private int pageSize = 8;
	private Xsb xs;
	private XsService xsService;
	/* Action ģ�飺�޸�ĳѧ����Ϣ */
	private ZyService zyService;				//���ڲ�������רҵ��Ϣ�Լ���רҵ�����б�
	private File zpFile;					//���ڻ�ȡ��Ƭ�ļ�
	/* Action ģ�飺ѧ����Ϣ¼�� */
	private List list;						//���רҵ����	
	/* Action ģ�飺ѧ����Ϣ��ѯ */
	public String execute() throws Exception{		//��ʾ����ѧ����Ϣ
		List list=xsService.findAll(pageNow,pageSize);
		Map request=(Map)ActionContext.getContext().get("request");
		Pager page=new Pager(getPageNow(),xsService.findXsSize());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	public String findXs() throws Exception{
		String xh=xs.getXh();
		Xsb stu=xsService.find(xh);			//ֱ��ʹ��XsServiceҵ���߼��ӿ��е�find()����
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("xs", stu);
		return SUCCESS;
	}
	public String getImage() throws Exception{
		HttpServletResponse response=ServletActionContext.getResponse();
		String xh=xs.getXh();
		Xsb stu=xsService.find(xh);	//ֱ��ʹ��XsServiceҵ���߼��ӿ��е�find()����
		byte[] img=stu.getZp();
		response.setContentType("image/jpeg");
		ServletOutputStream os=response.getOutputStream();
		if(img!=null&&img.length!=0){
			for(int i=0; i<img.length; i++){
				os.write(img[i]);
			}
			os.flush();
		}
		return NONE;
	}
	public String deleteXs() throws Exception{
		String xh=xs.getXh();
		xsService.delete(xh);	      //ֱ��ʹ��XsServiceҵ���߼��ӿ��е�delete()����
		return SUCCESS;
	}
	/* Action ģ�飺�޸�ĳѧ����Ϣ */
	//��ʾ�޸�ҳ��
	public String updateXsView() throws Exception{
		String xh=xs.getXh();
		Xsb xsInfo=xsService.find(xh);		//ֱ��ʹ��XsServiceҵ���߼��ӿ��е�find()����
		List zys=zyService.getAll();			//ֱ��ʹ��ZyServiceҵ���߼��ӿ��е�getAll()����
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("xsInfo", xsInfo);
		request.put("zys", zys);
		return SUCCESS;
	}
	//ִ���޸Ĳ���
	public String updateXs() throws Exception{
		Xsb xs1=xsService.find(xs.getXh());		//ֱ��ʹ��XsServiceҵ���߼��ӿ��е�find()����
		xs1.setXm(xs.getXm());
		xs1.setXb(xs.getXb());
		//ֱ��ʹ��ZyServiceҵ���߼��ӿ��е�getOneZy()����
		xs1.setZyb(zyService.getOneZy(xs.getZyb().getId()));
		xs1.setCssj(xs.getCssj());
		xs1.setZxf(xs.getZxf());
		xs1.setBz(xs.getBz());
		if(this.getZpFile()!=null){
			FileInputStream fis=new FileInputStream(this.getZpFile());
			byte[] buffer=new byte[fis.available()];
			fis.read(buffer);
			xs1.setZp(buffer);
		}
		Map request=(Map)ActionContext.getContext().get("request");
		xsService.update(xs1);				//ֱ��ʹ��XsServiceҵ���߼��ӿ��е�update()����
		return SUCCESS;
	}
	/* Action ģ�飺ѧ����Ϣ¼�� */
	//��ʾ¼��ҳ��
	public String addXsView() throws Exception{
		return SUCCESS;
	}
	//ִ��¼�����
	public String addXs() throws Exception{
		Xsb stu=new Xsb();
		String xh1=xs.getXh();
		//ѧ���Ѵ��ڣ������ظ�¼��
		if(xsService.find(xh1)!=null){	//ʹ��XsServiceҵ���߼��ӿ��е�find()�����ж�
			return ERROR;
		}
		stu.setXh(xs.getXh());
		stu.setXm(xs.getXm());
		stu.setXb(xs.getXb());
		stu.setCssj(xs.getCssj());
		stu.setZxf(xs.getZxf());
		stu.setBz(xs.getBz());
		//ֱ��ʹ��ZyServiceҵ���߼��ӿ��е�getOneZy()����
		stu.setZyb(zyService.getOneZy(xs.getZyb().getId()));
		if(this.getZpFile()!=null){
			FileInputStream fis=new FileInputStream(this.getZpFile());
			byte[] buffer=new byte[fis.available()];
			fis.read(buffer);
			stu.setZp(buffer);
		}
		xsService.save(stu);
		return SUCCESS;
	}

	public Xsb getXs(){
		return xs;
	}
	public void setXs(Xsb xs){
		this.xs = xs;
	}
	
	public XsService getXsService(){
		return xsService;
	}
	public void setXsService(XsService xsService){
		this.xsService = xsService;
	}
	
	/* Action ģ�飺�޸�ĳѧ����Ϣ */
	public ZyService getZyService(){
		return zyService;
	}
	public void setZyService(ZyService zyService){
		this.zyService = zyService;
	}
	
	public File getZpFile(){
		return zpFile;
	}
	public void setZpFile(File zpFile){
		this.zpFile = zpFile;
	}
	//
	/* Action ģ�飺ѧ����Ϣ¼�� */
	public List getList(){
		return zyService.getAll();			//����רҵ�ļ���
	}
	public void setList(List list){
		this.list = list;
	}
	//
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
