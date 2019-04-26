package com.chinasofti.YaHui.dao;

import java.util.List;

import com.chinasofti.YaHui.domain.FoodType;

public interface FoodTyptDao {
	//增加种类
	public boolean addFoodType(String ftname);
	//删除种类(删除其中的菜)
	public boolean delFoodType(int typeid);
	//修改种类
	public boolean updateTypeName(int typeid,String typename);
	//查询所有种类
	public List<FoodType> FindAllType();
	//查询种类id是否存在
	public boolean ifFTypeId(int typeId);
	//查询种类名字是否存在
	public boolean ifFTypeName(String typeName);
}
