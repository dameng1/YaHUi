package com.chinasofti.YaHui.biz;

import java.util.List;

import com.chinasofti.YaHui.domain.Address;

public interface AddressBiz {
	//通过id查询地址
	public String FindAddressById(int aid);
	//显示所有
	public List<Address> FindAll();

}
