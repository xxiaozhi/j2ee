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
	/* Action 模块：修改某学生信息 */
	private ZyService zyService;				//用于查找所有专业信息以加载专业下拉列表
	private File zpFile;					//用于获取照片文件
	/* Action 模块：学生信息录入 */
	private List list;						//存放专业集合	
	/* Action 模块：学生信息查询 */
	public String execute() throws Exception{		//显示所有学生信息
		List list=xsService.findAll(pageNow,pageSize);
		Map request=(Map)ActionContext.getContext().get("request");
		Pager page=new Pager(getPageNow(),xsService.findXsSize());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	public String findXs() throws Exception{
		String xh=xs.getXh();
		Xsb stu=xsService.find(xh);			//直接使用XsService业务逻辑接口中的find()方法
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("xs", stu);
		return SUCCESS;
	}
	public String getImage() throws Exception{
		HttpServletResponse response=ServletActionContext.getResponse();
		String xh=xs.getXh();
		Xsb stu=xsService.find(xh);	//直接使用XsService业务逻辑接口中的find()方法
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
		xsService.delete(xh);	      //直接使用XsService业务逻辑接口中的delete()方法
		return SUCCESS;
	}
	/* Action 模块：修改某学生信息 */
	//显示修改页面
	public String updateXsView() throws Exception{
		String xh=xs.getXh();
		Xsb xsInfo=xsService.find(xh);		//直接使用XsService业务逻辑接口中的find()方法
		List zys=zyService.getAll();			//直接使用ZyService业务逻辑接口中的getAll()方法
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("xsInfo", xsInfo);
		request.put("zys", zys);
		return SUCCESS;
	}
	//执行修改操作
	public String updateXs() throws Exception{
		Xsb xs1=xsService.find(xs.getXh());		//直接使用XsService业务逻辑接口中的find()方法
		xs1.setXm(xs.getXm());
		xs1.setXb(xs.getXb());
		//直接使用ZyService业务逻辑接口中的getOneZy()方法
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
		xsService.update(xs1);				//直接使用XsService业务逻辑接口中的update()方法
		return SUCCESS;
	}
	/* Action 模块：学生信息录入 */
	//显示录入页面
	public String addXsView() throws Exception{
		return SUCCESS;
	}
	//执行录入操作
	public String addXs() throws Exception{
		Xsb stu=new Xsb();
		String xh1=xs.getXh();
		//学号已存在，不可重复录入
		if(xsService.find(xh1)!=null){	//使用XsService业务逻辑接口中的find()方法判断
			return ERROR;
		}
		stu.setXh(xs.getXh());
		stu.setXm(xs.getXm());
		stu.setXb(xs.getXb());
		stu.setCssj(xs.getCssj());
		stu.setZxf(xs.getZxf());
		stu.setBz(xs.getBz());
		//直接使用ZyService业务逻辑接口中的getOneZy()方法
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
	
	/* Action 模块：修改某学生信息 */
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
	/* Action 模块：学生信息录入 */
	public List getList(){
		return zyService.getAll();			//返回专业的集合
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
