package com.chinasofti.YaHui.biz.impl;

import java.util.List;

import javax.sound.sampled.LineListener;

import com.chinasofti.YaHui.biz.EmpBiz;
import com.chinasofti.YaHui.dao.EmpDao;
import com.chinasofti.YaHui.dao.impl.EmpDaoImpl;
import com.chinasofti.YaHui.domain.Address;
import com.chinasofti.YaHui.domain.Emp;

public class EmpBizImpl implements EmpBiz{
	EmpDao ed;
	

	public EmpBizImpl() {
		this.ed = new EmpDaoImpl();
	}

	@Override
	public String addEmp(String ename, String epasswd, String sex, int epower, Address a) {
		boolean addEmp = ed.addEmp(ename, epasswd, sex, epower, a);
		return addEmp?"添加成功":"添加失败";
	}

	@Override
	public int ifEmpPower(int eid) {
		Emp emp = ed.selectByid(eid);
		if(emp!=null) {
			return emp.getEpower();
		}
		return 000;
	}

	@Override
	public String updateAssess(int eid,int assess,boolean aif) {
		Emp emp = ed.selectByid(eid);
		if(aif) {
			boolean a = ed.updateEmpAssess(eid, emp.getAssess()+assess);
			return a?"满意度提升成功，感谢您的配合":"满意度提升失败，感谢您的配合";
		}else {
			boolean a = ed.updateEmpAssess(eid, emp.getAssess()-assess);
			return a?"满意度降低成功，感谢您的配合":"满意度降低失败，感谢您的配合";
		}
		
		
	}

	@Override
	public String updateImg(int eid, String ename, String passwd, String sex) {
		Emp emp = ed.selectByid(eid);
		if(emp!=null) {
			boolean aa = ed.updateEmp(eid, ename, passwd, sex);
			return aa?"个人信息修改成功":"人信息修改失败";
		}
		return "员工不存在";
	}

	@Override
	public String deleteEmp(int eid) {
		Emp emp = ed.selectByid(eid);
		if(emp!=null) {
			boolean aa = ed.deleteEmp(eid);
			return aa?"删除成功":"删除失败";
		}
		return "员工号不存在";
	}

	@Override
	public Emp findbyId(int eid) {
		Emp emp = ed.selectByid(eid);
		return emp;
	}

	@Override
	public List<Emp> findAll() {
		List<Emp> list=ed.selectAllEmp();
		return list;
	}

	@Override
	public String updateAddress(int eid, Address a) {
		Emp emp = ed.selectByid(eid);
		if(emp!=null){
			boolean aa = ed.updateAddress(eid, a);
			return aa?"修改成功":"修改失败";
		}
		
		return "用户不存在";
	}

	@Override
	public boolean ifEmp(int eid, String passwd) {
		return ed.ifEmp(eid, passwd);
	    
	}

}
