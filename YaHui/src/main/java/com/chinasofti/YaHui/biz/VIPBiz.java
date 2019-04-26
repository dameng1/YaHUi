package com.chinasofti.YaHui.biz;

import java.util.List;

import com.chinasofti.YaHui.domain.VIP;

public interface VIPBiz {
	//修改折扣
	public String update(double discount,int vid);
	//查询所有
	public List<VIP> findAll();
	//查询折扣
	public double selectPower(int vid);
}
