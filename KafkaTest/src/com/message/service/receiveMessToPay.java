package com.message.service;
/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import kafka.utils.ShutdownableThread;
import net.sf.json.JSONObject;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.constrants.KafkaProperties;
import com.message.service.KafkaProdPool;
import com.pay.domain.Account;
import com.pay.dto.TradinfoDto;
import com.pay.service.ToPayAndUpdateAccSrv;
import com.pay.service.impl.ToPayAndUpdateAccSrvImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class receiveMessToPay extends ShutdownableThread {

	private final String topic;

	private static kafkaCustPool mykafka = new kafkaCustPool();

	public receiveMessToPay(String topic, int groupid) {
		super("KafkaConsumerExample", false);

		if (groupid > 0)
			mykafka.kafkaCustPools(groupid);

		this.topic = topic;
	}

	@Override
	public void doWork() {
		
		mykafka.consumer.subscribe(Collections.singletonList(this.topic));
		
		ConsumerRecords<Integer, String> records = mykafka.consumer.poll(200);	// 使用200ms作为获取超时时间

		ArrayList tradlist = new ArrayList();

		for (ConsumerRecord<Integer, String> record : records) {
			JSONObject jsonobj = JSONObject.fromObject(record.value());

			TradinfoDto traddto = (TradinfoDto) JSONObject.toBean(jsonobj, TradinfoDto.class);
			tradlist.add(traddto);
			System.out.println(" new consumer : Received message: (" + traddto.getId() + ", " + traddto.getTradCus()
					+ ") at offset " + record.offset());
		}

		ToPayAndUpdateAccSrv savepay = new ToPayAndUpdateAccSrvImpl();
		savepay.ToPayAndUpdateAccSrv(tradlist);

	}

	@Override
	public String name() {
		return null;
	}

	@Override
	public boolean isInterruptible() {
		return false;
	}
}
