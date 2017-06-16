import com.message.service.ConsumerHandler;

public class MTReadMessToPay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String brokerList = "localhost:9092,localhost:9093,localhost:9094,localhost:9095";
		String groupId = "mt-group1";
		String topic = "mypaytopic";
		int workerNum = 3;

		ConsumerHandler consumers = new ConsumerHandler(brokerList, "mt-group1", topic);
		consumers.execute(workerNum);
		
		ConsumerHandler consumers2 = new ConsumerHandler(brokerList, "mt-group1", topic);
		consumers2.execute(workerNum);
		
//		ConsumerHandler consumers3 = new ConsumerHandler(brokerList, "mt-group1", topic);
//		consumers3.execute(workerNum);
//		
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException ignored) {
		}
		consumers.shutdown();
		consumers2.shutdown();
	//	consumers3.shutdown();
	}

}
