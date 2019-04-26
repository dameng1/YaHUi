package com.chinasofti.YaHui.biz.impl;

import java.util.List;

import com.chinasofti.YaHui.biz.VIPBiz;
import com.chinasofti.YaHui.dao.VIPDao;
import com.chinasofti.YaHui.dao.impl.VIPDaoImpl;
import com.chinasofti.YaHui.domain.VIP;

public class VIPBizImpl implements VIPBiz{
	VIPDao vd;
	

	public VIPBizImpl() {
		vd=new VIPDaoImpl();
	}


	@Override
	public String update(double discount, int vid) {
		boolean a = vd.updateDiscount(discount, vid);
		return a?"修改成功":"修改失败";
	}


	@Override
	public List<VIP> findAll() {
		List<VIP> list = vd.finfAll();
		return list;
	}


	@Override
	public double selectPower(int vid) {
		double cDiscount = vd.cDiscount(vid);
		return cDiscount;
	}

}
