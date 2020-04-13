package com.gs.tour.shxt.themed.service;

import java.util.Map;

import com.gs.tour.shxt.base.model.PageBean;
import com.gs.tour.shxt.themed.dao.ThemedDao;
import com.gs.tour.shxt.themed.model.Themed;

public class ThemedService {
	ThemedDao themedDao=new ThemedDao();
	/**查询主题列表*/
	public PageBean getAllThemedList(Themed themed,PageBean pageBean){
		return this.themedDao.getAllThemedList(themed, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addThemed(Themed themed) throws Exception{
		Integer num=this.themedDao.addThemed(themed);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Themed load(Integer themed_id){
		Themed themed;
		try {
			themed=this.themedDao.load(themed_id);
			return themed;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Themed themed){
		this.themedDao.update(themed);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.themedDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据主题id获取主题*/
	public Themed queryThemedByThemedId(Integer themed_id){
		return this.themedDao.queryThemedByThemedId(themed_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer themed_id) throws Exception {
		Themed themed = this.themedDao.queryThemedByThemedId(themed_id);
		Integer themed_status = themed.getThemed_status();
		if(themed_status==1){
			themed_status=0;
		}else{
			themed_status=1;
		}
		this.themedDao.updateStatus(themed_id, themed_status);
		return themed_status;
	}
}
