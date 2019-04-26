package com.chinasofti.YaHui.dao;

public interface PointDao {
	//添加一个卡积分
	public boolean addPoint(int cid);
	//删除一个卡积分
	public boolean delPoint(int cid);
	//修改一个卡积分
	public boolean updatePoint(int cid,double point,boolean a);
	//查询一个卡积分
	public double selectPoint(int cid);

}
