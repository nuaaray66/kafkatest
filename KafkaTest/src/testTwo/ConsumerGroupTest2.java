package testTwo;

import java.util.ArrayList;
import java.util.List;

public class ConsumerGroupTest2 {

	private List<ConsumerRunnableTest2> consumers;

	public ConsumerGroupTest2(int consumerNum, String groupId, String topic, String brokerList) {
		consumers = new ArrayList<>(consumerNum);
		for (int i = 0; i < consumerNum; ++i) {
			ConsumerRunnableTest2 consumerThread = new ConsumerRunnableTest2(brokerList, groupId, topic);
			consumers.add(consumerThread);
		}
	}

	public void execute() {
		for (ConsumerRunnableTest2 task : consumers) {
			new Thread(task).start();
			
		}
	}
}
