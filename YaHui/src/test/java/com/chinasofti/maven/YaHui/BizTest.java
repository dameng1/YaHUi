package com.chinasofti.maven.YaHui;

import java.util.List;

import org.junit.Test;

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
import com.chinasofti.YaHui.domain.VIP;

public class BizTest {
	EmpBiz eb=new EmpBizImpl();
	VIPBiz vb=new VIPBizImpl();
	CardBiz cb=new CardBizImpl();
	FoodBiz fb=new FoodBizImpl();
	OrderBiz ob=new OrderBizImpl();
	FoodTypeBiz ftb=new FoodTypeBizImpl();
	@Test
	public void add() {
		String addEmp = eb.addEmp("小胖","qqqwww","男",1,new Address(10003,null));
		System.out.println(addEmp);
	}
	@Test
	public void ifass() {
		int ifEmpPower = eb.ifEmpPower(10005);
		System.out.println(ifEmpPower);
	}
	@Test
	public void upd() {
		String updateAssess = eb.updateAssess(10002, 1, true);
		System.out.println(updateAssess);
	}
	@Test
	public void updw() {
		eb.updateImg(10003, "王刚", "qqqwww", "男");
	}
	@Test
	public void del() {
		String deleteEmp = eb.deleteEmp(10008);
		System.out.println(deleteEmp);
	}
	@Test
	public void find() {
		List<Emp> findAll = eb.findAll();
		for (Emp emp : findAll) {
			System.out.println(emp);
		}
		
	}
	@Test
	public void sele() {
		String a = eb.updateAddress(10005, new Address(10002,null));
		System.out.println(a);
		
	}
	@Test
	public void vsele() {
		List<VIP> list = vb.findAll();
		for (VIP vip : list) {
			System.out.println(vip);
		}
		
	}
	@Test
	public void cfin() {
		List<Card> list = cb.findAllCard();
		for (Card card : list) {
			System.out.println(card);
		}
		
	}
	@Test
	public void cadd() {
		String a = cb.addCard("李二狗", "qqqwww", 1, 900);
		System.out.println(a);
	}
	@Test
	public void cdel() {
		String a = cb.deleteCard(100000007);
		System.out.println(a);
	}
	@Test
	public void cdef() {
		String a = cb.FreezeCard(100000025);
		System.out.println(a);
	}
	@Test
	public void cjdef() {
		String a = cb.AgainOwn(100000025);
		System.out.println(a);
	}
	@Test
	public void cup() {
		String a = cb.updateImgCard(100000026, "苏大庆", "qqqwww");
		System.out.println(a);
	}
	@Test
	public void cup1() {
		String a = cb.updateCardMoney(100000026, 900, true);
		System.out.println(a);
	}
	@Test
	public void cup2() {
		String a = cb.updateCardVip(100000030, 0);
		System.out.println(a);
	}
	@Test
	public void if2() {
		boolean a = cb.ifCard(100000030, "qqqwww");
		System.out.println(a);
	}
	@Test
	public void food1() {
		fb.addFood("凉拌土豆丝", 5.9, 4);
	}
	@Test
	public void food2() {
		List<Food> list = fb.findFood(4);
		for (Food food : list) {
			System.out.println(food);
		}
	}
	@Test
	public void food3() {
		fb.delFood(21);
	}
	@Test
	public void food4() {
		fb.updateFoodName(12, "地三鲜");
	}
	@Test
	public void food5() {
		fb.updateFoodPrice(19, 8.21);
	}
	@Test
	public void food6() {
		fb.updateFoodNum(10, 8);
	}
	@Test
	public void food7() {
		List<Food> list = fb.findFood(3);
		for (Food food : list) {
			System.out.println(food);
		}
	}
	@Test
	public void food8() {
		System.out.println(fb.findFoodById(12));
		
	}
	@Test
	public void food9() {
		fb.delTypeFood(4);
		
	}
	@Test
	public void foodtype1() {
		List<FoodType> list = ftb.FindAllType();
		for (FoodType foodType : list) {
			System.out.println(foodType);
		}
		
	}
	@Test
	public void foodtype2() {
		ftb.addFoodType("青菜");
	}
	@Test
	public void foodtype3() {
		ftb.delFoodType(5);
	}
	@Test
	public void foodtype4() {
		System.out.println(ftb.updateTypeName(5, "开心"));
	}
	@Test
	public void foodtype5() {
		System.out.println(ftb.updateTypeName(5, "开心"));
	}
	@Test
	public void foodnax() {
		System.out.println(fb.NnmMax());
		
	}
	@Test
	public void order1() {
		System.out.println(ob.addOrder(163.5, new Emp(10009), new Address(10001, null)));
		
	}
	@Test
	public void order2() {
		ob.addShop(new Food(4, "鱼香肉丝", 23.5), 1);
		
	}
	@Test
	public void order3() {
		ob.deleteOneFood("鱼香肉丝");
		
	}
	@Test
	public void order4() {
		System.out.println(ob.updateFoodNum("馒头", 3));
		
	}
	@Test
	public void order5() {
		ob.show(100000032, 500);
		
	}
	@Test
	public void order6() {
		System.out.println(ob.sumMoney());
		
	}
	@Test
	public void order7() {
		AddressBiz ab=new AddressBizImpl();
		List<Address> list = ab.FindAll();
		for (Address address : list) {
			System.out.println(address);
		}
		
	}
	@Test
	public void order8() {
		fb.updateFoodNum(5, 1);
		
	}
	@Test
	public void order9() {
		ob.addShop(new Food(11, "大闸蟹", 105), 2);
		
	}
	@Test
	public void card1() {
		String addCard = cb.addCard("萧炎", "qqqwww", 1, 1200);
		System.out.println(addCard);
		
	}
	@Test
	public void card2() {
		String addCard = cb.FreezeCard(100000049);
		System.out.println(addCard);
		
	}
	@Test
	public void card3() {
		String addCard = cb.deleteCard(100000047);
		System.out.println(addCard);
		
	}
	@Test
	public void card4() {
		String addCard = cb.AgainOwn(100000057);
		System.out.println(addCard);
		
	}
	@Test
	public void card5() {
		String addCard = cb.updatePoint(100000049, 250, true);
		System.out.println(addCard);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
