package com.gs.tour.shxt.train.service;

import java.util.Map;

import com.gs.tour.shxt.train.dao.TrainDao;
import com.gs.tour.shxt.train.model.Train;
import com.gs.tour.shxt.base.model.PageBean;

public class TrainService {
	TrainDao trainDao=new TrainDao();
	/**查询机票列表*/
	public PageBean getAllTrainList(Train train,PageBean pageBean){
		return this.trainDao.getAllTrainList(train, pageBean);
	}
	/**添加
	 * @throws Exception */
	public void addTrain(Train train) throws Exception{
		Integer num=this.trainDao.addTrain(train);
		if(num<=0){
			throw new Exception("添加失败");
		}
	}
	/**更新*/
	public Train load(Integer train_id){
		Train train;
		try {
			train=this.trainDao.load(train_id);
			return train;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**编辑*/
	public void update(Train train){
		this.trainDao.update(train);
	}
	/**上传图片
	 * @throws s */
	public void upload(Map<String,Object> map) throws Exception{
		Integer num=this.trainDao.upload(map);
		if(num<=0){
			throw new Exception("上传失败");
		}
	}
	/**根据机票id获取机票*/
	public Train queryTrainByTrainId(Integer train_id){
		return this.trainDao.queryTrainByTrainId(train_id);
	}
	/**更改状态*/
	public Integer updateStatus(Integer train_id) throws Exception {
		Train train = this.trainDao.queryTrainByTrainId(train_id);
		Integer train_status = train.getTrain_status();
		if(train_status==1){
			train_status=0;
		}else{
			train_status=1;
		}
		this.trainDao.updateStatus(train_id, train_status);
		return train_status;
	}
}
