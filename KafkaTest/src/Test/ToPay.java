package Test;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;

import com.dao.PaymentMapper;
import com.dao.TradinfoMapper;
import com.dao.impl.PaymentDaoImpl;
import com.dao.impl.TradinfoDaoImpl;

import com.message.service.KafkaProdPool;
import com.pay.domain.Tradinfo;
import com.pay.dto.TradinfoDto;
import com.pay.service.CreatePayOrderService;
import com.pay.service.UpdateAccontService;
import com.pay.service.impl.CreateOrderServiceImpl;
import com.pay.service.impl.CreatePayOrderSerciveImpl;
import com.pay.service.impl.UpdateAccountServiceImpl;

public class ToPay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<TradinfoDto> tradDtolist = getOrderFromMessServer();

		CreatePayOrderService createonepay = new CreatePayOrderSerciveImpl();
		
		
		Iterator it = tradDtolist.iterator();
		
		while (it.hasNext()) {
			createonepay.CreatePayOrder((TradinfoDto) it.next());
			
		}
		
		System.out.println("all message is ok");
		
	}

	public static ArrayList<TradinfoDto> getOrderFromMessServer() {

		ArrayList<TradinfoDto> tradlist = new ArrayList();
		
//        Consumer consumerThread1 = new Consumer(KafkaProperties.TOPIC);
//   
//        consumerThread1.start();
//		

		return tradlist;

		
	}

	
	public static ArrayList<TradinfoDto> getOrderFromDb() {

		ArrayList<Tradinfo> tradlist = new TradinfoDaoImpl().selectAll(0);
		ArrayList traddtolist = new ArrayList();

		Iterator it = tradlist.iterator();

		while (it.hasNext()) {
			Tradinfo mytrad = (Tradinfo) it.next();
			TradinfoDto mydto = new TradinfoDto();

			mydto.setFlag(mytrad.getFlag());
			mydto.setId(mytrad.getId());
			mydto.setProdId(mytrad.getProdId());
			mydto.setTradAccount(mytrad.getTradAccount());
			mydto.setTradCus(mytrad.getTradCus());
			mydto.setTradNum(mytrad.getTradNum());
			mydto.setTradTime(mytrad.getTradTime());
			traddtolist.add(mydto);
		}

		return traddtolist;

		
	}
}
