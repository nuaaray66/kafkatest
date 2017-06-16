package com.pay.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;


import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.dao.PaymentMapper;
import com.dao.impl.PaymentDaoImpl;
import com.db.ConnectionFactory;
import com.pay.domain.Payment;
import com.pay.dto.PaymentDto;
import com.pay.dto.TradinfoDto;
import com.pay.service.CreatePayOrderService;
import com.pay.service.UpdateAccontService;

public class CreatePayOrderSerciveImpl implements CreatePayOrderService {

	
	@Override
	public PaymentDto CreatePayOrder(TradinfoDto record) {
		// TODO Auto-generated method stub
		Payment onepay = new Payment();
		
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		
		//System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

		//Date thisnow = new Date();
		
		onepay.setBeginTime(record.getTradTime());
		onepay.setEndTime(record.getTradTime());
		onepay.setFlag(0);
		onepay.setPayAccount(record.getTradAccount());
		onepay.setPayCus(record.getTradCus());
		onepay.setPayNum(record.getTradNum());
		onepay.setResult("0");
		
		
		PaymentMapper mypay = new PaymentDaoImpl();
		
		int i = mypay.insert(onepay);
		
		mypay.commit();
		
		PaymentDto onepaydto = new PaymentDto();
		onepaydto.setBeginTime(onepay.getBeginTime());
		onepaydto.setEndTime(onepay.getEndTime());
		onepaydto.setFlag(onepay.getFlag());
		onepaydto.setId(onepay.getId());
		onepaydto.setPayAccount(onepay.getPayAccount());
		onepaydto.setPayCus(onepay.getPayCus());
		onepaydto.setPayNum(onepay.getPayNum());
		onepaydto.setResult(onepay.getResult());
		
		UpdateAccontService uas = new UpdateAccountServiceImpl();
		
		uas.updateAccount(onepaydto);		
		
		return onepaydto;
	}
	
	
	
	

}
