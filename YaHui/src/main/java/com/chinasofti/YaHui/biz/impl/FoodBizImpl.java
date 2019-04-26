package com.chinasofti.YaHui.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.YaHui.biz.FoodBiz;
import com.chinasofti.YaHui.dao.FoodDao;
import com.chinasofti.YaHui.dao.FoodTyptDao;
import com.chinasofti.YaHui.dao.impl.FoodDaoImpl;
import com.chinasofti.YaHui.dao.impl.FoodTypeDaoImpl;
import com.chinasofti.YaHui.domain.Food;

public class FoodBizImpl implements FoodBiz{
	FoodTyptDao ftd;
	FoodDao fd;

	public FoodBizImpl() {
		ftd=new FoodTypeDaoImpl();
		fd=new FoodDaoImpl();
	}

	@Override
	public List<Food> findFood(int typeid) {
		boolean a = ftd.ifFTypeId(typeid);
		if(a){
			List<Food> list = fd.findAllFood(typeid);
			return list;
		}
		return null;
	}

	@Override
	public String addFood(String fname, double fprice, int typeid) {
		boolean a = fd.addFood(fname,fprice,typeid);
		return a?"添加成功":"添加失败";
	}

	@Override
	public String delFood(int fid) {
		boolean a = fd.delFood(fid);
		return a?"删除成功":"删除失败";
	}

	@Override
	public boolean delTypeFood(int typeid) {
		
		return fd.delTypeFood(typeid);
		
	}

	@Override
	public String updateFoodName(int fid, String fname) {
		Food food = findFoodById(fid);
		if(food!=null) {
			boolean a = fd.updateFoodName(fid, fname);
			return a?"修改成功":"修改失败";
		}
		return "菜品不存在";
		
	}

	@Override
	public String updateFoodPrice(int fid, double price) {
		Food food = findFoodById(fid);
		if(food!=null) {
			boolean a = fd.updateFoodPrice(fid, price);
			return a?"修改成功":"修改失败";
		}
		return "菜品不存在";
		
	}

	@Override
	public String updateFoodNum(int fid, int num) {
		Food food = findFoodById(fid);
		if(food!=null) {
			boolean a = fd.updateFoodNum(fid, num);
			return a?"修改成功":"修改失败";
		}
		return "菜品不存在";
	}

	@Override
	public Food findFoodById(int id) {
		Food food = fd.findFoodById(id);
		return food;
	}

	@Override
	public Food NnmMax() {
		List<Food> list = fd.findAllFood();
		int num=0;
		Food f = null;
		for (Food food : list) {
			if(num<food.getfNum()) {
				num=food.getfNum();
				f=food;
			}
		}
		return f;
		
	}

}
