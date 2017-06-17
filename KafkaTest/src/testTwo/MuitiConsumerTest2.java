package testTwo;

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

public class MuitiConsumerTest2 {
	public static void main(String[] args) {

		// Scenario 1: this 3 customer in one consumer group, the amount of
		// received messages is 100000,
		// the speed of dealing with the message is 3 times of one customers;
		// set customer group is mypay_group

		String brokerList = "localhost:9092,localhost:9093,localhost:9094,localhost:9095";
		String groupId = "perfgroup";
		String groupId2 = "perfgroup2";
		String topic = "safetopic";
		int consumerNum = 1;

		ConsumerGroupTest2 consumerGroup = new ConsumerGroupTest2(consumerNum, groupId, topic, brokerList);
		consumerGroup.execute();
		
	}
}
