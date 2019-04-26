package com.chinasofti.YaHui.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.YaHui.dao.CardDao;
import com.chinasofti.YaHui.domain.Card;
import com.chinasofti.YaHui.domain.VIP;
import com.chinasofti.YaHui.util.DBUtil;

public class CardDaoImpl implements CardDao{
	DBUtil db;

	@Override
	public boolean addCard(String name,String cpasswd,int vid,double cmoney) {
		db=new DBUtil();
		String sql="insert into card values(card_seq.nextval,?,?,?,?)";
		try {
			int i = db.update(sql,name,cpasswd,vid,cmoney);
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
	public boolean deleteCard(int cid) {
		db=new DBUtil();
		String sql="delete from card where cid="+cid;
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
	public boolean AddcopyCard(int cid) {
		db=new DBUtil();
		String sql="insert into card_copy select * from card where cid="+cid;
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
	public boolean updateMoney(int cid, double money, boolean a) {
		Card card = findByid(cid);
		double cmoney;
		String sql="update card set cmoney=? where cid="+cid;
		if(a==true) {
			cmoney=money+card.getCmoney();
		}else {
			cmoney=card.getCmoney()-money;
			if(cmoney<0) {
				return false;
			}else {
				
			}
		}
		db=new DBUtil();
		try {
			int i = db.update(sql,cmoney);
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
	public boolean updateVipPower(int cid, int vid) {
		db=new DBUtil();
		String sql="update card set vid="+vid+" where cid="+cid;
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
	public boolean updateCardImg(int cid,String name,String passwd) {
		db=new DBUtil();
		String sql="update card set username=?,cpasswd=? where cid="+cid;
		try {
			int i = db.update(sql,name,passwd);
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
	public List<Card> findAll() {
		db=new DBUtil();
		String sql="select * from card";
		List<Card> list=new ArrayList<Card>();
		try {
			ResultSet rs = db.query(sql);
			while(rs.next()) {
				list.add(new Card(rs.getInt("cid"), rs.getString("username"),rs.getString("cpasswd"),new VIP(rs.getInt("vid"), null, 0) , rs.getDouble("cmoney")));	
			}
			return list;
		} 
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return null;
	}

	@Override
	public Card findByid(int cid) {
		db=new DBUtil();
		String sql="select * from card where cid="+cid;
		try {
			ResultSet rs = db.query(sql);
			if(rs.next()) {
				return new Card(rs.getInt("cid"),rs.getString("username"),rs.getString("cpasswd"),new VIP(rs.getInt("vid"), null, 0) , rs.getDouble("cmoney"));
			}
		} 
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return null;
	}

	@Override
	public boolean DelcopyCard(int cid) {
		db=new DBUtil();
		String sql="delete from card_copy where cid="+cid;
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
	public Card findByidCopy(int cid) {
		db=new DBUtil();
		String sql="select * from card_copy where cid="+cid;
		try {
			ResultSet rs = db.query(sql);
			if(rs.next()) {
				return new Card(rs.getInt("cid"),rs.getString("username"),rs.getString("cpasswd"),new VIP(rs.getInt("vid"), null, 0) , rs.getDouble("cmoney"));
			}
		} 
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return null;
	}


}
