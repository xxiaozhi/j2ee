package org.dao.imp;
import java.util.*;
import org.dao.*;
import org.hibernate.*;
import org.model.*;
public class ZyDaoImp extends BaseDAO implements ZyDao{
	/* ʵ�֣�ѧ����Ϣ��ѯ */
	public Zyb getOneZy(Integer zyId){		//����רҵID����רҵ��Ϣ
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Zyb where id=?");
			query.setParameter(0, zyId);
			query.setMaxResults(1);
			return (Zyb)query.uniqueResult();	
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
	/* ʵ�֣��޸�ĳѧ����Ϣ */
	public List getAll(){					//��������רҵ��Ϣ��Ϊ����רҵ�����б��ã�
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			List list=session.createQuery("from Zyb").list();
			ts.commit();
			session.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
}
