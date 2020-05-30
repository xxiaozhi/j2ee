package org.dao.imp;
import java.util.*;
import org.dao.*;
import org.hibernate.*;
import org.model.*;
public class CjDaoImp extends BaseDAO implements CjDao{
	/* ʵ�֣��ɼ���Ϣ¼�� */
	public Cjb getXsCj(String xh, String kch){			//����ѧ�źͿγ̺Ų�ѯѧ���ɼ�
		CjbId cjbId=new CjbId();
		cjbId.setXh(xh);
		cjbId.setKch(kch);
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		return (Cjb)session.get(Cjb.class, cjbId);
	}
	public void saveorupdateCj(Cjb cj){				//¼��ѧ���ɼ�
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		session.saveOrUpdate(cj);
		ts.commit();
		session.close();
	}	
	/* ʵ�֣�ѧ���ɼ���ѯ */
	public List findAllCj(int pageNow, int pageSize){	//��ҳ��ʾ����ѧ���ɼ�
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("SELECT c.id.xh,a.xm,b.kcm,c.cj,c.xf,c.id.kch FROM Xsb a,Kcb b,Cjb c WHERE a.xh=c.id.xh AND b.kch=c.id.kch");
		query.setFirstResult((pageNow-1)*pageSize);	//��ҳ�Ӽ�¼��ʼ����
		query.setMaxResults(pageSize);			//���ҵ����������
		List list=query.list();
		ts.commit();
		session.close();
		return list;
	}
	public int findCjSize(){						//��ѯһ���ж������ɼ���¼
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			return session.createQuery("from Cjb").list().size();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}	
	/* ʵ�֣��鿴ĳ��ѧ���ĳɼ��� */
	public List getXsCjList(String xh){				//��ȡĳѧ���ĳɼ��б�
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("SELECT c.id.xh,b.kch,c.cj,b.xf FROM Xsb a,Kcb b,Cjb c WHERE c.id.xh=? AND a.xh=c.id.xh AND b.kch=c.id.kch");
		query.setParameter(0, xh);
		List<Object[]> list=query.list();
		ts.commit();
		session.close();
		return list;
	}	
	/* ʵ�֣�ɾ��ѧ���ɼ� */
	public void deleteCj(String xh, String kch){		//����ѧ�źͿγ̺�ɾ��ѧ���ɼ�
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.delete(getXsCj(xh, kch));
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void deleteOneXsCj(String xh){			//ɾ��ĳѧ���ĳɼ�����ɾ��������Ϣʱ��Ӧɾ����
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			List<Object[]> l=getXsCjList(xh);
			for(Object[] objs : l){
	           String x1=objs[0].toString();
	           String x2=objs[1].toString();
	           String x3=objs[2].toString();
	           String x4=objs[3].toString();
	           CjbId cjbId=new CjbId();
	           cjbId.setXh(x1);
	           cjbId.setKch(x2);
	           Cjb cjb=new Cjb();
	           cjb.setId(cjbId);
	           cjb.setCj(Integer.valueOf(x3));
	           cjb.setXf(Integer.valueOf(x4));
	           session.delete(cjb);
	           }
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
