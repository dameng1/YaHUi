package com.chinasofti.YaHui.biz.impl;

import java.util.List;

import com.chinasofti.YaHui.biz.OrderBiz;
import com.chinasofti.YaHui.dao.AddressDao;
import com.chinasofti.YaHui.dao.CardDao;
import com.chinasofti.YaHui.dao.EmpDao;
import com.chinasofti.YaHui.dao.FoodDao;
import com.chinasofti.YaHui.dao.OrderDao;
import com.chinasofti.YaHui.dao.VIPDao;
import com.chinasofti.YaHui.dao.impl.AddressDaoImpl;
import com.chinasofti.YaHui.dao.impl.CardDaoImpl;
import com.chinasofti.YaHui.dao.impl.EmpDaoImpl;
import com.chinasofti.YaHui.dao.impl.FoodDaoImpl;
import com.chinasofti.YaHui.dao.impl.OrderDaoImpl;
import com.chinasofti.YaHui.dao.impl.VIPDaoImpl;
import com.chinasofti.YaHui.domain.Address;
import com.chinasofti.YaHui.domain.Card;
import com.chinasofti.YaHui.domain.Emp;
import com.chinasofti.YaHui.domain.Food;
import com.chinasofti.YaHui.domain.Order;
import com.chinasofti.YaHui.domain.Shopping;

public class OrderBizImpl implements OrderBiz{
	OrderDao od;
	FoodDao fd;
	AddressDao ad;
	CardDao cd;
	VIPDao vd;
	EmpDao ed;
	public OrderBizImpl() {
		super();
		this.od = new OrderDaoImpl();
		this.fd=new FoodDaoImpl();
		this.ad=new AddressDaoImpl();
		this.cd=new CardDaoImpl();
		this.vd=new VIPDaoImpl();
		this.ed=new EmpDaoImpl();
	}

	@Override
	public String addOrder(double oMonry, Emp emp, Address ads) {
		od.delShop();
		boolean a = od.addOrder(oMonry, emp, ads);
		return a?"添加成功":"添加失败";
	
	}

	@Override
	public String addShop(Food f, int fsnu) {
		boolean a = od.addShop(f, fsnu);
		return a?"添加成功":"添加失败";
	}

	@Override
	public String deleteOneFood(String fname) {
		boolean a = od.delShopOne(fname);
		return a?"删除成功":"删除失败";
	}

	@Override
	public String updateFoodNum(String fname, int num) {
		boolean a = od.updateShop(fname, num);
		return a?"修改成功":"修改失败";
	}

	@Override
	public void show(int cid,double money) {
		Order order = od.ShowOrder();
		Address a = order.getAddress();
		String address = ad.findAddressByid(a.getAid());
		System.out.println(address+"----欢迎光临----");
		System.out.println("今天是："+order.getoDate());
		System.out.println("员工"+order.getEmp().getEid()+"为您服务");
		System.out.println("===============================");
		System.out.println("商品名称\t商品单价\t购买数量");
		List<Shopping> list = od.selectShop();
		for (Shopping shopping : list) {
			System.out.println(shopping);
		}
		double sumMoney = sumMoney();
		System.out.println("===============================");
		Card card = cd.findByid(cid);
		double cDiscount = vd.cDiscount(card.getVip().getVid());
		System.out.print("应收："+sumMoney*cDiscount);
		System.out.println("折扣为："+cDiscount);
		System.out.print("实收："+money);
		double Ymoney=sumMoney*cDiscount;
		System.out.println("找零："+(money-Ymoney));
		System.out.println("=============谢谢惠顾============");

	}

	@Override
	public double sumMoney() {
		List<Shopping> list = od.selectShop();
		double sum=0;
		for (Shopping shopping : list) {
			sum=shopping.getFprice()*shopping.getFsnum()+sum;
		}
		return sum;
	}

	@Override
	public List<Shopping> showShopping() {
		List<Shopping> list = od.selectShop();
		return list;
	}

	@Override
	public Order showOrder() {
		Order order = od.ShowOrder();
		return order;
	}

	@Override
	public int showOrderEmpNum(int eid) {
		if(ed.selectByid(eid)!=null) {
			int num = od.ShowOrder(eid);
			return num;
		}
		
		return 0;
	}


}
