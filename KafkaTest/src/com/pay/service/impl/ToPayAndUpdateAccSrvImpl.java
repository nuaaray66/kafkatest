package com.pay.service.impl;

import java.util.ArrayList;
import java.util.Iterator;

import com.pay.dto.PaymentDto;
import com.pay.dto.TradinfoDto;
import com.pay.service.*;

public class ToPayAndUpdateAccSrvImpl implements ToPayAndUpdateAccSrv{
	
	/**
	 * 更新account会员的余额信息
	 * 
	 * @param input
	 * @return
	 */
	public int ToPayAndUpdateAccSrv(ArrayList<TradinfoDto> recordlist){
		
		ArrayList<TradinfoDto> tradDtolist = recordlist;

		CreatePayOrderService createonepay = new CreatePayOrderSerciveImpl();
				
		Iterator it = tradDtolist.iterator();
		
		while (it.hasNext()) {
			createonepay.CreatePayOrder((TradinfoDto) it.next());
			
		}
	
		
		return 1;
	}
	

}
