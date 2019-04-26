package com.chinasofti.YaHui.biz.impl;

import java.util.List;

import com.chinasofti.YaHui.biz.FoodTypeBiz;
import com.chinasofti.YaHui.dao.FoodDao;
import com.chinasofti.YaHui.dao.FoodTyptDao;
import com.chinasofti.YaHui.dao.impl.FoodDaoImpl;
import com.chinasofti.YaHui.dao.impl.FoodTypeDaoImpl;
import com.chinasofti.YaHui.domain.Food;
import com.chinasofti.YaHui.domain.FoodType;

public class FoodTypeBizImpl implements FoodTypeBiz{
	FoodTyptDao ftd;
	FoodDao fd;

	public FoodTypeBizImpl() {
		ftd=new FoodTypeDaoImpl();
		fd=new FoodDaoImpl();
	}

	@Override
	public String addFoodType(String ftname) {
		
		boolean b = ftd.addFoodType(ftname);
		return b?"添加成功":"添加失败";
	}

	@Override
	public String delFoodType(int typeid) {
		boolean a = ftd.ifFTypeId(typeid);
		if(a) {
			fd.delTypeFood(typeid);
			boolean c = ftd.delFoodType(typeid);
			return c?"删除成功":"删除失败";
		}
		
		return "类型id不存在";
	}

	@Override
	public String updateTypeName(int typeid, String typename) {
		boolean a = ftd.ifFTypeId(typeid);
		if(a==true) {
			boolean b = ftd.updateTypeName(typeid, typename);
			return b?"修改成功":"修改失败";
		}
		return "类型id不存在";
	}

	@Override
	public List<FoodType> FindAllType() {
		List<FoodType> list = ftd.FindAllType();
		return list;
	}

}
