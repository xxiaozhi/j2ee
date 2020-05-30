package org.service.imp;
import java.util.*;
import org.dao.*;
import org.service.*;
import org.model.*;
public class CjServiceManage implements CjService{
	private CjDao cjDao;						//对CjDao进行依赖注入
	/* 业务实现：成绩信息录入 */
	public Cjb getXsCj(String xh, String kch){			//根据学号和课程号查询学生成绩
		return cjDao.getXsCj(xh, kch);
	}
	public void saveorupdateCj(Cjb cj){				//录入学生成绩
		cjDao.saveorupdateCj(cj);
	}	
	/* 业务实现：学生成绩查询 */
	public List findAllCj(int pageNow, int pageSize){	//分页显示所有学生成绩
		return cjDao.findAllCj(pageNow, pageSize);
	}
	public int findCjSize(){						//查询一共有多少条成绩记录
		return cjDao.findCjSize();
	}	
	/* 业务实现：查看某个学生的成绩表 */
	public List getXsCjList(String xh){				//获取某学生的成绩列表
		return cjDao.getXsCjList(xh);
	}	
	/* 业务实现：删除学生成绩 */
	public void deleteCj(String xh, String kch){		//根据学号和课程号删除学生成绩
		cjDao.deleteCj(xh, kch);
	}
	public void deleteOneXsCj(String xh){			//删除某学生的成绩（在删除该生信息时对应删除）
		cjDao.deleteOneXsCj(xh);
	}
	//省略CjDao的getter/setter方法
	public CjDao getCjDao() {
		return cjDao;
	}
	public void setCjDao(CjDao cjDao) {
		this.cjDao = cjDao;
	}
	
}
