package com.pay.service.impl;

import javax.annotation.Resource;


import org.apache.ibatis.session.SqlSession;

import com.message.service.KafkaProdPool;
import com.message.service.ProducerTradMess;
import com.pay.dto.TradinfoDto;
import com.pay.service.SendOrderToMessageService;
import com.constrants.*;

import net.sf.json.JSONObject;

public class SendOrderToMessageServiceImpl implements SendOrderToMessageService {

	@Override
	public int SendOrderToMessage(TradinfoDto record, int servertype) {
		// TODO Auto-generated method stub
		if (servertype == 1)
			SendOrderToKafkaMessage(record);

		else if (servertype == 2)
			SendOrderToActiveMqMessage(record);
		else if (servertype == 3)
			SendOrderToRedisServer(record);
		else
			SendOrderToFileServer(record);

		return 0;
	}

	@Override
	public int SendOrderToKafkaMessage(TradinfoDto record) {
		// TODO Auto-generated method stub


		boolean isAsync = true;
		
		int skey = record.getId();

		JSONObject tradjson = JSONObject.fromObject(record);

		System.out.println(tradjson.toString());

		ProducerTradMess producerThread = new ProducerTradMess(skey, tradjson, isAsync, KafkaProperties.TOPIC);

		return skey;
	}

	@Override
	public int SendOrderToActiveMqMessage(TradinfoDto record) {
		// TODO Auto-generated method stub

		System.out.println(
				"the message: " + record.getId() + " " + record.getTradNum() + " has been sent to activemq server! ");

		return 0;
	}

	@Override
	public int SendOrderToRedisServer(TradinfoDto record) {
		// TODO Auto-generated method stub

		System.out.println(
				"the message: " + record.getId() + " " + record.getTradNum() + " has been sent to redis server! ");

		return 0;
	}

	@Override
	public int SendOrderToFileServer(TradinfoDto record) {
		// TODO Auto-generated method stub

		System.out.println(
				"the message: " + record.getId() + " " + record.getTradNum() + " has been sent to file server! ");

		return 0;
	}
}
