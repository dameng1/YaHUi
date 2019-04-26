package com.chinasofti.YaHui.dao;

import java.util.Date;
import java.util.List;

import com.chinasofti.YaHui.domain.Shopping;
import com.chinasofti.YaHui.domain.Address;
import com.chinasofti.YaHui.domain.Emp;
import com.chinasofti.YaHui.domain.Food;
import com.chinasofti.YaHui.domain.Order;

public interface OrderDao {
	//增加一个订单
	public boolean addOrder(double oMonry,Emp emp,Address ads);
	//添加数据到购物车
	public boolean addShop(Food f,int fsnu);
	//删除购物车数据
	public boolean delShop();
	//删除购物车数据
	public boolean delShopOne(String fname);
	//修改购物车数据数量
	public boolean updateShop(String fname,int num);
	//查询购物车
	public List<Shopping> selectShop();
	//查询所有订单
	public List<Order> selectAllOrder();
	//查询订单
	public Order ShowOrder();
	//查看员工下所有订单
	public int ShowOrder(int eid);
	

}
