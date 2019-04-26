package com.chinasofti.YaHui.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.YaHui.dao.PointDao;
import com.chinasofti.YaHui.util.DBUtil;

public class PointDaoImpl implements PointDao{
	DBUtil db;

	@Override
	public boolean addPoint(int cid) {
		db=new DBUtil();
		String sql="insert into point values(point_seq.nextval,?,0)";
		try {
			int i = db.update(sql,cid);
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
	public boolean delPoint(int cid) {
		db=new DBUtil();
		String sql="delete from point where cid="+cid;
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
	public boolean updatePoint(int cid, double point, boolean a) {
		double selectPoint = selectPoint(cid);
		db=new DBUtil();
		double p=0;
		if(a) {
			p=selectPoint+point;
		}else {
			p=selectPoint-point;
		}
		try {
			String sql="update point set point=? where cid="+cid;
			int i = db.update(sql,p);
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
	public double selectPoint(int cid) {
		db=new DBUtil();
		String sql="select point from point where cid="+cid;
		try {
			ResultSet rs = db.query(sql);
			if(rs.next()) {
				return rs.getDouble("point");
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
