package com.chinasofti.YaHui.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.YaHui.dao.EmpDao;
import com.chinasofti.YaHui.domain.Address;
import com.chinasofti.YaHui.domain.Emp;
import com.chinasofti.YaHui.util.DBUtil;

public class EmpDaoImpl implements EmpDao{
	DBUtil db;

	public boolean addEmp(String ename,String epasswd,String sex,int epower,Address a) {
		db=new DBUtil();
		String sql="insert into emp values(emp_seq.nextval,?,?,?,?,?,10)";
		try {
			int i = db.update(sql, ename,epasswd,sex,epower,a.getAid());
			return i>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}finally {
			db.closed();
		}
		
	}

	public boolean deleteEmp(int eid) {
		db=new DBUtil();
		String sql="delete from emp where eid="+eid;
		try {
			int i = db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			db.closed();
		}
		
	}

	public boolean updateEmp(int eid,String ename,String passwd,String sex) {
		
		Emp ee = selectByid(eid);
		if(ee!=null) {
			db=new DBUtil();
			String sql="update emp set ename=?,epasswd=?,sex=? where eid="+eid;
			try {
				int i = db.update(sql,ename,passwd,sex);
				return i>0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}finally {
				db.closed();
			}
		}
		return false;
		
		
	}

	public List<Emp> selectAllEmp() {
		db=new DBUtil();
		List<Emp> list=new ArrayList<Emp>();
		String sql="select * from emp where epower=0";
		try {
			ResultSet rs = db.query(sql);
			while(rs.next()) {
				int aid = rs.getInt("aid");
				list.add(new Emp(rs.getInt("eid"), rs.getString("ename"), rs.getString("epasswd"), rs.getString("sex"), rs.getInt("epower"), new Address(aid,null),rs.getInt("assess")));
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

	public Emp selectByid(int id) {
		db=new DBUtil();
		String sql="select * from emp where eid="+id;
		try {
			ResultSet rs = db.query(sql);
			if(rs.next()) {
				int aid = rs.getInt("aid");
				return new Emp(rs.getInt("eid"), rs.getString("ename"), rs.getString("epasswd"), rs.getString("sex"), rs.getInt("epower"), new Address(aid,null),rs.getInt("assess"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			db.closed();
		}
		return null;
		
	}

	@Override
	public boolean updateEmpAssess(int eid, int assess) {
		Emp ee = selectByid(eid);
		if(ee!=null) {
			db=new DBUtil();
			String sql="update emp set assess="+assess+"where eid="+eid;
			try {
				int i = db.update(sql);
				return i>0;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.closed();
			}
		}
		return false;
	}

	@Override
	public boolean updateAddress(int eid, Address a) {
		db=new DBUtil();
		String sql="update emp set aid="+a.getAid()+"where eid="+eid;
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
	public boolean ifEmp(int eid, String passwd) {
		Emp emp = selectByid(eid);
		if(emp!=null) {
			if(emp.getEpasswd().equals(passwd)) {
				return true;
			}
		}
		return false;
	}

}
