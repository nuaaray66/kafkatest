package com.message.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.pay.dto.TradinfoDto;
import com.pay.service.ToPayAndUpdateAccSrv;
import com.pay.service.impl.ToPayAndUpdateAccSrvImpl;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerRunnable implements Runnable {

	// 每个线程维护私有的KafkaConsumer实例
	private final KafkaConsumer<String, String> consumer;

	public ConsumerRunnable(String brokerList, String groupId, String topic) {
		Properties props = new Properties();
		props.put("bootstrap.servers", brokerList);
		props.put("group.id", groupId);
		props.put("enable.auto.commit", "true"); // 本例使用自动提交位移
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		this.consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(topic)); // 本例使用分区副本自动分配策略
	}

	@Override
	public void run() {
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(20000); // 本例使用200ms作为获取超时时间
		
			ArrayList tradlist = new ArrayList();

			for (ConsumerRecord<String, String> record : records) {
				JSONObject jsonobj = JSONObject.fromObject(record.value());

				TradinfoDto traddto = (TradinfoDto) JSONObject.toBean(jsonobj, TradinfoDto.class);
				tradlist.add(traddto);
				System.out.println(Thread.currentThread().getName() + " consumed " + record.partition()
				+ "th patition message with offset: " + record.offset() + " :" + traddto.getId() + " ,"
				+ traddto.getTradCus());

			}

			ToPayAndUpdateAccSrv savepay = new ToPayAndUpdateAccSrvImpl();
			savepay.ToPayAndUpdateAccSrv(tradlist);
			
		}
	}
}