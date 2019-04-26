package com.chinasofti.YaHui.dao;

import java.util.List;

import com.chinasofti.YaHui.domain.Card;
import com.chinasofti.YaHui.domain.VIP;

public interface CardDao {
	//添加一张会员卡
	public boolean addCard(String name,String cpasswd,int vid,double cmoney);
	//删除一张会员卡
	public boolean deleteCard(int cid);
	//将信息添加到复制表中
	public boolean AddcopyCard(int cid);
	//删除复制表中信息
	public boolean DelcopyCard(int cid);
	//修改卡内金额
	public boolean updateMoney(int cid,double money,boolean a);
	//修改会员等级
	public boolean updateVipPower(int cid,int vid);
	//修改会员卡信息
	public boolean updateCardImg(int cid,String name,String passwd);
	//查询所有会员卡
	public List<Card> findAll();
	//通过id查询会员卡
	public Card findByid(int cid);
	//通过id查询复制会员卡
	public Card findByidCopy(int cid);
	
}
