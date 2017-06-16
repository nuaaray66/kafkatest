
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
import com.message.service.KafkaProdPool;
import com.message.service.receiveMessToPay;
import com.message.service.receiveMessToPayGroup;
import com.pay.domain.Tradinfo;
import com.pay.dto.TradinfoDto;

import net.sf.json.JSONObject;

public class ReadMessToPayProcess {
	public static void main(String[] args) {

		// Scenario 1: this 3 customer in one consumer group, the amount of
		// received messages is 100000,
		// the speed of dealing with the message is 3 times of one customers;
		// because the kafak is not thread-safle, you need to startup 3 time of
		// this application;
		// set customer group is paycon_group
		// receiveMessToPay consumerThread1 = new receiveMessToPay("paytopic",
		// 0);
		//
		// consumerThread1.start();

		int groupId = 0;
		String topic = "paytopic";
		int consumerNum = 3;
		receiveMessToPayGroup consumerGroup = new receiveMessToPayGroup(consumerNum, topic, groupId);
		
		consumerGroup.execute();

		// Scenario 2: this 5 customer in one consumer group, the amount of
		// received messages is 100000,
		// the speed of dealing with the message is still 3 times of one
		// customers;
		// because paytopic has only 3 partitions
		// because the kafak is not thread-safle, you need to startup 5 time of
		// this application;
		// set customer group is paycon_group

		// Scenario 3: this 5 customer in one consumer group, the amount of
		// received messages is 100000*5= 500000,
		// and there are 5 same messages
		// because the kafak is not thread-safle, you need to startup 5 time of
		// this application;
		// set customer group is paycon_group1~paycon_group5

	}
}
