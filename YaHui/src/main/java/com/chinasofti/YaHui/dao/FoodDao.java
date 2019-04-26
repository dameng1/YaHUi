package com.chinasofti.YaHui.dao;

import java.util.List;

import com.chinasofti.YaHui.domain.Food;

public interface FoodDao {
	//添加菜品
	public boolean addFood(String fname,double fprice,int typeid);
	//删除菜品
	public boolean delFood(int fid);
	//删除菜品根据类型
	public boolean delTypeFood(int typeid);
	//修改菜名
	public boolean updateFoodName(int fid,String fname);
	//修改价格
	public boolean updateFoodPrice(int fid,double price);
	//修改数量
	public boolean updateFoodNum(int fid,int num);
	//根据菜类型查询所有菜
	public List<Food> findAllFood(int typeid);
	//根据id查询菜
	public Food findFoodById(int id);
	//查询所有菜
	public List<Food> findAllFood();
}
