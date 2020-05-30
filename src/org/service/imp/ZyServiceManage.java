package org.service.imp;
import java.util.*;
import org.dao.*;
import org.service.*;
import org.model.*;
public class ZyServiceManage implements ZyService{
	private ZyDao zyDao;						//对ZyDao进行依赖注入
	/* 业务实现：学生信息查询 */
	public Zyb getOneZy(Integer zyId){		//根据专业ID查找专业信息
		return zyDao.getOneZy(zyId);
	}	
	/* 业务实现：修改某学生信息 */
	public List getAll(){						//查找所有专业信息（为加载专业下拉列表用）
		return zyDao.getAll();
	}
	//省略ZyDao的getter/setter方法
	public ZyDao getZyDao() {
		return zyDao;
	}
	public void setZyDao(ZyDao zyDao) {
		this.zyDao = zyDao;
	}
	
}
