package com.chinasofti.YaHui.biz.impl;

import java.util.List;

import com.chinasofti.YaHui.biz.CardBiz;
import com.chinasofti.YaHui.dao.CardDao;
import com.chinasofti.YaHui.dao.PointDao;
import com.chinasofti.YaHui.dao.impl.CardDaoImpl;
import com.chinasofti.YaHui.dao.impl.PointDaoImpl;
import com.chinasofti.YaHui.domain.Card;

public class CardBizImpl implements CardBiz{
	CardDao cd;
	PointDao pd;
	

	public CardBizImpl() {
		cd=new CardDaoImpl();
		pd=new PointDaoImpl();
	}

	@Override
	public String addCard(String name, String cpasswd, int vid, double cmoney) {
		boolean a = cd.addCard(name, cpasswd, vid, cmoney);
		List<Card> list = findAllCard();
		int cid=0;
		for (Card card : list) {
			if(card.getCid()>cid) {
				cid=card.getCid();
			}
		}
		boolean b = pd.addPoint(cid);
		return a&b?"添加成功":"添加失败";
	}

	@Override
	public String deleteCard(int cid) {
		boolean b = pd.delPoint(cid);
		boolean a = cd.deleteCard(cid);
		return a&b?"删除成功":"删除失败";
	}

	@Override
	public String FreezeCard(int cid) {
		boolean a = cd.AddcopyCard(cid);
		deleteCard(cid);
		return a?"冻结成功":"冻结失败";

	}

	@Override
	public String AgainOwn(int cid) {
		Card card = cd.findByidCopy(cid);
		
		if(card!=null) {
			addCard(card.getUsername(), card.getCpasswd(), card.getVip().getVid(), card.getCmoney());
			boolean b = cd.DelcopyCard(cid);
			return b?"补卡成功":"补卡失败";
		}
		return "卡号不存在";
	}

	@Override
	public String updateImgCard(int cid, String name, String passwd) {
		
		Card card = cd.findByid(cid);
		if(card!=null) {
			boolean a = cd.updateCardImg(cid, name, passwd);
			return a?"修改成功":"修改失败";
		}
		return "卡号不存在";
	}

	@Override
	public String updateCardMoney(int cid, double money, boolean a) {
		Card card = cd.findByid(cid);
		if(card!=null) {
			boolean aa = cd.updateMoney(cid, money, a);
			return aa?"修改成功":"修改失败";
		}
		return "卡号不存在";
		
	}

	@Override
	public String updateCardVip(int cid, int vid) {
		Card card = cd.findByid(cid);
		if(card!=null) {
			boolean a = cd.updateVipPower(cid, vid);
			return a?"修改成功":"修改失败";
		}
		return "卡号不存在";
	}

	@Override
	public List<Card> findAllCard() {
		List<Card> list = cd.findAll();
		return list;
	}

	@Override
	public boolean ifCard(int cid, String passed) {
		Card card = cd.findByid(cid);
		if(card!=null) {
			if(card.getCpasswd().equals(passed)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Card ifCard(int cid) {
		Card card = cd.findByid(cid);
		return card;
	}

	@Override
	public Card ifCopyCard(int cid) {
		Card card = cd.findByidCopy(cid);
		return card;
	}

	@Override
	public String updatePoint(int cid, double point, boolean a) {
		boolean aa = pd.updatePoint(cid, point, a);
		return aa?"修改成功":"修改失败";
	}

	@Override
	public double selectPoint(int cid) {
		double point = pd.selectPoint(cid);
		return point;
	}

}
