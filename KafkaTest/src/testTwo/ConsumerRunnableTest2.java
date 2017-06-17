package testTwo;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.dao.PaymentMapper;
import com.dao.impl.PaymentDaoImpl;
import com.pay.domain.Payment;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class ConsumerRunnableTest2 implements Runnable {

	// 每个线程维护私有的KafkaConsumer实例
	private final KafkaConsumer<String, String> consumer;

	public ConsumerRunnableTest2(String brokerList, String groupId, String topic) {
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


		System.out.println(Thread.currentThread().getName() + " 开始消费消息队列： " + new Date().toString());

		while (true) {
			long allstartTime = System.currentTimeMillis();
			
			long alltime = 0;
			long allstopTime = System.currentTimeMillis();

			ConsumerRecords<String, String> records = consumer.poll(1000); // 本例使用1000ms作为获取超时时间

			for (ConsumerRecord<String, String> record : records) {
				String str = record.value();

			}
			if (records.count() > 0) {
				allstopTime = System.currentTimeMillis();
				alltime += allstopTime - allstartTime;
				
				System.out.println(Thread.currentThread().getName() + " consumed " + String.valueOf(alltime) + " ms");
				Payment custime = new Payment();
				
				custime.setPayNum(Thread.currentThread().getName());
				custime.setBeginTime(new Date());
				custime.setFlag(Integer.valueOf((int) alltime));
				custime.setPayAccount(BigDecimal.valueOf(records.count()));
				PaymentMapper paydb = new PaymentDaoImpl();
				
				paydb.insert(custime);
				paydb.commit();
			
			}
			
		}
		

	}
}