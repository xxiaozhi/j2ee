package org.dao.imp;
import java.util.*;
import org.dao.*;
import org.model.*;
import org.hibernate.*;
public class XsDaoImp extends BaseDAO implements XsDao{
	/* 实现：学生信息查询 */
	public List findAll(int pageNow, int pageSize){			//显示所有学生信息
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Xsb order by xh");
			int firstResult=(pageNow-1)*pageSize;
			query.setFirstResult(firstResult);
			query.setMaxResults(pageSize);
			List list=query.list();
			ts.commit();
			session.close();
			session=null;
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	public int findXsSize(){							//查询一共有多少条学生记录
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			int size=session.createQuery("from Xsb").list().size();
			session.close();
			return size;			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	/* 实现：查看某个学生的详细信息 */
	public Xsb find(String xh){						//根据学号查询某学生信息
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Xsb where xh=?");
			query.setParameter(0, xh);
			query.setMaxResults(1);
			Xsb xs=(Xsb)query.uniqueResult();
			ts.commit();
			session.clear();
			session.close();
			return xs;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
	/* 实现：删除某学生信息 */
	public void delete(String xh){						//根据学号删除学生
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Xsb xs=find(xh);
			session.delete(xs);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/* 实现：修改某学生信息 */
	public void update(Xsb xs){						//修改学生信息
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.update(xs);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/* 实现：学生信息录入 */
	public void save(Xsb xs){						//插入学生
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.save(xs);
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
