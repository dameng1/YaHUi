package com.chinasofti.YaHui.biz;

import java.util.List;

import com.chinasofti.YaHui.domain.Address;
import com.chinasofti.YaHui.domain.Emp;

public interface EmpBiz {
	//添加员工业务
	public String addEmp(String ename,String epasswd,String sex,int epower,Address a);
	//判断是普通员工还是经理
	public int ifEmpPower(int eid);
	//增加减少满意度业务
	public String updateAssess(int eid,int assess,boolean aif);
	//修改个人信息业务
	public String updateImg(int eid,String ename,String passwd,String sex);
	//修改员工地址业务
	public String updateAddress(int eid,Address a);
	//删除员工业务
	public String deleteEmp(int eid);
	//通过id查询员工
	public Emp findbyId(int eid);
	//查询所有员工
	public List<Emp> findAll();
	//判断id密码是否正确
	public boolean ifEmp(int eid,String passwd);

}
