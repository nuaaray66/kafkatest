package com.message.service;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.constrants.KafkaProperties;

public class kafkaCustPool {
	
	// 每个线程维护私有的KafkaConsumer实例
	public static KafkaConsumer<Integer, String> consumer;

	kafkaCustPool() {
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "paycon_group");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");	//自动提交位移
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "200");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.IntegerDeserializer");
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringDeserializer");
		if (this.consumer == null)
			this.consumer = new KafkaConsumer<>(props);
	}

	public KafkaConsumer<Integer, String> kafkaCustPools(int cusnum) {

		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
				KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.IntegerDeserializer");
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringDeserializer");

		if (cusnum == 1) {
			props.put(ConsumerConfig.GROUP_ID_CONFIG, "paycon_group1");
			this.consumer = new KafkaConsumer<>(props);
		} else if (cusnum == 2) {
			props.put(ConsumerConfig.GROUP_ID_CONFIG, "paycon_group2");
			this.consumer = new KafkaConsumer<>(props);
		} else if (cusnum == 3) {
			props.put(ConsumerConfig.GROUP_ID_CONFIG, "paycon_group3");
			this.consumer = new KafkaConsumer<>(props);
		} else if (cusnum == 4) {
			props.put(ConsumerConfig.GROUP_ID_CONFIG, "paycon_group4");
			this.consumer = new KafkaConsumer<>(props);
		} else if (cusnum == 5) {
			props.put(ConsumerConfig.GROUP_ID_CONFIG, "paycon_group5");
			this.consumer = new KafkaConsumer<>(props);
		}

	

		return this.consumer;
	}
}
