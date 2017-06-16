package com.message.service;

import java.util.ArrayList;
import java.util.List;

public class receiveMessToPayGroup {
	private List<receiveMessToPay> consumers;

	public receiveMessToPayGroup(int consumerNum, String topic,int groupid) {
		consumers = new ArrayList<>(consumerNum);
		
		for (int i = 0; i < consumerNum; ++i) {
			receiveMessToPay consumerThread = new receiveMessToPay(topic,groupid);
			consumers.add(consumerThread);
		}
	}

	public void execute() {
		for (receiveMessToPay task : consumers) {
			new Thread(task).start();
		}
	}
}
