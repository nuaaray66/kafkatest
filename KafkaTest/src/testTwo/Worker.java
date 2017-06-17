package testTwo;

import java.util.ArrayList;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.pay.dto.TradinfoDto;
import com.pay.service.CreatePayOrderService;
import com.pay.service.ToPayAndUpdateAccSrv;
import com.pay.service.impl.CreatePayOrderSerciveImpl;
import com.pay.service.impl.ToPayAndUpdateAccSrvImpl;

import net.sf.json.JSONObject;

public class Worker implements Runnable {

	private ConsumerRecord<String, String> consumerRecord;

	public Worker(ConsumerRecord record) {
		this.consumerRecord = record;
	}

	@Override
	public void run() {

		JSONObject jsonobj = JSONObject.fromObject(consumerRecord.value());
		TradinfoDto traddto = (TradinfoDto) JSONObject.toBean(jsonobj, TradinfoDto.class);

		CreatePayOrderService createonepay = new CreatePayOrderSerciveImpl();
		createonepay.CreatePayOrder(traddto);

		System.out.println(Thread.currentThread().getName() + " consumed " + consumerRecord.partition()
				+ "th patition message with offset: " + consumerRecord.offset() + " :" + traddto.getId() + " ,"
				+ traddto.getTradCus());

	}

	// 这里写你的消息处理逻辑，本例中只是简单地打印消息
	// System.out.println(Thread.currentThread().getName() + " consumed " +
	// consumerRecord.partition()
	// + "th message with offset: " + consumerRecord.offset());

}
