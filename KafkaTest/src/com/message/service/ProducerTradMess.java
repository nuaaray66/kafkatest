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
package com.message.service;

import org.apache.kafka.clients.producer.Callback;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import net.sf.json.JSONObject;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerTradMess {

	private static KafkaProdPool mykafka = new KafkaProdPool();
	
	private final String topic;
	private final Boolean isAsync;
	private String sendMess;
	private int imessageid;

	public ProducerTradMess(int skey, JSONObject obj, Boolean isAsync, String topicname) {
		
		this.sendMess = obj.toString();
		
		this.topic = topicname;
	
		this.isAsync = isAsync;
		
		this.imessageid= skey;
	
		long startTime = System.currentTimeMillis();
		
		if (isAsync) { // Send asynchronously
			mykafka.producer.send(new ProducerRecord<>(topic,imessageid,sendMess),
					new DemoCallBack(startTime, imessageid,sendMess));
		} else { // Send synchronously
			try {
			mykafka.producer.send(new ProducerRecord<>(topic, imessageid, sendMess)).get();
				System.out.println("let begin: Sent message: ("  + sendMess + ")");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	
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
			System.out.println("message(" + key + ", " + message + ") sent to partition(" + metadata.partition() + "), "
					+ "offset(" + metadata.offset() + ") in " + elapsedTime + " ms");
		} else {
			exception.printStackTrace();
		}
	}
}
