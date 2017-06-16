package Test;
import java.io.Reader;
import java.lang.reflect.Field;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import com.db.ConnectionFactory;
import com.pay.dto.AccountDto;
import com.pay.dto.Message;

import net.sf.json.JSONObject;

import com.pay.domain.Account;

public class Test {
	private static SqlSession mysession = ConnectionFactory.getSession();

	public static void main(String[] args) throws Exception {

		try {
			Account account = (Account) mysession.selectOne("com.dao.AccountMapper.selectByCusCode", "CUSCODE5613");
		
			JSONObject jsonObj;

//			AccountDto dto = new AccountDto();
//			dto.setAccount(account.getAccount());
//			dto.setCusCode(account.getCusCode());
//			dto.setCusName(account.getCusName());
//			dto.setId(account.getId());
//			dto.setLastPayTime(account.getLastPayTime());
//			dto.setPassword(account.getPassword());
//			dto.setStatus(account.getStatus());
//			
			jsonObj = JSONObject.fromObject(account);
			
			Account myacc =  (Account) JSONObject.toBean(jsonObj, Account.class);

			System.out.println(jsonObj.toString());
		
			System.out.println(myacc.getCusName());

		} finally {
			mysession.close();
		}
	}
	
	
	
}