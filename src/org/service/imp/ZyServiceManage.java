package org.service.imp;
import java.util.*;
import org.dao.*;
import org.service.*;
import org.model.*;
public class ZyServiceManage implements ZyService{
	private ZyDao zyDao;						//��ZyDao��������ע��
	/* ҵ��ʵ�֣�ѧ����Ϣ��ѯ */
	public Zyb getOneZy(Integer zyId){		//����רҵID����רҵ��Ϣ
		return zyDao.getOneZy(zyId);
	}	
	/* ҵ��ʵ�֣��޸�ĳѧ����Ϣ */
	public List getAll(){						//��������רҵ��Ϣ��Ϊ����רҵ�����б��ã�
		return zyDao.getAll();
	}
	//ʡ��ZyDao��getter/setter����
	public ZyDao getZyDao() {
		return zyDao;
	}
	public void setZyDao(ZyDao zyDao) {
		this.zyDao = zyDao;
	}
	
}
