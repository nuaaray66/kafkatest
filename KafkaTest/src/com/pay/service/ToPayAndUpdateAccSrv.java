package com.pay.service;

import java.util.ArrayList;

import com.pay.dto.PaymentDto;
import com.pay.dto.TradinfoDto;

public interface ToPayAndUpdateAccSrv {

	/**
	 * 更新account会员的余额信息
	 * 
	 * @param input
	 * @return
	 */
	public int ToPayAndUpdateAccSrv(ArrayList<TradinfoDto> record);
	
	
	
}
