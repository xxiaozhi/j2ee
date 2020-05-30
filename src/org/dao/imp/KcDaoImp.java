package org.dao.imp;
import java.util.List;
import org.dao.*;
import org.hibernate.*;
import org.model.*;
public class KcDaoImp extends BaseDAO implements KcDao{
	/* ʵ�֣��ɼ���Ϣ¼�� */
	public List findAll(int pageNow, int pageSize){			//��ѯ���пγ���Ϣ
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Kcb");
		int firstResult=(pageNow-1)*pageSize;
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		List list=query.list();
		ts.commit();
		session.close();
		session=null;
		return list;
	}
	public int findKcSize(){							//��ѯһ���ж������γ̼�¼
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		return session.createQuery("from Kcb").list().size();
	}
	public Kcb find(String kch){						//���ݿγ̺Ų��ҿγ���Ϣ
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Kcb where kch=?");
			query.setParameter(0, kch);
			query.setMaxResults(1);
			Kcb kc=(Kcb)query.uniqueResult();
			ts.commit();
			session.clear();						//�������
			return kc;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
