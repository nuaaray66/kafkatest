import org.apache.ibatis.session.SqlSession;

import com.dao.TradinfoMapper;
import com.dao.impl.TradinfoDaoImpl;
import com.db.ConnectionFactory;
import com.pay.domain.Tradinfo;
import com.pay.service.CreateOrderService;
import com.pay.service.impl.CreateOrderServiceImpl;

public class CreateTradProcess {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//将所有ID>0的所有交易订单发送网消息服务器
		CreateOrderService createorder = new CreateOrderServiceImpl();

		createorder.CreateTradOrder(0);
		
	}

}
