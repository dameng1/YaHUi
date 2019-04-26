package com.chinasofti.YaHui.dao;

import java.util.List;

import com.chinasofti.YaHui.domain.Address;

public interface AddressDao {
	public String findAddressByid(int id);
	public List<Address> findAddress();
}
