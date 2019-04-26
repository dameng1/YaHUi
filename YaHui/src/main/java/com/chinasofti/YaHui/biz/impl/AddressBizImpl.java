package com.chinasofti.YaHui.biz.impl;

import java.util.List;

import com.chinasofti.YaHui.biz.AddressBiz;
import com.chinasofti.YaHui.dao.AddressDao;
import com.chinasofti.YaHui.dao.impl.AddressDaoImpl;
import com.chinasofti.YaHui.domain.Address;

public class AddressBizImpl implements AddressBiz{
	AddressDao ad;
	

	public AddressBizImpl() {
		super();
		this.ad = new AddressDaoImpl();
	}

	@Override
	public String FindAddressById(int aid) {
		String a = ad.findAddressByid(aid);
		return a;
	}

	@Override
	public List<Address> FindAll() {
		List<Address> list = ad.findAddress();
		return list;
	}

}
