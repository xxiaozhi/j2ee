package org.service.imp;
import java.util.*;
import org.dao.*;
import org.service.*;
import org.model.*;
public class XsServiceManage implements XsService{
	//��XsDao��CjDao��������ע��
	private XsDao xsDao;
	private CjDao cjDao;
	/* ҵ��ʵ�֣�ѧ����Ϣ��ѯ */
	public List findAll(int pageNow, int pageSize){		//��ʾ����ѧ����Ϣ
		return xsDao.findAll(pageNow, pageSize);
	}
	public int findXsSize(){						//��ѯһ���ж�����ѧ����¼
		return xsDao.findXsSize();
	}	
	/* ҵ��ʵ�֣��鿴ĳ��ѧ������ϸ��Ϣ */
	public Xsb find(String xh){					//����ѧ�Ų�ѯĳѧ����Ϣ
		return xsDao.find(xh);
	}	
	/* ҵ��ʵ�֣�ɾ��ĳѧ����Ϣ */
	public void delete(String xh){					//����ѧ��ɾ��ѧ��
		
		cjDao.deleteOneXsCj(xh);				//ɾ��ѧ����ͬʱҪɾ��������Ӧ�ĳɼ�
		xsDao.delete(xh);
	}	
	/* ҵ��ʵ�֣��޸�ĳѧ����Ϣ */
	public void update(Xsb xs){					//�޸�ѧ����Ϣ
		xsDao.update(xs);
	}	
	/* ҵ��ʵ�֣�ѧ����Ϣ¼�� */
	public void save(Xsb xs){					//����ѧ��
		xsDao.save(xs);
	}
	//ʡ��XsDao��CjDao��getter/setter����
	public XsDao getXsDao() {
		return xsDao;
	}
	public void setXsDao(XsDao xsDao) {
		this.xsDao = xsDao;
	}
	public CjDao getCjDao() {
		return cjDao;
	}
	public void setCjDao(CjDao cjDao) {
		this.cjDao = cjDao;
	}
	
}
