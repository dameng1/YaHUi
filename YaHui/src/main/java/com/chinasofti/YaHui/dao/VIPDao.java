package com.chinasofti.YaHui.dao;

import java.util.List;

import com.chinasofti.YaHui.domain.Card;
import com.chinasofti.YaHui.domain.VIP;

public interface VIPDao {
	//修改会员等级的折扣额度
	public boolean updateDiscount(double discount,int vid);
	//查询所有
	public List<VIP> finfAll();
	//查询折扣
	public double cDiscount(int vid);
}
