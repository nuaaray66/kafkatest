
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

import java.util.Date;

import java.util.HashMap;

import com.constrants.KafkaProperties;
import com.message.service.ConsumerGroup;
import com.message.service.ConsumerHandler;
import com.message.service.KafkaProdPool;
import com.message.service.receiveMessToPay;
import com.message.service.receiveMessToPayGroup;
import com.pay.domain.Tradinfo;
import com.pay.dto.TradinfoDto;

import net.sf.json.JSONObject;

public class MCReadMessToPay {
	public static void main(String[] args) {

		// Scenario 1: this 3 customer in one consumer group, the amount of
		// received messages is 100000,
		// the speed of dealing with the message is 3 times of one customers;
		// set customer group is mypay_group

		String brokerList = "localhost:9092,localhost:9093,localhost:9094,localhost:9095";
		String groupId = "mc-group1";
		String topic = "mypaytopic";
		int consumerNum = 3;

		ConsumerGroup consumerGroup = new ConsumerGroup(consumerNum, groupId, topic, brokerList);
		consumerGroup.execute();

		//
		// Scenario 2: this 5 customer in one consumer group, the amount of
		// received messages is 100000,
		// the speed of dealing with the message is still 3 times of one
		// customers;
		// because mypaytopic has only 3 partitions, so there is 2 customer have
		// no messages to deal with
		// set customer group is mypay_group

		// int groupId = 0;
		// String topic = "mypaytopic";
		// int consumerNum = 5;
		// receiveMessToPayGroup consumerGroup = new
		// receiveMessToPayGroup(consumerNum, topic, groupId);
		//
		// consumerGroup.execute();

		// Scenario 3: this 3 customer in 3 consumer group, the amount of
		// received messages is 100000*3= 300000,
		// and there are 3 same messages
		// set customer group is mypay_group1~mypay_group3

		// int groupId = 3;
		// String topic = "mypaytopic";
		// int consumerNum = 3;
		// receiveMessToPayGroup consumerGroup = new
		// receiveMessToPayGroup(consumerNum, topic, groupId);
		//
		// consumerGroup.execute();

		// 创建1个consumer，多个线程共享一个consumer
		// String brokerList = "localhost:9092";
		// String groupId = "group2";
		// String topic = "paytopic";
		// int workerNum = 5;
		//
		// ConsumerHandler consumers = new ConsumerHandler(brokerList, groupId,
		// topic);
		// consumers.execute(workerNum);
		// try {
		// Thread.sleep(1000000);
		// } catch (InterruptedException ignored) {
		// }
		// consumers.shutdown();

		// 创建多个线程，每个线程一个consumer
		// String brokerList = "localhost:2181";
		// String groupId = "testGroup1";
		// String topic = "paytopic";
		// int consumerNum = 3;
		//
		// ConsumerGroup consumerGroup = new ConsumerGroup(consumerNum, groupId,
		// topic, brokerList);
		// consumerGroup.execute();
	}
}
