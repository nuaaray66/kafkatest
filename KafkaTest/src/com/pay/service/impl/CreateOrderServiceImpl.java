package com.pay.service.impl;

import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.dao.TradinfoMapper;
import com.dao.impl.TradinfoDaoImpl;
import com.db.ConnectionFactory;
import com.pay.domain.Tradinfo;

import com.pay.dto.TradinfoDto;
import com.pay.service.CreateOrderService;
import com.pay.service.SendOrderToMessageService;

public class CreateOrderServiceImpl implements CreateOrderService {


	@Override
	public ArrayList<TradinfoDto> CreateTradOrder(int id) {
		// TODO Auto-generated method stub
		
		ArrayList<Tradinfo> mytradlist = new TradinfoDaoImpl().selectAll(id);

		Iterator it1 = mytradlist.iterator();
		while (it1.hasNext()) {

			TradinfoDto mytradinfoDto = new TradinfoDto();
			Tradinfo mytradinfo = (Tradinfo) it1.next();

			mytradinfoDto.setId(mytradinfo.getId());
			mytradinfoDto.setFlag(mytradinfo.getFlag());
			mytradinfoDto.setProdId(mytradinfo.getProdId());
			mytradinfoDto.setTradAccount(mytradinfo.getTradAccount());
			mytradinfoDto.setTradCus(mytradinfo.getTradCus());
			mytradinfoDto.setTradNum(mytradinfo.getTradNum());
			mytradinfoDto.setTradTime(mytradinfo.getTradTime());

			SendOrderToMessageService mysend = new SendOrderToMessageServiceImpl();

			mysend.SendOrderToMessage(mytradinfoDto,1);

		}

		return null;
	}

	@Override
	public TradinfoDto CreateOneTradOrder(Tradinfo record) {
		// TODO Auto-generated method stub
		Tradinfo mytradinfo = new TradinfoDaoImpl().selectByPrimaryKey(record.getId());

		TradinfoDto mytradinfoDto = new TradinfoDto();

		mytradinfoDto.setId(mytradinfo.getId());
		mytradinfoDto.setFlag(mytradinfo.getFlag());
		mytradinfoDto.setProdId(mytradinfo.getProdId());
		mytradinfoDto.setTradAccount(mytradinfo.getTradAccount());
		mytradinfoDto.setTradCus(mytradinfo.getTradCus());
		mytradinfoDto.setTradNum(mytradinfo.getTradNum());
		mytradinfoDto.setTradTime(mytradinfo.getTradTime());

		SendOrderToMessageService mysend = new SendOrderToMessageServiceImpl();

		mysend.SendOrderToMessage(mytradinfoDto,1);

		return mytradinfoDto;
	}

}
