package com.chinasofti.YaHui.biz;

import java.util.List;

import com.chinasofti.YaHui.dao.OrderDao;
import com.chinasofti.YaHui.dao.impl.OrderDaoImpl;
import com.chinasofti.YaHui.domain.Address;
import com.chinasofti.YaHui.domain.Emp;
import com.chinasofti.YaHui.domain.Food;
import com.chinasofti.YaHui.domain.Order;
import com.chinasofti.YaHui.domain.Shopping;

public interface OrderBiz {
	//添加一个订单
	public String addOrder(double oMonry, Emp emp, Address ads);
	//向订单中添加菜
	public String addShop(Food f,int fsnu);
	//删除一个菜
	public String deleteOneFood(String fname);
	//修改一个菜的数量
	public String updateFoodNum(String fname,int num);
	//计算总价
	public double sumMoney();
	//打印小票
	public void show(int cid,double money);
	//显示购物车
	public List<Shopping> showShopping();
	//显示订单
	public Order showOrder();
	//显示订单数
	public int showOrderEmpNum(int eid);
}
