package com.chinasofti.YaHui.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.YaHui.dao.FoodTyptDao;
import com.chinasofti.YaHui.domain.FoodType;
import com.chinasofti.YaHui.util.DBUtil;

public class FoodTypeDaoImpl implements FoodTyptDao{
	DBUtil db;
	@Override
	public boolean addFoodType(String ftname) {
		db=new DBUtil();
		String sql="insert into foodtype values(foodtype_seq.nextval,?)";
		try {
			int i = db.update(sql,ftname);
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
	public boolean delFoodType(int typeid) {
		db=new DBUtil();
		String sql="delete from foodtype where typeid="+typeid;
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
	public boolean updateTypeName(int typeid, String typename) {
		db=new DBUtil();
		String sql="update foodtype set typename=? where typeid=?";
		try {
			int i = db.update(sql,typename,typeid);
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
	public List<FoodType> FindAllType() {
		db=new DBUtil();
		String sql="select * from foodtype";
		List<FoodType> list=new ArrayList<FoodType>();
		try {
			ResultSet rs = db.query(sql);
			while(rs.next()) {
				list.add(new FoodType(rs.getInt("typeId"), rs.getString("typeName")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean ifFTypeId(int typeId) {
		List<FoodType> list = FindAllType();
		for (FoodType foodType : list) {
			if(foodType.getTypeId()==typeId) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean ifFTypeName(String typeName) {
		List<FoodType> list = FindAllType();
		for (FoodType foodType : list) {
			if(foodType.getTypeName().equals(typeName)) {
				return true;
			}
		}
		return false;
	}

}
