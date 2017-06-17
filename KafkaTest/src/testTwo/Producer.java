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
package testTwo;

import org.apache.kafka.clients.producer.Callback;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer extends Thread {
	private final KafkaProducer<Integer, String> producer;
	private final String topic;
	private final Boolean isAsync;
	
	public static long processtime=0;

	public Producer(String topic, Boolean isAsync) {
		Properties props = new Properties();
		props.put("bootstrap.servers", KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
		props.put("client.id", "DemoProducer");
		props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		producer = new KafkaProducer<>(props);
		this.topic = topic;
		this.isAsync = isAsync;
	}

	public void run() {
		int messageNo = 0;
		Date date = new Date();
		long allstartTime = System.currentTimeMillis();
		long allstopTime = System.currentTimeMillis();
	
		System.out.println(Thread.currentThread().getName() + " 开始发送消息队列： " + date.toString());
		String messageStr = "message body is a json: {\"flag\":0,\"id\":100739,\"prodId\":\"PRODUCT708\",\"tradAccount\":32,\"tradCus\":\"CUSCODE445\",\"tradNum\":\"TRAD708\",\"tradTime\":{\"date\":8,\"day\":5,\"hours\":7,\"minutes\":53,\"month\":3,\"seconds\":30,\"time\":1460116410000,\"timezoneOffset\":240,\"year\":116}}";
		messageStr = messageStr + messageStr +messageStr+messageStr;
		//System.out.println(messageStr.getBytes().length);
		while (messageNo < 100000) {

			long startTime = System.currentTimeMillis();
			if (isAsync) { // Send asynchronously
				producer.send(new ProducerRecord<>(topic, messageNo, messageStr),
						new DemoCallBack(startTime, messageNo, messageStr));
			} else { // Send synchronously
				try {
					producer.send(new ProducerRecord<>(topic, messageNo, messageStr)).get();
					// System.out.println("let begin: Sent message: (" +
					// messageNo + ", " + messageStr + ")");
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
			++messageNo;
		}
		allstopTime = System.currentTimeMillis();
		this.processtime = allstopTime - allstartTime;
		
		System.out.println(Thread.currentThread().getName() + " 结束发送消息队列： " + date.toString() + " , 共消耗 " + String.valueOf(allstopTime - allstartTime) + " ms" );
	}
}

class DemoCallBack implements Callback {

	private final long startTime;
	private final int key;
	private final String message;

	public DemoCallBack(long startTime, int key, String message) {
		this.startTime = startTime;
		this.key = key;
		this.message = message;
	}

	/**
	 * A callback method the user can implement to provide asynchronous handling
	 * of request completion. This method will be called when the record sent to
	 * the server has been acknowledged. Exactly one of the arguments will be
	 * non-null.
	 *
	 * @param metadata
	 *            The metadata for the record that was sent (i.e. the partition
	 *            and offset). Null if an error occurred.
	 * @param exception
	 *            The exception thrown during processing of this record. Null if
	 *            no error occurred.
	 */
	public void onCompletion(RecordMetadata metadata, Exception exception) {
		long elapsedTime = System.currentTimeMillis() - startTime;
		if (metadata != null) {
			// System.out.println(
			// "message(" + key + ", " + message + ") sent to partition(" +
			// metadata.partition() +
			// "), " +
			// "offset(" + metadata.offset() + ") in " + elapsedTime + " ms");
		} else {
			exception.printStackTrace();
		}
	}
}
