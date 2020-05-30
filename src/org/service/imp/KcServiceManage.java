package org.service.imp;
import java.util.*;
import org.dao.*;
import org.service.*;
import org.model.*;
public class KcServiceManage implements KcService{
	private KcDao kcDao;			//对KcDao进行依赖注入
	/* 业务实现：成绩信息录入 */
	public List findAll(int pageNow, int pageSize){	//查询所有课程信息
		return kcDao.findAll(pageNow, pageSize);
	}
	public int findKcSize(){			//查询一共有多少条课程记录
		return kcDao.findKcSize();
	}
	public Kcb find(String kch){			//根据课程号查找课程信息
		return kcDao.find(kch);
	}
	//省略KcDao的getter/setter方法
	public KcDao getKcDao() {
		return kcDao;
	}
	public void setKcDao(KcDao kcDao) {
		this.kcDao = kcDao;
	}
	
}
