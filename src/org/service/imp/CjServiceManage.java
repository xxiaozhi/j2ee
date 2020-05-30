package org.service.imp;
import java.util.*;
import org.dao.*;
import org.service.*;
import org.model.*;
public class CjServiceManage implements CjService{
	private CjDao cjDao;						//��CjDao��������ע��
	/* ҵ��ʵ�֣��ɼ���Ϣ¼�� */
	public Cjb getXsCj(String xh, String kch){			//����ѧ�źͿγ̺Ų�ѯѧ���ɼ�
		return cjDao.getXsCj(xh, kch);
	}
	public void saveorupdateCj(Cjb cj){				//¼��ѧ���ɼ�
		cjDao.saveorupdateCj(cj);
	}	
	/* ҵ��ʵ�֣�ѧ���ɼ���ѯ */
	public List findAllCj(int pageNow, int pageSize){	//��ҳ��ʾ����ѧ���ɼ�
		return cjDao.findAllCj(pageNow, pageSize);
	}
	public int findCjSize(){						//��ѯһ���ж������ɼ���¼
		return cjDao.findCjSize();
	}	
	/* ҵ��ʵ�֣��鿴ĳ��ѧ���ĳɼ��� */
	public List getXsCjList(String xh){				//��ȡĳѧ���ĳɼ��б�
		return cjDao.getXsCjList(xh);
	}	
	/* ҵ��ʵ�֣�ɾ��ѧ���ɼ� */
	public void deleteCj(String xh, String kch){		//����ѧ�źͿγ̺�ɾ��ѧ���ɼ�
		cjDao.deleteCj(xh, kch);
	}
	public void deleteOneXsCj(String xh){			//ɾ��ĳѧ���ĳɼ�����ɾ��������Ϣʱ��Ӧɾ����
		cjDao.deleteOneXsCj(xh);
	}
	//ʡ��CjDao��getter/setter����
	public CjDao getCjDao() {
		return cjDao;
	}
	public void setCjDao(CjDao cjDao) {
		this.cjDao = cjDao;
	}
	
}
