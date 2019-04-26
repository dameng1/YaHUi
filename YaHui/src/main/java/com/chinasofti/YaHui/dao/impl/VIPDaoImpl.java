package com.chinasofti.YaHui.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.YaHui.dao.VIPDao;
import com.chinasofti.YaHui.domain.Card;
import com.chinasofti.YaHui.domain.VIP;
import com.chinasofti.YaHui.util.DBUtil;

public class VIPDaoImpl implements VIPDao{
	DBUtil db;
	@Override
	public boolean updateDiscount(double discount,int vid) {
		db=new DBUtil();
		String sql="update vip set vdiscount="+discount+"where vid="+vid;
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
	public List<VIP> finfAll() {

		db=new DBUtil();
		String sql="select * from vip";
		List<VIP> list =new ArrayList<VIP>();
		try {
			ResultSet rs = db.query(sql);
			while(rs.next()) {
				list.add(new VIP(rs.getInt("vid"), rs.getString("vname"), rs.getDouble("vdiscount")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return null;
	}

	@Override
	public double cDiscount(int vid) {
		db=new DBUtil();
		String sql="select vdiscount from vip where vid="+vid;
		try {
			ResultSet rs = db.query(sql);
			if(rs.next()) {
				return rs.getDouble("vdiscount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return 0;
	}

}
