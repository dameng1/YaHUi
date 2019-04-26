package com.chinasofti.YaHui.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chinasofti.YaHui.dao.OrderDao;
import com.chinasofti.YaHui.domain.Address;
import com.chinasofti.YaHui.domain.Emp;
import com.chinasofti.YaHui.domain.Food;
import com.chinasofti.YaHui.domain.Order;
import com.chinasofti.YaHui.domain.Shopping;
import com.chinasofti.YaHui.util.DBUtil;

public class OrderDaoImpl implements OrderDao{
	DBUtil db;
	@Override
	public boolean addOrder(double oMonry, Emp emp, Address ads) {
		db=new DBUtil();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date=df.format(new Date());// new Date()为获取当前系统时间
		String sql="insert into ordertable values(order_seq.nextval,to_date(?,'yyyy-mm-dd'),?,?,?)";
		try {
			int i = db.update(sql,date,oMonry,emp.getEid(),ads.getAid());
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
	public boolean addShop(Food f,int fsnu) {
		db=new DBUtil();
		String sql="insert into shopping values(?,?,?)";
		try {
			int i = db.update(sql,f.getfName(),f.getfPrice(),fsnu);
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
	public boolean delShop() {
		db=new DBUtil();
		String sql="delete shopping";
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
	public boolean updateShop(String fname, int num) {
		db=new DBUtil();
		String sql="update shopping set fsnum=? where fname=?";
		try {
			int i = db.update(sql,num,fname);
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
	public List<Shopping> selectShop() {
		db=new DBUtil();
		String sql="select * from shopping";
		List<Shopping> list=new ArrayList<Shopping>();
		try {
			ResultSet rs = db.query(sql);
			while(rs.next()) {
				list.add(new Shopping(rs.getString("fname"), rs.getDouble("fprice"), rs.getInt("fsnum")));
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
	public Order ShowOrder() {
		int oid=0;
		List<Order> list = selectAllOrder();
		for (Order order : list) {
			if(order.getoID()>oid) {
				oid=order.getoID();
			}
		}
		db=new DBUtil();
		String sql="select * from ordertable where oid="+oid;
		try {
			ResultSet rs = db.query(sql);
			if(rs.next()) {
				return new Order(rs.getInt("oID"), rs.getDate("oDate"), rs.getDouble("oMoney"), new Emp(rs.getInt("eid"), null, null, null, 0, null, 0), new Address(rs.getInt("aid"), null));
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
	public List<Order> selectAllOrder() {
		db=new DBUtil();
		String sql="select * from ordertable";
		List<Order> list=new ArrayList<Order>();
		try {
			ResultSet rs = db.query(sql);
			while(rs.next()) {
				list.add(new Order(rs.getInt("oID"), rs.getDate("oDate"), rs.getDouble("oMoney"), new Emp(rs.getInt("eid"), null, null, null, 0, null, 0), new Address(rs.getInt("aid"), null)));
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
	public boolean delShopOne(String fname) {
		db=new DBUtil();
		String sql="delete from shopping where fname=?";
		try {
			int i = db.update(sql,fname);
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
	public int ShowOrder(int eid) {
		db=new DBUtil();
		String sql="select * from order where eid="+eid;
		List list=new ArrayList();
		try {
			ResultSet rs = db.query(sql);
			while(rs.next()) {
				list.add(rs.getInt("oid"));
			}
			return list.size();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
