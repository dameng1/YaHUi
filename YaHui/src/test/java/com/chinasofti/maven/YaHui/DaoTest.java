package com.chinasofti.maven.YaHui;

import java.util.List;

import org.junit.Test;

import com.chinasofti.YaHui.dao.CardDao;
import com.chinasofti.YaHui.dao.EmpDao;
import com.chinasofti.YaHui.dao.PointDao;
import com.chinasofti.YaHui.dao.VIPDao;
import com.chinasofti.YaHui.dao.impl.CardDaoImpl;
import com.chinasofti.YaHui.dao.impl.EmpDaoImpl;
import com.chinasofti.YaHui.dao.impl.PointDaoImpl;
import com.chinasofti.YaHui.dao.impl.VIPDaoImpl;
import com.chinasofti.YaHui.domain.Address;
import com.chinasofti.YaHui.domain.Card;
import com.chinasofti.YaHui.domain.Emp;
import com.chinasofti.YaHui.domain.VIP;

public class DaoTest {
	EmpDao ed=new EmpDaoImpl();
	VIPDao vd=new VIPDaoImpl();
	CardDao cd=new CardDaoImpl();
	PointDao pd=new PointDaoImpl();
	@Test
	public void addEmp() {
		System.out.println(ed.addEmp("刘三姐", "qqqwww", "女", 0, new Address(10002,null)));
	}
	@Test
	public void findall() {
		List<Emp> list = ed.selectAllEmp();
		for (Emp emp : list) {
			System.out.println(emp);
		}
		
	}
	@Test
	public void find() {
		System.out.println(ed.selectByid(10006));
	}
	@Test
	public void updatename() {
		boolean updateEmp = ed.updateEmp(10002, "李瘦", "qqqwww", "女");
		System.out.println(updateEmp);
	}
	@Test
	public void updateassess() {
		boolean updateEmpAssess = ed.updateEmpAssess(10004, 10);
		System.out.println(updateEmpAssess);
	}
	@Test
	public void delete() {
		boolean deleteEmp = ed.deleteEmp(10006);
		System.out.println(deleteEmp);
	}
	@Test
	public void vsl() {
		List<VIP> finfAll = vd.finfAll();
		for (VIP vip : finfAll) {
			System.out.println(vip);
		}
	}
	@Test
	public void seld() {
		double cDiscount = vd.cDiscount(1);
		System.out.println(cDiscount);
	}
	@Test
	public void cselall() {
		List<Card> list = cd.findAll();
		for (Card card : list) {
			System.out.println(card);
		}
	}
	@Test
	public void cadd() {
		boolean a = cd.addCard("桥二狗","qqqwwww", 0, 10.26);
		System.out.println(a);
	}
	@Test
	public void cdel() {
		boolean a = cd.deleteCard(100000002);
		System.out.println(a);
	}
	@Test
	public void caddcopy() {
		cd.AddcopyCard(100000004);
	}
	@Test
	public void upmoney() {
		boolean a = cd.updateMoney(100000003, 5.64, false);
		System.out.println(a);
	}
	@Test
	public void upcimg() {
		cd.updateCardImg(100000002,"王胖子", "qqqwwww");
	}
	@Test
	public void upp() {
		cd.updateVipPower(100000003, 1);
	}
	@Test
	public void cfind() {
		System.out.println(cd.findByid(100000003).getCmoney());
	}
	@Test
	public void delcc() {
		cd.DelcopyCard(100000004);
	}
	@Test
	public void fincc() {
		System.out.println(cd.findByidCopy(100000004));
		
	}
	@Test
	public void fincc1() {
		
		System.out.println(ed.deleteEmp(10002));
		
	}
	@Test
	public void fincc2() {
		
		System.out.println(pd.selectPoint(100000059));
		
	}


}
