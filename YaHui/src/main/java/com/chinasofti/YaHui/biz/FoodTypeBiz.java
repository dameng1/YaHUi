package com.chinasofti.YaHui.biz;

import java.util.List;

import com.chinasofti.YaHui.domain.FoodType;

public interface FoodTypeBiz {
	//增加种类
	public String addFoodType(String ftname);
	//删除种类(删除其中的菜)
	public String delFoodType(int typeid);
	//修改种类
	public String updateTypeName(int typeid,String typename);
	//查询所有种类
	public List<FoodType> FindAllType();

}
