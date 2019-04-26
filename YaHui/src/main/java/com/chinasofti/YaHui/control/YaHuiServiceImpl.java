package com.chinasofti.YaHui.control;

import java.util.List;

import com.chinasofti.YaHui.biz.AddressBiz;
import com.chinasofti.YaHui.biz.CardBiz;
import com.chinasofti.YaHui.biz.EmpBiz;
import com.chinasofti.YaHui.biz.FoodBiz;
import com.chinasofti.YaHui.biz.FoodTypeBiz;
import com.chinasofti.YaHui.biz.OrderBiz;
import com.chinasofti.YaHui.biz.VIPBiz;
import com.chinasofti.YaHui.biz.impl.AddressBizImpl;
import com.chinasofti.YaHui.biz.impl.CardBizImpl;
import com.chinasofti.YaHui.biz.impl.EmpBizImpl;
import com.chinasofti.YaHui.biz.impl.FoodBizImpl;
import com.chinasofti.YaHui.biz.impl.FoodTypeBizImpl;
import com.chinasofti.YaHui.biz.impl.OrderBizImpl;
import com.chinasofti.YaHui.biz.impl.VIPBizImpl;
import com.chinasofti.YaHui.domain.Address;
import com.chinasofti.YaHui.domain.Card;
import com.chinasofti.YaHui.domain.Emp;
import com.chinasofti.YaHui.domain.Food;
import com.chinasofti.YaHui.domain.FoodType;
import com.chinasofti.YaHui.domain.Order;
import com.chinasofti.YaHui.domain.Shopping;
import com.chinasofti.YaHui.domain.VIP;



public class YaHuiServiceImpl implements YaHuiService{
	CardBiz cb;
	EmpBiz eb;
	FoodBiz fb;
	FoodTypeBiz ftb;
	VIPBiz vb;
	OrderBiz ob;
	AddressBiz ab;

	public YaHuiServiceImpl() {
		super();
		this.cb = new CardBizImpl();
		this.eb = new EmpBizImpl();
		this.fb = new FoodBizImpl();
		this.ftb = new FoodTypeBizImpl();
		this.vb = new VIPBizImpl();
		this.ob=new OrderBizImpl();
		this.ab=new AddressBizImpl();
	}


	@Override
	public String addEmp(String ename, String epasswd, String sex, int epower, Address a) {
		String addEmp = eb.addEmp(ename, epasswd, sex, epower, a);
		return addEmp;
	}


	@Override
	public int ifEmpPower(int eid) {
		int ifEmpPower = eb.ifEmpPower(eid);
		return ifEmpPower;
	}


	@Override
	public String updateAssess(int eid, int assess, boolean aif) {
		String updateAssess = eb.updateAssess(eid, assess, aif);
		return updateAssess;
	}


	@Override
	public String updateImg(int eid, String ename, String passwd, String sex) {
		String updateImg = eb.updateImg(eid, ename, passwd, sex);
		return updateImg;
	}


	@Override
	public String updateAddress(int eid, Address a) {
		String updateAddress = eb.updateAddress(eid, a);
		return updateAddress;
	}


	@Override
	public String deleteEmp(int eid) {
		// TODO Auto-generated method stub
		return eb.deleteEmp(eid);
	}


	@Override
	public Emp findbyId(int eid) {
		// TODO Auto-generated method stub
		return eb.findbyId(eid);
	}


	@Override
	public List<Emp> findAll() {
		// TODO Auto-generated method stub
		return eb.findAll();
	}


	@Override
	public boolean ifEmp(int eid, String passwd) {
		// TODO Auto-generated method stub
		return eb.ifEmp(eid, passwd);
	}


	@Override
	public String addCard(String name, String cpasswd, int vid, double cmoney) {
		// TODO Auto-generated method stub
		return cb.addCard(name, cpasswd, vid, cmoney);
	}


	@Override
	public String deleteCard(int cid) {
		// TODO Auto-generated method stub
		return cb.deleteCard(cid);
	}


	@Override
	public String FreezeCard(int cid) {
		// TODO Auto-generated method stub
		return cb.FreezeCard(cid);
	}


	@Override
	public String AgainOwn(int cid) {
		// TODO Auto-generated method stub
		return cb.AgainOwn(cid);
	}


	@Override
	public String updateImgCard(int cid, String name, String passwd) {
		// TODO Auto-generated method stub
		return cb.updateImgCard(cid, name, passwd);
	}


	@Override
	public String updateCardMoney(int cid, double money, boolean a) {
		// TODO Auto-generated method stub
		return cb.updateCardMoney(cid, money, a);
	}


	@Override
	public String updateCardVip(int cid, int vid) {
		// TODO Auto-generated method stub
		return cb.updateCardVip(cid, vid);
	}


	@Override
	public List<Card> findAllCard() {
		// TODO Auto-generated method stub
		return cb.findAllCard();
	}


	@Override
	public boolean ifCard(int cid, String passed) {
		// TODO Auto-generated method stub
		return cb.ifCard(cid, passed);
	}


	@Override
	public String update(double discount, int vid) {
		// TODO Auto-generated method stub
		return vb.update(discount, vid);
	}


	@Override
	public List<VIP> findAllVIP() {
		// TODO Auto-generated method stub
		return vb.findAll();
	}


	@Override
	public List<Food> findFood(int typeid) {
		// TODO Auto-generated method stub
		return fb.findFood(typeid);
	}


	@Override
	public String addFood(String fname, double fprice, int typeid) {
		// TODO Auto-generated method stub
		return fb.addFood(fname, fprice, typeid);
	}


	@Override
	public String delFood(int fid) {
		// TODO Auto-generated method stub
		return fb.delFood(fid);
	}


	@Override
	public boolean delTypeFood(int typeid) {
		// TODO Auto-generated method stub
		return fb.delTypeFood(typeid);
	}


	@Override
	public String updateFoodName(int fid, String fname) {
		// TODO Auto-generated method stub
		return fb.updateFoodName(fid, fname);
	}


	@Override
	public String updateFoodPrice(int fid, double price) {
		// TODO Auto-generated method stub
		return fb.updateFoodPrice(fid, price);
	}


	@Override
	public String updateFoodNum(int fid, int num) {
		// TODO Auto-generated method stub
		return fb.updateFoodNum(fid, num);
	}


	@Override
	public Food findFoodById(int id) {
		// TODO Auto-generated method stub
		return fb.findFoodById(id);
	}


	@Override
	public Food NnmMax() {
		// TODO Auto-generated method stub
		return fb.NnmMax();
	}


	@Override
	public String addFoodType(String ftname) {
		// TODO Auto-generated method stub
		return ftb.addFoodType(ftname);
	}


	@Override
	public String delFoodType(int typeid) {
		// TODO Auto-generated method stub
		return ftb.delFoodType(typeid);
	}


	@Override
	public String updateTypeName(int typeid, String typename) {
		// TODO Auto-generated method stub
		return ftb.updateTypeName(typeid, typename);
	}


	@Override
	public List<FoodType> FindAllType() {
		// TODO Auto-generated method stub
		return ftb.FindAllType();
	}


	@Override
	public String addOrder(double oMonry, Emp emp, Address ads) {
		return ob.addOrder(oMonry, emp, ads);
	}


	@Override
	public String addShop(Food f, int fsnu) {
		// TODO Auto-generated method stub
		return ob.addShop(f, fsnu);
	}


	@Override
	public String deleteOneFood(String fname) {
		// TODO Auto-generated method stub
		return ob.deleteOneFood(fname);
	}


	@Override
	public String updateFoodNum(String fname, int num) {
		// TODO Auto-generated method stub
		return ob.updateFoodNum(fname, num);
	}


	@Override
	public double sumMoney() {
		// TODO Auto-generated method stub
		return ob.sumMoney();
	}


	@Override
	public void show(int cid, double money) {
		// TODO Auto-generated method stub
		ob.show(cid, money);
	}


	@Override
	public String FindAddressById(int aid) {
		
		return ab.FindAddressById(aid);
	}


	@Override
	public List<Address> FindAllAddress() {
		// TODO Auto-generated method stub
		return ab.FindAll();
	}


	@Override
	public List<Shopping> showShopping() {
		List<Shopping> list = ob.showShopping();
		return list;
	}


	@Override
	public Card ifCard(int cid) {
		
		return cb.ifCard(cid);
	}


	@Override
	public Order showOrder() {
		
		return ob.showOrder();
	}


	@Override
	public double selectPower(int vid) {
		// TODO Auto-generated method stub
		return vb.selectPower(vid);
	}


	@Override
	public Card ifCopyCard(int cid) {
		
		return cb.ifCopyCard(cid);
	}


	@Override
	public int showOrderEmpNum(int eid) {
		// TODO Auto-generated method stub
		return ob.showOrderEmpNum(eid);
	}


	@Override
	public String updatePoint(int cid, double point, boolean a) {
		
		return cb.updatePoint(cid, point, a);
	}


	@Override
	public double selectPoint(int cid) {
		// TODO Auto-generated method stub
		return cb.selectPoint(cid);
	}

	


}
