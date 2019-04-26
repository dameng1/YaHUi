

package com.chinasofti.YaHui.biz;

import java.util.List;

import com.chinasofti.YaHui.domain.Card;

public interface CardBiz {
	//新建一张卡
	public String addCard(String name,String cpasswd,int vid,double cmoney);
	//删除一张卡
	public String deleteCard(int cid);
	//冻结一张卡
	public String FreezeCard(int cid);
	//补卡
	public String AgainOwn(int cid);
	//修改卡信息
	public String updateImgCard(int cid,String name,String passwd);
	//修改卡余额
	public String updateCardMoney(int cid,double money,boolean a);
	//修改卡VIP等级
	public String updateCardVip(int cid,int vid);
	//查询所有卡
	public List<Card> findAllCard();
	//查询卡号密码是否正确
	public boolean ifCard(int cid,String passed);
	//查询卡
	public Card ifCard(int cid);
	//查询复制卡
	public Card ifCopyCard(int cid);
	//修改积分
	public String updatePoint(int cid,double point,boolean a);
	//查询积分
	public double selectPoint(int cid);
}
