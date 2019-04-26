package com.chinasofti.YaHui.dao;

import java.util.List;

import com.chinasofti.YaHui.domain.Address;
import com.chinasofti.YaHui.domain.Emp;

public interface EmpDao {
	//增加员工
	public boolean addEmp(String ename,String epasswd,String sex,int epower,Address a);
	//删除员工
	public boolean deleteEmp(int eid);
	//修改员工个人信息
	public boolean updateEmp(int eid,String ename,String passwd,String sex);
	//修改员工满意度
	public boolean updateEmpAssess(int eid,int assess);
	//修改员工地址
	public boolean updateAddress(int eid,Address a);
	//查询所有员工
	public List<Emp> selectAllEmp();
	//通过id查询员工
	public Emp selectByid(int id);
	//验证账号密码是否正确
	public boolean ifEmp(int eid,String passwd);
}
