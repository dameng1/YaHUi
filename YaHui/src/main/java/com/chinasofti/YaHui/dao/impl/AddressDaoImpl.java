package com.chinasofti.YaHui.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.YaHui.dao.AddressDao;
import com.chinasofti.YaHui.domain.Address;
import com.chinasofti.YaHui.util.DBUtil;

public class AddressDaoImpl implements AddressDao{

	@Override
	public String findAddressByid(int id) {
		DBUtil db=new DBUtil();
		String sql="select address from address where aid="+id;
		try {
			ResultSet rs = db.query(sql);
			if(rs.next()) {
				return rs.getString("address");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return null;
	}

	@Override
	public List<Address> findAddress() {
		DBUtil db=new DBUtil();
		String sql="select * from address";
		List<Address> list=new ArrayList<Address>();
		try {
			ResultSet rs = db.query(sql);
			while(rs.next()) {
				list.add(new Address(rs.getInt("aid"), rs.getString("address")));
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

}
