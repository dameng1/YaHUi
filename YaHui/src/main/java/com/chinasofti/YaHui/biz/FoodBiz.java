package com.chinasofti.YaHui.biz;

import java.util.List;

import com.chinasofti.YaHui.domain.Food;

public interface FoodBiz {
	//通过种类id查询所有菜
	public List<Food> findFood(int typeid);
	//添加菜品
	public String addFood(String fname,double fprice,int typeid);
	//删除菜品
	public String delFood(int fid);
	//删除菜品根据类型
	public boolean delTypeFood(int typeid);
	//修改菜名
	public String updateFoodName(int fid,String fname);
	//修改价格
	public String updateFoodPrice(int fid,double price);
	//修改数量
	public String updateFoodNum(int fid,int num);
	//根据id查询菜
	public Food findFoodById(int id);
	//查询数量最多的菜
	public Food NnmMax();
}
