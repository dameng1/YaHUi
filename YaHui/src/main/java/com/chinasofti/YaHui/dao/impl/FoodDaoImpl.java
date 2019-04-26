package com.chinasofti.YaHui.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.YaHui.dao.FoodDao;
import com.chinasofti.YaHui.domain.Food;
import com.chinasofti.YaHui.domain.FoodType;
import com.chinasofti.YaHui.util.DBUtil;

public class FoodDaoImpl implements FoodDao{
	DBUtil db;
	@Override
	public boolean addFood(String fname, double fprice, int typeid) {
		db=new DBUtil();
		String sql="insert into food values(food_seq.nextval,?,?,0,?)";
		try {
			int i = db.update(sql,fname,fprice,typeid);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return false;
	}

	@Override
	public boolean delFood(int fid) {
		db=new DBUtil();
		String sql="delete from food where fid="+fid;
		try {
			int i = db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return false;
	}

	@Override
	public boolean updateFoodName(int fid, String fname) {
		db=new DBUtil();
		String sql="update food set fname=? where fid=?";
		try {
			int i = db.update(sql,fname,fid);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return false;
	}

	@Override
	public boolean updateFoodPrice(int fid, double price) {
		db=new DBUtil();
		String sql="update food set fprice=? where fid=?";
		try {
			int i = db.update(sql,price,fid);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return false;
	}

	@Override
	public boolean updateFoodNum(int fid, int num) {
		
		Food food = findFoodById(fid);
		num=food.getfNum()+num;
		db=new DBUtil();
		String sql="update food set fnum=? where fid=?";
		try {
			int i = db.update(sql,num,fid);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return false;
	}

	@Override
	public List<Food> findAllFood(int typeid) {
		db=new DBUtil();
		List<Food> list=new ArrayList<Food>();
		String sql="select * from food where typeid="+typeid;
		try {
			ResultSet rs = db.query(sql);
			while(rs.next()) {
				list.add(new Food(rs.getInt("fId"), rs.getString("fName"), rs.getDouble("fPrice"), rs.getInt("fNum"), new FoodType(rs.getInt("typeid"),null)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Food findFoodById(int id) {
		db=new DBUtil();
		String sql="select * from food where fid="+id;
		try {
			ResultSet rs = db.query(sql);
			if(rs.next()) {
				return new Food(rs.getInt("fId"), rs.getString("fName"), rs.getDouble("fPrice"), rs.getInt("fNum"), new FoodType(rs.getInt("typeid"),null));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delTypeFood(int typeid) {
		db=new DBUtil();
		String sql="delete from food where typeid="+typeid;
		try {
			int i = db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return false;
	}

	@Override
	public List<Food> findAllFood() {
		db=new DBUtil();
		List<Food> list=new ArrayList<Food>();
		String sql="select * from food";
		try {
			ResultSet rs = db.query(sql);
			while(rs.next()) {
				list.add(new Food(rs.getInt("fId"), rs.getString("fName"), rs.getDouble("fPrice"), rs.getInt("fNum"), new FoodType(rs.getInt("typeid"),null)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
