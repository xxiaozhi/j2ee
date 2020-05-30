package org.service.imp;
import java.util.*;
import org.dao.*;
import org.service.*;
import org.model.*;
public class XsServiceManage implements XsService{
	//对XsDao和CjDao进行依赖注入
	private XsDao xsDao;
	private CjDao cjDao;
	/* 业务实现：学生信息查询 */
	public List findAll(int pageNow, int pageSize){		//显示所有学生信息
		return xsDao.findAll(pageNow, pageSize);
	}
	public int findXsSize(){						//查询一共有多少条学生记录
		return xsDao.findXsSize();
	}	
	/* 业务实现：查看某个学生的详细信息 */
	public Xsb find(String xh){					//根据学号查询某学生信息
		return xsDao.find(xh);
	}	
	/* 业务实现：删除某学生信息 */
	public void delete(String xh){					//根据学号删除学生
		
		cjDao.deleteOneXsCj(xh);				//删除学生的同时要删除该生对应的成绩
		xsDao.delete(xh);
	}	
	/* 业务实现：修改某学生信息 */
	public void update(Xsb xs){					//修改学生信息
		xsDao.update(xs);
	}	
	/* 业务实现：学生信息录入 */
	public void save(Xsb xs){					//插入学生
		xsDao.save(xs);
	}
	//省略XsDao和CjDao的getter/setter方法
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
