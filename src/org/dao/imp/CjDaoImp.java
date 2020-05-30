package org.dao.imp;
import java.util.*;
import org.dao.*;
import org.hibernate.*;
import org.model.*;
public class CjDaoImp extends BaseDAO implements CjDao{
	/* 实现：成绩信息录入 */
	public Cjb getXsCj(String xh, String kch){			//根据学号和课程号查询学生成绩
		CjbId cjbId=new CjbId();
		cjbId.setXh(xh);
		cjbId.setKch(kch);
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		return (Cjb)session.get(Cjb.class, cjbId);
	}
	public void saveorupdateCj(Cjb cj){				//录入学生成绩
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		session.saveOrUpdate(cj);
		ts.commit();
		session.close();
	}	
	/* 实现：学生成绩查询 */
	public List findAllCj(int pageNow, int pageSize){	//分页显示所有学生成绩
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("SELECT c.id.xh,a.xm,b.kcm,c.cj,c.xf,c.id.kch FROM Xsb a,Kcb b,Cjb c WHERE a.xh=c.id.xh AND b.kch=c.id.kch");
		query.setFirstResult((pageNow-1)*pageSize);	//分页从记录开始查找
		query.setMaxResults(pageSize);			//查找到的最大条数
		List list=query.list();
		ts.commit();
		session.close();
		return list;
	}
	public int findCjSize(){						//查询一共有多少条成绩记录
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			return session.createQuery("from Cjb").list().size();
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}	
	/* 实现：查看某个学生的成绩表 */
	public List getXsCjList(String xh){				//获取某学生的成绩列表
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("SELECT c.id.xh,b.kch,c.cj,b.xf FROM Xsb a,Kcb b,Cjb c WHERE c.id.xh=? AND a.xh=c.id.xh AND b.kch=c.id.kch");
		query.setParameter(0, xh);
		List<Object[]> list=query.list();
		ts.commit();
		session.close();
		return list;
	}	
	/* 实现：删除学生成绩 */
	public void deleteCj(String xh, String kch){		//根据学号和课程号删除学生成绩
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
	public void deleteOneXsCj(String xh){			//删除某学生的成绩（在删除该生信息时对应删除）
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
