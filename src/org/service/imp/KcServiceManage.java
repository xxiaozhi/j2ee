package org.service.imp;
import java.util.*;
import org.dao.*;
import org.service.*;
import org.model.*;
public class KcServiceManage implements KcService{
	private KcDao kcDao;			//��KcDao��������ע��
	/* ҵ��ʵ�֣��ɼ���Ϣ¼�� */
	public List findAll(int pageNow, int pageSize){	//��ѯ���пγ���Ϣ
		return kcDao.findAll(pageNow, pageSize);
	}
	public int findKcSize(){			//��ѯһ���ж������γ̼�¼
		return kcDao.findKcSize();
	}
	public Kcb find(String kch){			//���ݿγ̺Ų��ҿγ���Ϣ
		return kcDao.find(kch);
	}
	//ʡ��KcDao��getter/setter����
	public KcDao getKcDao() {
		return kcDao;
	}
	public void setKcDao(KcDao kcDao) {
		this.kcDao = kcDao;
	}
	
}
